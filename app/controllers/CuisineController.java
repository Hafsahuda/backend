package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.Cuisine;
import models.Restaurant;
import play.Logger;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by anubhuti on 10/02/17.
 */
public class CuisineController extends Controller {

    public CuisineController() {
    }
    private JPAApi jpaApi;

    @Inject
    public CuisineController(JPAApi jpaApi){
        this.jpaApi = jpaApi;
    }

    @Transactional
    public Result getCuisines(){

        TypedQuery<Cuisine> query = jpaApi.em().createQuery("SELECT c FROM Cuisine c ", Cuisine.class);
        List<Cuisine> cuisines = query.getResultList();
        JsonNode json = Json.toJson(cuisines);
        return ok(json);
    }
}
