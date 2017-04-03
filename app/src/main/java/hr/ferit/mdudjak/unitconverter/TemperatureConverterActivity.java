package hr.ferit.mdudjak.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class TemperatureConverterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerTemperatureFrom, spinnerTemperatureTo;
    EditText editTextValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
        setUpUI();
    }

    private void setUpUI() {
        this.editTextValue = (EditText) findViewById(R.id.etxtValue);

        this.spinnerTemperatureFrom = (Spinner) findViewById(R.id.TemperatureFromSpinner);
        this.spinnerTemperatureTo = (Spinner) findViewById(R.id.TemperatureToSpinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.TemperatureSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemperatureFrom.setAdapter(adapter);
        spinnerTemperatureTo.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
