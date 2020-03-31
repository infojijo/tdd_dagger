package com.cjnet.tdd_sample.api;

import com.cjnet.tdd_sample.api.model.PostsList;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiEndPoint {
    //http://cjnet.ca/tdd/posts.php
    @GET(ApiConstant.POST_URL)
    Single<PostsList> fetchPostsList();
}
