package com.cjnet.tdd_sample.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostsList {

    @SerializedName("results")
    private List<Posts> results;

    public List<Posts> getResults() {
        return results;
    }

    public void setResults(List<Posts> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "ClassPojo [results = " + results + "]";
    }
}
