package hr.ferit.mdudjak.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class WeightConverterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinnerWeightFrom, spinnerWeightTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_converter);
        setUpUI();
    }

    private void setUpUI() {

        this.spinnerWeightFrom = (Spinner) findViewById(R.id.WeightFromSpinner);
        this.spinnerWeightTo = (Spinner) findViewById(R.id.WeightToSpinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.WeightSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWeightFrom.setAdapter(adapter);
        spinnerWeightTo.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
