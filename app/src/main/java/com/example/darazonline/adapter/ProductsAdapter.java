package com.example.darazonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.darazonline.HomeFragment;
import com.example.darazonline.R;
import com.example.darazonline.model.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {

    Context mContext;
    List<Products>productsList;

    public ProductsAdapter(Context mContext, List<Products> productsList) {
        this.mContext = mContext;
        this.productsList = productsList;
    }




    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard,parent,false);

        return new ProductsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        Products products=productsList.get(position);
        holder.productImage.setImageResource(products.getImageId());
        holder.tvProductName.setText(products.getName());
        holder.tvPrice.setText(products.getPrice());
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ProductsViewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView tvProductName,tvPrice;
        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage=itemView.findViewById(R.id.imageView);
            tvProductName=itemView.findViewById(R.id.tvProductName);
            tvPrice=itemView.findViewById(R.id.tvPrice);



        }
    }
}
