package com.cjnet.tdd_sample.ui.viewmodel;

import android.widget.Toast;

import com.cjnet.tdd_sample.api.PostsApiClient;
import com.cjnet.tdd_sample.api.RxSchedulers;
import com.cjnet.tdd_sample.api.model.PostsList;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class PostsViewModel extends ViewModel {

    private CompositeDisposable disposable;
    private final PostsApiClient apiClient;
    private final RxSchedulers rxSingleSchedulers;
    private final MutableLiveData<PostListViewState> newsListState = new MutableLiveData<>();

    public MutableLiveData<PostListViewState> getPostsListState() {
        return newsListState;
    }

    @Inject
    public PostsViewModel(PostsApiClient apiClient,
                          RxSchedulers rxSingleSchedulers) {
        this.apiClient = apiClient;
        this.rxSingleSchedulers = rxSingleSchedulers;
        disposable = new CompositeDisposable();

    }

    public void fetchPosts() {
        disposable.add(apiClient.fetchPosts()
                .doOnEvent((newsList, throwable) -> onLoading())
                .compose(rxSingleSchedulers.applySchedulers())
                .subscribe(this::onSuccess,
                        this::onError));
    }


   private void onSuccess(PostsList newsList) {
        PostListViewState.SUCCESS_STATE.setData(newsList);
        newsListState.postValue(PostListViewState.SUCCESS_STATE);

    }

    private void onError(Throwable error) {
        PostListViewState.ERROR_STATE.setError(error);
        newsListState.postValue(PostListViewState.ERROR_STATE);
    }

    private void onLoading() {
        newsListState.postValue(PostListViewState.LOADING_STATE);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }

}
