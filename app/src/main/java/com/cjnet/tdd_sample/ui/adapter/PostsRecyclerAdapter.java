package com.cjnet.tdd_sample.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjnet.tdd_sample.R;
import com.cjnet.tdd_sample.api.model.Posts;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.annotations.NonNull;

public class PostsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Posts> posts = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_post_list_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((PostViewHolder)holder).bind(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Posts> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        TextView title;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }

        public void bind(Posts post){
            title.setText(post.getTitle());
        }
    }
}
