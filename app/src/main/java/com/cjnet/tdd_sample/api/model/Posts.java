package com.cjnet.tdd_sample.api.model;

import com.google.gson.annotations.SerializedName;

public class Posts {
    public Posts(String id, String title, String body, String userId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    @SerializedName("userId")
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", title = " + title + ", body = " + body + ", userId = " + userId + "]";
    }
}
