package com.CA3.WeatherApp;

import com.CA3.WeatherApp.network.ResponseDaily;

import java.util.List;

/**
 /**
 * Created by Luciana Alves - 18350
 */

public interface DailyWeatherContract {
    interface View{
        void showDialog();
        void hideDialog();
        void showData(List<ResponseDaily> responseDailies);
        void showError(String message);
    }
    interface Presenter{
        void load();
    }
}
