package com.CA3.WeatherApp.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luciana Alves - 18350
 */
public class DataSingleton {

    private static DataSingleton instance;

    private List<MyWarning> myWarningList = new ArrayList<MyWarning>();

    private DataSingleton() {

    }
    public static DataSingleton getInstance(){
        if(instance!=null){
            return  instance;
        }
        instance = new DataSingleton();
        return instance;
    }

    public List<MyWarning> getMyWarningList() {
        return myWarningList;
    }

    public void setMyWarningList(List<MyWarning> myWarningList) {
        this.myWarningList = myWarningList;
    }
}
