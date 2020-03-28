package com.cjnet.tdd_sample.api;

import com.cjnet.tdd_sample.api.model.PostsList;

import javax.inject.Inject;

import io.reactivex.Single;

public class PostsApiClient {

    private final ApiEndPoint api;

    @Inject
    public PostsApiClient(ApiEndPoint api) {
        this.api = api;
    }

    public Single<PostsList> fetchPosts() {
        return api.fetchPostsList();
    }
}
