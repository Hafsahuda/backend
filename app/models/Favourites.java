package models;

import javax.persistence.*;

/**
 * Created by welcome on 3/6/2017.
 */
@Entity
public class Favourites {
    @Id
    @GeneratedValue
    Integer id;
    @Basic
    Integer rid;
    @Column(name = "uname")
    Integer uid;

    public Favourites() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
