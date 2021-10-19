package com.cosmic.ec2retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    EC2API ec2API;
    private RecyclerView recyclerView;
    private StarTrekAdapter starTrekAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        initRetrofit();
    }

    private void initRetrofit(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://52.203.46.157:5000")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ec2API = retrofit.create(EC2API.class);

        getStarTreks();
    }

    private void getStarTreks(){
        Call<List<StarTrek>> starTreks = ec2API.getStarTreks();
        starTreks.enqueue(new Callback<List<StarTrek>>() {
            @Override
            public void onResponse(Call<List<StarTrek>> call, Response<List<StarTrek>> response) {
                if (!response.isSuccessful()){
                    Log.d(TAG, "onResponse: there was a response but it was not successful : " + "\n" + response.code());
                }
                ArrayList<StarTrek> starTrekArrayList = new ArrayList<>();
                starTrekArrayList.clear();
                List<StarTrek> starTrek = response.body();
                for (int i = 0; i < starTrek.size(); i++){
                    starTrekArrayList.add(starTrek.get(i));
                }
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                linearLayoutManager.setReverseLayout(false);
                recyclerView.setLayoutManager(linearLayoutManager);
                starTrekAdapter = new StarTrekAdapter(MainActivity.this, starTrekArrayList);
                recyclerView.setAdapter(starTrekAdapter);
            }

            @Override
            public void onFailure(Call<List<StarTrek>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}