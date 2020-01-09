package com.example.darazonline.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductsAdapter {

    public class ProductsViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView tvProductName,tvPrice;
        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
