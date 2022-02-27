package com.example.newstak.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newstak.AdapterRecyclerView;
import com.example.newstak.ApiUtilities;
import com.example.newstak.Model;
import com.example.newstak.R;
import com.example.newstak.mainNewa;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Health extends Fragment {

    String api = "a0d00fff91f34940b1997ba9ea0aafe7";
    ArrayList<Model> modelArrayList;
    AdapterRecyclerView adapterRecyclerView;
    String country = "in";
    private RecyclerView recyclerViewofHealth;
    private String category = "health";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_health, null);
        recyclerViewofHealth = view.findViewById(R.id.recyclerViewofHealth);
        modelArrayList=new ArrayList<>();
        recyclerViewofHealth.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterRecyclerView = new AdapterRecyclerView(getContext(),modelArrayList);
        recyclerViewofHealth.setAdapter(adapterRecyclerView);

        findNews();
        return view;

    }

    private void findNews() {
        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<mainNewa>() {
            @Override
            public void onResponse(Call<mainNewa> call, Response<mainNewa> response) {
                if(response.isSuccessful()){
                    modelArrayList.addAll(response.body().getArticles());
                    adapterRecyclerView.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<mainNewa> call, Throwable t) {

            }
        });
    }
}