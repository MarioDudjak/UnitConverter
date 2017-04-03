package hr.ferit.mdudjak.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;



public class DistanceConverterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinnerDistanceFrom, spinnerDistanceTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_converter);
        setUpUI();
    }
    private void setUpUI() {

        this.spinnerDistanceFrom = (Spinner) findViewById(R.id.DistanceFromSpinner);
        this.spinnerDistanceTo = (Spinner) findViewById(R.id.DistanceToSpinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.DistanceSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDistanceFrom.setAdapter(adapter);
        spinnerDistanceTo.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
