package fr.eilco.model;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String login;
    private String email;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
