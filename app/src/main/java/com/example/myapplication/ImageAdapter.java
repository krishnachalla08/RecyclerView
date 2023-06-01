package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter  extends RecyclerView.Adapter<ImageAdapter.imageViewHolder>{

    Context context;
    ArrayList<ApiImages>imagesArrayList;

    public ImageAdapter(Context context, ArrayList<ApiImages> imagesArrayList) {
        this.context = context;
        this.imagesArrayList = imagesArrayList;
    }

    @NonNull
    @Override
    public imageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.imagelayout,parent,false);
        return new imageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull imageViewHolder holder, int position) {
        ApiImages apiImages = imagesArrayList.get(position);
        String imageurl;
        imageurl= apiImages.getUrl();
        Picasso.get().load(imageurl).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return imagesArrayList.size();
    }

    public class imageViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public imageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.apiimage);
        }


    }
}
