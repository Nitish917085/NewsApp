package com.example.newstak;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    Context context;
    ArrayList<Model> modelClassArrayList;

    public AdapterRecyclerView(Context context, ArrayList<Model> modelClassArrayList) {
        this.context = context;
        this.modelClassArrayList = modelClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,webView.class);
                intent.putExtra("url",modelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.pulish.setText(modelClassArrayList.get(position).getPublishedAt());
        holder.heading.setText(modelClassArrayList.get(position).getTitle());
        holder.content.setText(modelClassArrayList.get(position).getContent());
        holder.author.setText(modelClassArrayList.get(position).getAuthor());
        Glide.with(context).load(modelClassArrayList.get(position).getUrlToImage()).into(holder.imageView);



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading,content,author,category,line,pulish;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(View view) {
            super(view);
            heading=view.findViewById(R.id.heading);
            content=view.findViewById(R.id.mainContent);
            author=view.findViewById(R.id.author);
            imageView=view.findViewById(R.id.image);
            cardView =view.findViewById(R.id.cardView);
        }
    }
}
