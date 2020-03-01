package com.CA3.WeatherApp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.CA3.WeatherApp.R;
import com.CA3.WeatherApp.WarningContract;
import com.CA3.WeatherApp.database.DataSingleton;
import com.CA3.WeatherApp.database.MyWarning;
import com.CA3.WeatherApp.presenter.WarningPresenter;

import java.util.ArrayList;
import java.util.List;

public class EditWarningActivity extends AppCompatActivity implements WarningContract.View {

    private AppCompatImageView warningSquareImageView;
    private Spinner mSpnTypes,mSpnArea,mSpnLevel;
    private List<String> warningTypes, warningAreas,warningLevels;
    private int idItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_warning);


        this.idItem = getIntent().getIntExtra("MY_WARNING_ITEM", -1);
        setupUI();
        setupSpinners();
        setupValues();
    }

    private void setupUI(){
        warningSquareImageView = findViewById(R.id.warningImageView);
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

    private void setupValues(){
        MyWarning myWarning = DataSingleton.getInstance().getMyWarningList().get(this.idItem);
        mSpnTypes.setSelection(warningTypes.indexOf(myWarning.getType()));
        mSpnArea.setSelection(warningAreas.indexOf(myWarning.getArea()));
        mSpnLevel.setSelection(warningLevels.indexOf(myWarning.getLevel()));
    }


    private void setupSpinners(){
        WarningContract.Presenter mPresenter = new WarningPresenter(this);
        warningTypes = mPresenter.loadWarningTypes();
        warningAreas = mPresenter.loadWarningArea();
        setupLevelsData();


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


        this.mSpnLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                String charSequence = ((TextView) view).getText().toString();
                if (charSequence.toLowerCase().contains("yellow")) {

                    warningSquareImageView.setImageDrawable(getResources().getDrawable(R.drawable.warningyellow));
                }
                if (charSequence.toLowerCase().contains("orange")) {
                    warningSquareImageView.setImageDrawable(getResources().getDrawable(R.drawable.warningorange));
                }
                if (charSequence.toLowerCase().contains("red")) {
                    warningSquareImageView.setImageDrawable(getResources().getDrawable(R.drawable.warningred));
                }
            }
        });
    }

    public void updateWarning(View view) {

        DataSingleton.getInstance().getMyWarningList().get(this.idItem).setArea((String) mSpnArea.getSelectedItem());
        DataSingleton.getInstance().getMyWarningList().get(this.idItem).setType((String) mSpnTypes.getSelectedItem());
        DataSingleton.getInstance().getMyWarningList().get(this.idItem).setLevel((String) mSpnLevel.getSelectedItem());

        Toast.makeText(this, "Atualizado com sucesso",Toast.LENGTH_LONG).show();

        finish();

    }

    public void deleteItem(View view) {
        DataSingleton.getInstance().getMyWarningList().remove(this.idItem);

        Toast.makeText(this, "Item deletado com sucesso",Toast.LENGTH_LONG).show();

        finish();
    }


    @Override
    public void showDialog() {

    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showTypes(List<String> warningTypes) {

    }

    @Override
    public void showArea(List<String> warningAreas) {

    }

    @Override
    public void showError(String message) {

    }
}
