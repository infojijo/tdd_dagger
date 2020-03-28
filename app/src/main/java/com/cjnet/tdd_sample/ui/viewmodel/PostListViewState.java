package com.cjnet.tdd_sample.ui.viewmodel;

import com.cjnet.tdd_sample.api.model.PostsList;
import com.cjnet.tdd_sample.base.BaseViewState;

public class PostListViewState extends BaseViewState<PostsList> {

    private PostListViewState(PostsList data, int currentState, Throwable error) {
        this.data = data;
        this.error = error;
        this.currentState = currentState;
    }

    public static PostListViewState ERROR_STATE = new PostListViewState(null, State.FAILED.value, new Throwable());
    public static PostListViewState LOADING_STATE = new PostListViewState(null, State.LOADING.value, null);
    public static PostListViewState SUCCESS_STATE = new PostListViewState(new PostsList(), State.SUCCESS.value, null);

}
