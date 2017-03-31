package models;

import javax.persistence.*;


/**
 * Created by SAI PRABHA ANUBHUTI on 08-02-2017.
 */
@Entity
public class Cuisine {

    @Id
    @Column(name = "cuisine")
    private String cuisine;

    public Cuisine() {
    }

    public Cuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

}
