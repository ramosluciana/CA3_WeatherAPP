package com.CA3.WeatherApp.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Luciana Alves - 18350
 */
public interface ServerAPI {

    @GET("weather/daily/53.3239919/-6.5258808/7/")
    Call<List<ResponseDaily>> getDailyWeather();

    @GET("warnings/types/")
    Call<List<String>> getWarningTypes();


    @GET("warnings/regions/")
    Call<List<String>> getWarningRegions();
}
