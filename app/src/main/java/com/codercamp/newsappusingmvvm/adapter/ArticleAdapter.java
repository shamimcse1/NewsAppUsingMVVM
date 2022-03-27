package com.codercamp.newsappusingmvvm.adapter;

import static com.codercamp.newsappusingmvvm.constants.AppConstant.DESCRIPTION;
import static com.codercamp.newsappusingmvvm.constants.AppConstant.IMAGE_URL;
import static com.codercamp.newsappusingmvvm.constants.AppConstant.TITLE;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codercamp.newsappusingmvvm.R;
import com.codercamp.newsappusingmvvm.model.Article;
import com.codercamp.newsappusingmvvm.view.DetailsActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private  final Context context;
    ArrayList<Article> articleArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Article article = articleArrayList.get(position);

        holder.textView.setText(article.getTitle());
        Glide.with(context).load(article.getUrlToImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), DetailsActivity.class);
                intent.putExtra(TITLE,article.getTitle());
                intent.putExtra(DESCRIPTION,article.getDescription());
                intent.putExtra(IMAGE_URL,article.getUrlToImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public  static  class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.tvTitle);

        }
    }
}
