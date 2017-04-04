package hr.ferit.mdudjak.unitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class DataReceiverActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtValueFrom, txtValueTo, txtUnitFrom, txtUnitTo;
    ImageButton bReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_receiver);
        this.setUpUI();
    }

    private void setUpUI() {
    this.txtValueFrom = (TextView) findViewById(R.id.txtValueToConvert);
    this. txtValueTo = (TextView) findViewById(R.id.txtConvertedValue);
    this. txtUnitFrom = (TextView) findViewById(R.id.txtUnitToConvert);
    this.txtUnitTo = (TextView) findViewById(R.id.txtConvertedUnit);
    this.bReturn= (ImageButton) findViewById(R.id.ImageButtonReturn);
    this.bReturn.setOnClickListener(this);
    Intent startingIntent = this.getIntent();
    if(startingIntent.hasExtra(TemperatureConverterActivity.KEY_INPUT_DATA)){
        txtValueFrom.setText(startingIntent.getStringExtra(TemperatureConverterActivity.KEY_INPUT_DATA));
        txtUnitFrom.setText(startingIntent.getStringExtra(TemperatureConverterActivity.KEY_UNIT_FROM));
        txtUnitTo.setText(startingIntent.getStringExtra(TemperatureConverterActivity.KEY_UNIT_TO));
        txtValueTo.setText(startingIntent.getStringExtra(TemperatureConverterActivity.KEY_OUTPUT_DATA));
    }
    if(startingIntent.hasExtra(WeightConverterActivity.KEY_INPUT_DATA)){
        txtValueFrom.setText(startingIntent.getStringExtra(WeightConverterActivity.KEY_INPUT_DATA));
        txtUnitFrom.setText(startingIntent.getStringExtra(WeightConverterActivity.KEY_UNIT_FROM));
        txtUnitTo.setText(startingIntent.getStringExtra(WeightConverterActivity.KEY_UNIT_TO));
        txtValueTo.setText(startingIntent.getStringExtra(WeightConverterActivity.KEY_OUTPUT_DATA));
    }
    if(startingIntent.hasExtra(DistanceConverterActivity.KEY_INPUT_DATA)){
        txtValueFrom.setText(startingIntent.getStringExtra(DistanceConverterActivity.KEY_INPUT_DATA));
        txtUnitFrom.setText(startingIntent.getStringExtra(DistanceConverterActivity.KEY_UNIT_FROM));
        txtUnitTo.setText(startingIntent.getStringExtra(DistanceConverterActivity.KEY_UNIT_TO));
        txtValueTo.setText(startingIntent.getStringExtra(DistanceConverterActivity.KEY_OUTPUT_DATA));
    }
    if(startingIntent.hasExtra(TimeConverterActivity.KEY_INPUT_DATA)){
        txtValueFrom.setText(startingIntent.getStringExtra(TimeConverterActivity.KEY_INPUT_DATA));
        txtUnitFrom.setText(startingIntent.getStringExtra(TimeConverterActivity.KEY_UNIT_FROM));
        txtUnitTo.setText(startingIntent.getStringExtra(TimeConverterActivity.KEY_UNIT_TO));
        txtValueTo.setText(startingIntent.getStringExtra(TimeConverterActivity.KEY_OUTPUT_DATA));
    }

    }

    @Override
    public void onClick(View v) {
        Intent explicitIntent= new Intent();
        explicitIntent.setClass(getApplicationContext(),MainActivity.class);
        this.startActivity(explicitIntent);
    }
}
