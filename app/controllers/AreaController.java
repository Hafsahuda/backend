package controllers;

/**
 * Created by welcome on 2/17/2017.
 */
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.Area;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.persistence.TypedQuery;
import java.util.List;


public class AreaController extends Controller {

    public AreaController() {
    }
    private JPAApi jpaApi;

    @Inject
    public AreaController(JPAApi jpaApi){
        this.jpaApi = jpaApi;
    }

    @Transactional
    public Result getAreas(){

        TypedQuery<Area> query = jpaApi.em().createQuery("SELECT a FROM Area a ", Area.class);
        List<Area> cuisines = query.getResultList();
        JsonNode json = Json.toJson(cuisines);
        return ok(json);
    }
}

