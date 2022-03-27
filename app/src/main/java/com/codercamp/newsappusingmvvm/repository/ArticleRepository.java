package com.codercamp.newsappusingmvvm.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.codercamp.newsappusingmvvm.model.Article;
import com.codercamp.newsappusingmvvm.response.ArticleResponse;
import com.codercamp.newsappusingmvvm.retrofit.ApiRequest;
import com.codercamp.newsappusingmvvm.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getDashboardNews() {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();

        apiRequest.getTopHeadLines()
                .enqueue(new Callback<Article>() {
                    @Override
                    public void onResponse(Call<Article> call, Response<Article> response) {
                        if (response.body() != null){
                            data.setValue(response.body());
                           // Log.d("Data", response.body().getTitle());
                        }
                    }

                    @Override
                    public void onFailure(Call<Article> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return  data;
    }


}
