package com.CA3.WeatherApp.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luciana Alves - 18350
 */
public class Server {
    //DUBLIN
    private final static String BASE_URL = "https://prodapi.metweb.ie/";

    public static Retrofit getServer(){
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .client(provideOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}
