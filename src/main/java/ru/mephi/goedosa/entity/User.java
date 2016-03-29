package ru.mephi.goedosa.entity;

import java.util.Map;

/**
 * Created by artemsamsonov on 26.11.15.
 */

public class User extends Entity {

    String login;
    String password;
    Map<String, Integer> access_level;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Integer> getAccess_level() {
        return access_level;
    }

    public void setAccess_level(Map<String, Integer> access_level) {
        this.access_level = access_level;
    }

    @Override
    public String toString() {
        return "User{" +
                "access_level=" + access_level +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}