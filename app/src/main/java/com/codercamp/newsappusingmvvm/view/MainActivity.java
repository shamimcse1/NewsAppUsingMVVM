package com.codercamp.newsappusingmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.codercamp.newsappusingmvvm.R;
import com.codercamp.newsappusingmvvm.adapter.ArticleAdapter;
import com.codercamp.newsappusingmvvm.model.Article;
import com.codercamp.newsappusingmvvm.view_model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;
    private ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getArticles();
    }


    public void init() {
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progress_circular);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new ArticleAdapter(MainActivity.this, articleArrayList);
        recyclerView.setAdapter(adapter);

        //articleViewModel = ViewModelProvider.of(this).get(ArticleViewModel.class);
        articleViewModel = new ViewModelProvider(MainActivity.this).get(ArticleViewModel.class);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void getArticles() {

        articleViewModel.getArticleResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null && articleResponse.getArticles() != null && !articleResponse.getArticles().isEmpty()) {
                progressBar.setVisibility(View.GONE);
                List<Article> articleList = articleResponse.getArticles();
                articleArrayList.addAll(articleList);

                adapter.notifyDataSetChanged();
            }
        });
    }
}