package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import controllers.security.UserAuthenticator;
import models.Ratings;
import models.Restaurant;
import models.User;
import play.Logger;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

import javax.persistence.TypedQuery;

import java.util.List;

import static play.mvc.Http.Context.Implicit.ctx;
import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;


public class RatingsController {
    private JPAApi jpaApi;

    @Inject
    public RatingsController(JPAApi jpaApi){
        this.jpaApi=jpaApi;
    }

    @Transactional
    @UserAuthenticator
    public Result addRating(){
        JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest();
        }
        Ratings r = Json.fromJson(json,Ratings.class);
        if(null == r){
            return badRequest();
        }

        User u = (User) ctx().args.get("user");

        Logger.debug(""+r);
        String q1 = "SELECT r FROM Ratings r where r.rid=" + r.getRid() + " AND r.uname = '" + u.getUname() + "'";
        TypedQuery<Ratings> query1 = jpaApi.em().createQuery(q1,Ratings.class);
        List<Ratings> existingRat = query1.getResultList();
        Logger.debug(existingRat+"");
        r.setUname(u.getUname());


        //not rated
        if(existingRat.isEmpty()){

            jpaApi.em().persist(r);
            Restaurant res = jpaApi.em().find(Restaurant.class,r.getRid());
            res.setRatings(r);
            Logger.debug("added");
            Logger.debug(r+"");
        }
        //rated
        else{
            Ratings existingRating = jpaApi.em().find(Ratings.class,existingRat.get(0).getId());
            existingRating.setRating(r.getRating());
            jpaApi.em().merge(existingRating);

            Logger.debug("updated");
        }


        //avg rating
        avgRating(r);


       return ok(json);
    }

    @Transactional
    public Result avgRating(Ratings r){
        double avgRat = 0;
        Logger.debug(""+r.getRid());
        int id = r.getRid();
        Restaurant res = jpaApi.em().find(Restaurant.class,id);
        Logger.debug(""+res);
        List<Ratings> ratList = res.getRatings();
        Logger.debug(""+ratList);
        Logger.debug(""+ratList.lastIndexOf(r));



        for(int i=0;i<ratList.size();i++){
            if(null == ratList.get(i).getRating()){
                continue;
            }
            avgRat += ratList.get(i).getRating();
            Logger.debug(""+avgRat);
        }
        avgRat = avgRat/(ratList.size());
        avgRat = (double) Math.round(avgRat*1000.0)/1000.0;
        res.setAvg_rating(avgRat);
        Logger.debug(""+avgRat);
        return ok();
    }

    @Transactional
    @UserAuthenticator
    public Result getRatingByUser(){
        User u = (User) ctx().args.get("user");
        String q = "SELECT r FROM Ratings r where r.uname = '" + u.getUname() + "'";
        if(request().getQueryString("rid") != null){
            q += " AND r.rid="+Integer.parseInt(request().getQueryString("rid"));
        }
        Logger.debug(q);
        TypedQuery<Ratings> query = jpaApi.em().createQuery(q,Ratings.class);
        List<Ratings> ratings = query.getResultList();
        return ok(Json.toJson(ratings));
    }

}
