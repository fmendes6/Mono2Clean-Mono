package com.clean.sharednode.mono;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.clean.sharednode.mono.model.Comment;
import com.clean.sharednode.mono.model.Post;
import com.clean.sharednode.mono.rest.ApiProvider;
import com.clean.sharednode.mono.rest.PostApi;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private PostApi mApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mApi = ApiProvider.getApi().create(PostApi.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadPost(1);
    }

    private void loadPost(final int postId){
        mApi.getPostById(postId, new Callback<Post>() {
            @Override
            public void success(Post post, Response response) {
                //TODO bind the content of the post to the layout here
                Toast.makeText(MainActivity.this,post.getBody(),Toast.LENGTH_SHORT).show();
                loadComments(postId);
            }

            @Override
            public void failure(RetrofitError error) {
                //TODO handle error
            }
        });
    }

    private void loadComments(int postId){
        mApi.getPostComments(postId, new Callback<List<Comment>>() {
            @Override
            public void success(List<Comment> commentList, Response response) {
                //TODO bind the content of the contents to the layout here
                Toast.makeText(MainActivity.this,"total comments="+commentList.size(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                //TODO handle error
            }
        });
    }
}
