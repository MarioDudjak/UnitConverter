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



public class DistanceConverterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    public static final String KEY_INPUT_DATA ="input_distance";
    public static final String KEY_UNIT_FROM = "value from";
    public static final String KEY_UNIT_TO = "value to";
    public static final String KEY_OUTPUT_DATA = "output distance";
    Spinner spinnerDistanceFrom, spinnerDistanceTo;
    EditText editTextValue;
    Button bCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_converter);
        setUpUI();
    }
    private void setUpUI() {
        this.editTextValue = (EditText) findViewById(R.id.etxtValue);
        this. bCalculate = (Button) findViewById(R.id.bCalculate);
        bCalculate.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        String valueFrom=editTextValue.getText().toString();
        if(valueFrom.length()==0) {
            editTextValue.setError("Converting value is required!");
        }
        else{
            String unitFrom, unitTo,sValueTo;
            unitFrom=spinnerDistanceFrom.getSelectedItem().toString();
            unitTo=spinnerDistanceTo.getSelectedItem().toString();
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

    private double round(Double value, int places) {
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
            case "Meter":
                if(unitTo.equals("Meter")) calculatedValue=fvalueFrom;
                if(unitTo.equals("Inch")) calculatedValue=fvalueFrom*39.37;
                if(unitTo.equals("Yard")) calculatedValue= fvalueFrom*1.0936;
                break;
            case "Inch":
                if(unitTo.equals("Meter")) calculatedValue=fvalueFrom/39.37;
                if(unitTo.equals("Inch")) calculatedValue=fvalueFrom;
                if(unitTo.equals("Yard")) calculatedValue=fvalueFrom*36;
                break;
            case "Yard":
                if(unitTo.equals("Meter")) calculatedValue=fvalueFrom/1.0936;
                if(unitTo.equals("Inch")) calculatedValue=fvalueFrom/36;
                if(unitTo.equals("Yard")) calculatedValue= fvalueFrom;
                break;
        }
        return calculatedValue;
    }
}
