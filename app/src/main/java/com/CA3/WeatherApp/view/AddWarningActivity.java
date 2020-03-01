package com.CA3.WeatherApp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.CA3.WeatherApp.R;
import com.CA3.WeatherApp.WarningContract;
import com.CA3.WeatherApp.database.DataSingleton;
import com.CA3.WeatherApp.database.MyWarning;
import com.CA3.WeatherApp.presenter.WarningPresenter;

import java.util.ArrayList;
import java.util.List;

public class AddWarningActivity extends AppCompatActivity implements WarningContract.View {

    ProgressBar mProgressBar;
    Spinner mSpnTypes,mSpnArea,mSpnLevel;
    WarningContract.Presenter mPresenter;
    List<String> warningTypes, warningAreas,warningLevels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_warning);

        setupLevelsData();
        setupUI();

        mPresenter = new WarningPresenter(this);
        warningTypes = mPresenter.loadWarningTypes();

        warningAreas = mPresenter.loadWarningArea();

        setupSpinners();

    }

    private void setupUI(){
        mProgressBar = findViewById(R.id.progressBar);
        mSpnArea = findViewById(R.id.areaSpinner);
        mSpnTypes = findViewById(R.id.typeSpinner);
        mSpnLevel = findViewById(R.id.levelSpinner);

    }

    private void setupLevelsData(){
        warningLevels = new ArrayList<>();
        warningLevels.add("Yellow & Above");
        warningLevels.add("Orange & Above");
        warningLevels.add("Red & Above");
    }

    private void setupSpinners(){
        ArrayAdapter<String> adapterTypes = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, warningTypes);
        adapterTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnTypes.setAdapter(adapterTypes);

        ArrayAdapter<String> adapterAreas = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, warningAreas);
        adapterAreas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnArea.setAdapter(adapterAreas);

        ArrayAdapter<String> adapteLevels = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, warningLevels);
        adapteLevels.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpnLevel.setAdapter(adapteLevels);
    }

    public void addWarning(View view) {

        DataSingleton.getInstance().getMyWarningList().add(
                new MyWarning(
                        (String) mSpnArea.getSelectedItem(),
                        (String) mSpnLevel.getSelectedItem(),
                        (String) mSpnTypes.getSelectedItem()
                )
        );
        Toast.makeText(this, "Adicionado com sucesso",Toast.LENGTH_LONG).show();

        finish();

    }

    public void cancel(View view) {
        finish();
    }

    @Override
    public void showDialog() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showTypes(List<String> warningTypes) {
        Log.d("showTypes", warningTypes.toString());
    }

    @Override
    public void showArea(List<String> warningAreas) {
        Log.d("showArea", warningAreas.toString());

    }


    @Override
    public void showError(String message) {

        Log.d("showError", message);
    }
}
