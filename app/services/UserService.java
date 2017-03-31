
package services;

import models.User;
import play.Logger;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


public class UserService {

    private JPAApi jpaApi;
    private HashingService hs;

    @Inject
    public UserService(JPAApi jpaApi,HashingService hs) {
        this.jpaApi = jpaApi;
        this.hs = hs;
    }

    public void createUser(User owner) {

        // TODO Save user in DB


    }

    @Transactional
    public User getUserByName(String uname){
        String q = "SELECT u FROM User u WHERE u.uname='" + uname + "'";
        TypedQuery<User> query = jpaApi.em().createQuery(q,User.class);
        List<User> u = query.getResultList();
        if(u.isEmpty()){
            return null;
        }
        return u.get(0);
    }

    public User authenticate(String username, String password) {

        // TODO Find username in DB and compare passwords
        // TODO If success, generate random auth_token and save in DB and return it from this method



        String q = "SELECT u FROM User u where u.uname = '" + username + "'";
        TypedQuery<User> query1 = jpaApi.em().createQuery(q,User.class);
        List<User> userList = query1.getResultList();

        if(userList.isEmpty()){
            return null;
        }

        User user = userList.get(0);

        password = hs.hashPwd(password,user.getSalt());

        if(!user.getPwd().equals(password)){
            return null;
        }


        user.setAuth_token(UUID.randomUUID().toString());

        Calendar cl = Calendar. getInstance();
        cl.add(Calendar.HOUR_OF_DAY,4);
        Logger.debug(""+cl.getTime());

        Timestamp t = new Timestamp(cl.getTimeInMillis());
        Logger.debug(""+t);
        user.setExpTime(t);
        return user;
    }

    @Transactional
    public User findUserByAuthToken(String authToken) {

        // TODO Find user in DB using authToken
        // TODO Verify token and expiration
        Logger.debug(authToken);
        String q = "SELECT u FROM User u where u.auth_token='" + authToken + "'";
        Logger.debug(q);
        TypedQuery<User> query = jpaApi.em().createQuery(q,User.class);
        Logger.debug("{}",query);
        List<User> users = query.getResultList();
        Logger.debug("{}",users);
        if(users.isEmpty()) {
            return null;
        }
        User u = users.get(0);

        return u;
    }



}
