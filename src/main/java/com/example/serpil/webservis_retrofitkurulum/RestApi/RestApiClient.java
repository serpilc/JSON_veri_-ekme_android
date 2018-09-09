package com.example.serpil.webservis_retrofitkurulum.RestApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiClient {
    private RestApi mRestApi;
    public RestApiClient(String restApiServiceUrl){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(3, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        OkHttpClient OkHttpClient = builder.build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(restApiServiceUrl)
                .client(OkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRestApi=retrofit.create(RestApi.class);
    }

    public RestApi getRestApi() {
        return mRestApi;
    }
}
