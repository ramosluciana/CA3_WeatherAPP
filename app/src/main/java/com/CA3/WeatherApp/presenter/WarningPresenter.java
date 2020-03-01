package com.CA3.WeatherApp.presenter;


import com.CA3.WeatherApp.WarningContract;

import java.util.Arrays;
import java.util.List;

/**
 /**
 * Created by Luciana Alves - 18350
 */

public class WarningPresenter implements WarningContract.Presenter {

    private WarningContract.View mView;

    public WarningPresenter(WarningContract.View view) {
        this.mView = view;
    }

    @Override
    public List<String> loadWarningTypes() {
        mView.hideDialog();
        return Arrays.asList("All",
                "Rain",
                "Wind",
                "Snow Ice",
                "Fog",
                "Low Temperature Ice",
                "High Temperature",
                "Thunderstorm",
                "Advisory"
        );

    }


    @Override
    public List<String> loadWarningArea() {
        mView.hideDialog();
        return Arrays.asList(
                "All counties",
                "Carlow",
                "Cavan",
                "Clare",
                "Cork",
                "Donegal",
                "Dublin",
                "Galway",
                "Kerry",
                "Kildare",
                "Kilkenny",
                "Laois",
                "Leitrim",
                "Limerick",
                "Longford",
                "Louth",
                "Mayo",
                "Meath",
                "Monaghan",
                "Offaly",
                "Roscommon",
                "Sligo",
                "Tipperary",
                "Waterford",
                "Westmeath",
                "Wexford",
                "Wicklow"
        );
    }
}
