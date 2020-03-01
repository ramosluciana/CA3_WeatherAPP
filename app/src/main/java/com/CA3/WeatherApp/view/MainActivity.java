package com.CA3.WeatherApp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.CA3.WeatherApp.adapter.DailyAdapter;
import com.CA3.WeatherApp.DailyWeatherContract;
import com.CA3.WeatherApp.R;
import com.CA3.WeatherApp.network.ResponseDaily;
import com.CA3.WeatherApp.presenter.DailyWeatherPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DailyWeatherContract.View,View.OnClickListener {

    private String[] dayNumbers = new String[7];
    private ProgressBar mProgress;

    private RecyclerView recyclerView;
    private DailyWeatherPresenter mPresenter;
    private DailyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setupViews();
        this.mProgress = findViewById(R.id.progressBar);
        this.recyclerView = findViewById(R.id.rv_daily);

        mPresenter = new DailyWeatherPresenter(this);
        mPresenter.load();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }



    @Override
    public void onClick(View v) {
        if (this.dayNumbers.length != 0) {
        }

    }

    @Override
    public void showDialog() {
        this.mProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        this.mProgress.setVisibility(View.GONE);
    }

    @Override
    public void showData(List<ResponseDaily> responseDailies) {
        Log.d("DATA",responseDailies.size()+"");
        adapter = new DailyAdapter(this, null,responseDailies);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showError(String message) {
        Log.d("DATA_ERROR",message);
    }

    public void warningsSession(View view) {
        startActivity(new Intent(this, WarningActivity.class));
    }
}
