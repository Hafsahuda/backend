package controllers;


import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import controllers.security.UserAuthenticator;
import controllers.security.UserVerified;
import models.User;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import play.Logger;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;

import javax.persistence.TypedQuery;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static play.mvc.Controller.ctx;
import static play.mvc.Controller.request;


import services.HashingService;
import services.UserService;


import java.util.Random;
import java.util.UUID;

import static play.mvc.Results.*;


public class UserController {

    public UserController() {

    }

    private JPAApi jpaApi;
    private UserService userService;
    private HashingService hs;

    @Inject
    public UserController(JPAApi jpaApi,UserService userService, HashingService hs){
        this.jpaApi = jpaApi;
        this.userService = userService;
        this.hs = hs;
    }

    @Transactional
    public Result getAllUsers(){

        TypedQuery<User> query = jpaApi.em().createQuery("SELECT u FROM User u ", User.class);
        List<User> users = query.getResultList();
        Logger.info("users",users);
        JsonNode json = Json.toJson(users);
        return ok(json);
    }

    @Transactional
    @UserAuthenticator
    public Result getUserByAuthToken(){

        User u = (User) ctx().args.get("user");
        if(null == u){
            return badRequest();
        }
        JsonNode json = Json.toJson(u);
        return ok(json.get("uname"));
    }


    @Transactional
    @UserAuthenticator
    public Result deleteUser(){

        User u = (User) ctx().args.get("user");
        jpaApi.em().remove(u);
        return ok();
    }

    @Transactional
    @UserAuthenticator
    public Result updatePassword(){
        final JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest("not found");
        }


        User existingUser = (User) ctx().args.get("user");


        if(!json.get("newPwd").asText().isEmpty()) {
            if(existingUser.getPwd().equals(hs.hashPwd(json.get("oldPwd").asText(),existingUser.getSalt()))){
                existingUser.setPwd(hs.hashPwd(json.get("newPwd").asText(), existingUser.getSalt()));
            }
            else{
                return badRequest("Old/Temp password wrong");
            }
        }

        jpaApi.em().merge(existingUser);

        return ok("updated "+existingUser.getUname());
    }

    @Transactional
    public Result addUser(){
        final JsonNode json = request().body().asJson();
        if (null == json) {
            Logger.error("Unable to get json from request");
            return badRequest("Unable to get json from request");
        }

        final User u = Json.fromJson(json, User.class);

        if (null == u) {
            Logger.error("Unable to parse json to Book object");
            return badRequest("Unable to parse json to Owner object");
        }

        //unique uname
        String q = "SELECT u FROM User u where u.uname = '" + u.getUname() + "'";
        TypedQuery<User> query = jpaApi.em().createQuery(q,User.class);
        List<User> owners = query.getResultList();
        if(!owners.isEmpty())
        {
            return badRequest("Username already exists");
        }

        //unique eid
        q = "SELECT u FROM User u where u.eid = '" + u.getEid() + "'";
        query = jpaApi.em().createQuery(q,User.class);
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

        u.setPwd(hs.hashPwd(json.get("pwd").asText(),saltString));
        u.setSalt(saltString);

        u.setVerifyToken(UUID.randomUUID().toString());
        u.setVerified(0);
        jpaApi.em().persist(u);
        JsonNode j = Json.toJson(u);

        HtmlEmail email = new HtmlEmail();
        try {
            Logger.debug("in try");
            String urlVerify = "http://localhost:8081/#/VerifyUser/uname/" + u.getVerifyToken();
            URL url = new URL(urlVerify);
            Logger.debug(urlVerify);
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("hungerquest.mail@gmail.com","code4route"));
            Logger.debug("auth");
            email.setSSLOnConnect(true);
            email.setFrom("hungerquest.mail@gmail.com");
            Logger.debug("from");
            email.addTo(u.getEid());
            Logger.debug("to");
            email.setSubject("Verify email");
            email.setHtmlMsg("<h1>Hungerquest Mail Verification</h1><p>Please verify your mail id by clicking the button below. If not you will not able to login.</p><Button><a href='"+urlVerify+"'>VERIFY</a></Button>");
            Logger.debug(""+email.getMimeMessage());
            email.send();
        }
        catch (Exception e){
            return badRequest("mail error");
        }

        return ok(j);
    }

    @Transactional
    @UserVerified
    public Result signIn(){

        JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest();
        }

        User u = userService.authenticate(json.get("uname").asText(),json.get("pwd").asText());
        if(null == u){
            return unauthorized("Invalid credentials");
        }
        Logger.debug("auth: {}",u.getAuth_token());

        return ok(Json.toJson(u));
    }

    @Transactional
    @UserAuthenticator
    public Result signOut(){
        final User u = (User) Http.Context.Implicit.ctx().args.get("user");
        u.setAuth_token("");
        u.setExpTime(null);
        return ok();
    }

    @Transactional
    public Result forgotPwd(){
        JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest("empty json");
        }
        String q = "SELECT u FROM User u where u.uname='" + json.get("uname").asText() + "'";
        TypedQuery<User> query = jpaApi.em().createQuery(q,User.class);
        List<User> u = query.getResultList();
        if(u.isEmpty()){
            return badRequest("username does not exist");
        }
        json = Json.toJson(u.get(0));
        return ok(json);
    }

    @Transactional
    public Result checkAns(){
        JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest("empty json");
        }
        String q = "SELECT u FROM User u where u.uname='" + json.get("uname").asText() + "'";
        TypedQuery<User> query = jpaApi.em().createQuery(q,User.class);
        List<User> u = query.getResultList();
        if(u.isEmpty()){
            return badRequest("Username does not exist");
        }
        User user = u.get(0);
        Logger.debug(user.getSecAns());
        if(!user.getSecAns().equals(json.get("secAns").asText())){
            return badRequest("Answer did not match");
        }

        final Random r = new SecureRandom();
        byte[] temPwd = new byte[32];
        r.nextBytes(temPwd);
        Logger.debug(temPwd.toString());
        String hashPass = hs.hashPwd(temPwd.toString(),user.getSalt());
        user.setPwd(hashPass);
        Calendar cl = Calendar. getInstance();
        cl.add(Calendar.HOUR_OF_DAY,1);
        Logger.debug(""+cl.getTime());
        Timestamp t = new Timestamp(cl.getTimeInMillis());
        Logger.debug(""+t);
        user.setExpTime(t);
        String eid = user.getEid();
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
            email.setMsg("This password is valid only for one hour.Login with this and change your password.\n"+"Temporary Password:"+ temPwd.toString() + "\n NOTE :- After you login with the temporary password: Go to My Profile -> Change Password and change your password");
            email.send();
        }
        catch (Exception e){
            return badRequest("mail error");
        }
        return ok();
    }

    @Transactional
    public Result verifyEmail(){
        String q = "SELECT u FROM User u where u.verifyToken='" + request().getQueryString("uname") +"'";
        TypedQuery<User> query = jpaApi.em().createQuery(q,User.class);
        List<User> user = query.getResultList();
        if(user.isEmpty()){
            return forbidden("not verified");
        }
        user.get(0).setVerified(1);
        user.get(0).setAuth_token(UUID.randomUUID().toString());

        Calendar cl = Calendar. getInstance();
        cl.add(Calendar.HOUR_OF_DAY,4);
        Logger.debug(""+cl.getTime());

        Timestamp t = new Timestamp(cl.getTimeInMillis());
        Logger.debug(""+t);
        user.get(0).setExpTime(t);
        JsonNode json = Json.toJson(user.get(0));
        return ok(json);
    }

    @Transactional
    @UserAuthenticator
    public Result expiredUser(){
        User u = (User) Http.Context.Implicit.ctx().args.get("user");
        return ok("not expired");
    }

}





