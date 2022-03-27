package com.codercamp.newsappusingmvvm.view;

import static com.codercamp.newsappusingmvvm.constants.AppConstant.DESCRIPTION;
import static com.codercamp.newsappusingmvvm.constants.AppConstant.IMAGE_URL;
import static com.codercamp.newsappusingmvvm.constants.AppConstant.TITLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codercamp.newsappusingmvvm.R;
import com.google.android.material.appbar.AppBarLayout;

import java.util.Objects;

public class DetailsActivity extends AppCompatActivity {
    private String title, description, image_url;
    private TextView Title, Description;
    private ImageView imageView;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_details);


        initView();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            title = bundle.getString(TITLE);
            description = bundle.getString(DESCRIPTION);
            image_url = bundle.getString(IMAGE_URL);
            setData();
        }
    }

    private void initView() {
        Title = findViewById(R.id.detailsTitle);
        Description = findViewById(R.id.detailsDescription);
        imageView = findViewById(R.id.detailsImageView);
        // toolbar = findViewById(R.id.toolbar);
    }

    private void setData() {
//        toolbar.setTitle(title);
//        setSupportActionBar(toolbar);
        Title.setText(title);
        Description.setText(description);
        Glide.with(DetailsActivity.this).load(image_url).into(imageView);
    }
}