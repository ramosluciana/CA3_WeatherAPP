package com.CA3.WeatherApp.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Luciana Alves - 18350
 */
public class ResponseWarning {
    @SerializedName("level")
    @Expose
    private String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
