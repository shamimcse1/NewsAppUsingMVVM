package com.codercamp.newsappusingmvvm.retrofit;

import static com.codercamp.newsappusingmvvm.constants.AppConstant.API_KEY;

import com.codercamp.newsappusingmvvm.model.Article;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("top-headlines?country=us&category=business&apiKey="+API_KEY)
    Call<Article> getTopHeadLines();
}
