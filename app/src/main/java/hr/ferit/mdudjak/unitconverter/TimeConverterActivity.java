package hr.ferit.mdudjak.unitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class TimeConverterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    public static final String KEY_INPUT_DATA ="input_time";
    public static final String KEY_UNIT_FROM = "value from";
    public static final String KEY_UNIT_TO = "value to";
    public static final String KEY_OUTPUT_DATA = "output time";
    Spinner spinnerTimeFrom, spinnerTmeTo;
    EditText editTextValue;
    Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_converter);
        setUpUI();
    }
    private void setUpUI() {
        this.editTextValue = (EditText) findViewById(R.id.etxtValue);
        this. bCalculate = (Button) findViewById(R.id.bCalculate);
        bCalculate.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        String valueFrom=editTextValue.getText().toString();
        if(valueFrom.length()==0) {
            editTextValue.setError("Converting value is required!");
        }
        else{
            String unitFrom, unitTo,sValueTo;
            unitFrom=spinnerTimeFrom.getSelectedItem().toString();
            unitTo=spinnerTmeTo.getSelectedItem().toString();
            Double valueTo = Calculate(unitFrom,unitTo,valueFrom);
            valueTo=round(valueTo,2);
            sValueTo=valueTo.toString();
            Intent explicitIntent = new Intent(getApplicationContext(),DataReceiverActivity.class);
            explicitIntent.putExtra(KEY_INPUT_DATA,valueFrom);
            explicitIntent.putExtra(KEY_OUTPUT_DATA,sValueTo);
            explicitIntent.putExtra(KEY_UNIT_FROM,unitFrom);
            explicitIntent.putExtra(KEY_UNIT_TO,unitTo);
            this.startActivity(explicitIntent);
        }
    }

    private Double round(Double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private Double Calculate(String unitFrom, String unitTo, String valueFrom) {
        double calculatedValue = 0;
        float fvalueFrom;
        fvalueFrom =Float.parseFloat(valueFrom);
        switch (unitFrom){
            case "Hour":
                if(unitTo.equals("Hour")) calculatedValue=fvalueFrom;
                if(unitTo.equals("Day")) calculatedValue=fvalueFrom/24;
                if(unitTo.equals("Week")) calculatedValue= fvalueFrom/168;
                break;
            case "Day":
                if(unitTo.equals("Hour")) calculatedValue=fvalueFrom*24;
                if(unitTo.equals("Day")) calculatedValue=fvalueFrom;
                if(unitTo.equals("Week")) calculatedValue=fvalueFrom/7;
                break;
            case "Week":
                if(unitTo.equals("Hour")) calculatedValue=fvalueFrom*168;
                if(unitTo.equals("Day")) calculatedValue=fvalueFrom*7;
                if(unitTo.equals("Week")) calculatedValue= fvalueFrom;
                break;
        }
        return calculatedValue;
    }
}
