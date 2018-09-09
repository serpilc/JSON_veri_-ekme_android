package com.example.serpil.webservis_retrofitkurulum.RestApi;

import com.example.serpil.webservis_retrofitkurulum.Models.Bilgiler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("/posts")
    Call<List<Bilgiler>> bilgiGetir();
}
