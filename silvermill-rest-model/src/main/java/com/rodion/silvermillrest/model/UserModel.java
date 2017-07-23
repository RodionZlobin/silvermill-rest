package com.rodion.silvermillrest.model;

import com.rodion.silvermilldata.domain.ValueObject;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class UserModel extends ValueObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected Object[] getIdFields() {
        return new Object[]{username, password};
    }
}
