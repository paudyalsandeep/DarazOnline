package com.example.darazonline;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.darazonline.URL.Url;
import com.example.darazonline.adapter.ProductsAdapter;
import com.example.darazonline.api.Api;
import com.example.darazonline.model.Products;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    public List<Products> productsList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        getProduct();
        return view;
    }

    public void getProduct() {
        Api retrofitProductAPI = Url.getRetrofit().create(Api.class);
        Call<List<Products>> ProductsCall = retrofitProductAPI.getAllproucts();
        ProductsCall.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                System.out.println("Product list " + response.body());
                ProductsAdapter recyclerviewAdapter = new ProductsAdapter(getContext(), response.body());
                RecyclerView.LayoutManager mlayoutManager = new GridLayoutManager(getContext(), 3);
                recyclerView.setLayoutManager(mlayoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(recyclerviewAdapter);
                recyclerviewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }
}
