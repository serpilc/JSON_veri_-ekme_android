package com.example.serpil.webservis_retrofitkurulum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.serpil.webservis_retrofitkurulum.Adapter.AdapterBilgi;
import com.example.serpil.webservis_retrofitkurulum.Models.Bilgiler;
import com.example.serpil.webservis_retrofitkurulum.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Bilgiler> list;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanımla();
        istek();
    }

    public void tanımla(){
        listView=findViewById(R.id.listView);
    }
    public void istek() {
        list=new ArrayList<>();
        Call<List<Bilgiler>> bilgiList = ManagerAll.getInstance().getirBilgileri();
        bilgiList.enqueue(new Callback<List<Bilgiler>>() {
            @Override
            public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {
                if (response.isSuccessful()){
                    list=response.body();
                    AdapterBilgi adp=new AdapterBilgi(list,getApplicationContext());
                    listView.setAdapter(adp);
                }

            }

            @Override
            public void onFailure(Call<List<Bilgiler>> call, Throwable t) {

            }
        });
    }
}