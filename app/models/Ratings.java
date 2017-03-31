package models;

import javax.persistence.*;


/**
 * Created by welcome on 2/23/2017.
 */

@Entity
public class Ratings {

    @Id
    @GeneratedValue
    private Integer id;

    @Basic
    private Integer rating;

    @Basic
    private String uname;

    @Column(name="rid")
    private Integer rid;


    public Ratings() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}


