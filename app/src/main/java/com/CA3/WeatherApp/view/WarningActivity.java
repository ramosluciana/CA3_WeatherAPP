package com.CA3.WeatherApp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.CA3.WeatherApp.R;
import com.CA3.WeatherApp.adapter.MyWarningsAdapter;

import static android.view.View.GONE;

public class WarningActivity extends AppCompatActivity{

    RecyclerView rv_my_warnings;
    ProgressBar mProgressBar;

    MyWarningsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning);

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        adapter = new MyWarningsAdapter(this);

        setupUI();

    }

    @Override
    protected void onResume() {
        super.onResume();

        setupAdapter();
    }

    private void setupUI(){
        rv_my_warnings = findViewById(R.id.rv_my_warning);
        mProgressBar = findViewById(R.id.progressBar);

    }

    private void setupAdapter(){
        rv_my_warnings.setLayoutManager(new LinearLayoutManager(this));
        rv_my_warnings.setAdapter(adapter);

        mProgressBar.setVisibility(GONE);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate your main_menu into the menu
        getMenuInflater().inflate(R.menu.menu_warning, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        if(id == R.id.action_add_warnings){

            startActivity(new Intent(this, AddWarningActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}
