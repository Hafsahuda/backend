package models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Time;
import java.util.List;

@Entity
public class Restaurant {
    
    @Id
    @GeneratedValue
    private Integer id;
    @Basic
    private String name;
    @Basic
    private Double latitude;
    @Basic
    private Double longitude;
    @Basic
    private Integer cost;
    @Basic
    private String phn;
    @Basic
    private String address;
    @Basic
    private String description;
    @Basic
    private String fbUrl;
    @Basic
    private Time openTime;
    @Basic
    private Time closeTime;
    @Basic
    private String[] highlights;
    @Basic
    private String[] photosPath;
    @JsonIgnore
    @Column(name = "o_id")
    private Integer oid;
    @Basic
    private Blob g;
    @Basic
    private double avg_rating;
    @Basic
    private String[] menuPath;
    @Basic
    private String homePageUrl;
    @Column(name="area")
    private String area;


    @ManyToMany
    @JoinColumn(name = "cuisine", referencedColumnName="cuisine")
    private List<Cuisine> cuisine;

    @OneToMany
    @JoinColumn(name = "rid", referencedColumnName="id")
    private List<Ratings> ratings;

    @OneToMany
    @JoinColumn(name = "rid", referencedColumnName="id")
    private List<Reviews> reviews;



    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Restaurant() {
    }

    public List<Cuisine> getCuisine() {
        return cuisine;
    }

    public void setCuisine(List<Cuisine> cuisine) {
        this.cuisine = cuisine;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public String[] getHighlights() {
        return highlights;
    }

    public void setHighlights(String[] highlights) {
        this.highlights = highlights;
    }

    public String[] getPhotosPath() {
        return photosPath;
    }

    public void setPhotosPath(String[] photosPath) {
        this.photosPath = photosPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFbUrl() {
        return fbUrl;
    }

    public void setFbUrl(String fbUrl) {
        this.fbUrl = fbUrl;
    }

    public double getAvg_rating() {
        return avg_rating;
    }

    public void setAvg_rating(double avg_rating) {
        this.avg_rating = avg_rating;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings.add(ratings);
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(Reviews reviews) {
        this.reviews.add(reviews);
    }

    public String[] getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String[] menuPath) {
        this.menuPath = menuPath;
    }

    public String getHomePageUrl() {
        return homePageUrl;
    }

    public void setHomePageUrl(String homePageUrl) {
        this.homePageUrl = homePageUrl;
    }

}
