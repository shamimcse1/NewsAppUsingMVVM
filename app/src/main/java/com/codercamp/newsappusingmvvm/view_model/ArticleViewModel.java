package com.codercamp.newsappusingmvvm.view_model;

import android.app.Application;

import androidx.annotation.Nullable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.codercamp.newsappusingmvvm.repository.ArticleRepository;
import com.codercamp.newsappusingmvvm.response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {
    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public ArticleViewModel(@Nullable Application application) {

        super(application);
        articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getDashboardNews();
    }

    public LiveData<ArticleResponse> getArticleResponseLiveData() {
        return articleResponseLiveData;
    }
}
