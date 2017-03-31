package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * Created by welcome on 1/4/2017.
 */
@Entity
public class Owner {
    @Id
    @GeneratedValue
    @JsonIgnore
    private int oid;

    @Basic
    private String oname;

    @Basic
    @JsonIgnore
    private String pwd;

    @Basic
    private String eid;

    @Basic
    private String auth_token;

    @Basic
    @JsonIgnore
    private Timestamp expTime;

    @Basic
    @JsonIgnore
    private String salt;

    @Basic
    private String secQuestion;

    @Basic
    private String secAns;

    @Basic
    private Integer verified;

    @Column(name = "verifyToken")
    private String verifyToken;

    @OneToMany
    @JoinColumn(name="o_id", referencedColumnName="oid")
    private List<Restaurant> restaurants;



    public Owner() {
    }


    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Restaurant restaurants) {
        this.restaurants.add(restaurants);
    }

    public String getAuth_token() {
        return auth_token;
    }

    public void setAuth_token(String auth_token) {
        this.auth_token = auth_token;
    }

    public Timestamp getExpTime() {
        return expTime;
    }

    public void setExpTime(Timestamp expTime) {
        this.expTime = expTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSecQuestion() {
        return secQuestion;
    }

    public void setSecQuestion(String secQuestion) {
        this.secQuestion = secQuestion;
    }

    public String getSecAns() {
        return secAns;
    }

    public void setSecAns(String secAns) {
        this.secAns = secAns;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public String getVerifyToken() {
        return verifyToken;
    }

    public void setVerifyToken(String verifyToken) {
        this.verifyToken = verifyToken;
    }
}