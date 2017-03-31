package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import controllers.security.Authenticator;
import controllers.security.OwnerVerified;
import models.Owner;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.HtmlEmail;
import play.Logger;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.HashingService;
import services.OwnerService;



import javax.mail.Session;
import javax.persistence.TypedQuery;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.*;


import static play.mvc.Controller.request;
import static play.mvc.Http.Context.Implicit.ctx;
import static play.mvc.Results.*;

/**
 * Created by welcome on 1/4/2017.
 */
public class OwnerController {



    private JPAApi jpaApi;
    private OwnerService ownerService;
    private HashingService hs;

    @Inject
    public OwnerController(JPAApi jpaApi,OwnerService ownerService,HashingService hs){
        this.jpaApi = jpaApi;
        this.ownerService = ownerService;
        this.hs = hs;
    }

    @Transactional
    public Result getAllOwners(){

        TypedQuery<Owner> query = jpaApi.em().createQuery("SELECT o FROM Owner o ",Owner.class);
        List<Owner> owners = query.getResultList();
        Logger.info("owner",owners);
        JsonNode json = Json.toJson(owners);
        return ok(json);
    }



    @Transactional
    @Authenticator
    public Result deleteOwner(){
        Owner o = (Owner) ctx().args.get("user");
        jpaApi.em().remove(o);
        return ok();
    }

    @Transactional
    @Authenticator
    public Result getOwnerByAuthToken(){

        Owner o = (Owner) Controller.ctx().args.get("user");
        if(null == o){
            return badRequest();
        }
        JsonNode json = Json.toJson(o);
        return ok(json.get("oname"));
    }


    @Transactional
    @Authenticator
    public Result updatePassword(){
        final JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest("not found");
        }
//        Owner o=Json.fromJson(json,Owner.class);
//        if(null == o){
//            return badRequest("not found");
//        }

        Owner existingOwner =(Owner) ctx().args.get("user");

        if(!json.get("newPwd").asText().isEmpty()) {
            if(existingOwner.getPwd().equals(hs.hashPwd(json.get("oldPwd").asText(),existingOwner.getSalt()))){
                existingOwner.setPwd(hs.hashPwd(json.get("newPwd").asText(), existingOwner.getSalt()));
            }
            else{
                return badRequest("Old/Temp password wrong");
            }
        }

        jpaApi.em().merge(existingOwner);

        return ok("updated"+existingOwner.getOname());
    }

    @Transactional
    public Result addOwner(){
        final JsonNode json = request().body().asJson();
        if (null == json) {
            Logger.error("Unable to get json from request");
            return badRequest("Unable to get json from request");
        }

        final Owner o = Json.fromJson(json, Owner.class);
        if (null == o) {
            Logger.error("Unable to parse json to Book object");
            return badRequest("Unable to parse json to Owner object");
        }

        //unique username
        String q = "SELECT o FROM Owner o where o.oname = '" + o.getOname() + "'";
        TypedQuery<Owner> query = jpaApi.em().createQuery(q,Owner.class);
        List<Owner> owners = query.getResultList();
        if(!owners.isEmpty())
        {
            return badRequest("Username already exists");
        }


        //unique eid
        q = "SELECT o FROM Owner o where o.eid = '" + o.getEid() + "'";
        query = jpaApi.em().createQuery(q,Owner.class);
        owners = query.getResultList();
        if(!owners.isEmpty())
        {
            return badRequest("Email id already registered");
        }


        final Random r = new SecureRandom();
        byte[] salt = new byte[32];
        r.nextBytes(salt);
        Logger.debug(salt.toString());
        String saltString = salt.toString();

        //String pass = o.getPwd();
        //Logger.debug(json.get("pass").asText());
        String hashPass = hs.hashPwd(json.get("pwd").asText(),saltString);
        Logger.debug(saltString);
        if(null == hashPass){
            return ok("algo error");
        }

        o.setPwd(hashPass);
        o.setSalt(saltString);
        o.setVerifyToken(UUID.randomUUID().toString());
        o.setVerified(0);

        jpaApi.em().persist(o);

        JsonNode j = Json.toJson(o);


        HtmlEmail email = new HtmlEmail();
        try {
            Logger.debug("in try");
            String urlVerify = "http://localhost:8081/#/VerifyUser/oname/" + o.getVerifyToken();
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("hungerquest.mail@gmail.com","code4route"));
            Logger.debug("auth");
            email.setSSLOnConnect(true);
            email.setFrom("hungerquest.mail@gmail.com");
            Logger.debug("from");
            email.addTo(o.getEid());
            Logger.debug("to");
            email.setSubject("Verify email");
            email.setHtmlMsg("<h1>Hungerquest Mail Verification</h1><p>Please verify your mail id by clicking the button below. If not you will not able to login.</p><Button><a href='"+urlVerify+"'>VERIFY</a></Button>");
            email.setBounceAddress("sivani.karnatakam@gmail.com");
            Session mailSession = email.getMailSession();
            Logger.debug(mailSession.toString());
            email.send();

        }
        catch (Exception e){
            return badRequest("mail error");
        }

        return ok(j);

    }

    @Transactional
    @OwnerVerified
    public Result signIn(){

       JsonNode json =  request().body().asJson();
       if(null == json){
           return badRequest();
       }

       Owner o = ownerService.authenticate(json.get("oname").asText(),json.get("pwd").asText());
       if(null == o){
           return unauthorized("Invalid credentials");
       }
       Logger.debug("auth: {}",o.getAuth_token());
       return ok(Json.toJson(o));
    }

    @Transactional
    @Authenticator
    public Result signOut(){
        final Owner o = (Owner) ctx().args.get("user");
        o.setAuth_token("");
        o.setExpTime(null);
        return ok();
    }

    @Transactional
    @Authenticator
    public Result getResByOwnerID(){
        final Owner o = (Owner) ctx().args.get("user");
        Logger.debug(""+o.getExpTime().getTime());
        JsonNode json = Json.toJson(o.getRestaurants());
        return ok(json);
    }

    @Transactional
    public Result forgotPwd(){
        JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest("empty json");
        }
        String q = "SELECT o FROM Owner o where o.oname='" + json.get("oname").asText() + "'";
        TypedQuery<Owner> query = jpaApi.em().createQuery(q,Owner.class);
        List<Owner> o = query.getResultList();
        if(o.isEmpty()){
            return badRequest("username does not exist");
        }
        json = Json.toJson(o.get(0));
        return ok(json);
    }

    @Transactional
    public Result checkAns(){
        JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest("empty json");
        }
        String q = "SELECT o FROM Owner o where o.oname='"+ json.get("oname").asText() + "'";
        TypedQuery<Owner> query = jpaApi.em().createQuery(q,Owner.class);
        List<Owner> o = query.getResultList();
        if(o.isEmpty()){
            return badRequest("Username does not exist");
        }
        Owner owner = o.get(0);
        if(!owner.getSecAns().equals(json.get("secAns").asText())){
            return badRequest("Answer did not match");
        }

        final Random r = new SecureRandom();
        byte[] temPwd = new byte[32];
        r.nextBytes(temPwd);
        Logger.debug(temPwd.toString());
        String hashPass = hs.hashPwd(temPwd.toString(),owner.getSalt());
        owner.setPwd(hashPass);
        Calendar cl = Calendar. getInstance();
        cl.add(Calendar.HOUR_OF_DAY,1);
        Logger.debug(""+cl.getTime());
        Timestamp t = new Timestamp(cl.getTimeInMillis());
        Logger.debug(""+t);
        owner.setExpTime(t);
        String eid = owner.getEid();
        Logger.debug(eid);
        SimpleEmail email = new SimpleEmail();
        try {
            Logger.debug("in try");
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("hungerquest.mail@gmail.com","code4route"));
            Logger.debug("auth");
            email.setSSLOnConnect(true);
            email.setFrom("hungerquest.mail@gmail.com");
            Logger.debug("from");
            email.addTo(eid);
            Logger.debug("to");
            email.setSubject("Temporary password");
            email.setMsg("This password is valid only for one hour.Login with this and change your password. \n"+"Temporary Password:"+ temPwd.toString() + "\n NOTE :- After you login with the temporary password: Go to My Profile -> Change Password and change your password");
            email.send();
        }
        catch (Exception e){
            return badRequest("mail error");
        }
        return ok();
    }

    @Transactional
    public Result verifyEmail(){
        String q = "SELECT o FROM Owner o where o.verifyToken='" + request().getQueryString("oname") +"'";
        TypedQuery<Owner> query = jpaApi.em().createQuery(q,Owner.class);
        List<Owner> owner = query.getResultList();
        if(owner.isEmpty()){
            return forbidden("not verified");
        }
        owner.get(0).setVerified(1);
        owner.get(0).setAuth_token(UUID.randomUUID().toString());

        Calendar cl = Calendar. getInstance();
        cl.add(Calendar.HOUR_OF_DAY,4);
        Logger.debug(""+cl.getTime());

        Timestamp t = new Timestamp(cl.getTimeInMillis());
        Logger.debug(""+t);
        owner.get(0).setExpTime(t);
        JsonNode json = Json.toJson(owner.get(0));

        return ok(json);
    }

    @Transactional
    @Authenticator
    public Result expiredOwner(){
        Owner o = (Owner) ctx().args.get("user");
        return ok("not expired");
    }

}

