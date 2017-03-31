
package services;

import com.fasterxml.jackson.databind.JsonNode;
import models.Owner;
import play.Logger;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import static play.mvc.Controller.request;


public class OwnerService {

    private JPAApi jpaApi;
    private HashingService hs;

    @Inject
    public OwnerService(JPAApi jpaApi, HashingService hs) {
        this.jpaApi = jpaApi;
        this.hs = hs;
    }

    public void createOwner(Owner owner) {

        // TODO Save user in DB


    }

    @Transactional
    public Owner getOwnerByName(String oname){
        String q = "SELECT o FROM Owner o WHERE o.oname='" + oname + "'";
        TypedQuery<Owner> query = jpaApi.em().createQuery(q,Owner.class);
        List<Owner> o = query.getResultList();
        if(o.isEmpty()){
            return null;
        }
        return o.get(0);
    }

    public Owner authenticate(String username, String password) {

        // TODO Find username in DB and compare passwords
        // TODO If success, generate random auth_token and save in DB and return it from this method



        String q = "SELECT o FROM Owner o where o.oname = '" + username + "'";
        TypedQuery<Owner> query1 = jpaApi.em().createQuery(q,Owner.class);
        List<Owner> ownerList = query1.getResultList();

        if(ownerList.isEmpty()){
            return null;
        }

        Owner owner = ownerList.get(0);

        password = hs.hashPwd(password,owner.getSalt());

        if(!owner.getPwd().equals(password)){
            return null;
        }


        owner.setAuth_token(UUID.randomUUID().toString());

        Calendar cl = Calendar. getInstance();
        cl.add(Calendar.HOUR_OF_DAY,4);
        Logger.debug(""+cl.getTime());

        Timestamp t = new Timestamp(cl.getTimeInMillis());
        Logger.debug(""+t);
        owner.setExpTime(t);
        return owner;
    }

    @Transactional
    public Owner findUserByAuthToken(String authToken) {

        // TODO Find user in DB using authToken
        // TODO Verify token and expiration

        //TODO should username be sent along with password
        Logger.debug(authToken);
        String q = "SELECT o FROM Owner o where o.auth_token='" + authToken + "'";
        Logger.debug(q);
        TypedQuery<Owner> query = jpaApi.em().createQuery(q,Owner.class);
        Logger.debug("{}",query);
        List<Owner> owners = query.getResultList();
        Logger.debug("{}",owners);
        if(owners.isEmpty()) {
            return null;
        }
        Owner o = owners.get(0);

        return o;
    }






}
