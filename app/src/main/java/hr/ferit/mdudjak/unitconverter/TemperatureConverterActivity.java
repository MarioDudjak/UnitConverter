package hr.ferit.mdudjak.unitconverter;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class TemperatureConverterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{
    public static final String KEY_INPUT_DATA ="input_temperature";
    public static final String KEY_UNIT_FROM = "value from";
    public static final String KEY_UNIT_TO = "value to";
    public static final String KEY_OUTPUT_DATA = "output temperature";

    Spinner spinnerTemperatureFrom, spinnerTemperatureTo;
    EditText editTextValue;
    Button bCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
        setUpUI();
    }

    private void setUpUI() {
        this.editTextValue = (EditText) findViewById(R.id.etxtValue);
        this. bCalculate = (Button) findViewById(R.id.bCalculate);
        bCalculate.setOnClickListener(this);
        this.spinnerTemperatureFrom = (Spinner) findViewById(R.id.TemperatureFromSpinner);
        this.spinnerTemperatureTo = (Spinner) findViewById(R.id.TemperatureToSpinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.TemperatureSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemperatureFrom.setAdapter(adapter);
        spinnerTemperatureTo.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Provjeriti jel tu šta treba
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Provjeriti jel tu šta treba
    }

    @Override
    public void onClick(View v) {
        String valueFrom=editTextValue.getText().toString();
        if(valueFrom.length()==0) {
            editTextValue.setError("Converting value is required!");
        }
        else{
            String unitFrom, unitTo,sValueTo;
            unitFrom=spinnerTemperatureFrom.getSelectedItem().toString();
            unitTo=spinnerTemperatureTo.getSelectedItem().toString();
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
           case "Celsius":
               if(unitTo.equals("Celsius")) calculatedValue=fvalueFrom;
               if(unitTo.equals("Fahrenheit")) calculatedValue=fvalueFrom*9/5 +32;
               if(unitTo.equals("Kelvin")) calculatedValue= fvalueFrom+273.15;
           break;
           case "Fahrenheit":
               if(unitTo.equals("Celsius")) calculatedValue=(fvalueFrom-32)*5/9;
               if(unitTo.equals("Fahrenheit")) calculatedValue=fvalueFrom;
               if(unitTo.equals("Kelvin")) calculatedValue= (fvalueFrom+459.67)*5/9;
           break;
           case "Kelvin":
               if(unitTo.equals("Celsius")) calculatedValue=fvalueFrom-273.15;
               if(unitTo.equals("Fahrenheit")) calculatedValue=fvalueFrom*9/5 - 459.67;
               if(unitTo.equals("Kelvin")) calculatedValue= fvalueFrom;
           break;
       }
        return calculatedValue;
    }


}
