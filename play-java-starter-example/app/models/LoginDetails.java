package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class LoginDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private Integer id;

    @Basic
    @JsonProperty("username")
    private String username;

    @Basic
    @JsonProperty("password")
    private String password;


    public LoginDetails(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public LoginDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}