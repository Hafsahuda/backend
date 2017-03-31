package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Sivani on 08/02/17.
 */
@Entity
public class User {
    @GeneratedValue
    @Id
    @JsonIgnore
    Integer uid;
    @Basic
    String uname;
    @Basic
    String eid;
    @Basic
    @JsonIgnore
    String pwd;
    @Basic
    private String auth_token;
    @Basic
    @JsonIgnore
    private String salt;
    @Basic
    @JsonIgnore
    private Timestamp expTime;
    @Basic
    private String secQuestion;
    @Basic
    private String secAns;
    @Basic
    private Integer verified;
    @Column(name="verifyToken")
    private String verifyToken;


    @OneToMany
    @JoinColumn(name = "uid", referencedColumnName="uid")
    private List<Favourites> favourites;

    public User() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public List<Favourites> getFavourites() {
        return favourites;
    }

    public void setFavourites(Favourites favourites) {
        this.favourites.add(favourites);
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
