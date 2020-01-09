package com.example.darazonline;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darazonline.adapter.ProductsAdapter;
import com.example.darazonline.model.Products;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=view.findViewById(R.id.recyclerView);

        List<Products>productsList=new ArrayList<>();
        productsList.add(new Products("Ram","500",R.drawable.ram));
        productsList.add(new Products("Speaker","200",R.drawable.ram));
        productsList.add(new Products("Monitor","1000",R.drawable.ram));

        ProductsAdapter productsAdapter=new ProductsAdapter();

        recyclerView.setAdapter(productsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));



        return view;
    }
}
