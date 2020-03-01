package com.CA3.WeatherApp;

import java.util.List;

/**
 * Created by Luciana Alves - 18350
 */
public interface WarningContract {
    interface View{
        void showDialog();
        void hideDialog();
        void showTypes(List<String> warningTypes);
        void showArea(List<String> warningAreas);
        void showError(String message);
    }
    interface Presenter{
        List<String> loadWarningTypes();
        List<String> loadWarningArea();
    }
}
