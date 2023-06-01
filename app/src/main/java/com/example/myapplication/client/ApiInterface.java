package com.example.myapplication.client;

import com.example.myapplication.ApiImages;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("photos")
    Call<ArrayList<ApiImages>> getApiImages();
}
