package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.client.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ImageActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    RecyclerView recyclerView;
    ImageAdapter imageAdapter;
    ArrayList<ApiImages>apiImages;

    private String base_url="https://jsonplaceholder.typicode.com/";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        recyclerView=findViewById(R.id.recycleView);

        apiImages=new ArrayList<>();

        clientresponse();

    }

    public void clientresponse(){

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface= retrofit.create(ApiInterface.class);

        Call<ArrayList<ApiImages>> arrayListCall=apiInterface.getApiImages();

        arrayListCall.enqueue(new Callback<ArrayList<ApiImages>>() {
            @Override
            public void onResponse(Call<ArrayList<ApiImages>> call, Response<ArrayList<ApiImages>> response) {
                apiImages = response.body();
                int i=0;
                for (i=0;i<apiImages.size();i++){
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    imageAdapter=new ImageAdapter(ImageActivity.this,apiImages);
                    recyclerView.setAdapter(imageAdapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ApiImages>> call, Throwable t) {

            }


        });
    }


}