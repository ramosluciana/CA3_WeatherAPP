package com.CA3.WeatherApp.presenter;


import com.CA3.WeatherApp.DailyWeatherContract;
import com.CA3.WeatherApp.network.ResponseDaily;
import com.CA3.WeatherApp.network.Server;
import com.CA3.WeatherApp.network.ServerAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 /**
 * Created by Luciana Alves - 18350
 */
public class DailyWeatherPresenter implements DailyWeatherContract.Presenter {

    private DailyWeatherContract.View mView;

    public DailyWeatherPresenter(DailyWeatherContract.View view) {
        this.mView = view;
    }

    @Override
    public void load() {
        this.mView.showDialog();
        Server.getServer()
                .create(ServerAPI.class)
                .getDailyWeather().enqueue(new Callback<List<ResponseDaily>>() {
            @Override
            public void onResponse(Call<List<ResponseDaily>> call, Response<List<ResponseDaily>> response) {
                mView.showData(response.body());
                mView.hideDialog();
            }

            @Override
            public void onFailure(Call<List<ResponseDaily>> call, Throwable t) {
                mView.showError(t.getMessage());
                mView.hideDialog();
            }
        });
    }
}
