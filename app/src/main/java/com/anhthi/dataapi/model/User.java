package com.anhthi.dataapi.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("login")
    private String login;
    @SerializedName("id")
    private Integer id;
    @SerializedName("avatar_url")
    private String avatar_url;

    public User() {
    }

    public User(String login, Integer id, String avatar_url) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
