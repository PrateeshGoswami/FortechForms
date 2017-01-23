package com.fortechenergyinc.fortechforms.service;

import com.fortechenergyinc.fortechforms.model.Post;
import com.fortechenergyinc.fortechforms.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Fortech_Room 9 on 1/20/2017.
 */

public interface PostService {
    @GET("/posts")
    Call<List<Post>> getAllPosts();

    @GET("/posts/{id}")
    Call<List<Post>> getPostById(@Path("id") int id);

    @POST("/posts")
    Call<Post> createPost(@Body Post post);

}
