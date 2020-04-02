package com.cjnet.tdd_sample.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cjnet.tdd_sample.R;
import com.cjnet.tdd_sample.api.TDDViewModelFactory;
import com.cjnet.tdd_sample.base.BaseActivity;
import com.cjnet.tdd_sample.ui.adapter.PostsRecyclerAdapter;
import com.cjnet.tdd_sample.ui.viewmodel.PostsViewModel;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActivity {

    //injected application viewmodel factory
    @Inject
    TDDViewModelFactory tddViewModelFactory;

    RecyclerView recyclerView;
    PostsRecyclerAdapter adapter;

    private PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        postsViewModel = ViewModelProviders.of(this, tddViewModelFactory)
                .get(PostsViewModel.class);
        observeDataChange();
        postsViewModel.fetchPosts();
        adapter = new PostsRecyclerAdapter();
        initRecyclerView();

    }

    private void observeDataChange() {
        postsViewModel.getPostsListState().observe(this, newsListViewState -> {
            switch (newsListViewState.getCurrentState()) {
                case 0:
                    //binding.setShowLoading(true);
                    Log.d("TDDAPP", "loading");
                    break;
                case 1:
                    Log.d("TDDAPP", "success");
                    //binding.setShowLoading(false);
                    adapter.setPosts(newsListViewState.getData().getResults());
                    newsListViewState.getData();
                    Toast.makeText(this, "Posts Loaded "+newsListViewState.getData().getResults().size(),Toast.LENGTH_LONG).show();
                    break;
                case -1: // show error
                    //binding.setShowLoading(false);
                    Log.d("TDDAPP", "error");
                    break;
            }
        });
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        VerticalSpacingItemDecoration verticalSpacingItemDecoration
                = new VerticalSpacingItemDecoration(15);
        recyclerView.addItemDecoration(verticalSpacingItemDecoration);
        recyclerView.setAdapter(adapter);

    }
}
