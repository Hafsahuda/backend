package models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sivani on 09/02/17.
 */
@Entity
public class Area {
    @Id
    @Column(name="area")
    private String area;

    @OneToMany
    @JoinColumn(name="area", referencedColumnName="area")
    private List<Restaurant> restaurants;

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Area() {
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


}
