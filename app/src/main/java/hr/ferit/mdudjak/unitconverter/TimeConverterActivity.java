package hr.ferit.mdudjak.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TimeConverterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerTimeFrom, spinnerTmeTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_converter);
        setUpUI();
    }
    private void setUpUI() {

        this.spinnerTimeFrom = (Spinner) findViewById(R.id.TimeFromSpinner);
        this.spinnerTmeTo = (Spinner) findViewById(R.id.TimeToSpinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.TimeSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTimeFrom.setAdapter(adapter);
        spinnerTmeTo.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
