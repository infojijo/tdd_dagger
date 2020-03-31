package com.cjnet.tdd_sample.viewmodel;

import com.cjnet.tdd_sample.api.ApiEndPoint;
import com.cjnet.tdd_sample.api.PostsApiClient;
import com.cjnet.tdd_sample.api.RxSchedulers;
import com.cjnet.tdd_sample.api.model.PostsList;
import com.cjnet.tdd_sample.ui.viewmodel.PostListViewState;
import com.cjnet.tdd_sample.ui.viewmodel.PostsViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import io.reactivex.Single;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class PostViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    ApiEndPoint apiEndPoint;

    @Mock
    PostsApiClient apiClient;

    private PostsViewModel viewModel;
    @Mock
    Observer<PostListViewState> observer;
    @Mock
    LifecycleOwner lifecycleOwner;
    Lifecycle lifecycle;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lifecycle = new LifecycleRegistry(lifecycleOwner);
        viewModel = new PostsViewModel(apiClient, RxSchedulers.TEST_SCHEDULER);
        viewModel.getPostsListState().observeForever(observer);
    }

    @Test
    public void testNull() {
        when(apiClient.fetchPosts()).thenReturn(null);
        assertNotNull(viewModel.getPostsListState());
        assertTrue(viewModel.getPostsListState().hasObservers());
    }

    @Test
    public void testApiFetchDataSuccess() {
        // Mock API response
        when(apiClient.fetchPosts()).thenReturn(Single.just(new PostsList()));
        viewModel.fetchPosts();
        verify(observer).onChanged(PostListViewState.LOADING_STATE);
        verify(observer).onChanged(PostListViewState.SUCCESS_STATE);
    }

  /*  @Test
    public void testApiFetchDataError() {
        when(apiClient.fetchPosts()).thenReturn(Single.error(new Throwable("Api error")));
        viewModel.getPostsListState();
        verify(observer).onChanged(PostListViewState.LOADING_STATE);
        verify(observer).onChanged(PostListViewState.ERROR_STATE);
    }*/

    @After
    public void tearDown() throws Exception {
        apiClient = null;
        viewModel = null;
    }
}
