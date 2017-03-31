package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import controllers.security.UserAuthenticator;
import models.Restaurant;
import models.Reviews;
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

/**
 * Created by Sivani on 02/03/17.
 */
public class ReviewsController {
    private JPAApi jpaApi;

    @Inject
    public ReviewsController(JPAApi jpaApi){
        this.jpaApi=jpaApi;
    }

    @Transactional
    @UserAuthenticator
    public Result addReview(){
        JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest();
        }
        Reviews r = Json.fromJson(json,Reviews.class);
        if(null == r){
            return badRequest();
        }

        User u = (User) ctx().args.get("user");

        Logger.debug(""+r);
        String q1 = "SELECT r FROM Reviews r where r.rid=" + r.getRid() + " AND r.uname = '" + u.getUname() + "'";
        TypedQuery<Reviews> query1 = jpaApi.em().createQuery(q1,Reviews.class);
        List<Reviews> existingRat = query1.getResultList();
        Logger.debug(existingRat+"");
        r.setUname(u.getUname());


        //not rated
        if(existingRat.isEmpty()){

            jpaApi.em().persist(r);
            Restaurant res = jpaApi.em().find(Restaurant.class,r.getRid());
            res.setReviews(r);
            Logger.debug("added");
            Logger.debug(r+"");
        }
        //rated
        else{
            Reviews existingReview = jpaApi.em().find(Reviews.class,existingRat.get(0).getId());
            existingReview.setMsg(r.getMsg());
            jpaApi.em().merge(existingReview);

            Logger.debug("updated");
        }

        json = Json.toJson(r);


        return ok(json);
    }

    @Transactional
    @UserAuthenticator
    public Result getReviewsByUser(){
        User u = (User) ctx().args.get("user");
        String q = "SELECT r FROM Reviews r where r.uname = '" + u.getUname() + "'";
        if(request().getQueryString("rid") != null){
            q += " AND r.rid=" +Integer.parseInt(request().getQueryString("rid"));
        }
        TypedQuery<Reviews> query = jpaApi.em().createQuery(q,Reviews.class);
        List<Reviews> reviews = query.getResultList();
        return ok(Json.toJson(reviews));
    }
}
