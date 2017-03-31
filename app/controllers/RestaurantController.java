package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import controllers.security.Authenticator;

import models.Cuisine;
import models.Owner;
import models.Restaurant;
import play.Logger;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;


import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.ListIterator;



/**
 * Created by Sivani on 29/12/16.
 */
public class RestaurantController extends Controller {

    private JPAApi jpaApi;

    public RestaurantController() {

    }

    @Inject
    public RestaurantController(JPAApi jpaApi){
        this.jpaApi = jpaApi;
    }

    @Transactional
    public Result getAllRestaurants(){

        TypedQuery<Restaurant> query = jpaApi.em().createQuery("SELECT r FROM Restaurant r ",Restaurant.class);
        List<Restaurant> restaurants = query.getResultList();
        Logger.info("restaurants" , restaurants);
        JsonNode json = Json.toJson(restaurants);
        return ok(json);
    }

    @Transactional
    public Result getRestaurantByID(Integer id){

        Restaurant r = jpaApi.em().find(Restaurant.class, id);
        JsonNode json = Json.toJson(r);
        return ok(json);
    }

    @Transactional
    @Authenticator
    public Result deleteRestaurant(Integer id){
        Restaurant r = jpaApi.em().find(Restaurant.class,id);
        jpaApi.em().remove(r);
        return ok();
    }

    @Transactional
    @Authenticator
    public Result updateRestaurant(Integer id){
        final JsonNode json = request().body().asJson();
        if(null == json){
            return badRequest("not found");
        }
        Restaurant r=Json.fromJson(json,Restaurant.class);
        if(null == r){
            return badRequest("not found");
        }

        Restaurant existingRes = jpaApi.em().find(Restaurant.class,id);

        if(null != r.getName()) {
            existingRes.setName(r.getName());
        }
        if(null != r.getCuisine()) {
            ListIterator<Cuisine> cuisineList = r.getCuisine().listIterator();
            existingRes.getCuisine().clear();
            while(cuisineList.hasNext()){
                Cuisine cuisine1 = new Cuisine(cuisineList.next().getCuisine());
                existingRes.getCuisine().add(cuisine1);
            }
        }
        if(null != r.getCost()) {
            existingRes.setCost(r.getCost());
        }
		 if(null != r.getPhotosPath()) {
            existingRes.setPhotosPath(r.getPhotosPath());
        }
        if(null != r.getMenuPath()) {
            existingRes.setMenuPath(r.getMenuPath());
        }
        if(null != r.getPhn()) {
            existingRes.setPhn(r.getPhn());
        }
        if(null != r.getAddress()) {
            existingRes.setAddress(r.getAddress());
        }
        if(null != r.getDescription()) {
            existingRes.setDescription(r.getDescription());
        }
        if(null != r.getOpenTime()) {
            existingRes.setOpenTime(r.getOpenTime());
        }
        if(null != r.getCloseTime()) {
            existingRes.setCloseTime(r.getCloseTime());
        }
        if(null != r.getHighlights()) {
            existingRes.setHighlights(r.getHighlights());
        }
        if(null != r.getFbUrl()) {
            existingRes.setFbUrl(r.getFbUrl());
        }
        if(null != r.getLatitude()){
            existingRes.setLatitude(r.getLatitude());
        }
        if(null != r.getLongitude()){
            existingRes.setLongitude(r.getLongitude());
        }
        if(null != r.getArea()){
            existingRes.setArea(r.getArea());
        }
        if(null != r.getFbUrl()){
            existingRes.setFbUrl(r.getFbUrl());
        }
        if(null != r.getHomePageUrl()){
            existingRes.setHomePageUrl(r.getHomePageUrl());
        }

        jpaApi.em().merge(existingRes);
        return ok("updated "+existingRes.getName());
    }

    @Transactional
    @Authenticator
    public Result addRestaurant(){

        JsonNode json = request().body().asJson();
        if (null == json) {
            Logger.error("Unable to get json from request");
            return badRequest("Unable to get json from request");
        }
        final Restaurant r = Json.fromJson(json, Restaurant.class);
        //Logger.info("hello"+o.getEid(),o);
        if (null == r) {
            Logger.error("Unable to parse json to restaurant object");
            return badRequest("Unable to parse json to restaurant object");
        }

        Owner o = (Owner) ctx().args.get("user");
        r.setOid(o.getOid());
        o.setRestaurants(r);
        jpaApi.em().persist(r);
        json = Json.toJson(r);
        return ok(json);
    }

    @Transactional
    public Result getRestaurantNew(){
        String q = "SELECT * FROM Restaurant ORDER BY id DESC LIMIT 6";
        Query query = jpaApi.em().createNativeQuery(q,Restaurant.class);
        List<Object[]> restaurants = query.getResultList();
        JsonNode json = Json.toJson(restaurants);
        return ok(json);
    }

    @Transactional
    public Result restaurantFilters() {

        Integer fCount = 0;
        String[] filters = {"","","","",""};
        Integer time = null;
        Integer id = null;
        Integer newFlag = null;
        Integer high,low;
        high = null;
        low = null;

        if(request().getQueryString("id") != null) {
            id = Integer.parseInt(request().getQueryString("id"));
            Logger.debug("" + id);

        }

        if(request().getQueryString("time") != null) {
            time = Integer.parseInt(request().getQueryString("time"));
            Logger.debug("" + time);

        }

        if(request().getQueryString("new") != null) {
            newFlag = Integer.parseInt(request().getQueryString("new"));
            Logger.debug("" + newFlag);

        }

        if(request().getQueryString("high") != null || request().getQueryString("high") != null) {
            high=Integer.parseInt(request().getQueryString("high"));
            low=Integer.parseInt(request().getQueryString("low"));
            Logger.debug(""+high+" "+low);

        }

        //calculating query parameters and its count

        if(request().getQueryString("area") != null){
            Logger.debug(request().getQueryString("area"));
            filters[fCount] = "area";
            fCount++;
            Logger.debug(""+fCount);
            Logger.debug(filters[fCount]);

        }

         if (request().getQueryString("name") != null) {
             filters[fCount] = "name";
            fCount++;

        }

         if (request().getQueryString("cuisine") != null) {
             filters[fCount] = "cuisine";
            fCount++;

        }

        if (request().getQueryString("lat") != null && request().getQueryString("lng") != null) {
            filters[fCount] = "nearby";
            fCount++;
        }

        if(request().getQueryString("rating") != null){
            filters[fCount] = "rating";
            fCount++;
        }

        if(high != null || low != null){
            filters[fCount] = "cost";
            fCount++;
            Logger.debug("inside"+high+low);
            // return getRestaurantByCost(low,high);
        }

        if (time != null) {
            filters[fCount] = "open";
            fCount++;
            Logger.debug("inside"+time);

        }

        if(request().getQueryString("type") != null){
            filters[fCount] = "type";
            fCount++;
        }

        //non-filters
        if(newFlag != null){

            return getRestaurantNew();
        }

         if(id != null){

            Logger.debug("inside "+id);
            return getRestaurantByID(id);
        }

        //no params
        if(0 == fCount)
            return getAllRestaurants();

        Logger.debug("count:"+fCount);

        return queryResolve(fCount,filters,request());

    }

    @Transactional
    public Result queryResolve(Integer fCount, String[] filters, Http.Request r){
        Logger.debug(r.getQueryString("area")+" query");
        String q = "Select * FROM Restaurant where ";
        for(int i=0;i<fCount;i++){
            if(filters[i].equals("name")){
                q += "name LIKE '%" + r.getQueryString("name") + "%'";
            }
            else if(filters[i].equals("area")){
                q += "area LIKE '%" + r.getQueryString("area") + "%'";
            }
            else if(filters[i].equals("cuisine")){
                q += "id IN (SELECT Restaurant_id FROM Restaurant_Cuisine where cuisine_cuisine LIKE '%"+r.getQueryString("cuisine")+"%')";
            }
            else if(filters[i].equals("nearby")){
                Logger.debug("in nearby",Restaurant.class);


                String q1 = "UPDATE restaurant \n" +
                        "SET g = GeomFromText( \n" +
                        "CONCAT('POINT(', CAST(latitude AS CHARACTER(20)), \n" +
                        "' ', CAST(longitude AS CHARACTER(20)),')') \n" +
                        ");";

                Query query1 = jpaApi.em().createNativeQuery(q1);
                query1.executeUpdate();

                Double lat = Double.parseDouble(r.getQueryString("lat"));
                Double lng = Double.parseDouble(r.getQueryString("lng"));
                Logger.info(""+lat+""+lng);
                q += "MBRCONTAINS(GeomFromText ( " +
                "        CONCAT('LINESTRING(',\n" + lat +
                        "                              -(4/111.045),' ',\n" + lng +
                        "                              -(4/(111.045* COS(RADIANS(" + lat + ")))),\n" +
                        "                              ',',\n" + lat +
                        "                              +(4/111.045) ,' ',\n" + lng +
                        "                              +(4/(111.045 * COS(RADIANS(" + lat + ")))), \n" +
                        "                              ')')),  g)";
            }
            else if(filters[i].equals("cost")){
                Integer low = Integer.parseInt(request().getQueryString("low"));
                Integer high = Integer.parseInt(request().getQueryString("high"));
                if(high == 0){
                    q +="cost >=" + low ;
                }
                else{
                    q += "cost BETWEEN " + low + " AND " + high;
                }
            }
            else if(filters[i].equals("open")){

                q += "((openTime > closeTime AND id IN(SELECT id FROM restaurant where CURTIME() > openTime and CURTIME() < ADDTIME(closeTime,'24:00:00'))) OR (CURTIME()>openTime and CURTIME()<closeTime))";
            }
            else if(filters[i].equals("rating")){
                q += "avg_rating >= " + Double.parseDouble(request().getQueryString("rating"));
            }
            else if(filters[i].equals("type")){
                q += "highlights LIKE '%" + request().getQueryString("type") + "%'";
            }
            if(i+1!=fCount) {
                q += " AND ";
            }
        }

        Query query = jpaApi.em().createNativeQuery(q,Restaurant.class);
        List<Object[]> restaurants = query.getResultList();
        Logger.info("restaurants",restaurants);
        JsonNode json = Json.toJson(restaurants);
        return ok(json);

    }

}
