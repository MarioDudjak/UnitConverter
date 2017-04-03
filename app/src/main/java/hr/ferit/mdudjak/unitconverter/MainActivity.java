package hr.ferit.mdudjak.unitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton ibTemp,ibWeight,ibLength,ibTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpUI();
    }

    private void setUpUI() {
        this.ibTemp = (ImageButton) findViewById(R.id.ImageButtonFirst);
        this.ibWeight = (ImageButton) findViewById(R.id.ImageButtonSecond);
        this.ibLength = (ImageButton) findViewById(R.id.ImageButtonThird);
        this.ibTime = (ImageButton) findViewById(R.id.ImageButtonFourth);
        this.ibTemp.setOnClickListener(this);
        this.ibWeight.setOnClickListener(this);
        this.ibLength.setOnClickListener(this);
        this.ibTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent explicitIntent = null;
        switch (v.getId()){
            case R.id.ImageButtonFirst:
                explicitIntent= new Intent();
                explicitIntent.setClass(getApplicationContext(),TemperatureConverterActivity.class);
                this.startActivity(explicitIntent);
                break;
            case R.id.ImageButtonSecond:
                explicitIntent= new Intent();
                explicitIntent.setClass(getApplicationContext(),WeightConverterActivity.class);
                this.startActivity(explicitIntent);
                break;
            case R.id.ImageButtonThird:
                explicitIntent= new Intent();
                explicitIntent.setClass(getApplicationContext(),DistanceConverterActivity.class);
                this.startActivity(explicitIntent);
                break;
            case R.id.ImageButtonFourth:
                explicitIntent= new Intent();
                explicitIntent.setClass(getApplicationContext(),TimeConverterActivity.class);
                this.startActivity(explicitIntent);
                break;
        }
    }
}
