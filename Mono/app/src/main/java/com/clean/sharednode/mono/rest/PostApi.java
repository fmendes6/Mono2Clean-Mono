package com.clean.sharednode.mono.rest;

import com.clean.sharednode.mono.model.Comment;
import com.clean.sharednode.mono.model.Post;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by filipemendes on 29/12/15.
 */
public interface PostApi {

    @GET("/posts/{postId}")
    void getPostById(@Path("postId") int postId, Callback<Post> callback);

    @GET("/posts/{postId}/comments")
    void getPostComments(@Path("postId") int postId, Callback<List<Comment>> callback);
}
