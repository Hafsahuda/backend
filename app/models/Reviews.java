package models;

import javax.persistence.*;

/**
 * Created by Sivani on 01/03/17.
 */
@Entity
public class Reviews {

    @Id
    @GeneratedValue
    private Integer id;

    @Basic
    private String uname;

    @Basic
    private String msg;

    @Column(name="rid")
    private Integer rid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
