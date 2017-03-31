package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.security.UserAuthenticator;
import models.Favourites;
import models.Restaurant;
import models.User;
import play.Logger;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import static play.mvc.Controller.request;
import static play.mvc.Http.Context.Implicit.ctx;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by welcome on 3/6/2017.
 */
public class FavouritesController {

    private JPAApi jpaApi;

    @Inject
    public FavouritesController(JPAApi jpaApi) {
        this.jpaApi = jpaApi;
    }

    @Transactional
    @UserAuthenticator
    public Result addFavourite(){
        JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest();
        }

        Favourites fav = Json.fromJson(json,Favourites.class);
        if(null == fav){
            return badRequest();
        }

        User u = (User) ctx().args.get("user");

        String q1 = "SELECT f FROM Favourites f where f.rid=" + fav.getRid() + " AND f.uid = '" + u.getUid() + "'";
        TypedQuery<Favourites> query1 = jpaApi.em().createQuery(q1,Favourites.class);
        List<Favourites> existingFav = query1.getResultList();
        Logger.debug(existingFav+"");
        fav.setUid(u.getUid());

        if(existingFav.isEmpty()){
            jpaApi.em().persist(fav);

            u.setFavourites(fav);
            Logger.debug("added");
            Logger.debug(fav+"");
            json = Json.toJson(fav);
            return ok(json);
        }

        else{
            Favourites existingFavs = jpaApi.em().find(Favourites.class,existingFav.get(0).getId());
            jpaApi.em().remove(existingFavs);
            Logger.debug("deleted");
            return ok("deleted");
        }


    }

    @Transactional
    @UserAuthenticator
    public Result getUserFavs(){
        User user = (User) ctx().args.get("user");
        ArrayList<Restaurant> res = new ArrayList<Restaurant>();
        for(int i=0;i<user.getFavourites().size();i++){
            res.add(jpaApi.em().find(Restaurant.class,user.getFavourites().get(i).getRid()));
        }
        JsonNode json = Json.toJson(res);
        return ok(json);
    }

}
