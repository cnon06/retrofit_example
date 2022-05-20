package com.cnon.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("/posts/{id}")
    public Call<Post> getPostWithID(@Path("id") int id);
}