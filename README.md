# UnitConverter
Android app for converting different types of measure units. 

Task description: 

UnitConverter is simple app for converting measurement units.
Application contains 4 different activities for each unit. 
Chosen physical quantities are: temperature, weight, distance and time.
Image for each physical quantity also represents a button that redirects to a data input field.
Temperature units are: Celsius, Kelvin and Fahrenheit.
Weight units: Kilogram, Pound and Ounce.
Distance units: Meter, Yard, Inch.
Time units: Hour, Day, Week.
Unique layout is used for representing results regardless of the unit. 

Description of program solutions & problems:


*User interface:

Application has 5 different layouts. 
Main layout consists of 4 ImageButtons each for every physical quantity.
By clicking on the ImageButton another layout is placed on screen. 
Every layout for data input has title in a TextView, 3 TextViews as labels, 2 Spinners for unit picking, EditText for value input and Button which redirects to Activity for displaying result.
Input value for EditText is set to number decimal, and maximal number of lines is 1. 
Also, EditText has option actionDone to show OK button for finishing input without the need to press back button on device.


*Working with Spinner:

Spinners provide a quick way to select one value from a set. 
In the default state, a spinner shows its currently selected value. 
Touching the spinner displays a dropdown menu with all other available values, from which the user can select a new one.
Firstly in resources file string-array was defined:

<string-array name="TemperatureSpinner">
        <item>Celsius</item>
        <item>Fahrenheit</item>
        <item>Kelvin</item>

Spinner is suplied with defined string-array by using an instance of ArrayAdapter:

ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.TemperatureSpinner, android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinnerTemperatureFrom.setAdapter(adapter);

The createFromResource() method allows to create an ArrayAdapter from the string array.
Then setDropDownViewResource(int) is called to specify the layout the adapter should use to display the list of spinner choices.
Value that is selected on spinner is used in Calculate function for calculating value of converted unit. 


Source: https://developer.android.com/guide/topics/ui/controls/spinner.html


*Starting another Activity:

Explicit intent is used for starting each activity for different physical quantities. 
It is necessary to create object of class Intent and set class by name explicitly and then start activity.
Firstly, it was necessary to set on OnClickListener for each ImageButton:

this.ibTemp = (ImageButton) findViewById(R.id.ImageButtonFirst);
this.ibTemp.setOnClickListener(this);

After that using switch-case branching it is necessary to differentiate which button was pressed:
switch (v.getId()){
            case R.id.ImageButtonFirst:
                explicitIntent= new Intent();
                explicitIntent.setClass(getApplicationContext(),TemperatureConverterActivity.class);
                this.startActivity(explicitIntent);

Source: https://loomen.carnet.hr/pluginfile.php/772054/mod_resource/content/1/LV2%20-%20predlo%C5%BEak%282017%29.pdf


*Data forwarding between activities 

In each activity for data input users are required to choose 2 units from 2 spinners and enter data in EditText.
After pressing Calculate button collected data is sent to DataReceiverActivity and there represented on layout for DataReceiverActivity.
That layout consists of 4 TextViews. 2 TextViews are for units involved in converting and 2 TextViews for entered data and calculated data.
It is necessary to define key values for appropriate data values:

public static final String KEY_INPUT_DATA ="input_temperature";

After that data is sent to DataReceiverActivity using putExtra method.
Before that it is necessary to create Intent object and set class for that intent to DataReceiverActivity class.

Intent explicitIntent = new Intent(getApplicationContext(),DataReceiverActivity.class);
explicitIntent.putExtra(KEY_INPUT_DATA,valueFrom);

To receiver data in DataReceiverActivity class Intent object was created and set to that class.

Intent startingIntent = this.getIntent();

By using that object it was checked if there is some data which refers to certain key from certain activity.
For example:

if(startingIntent.hasExtra(TemperatureConverterActivity.KEY_INPUT_DATA))
	txtValueFrom.setText(startingIntent.getStringExtra(WeightConverterActivity.KEY_INPUT_DATA));

Source: https://loomen.carnet.hr/pluginfile.php/772054/mod_resource/content/1/LV2%20-%20predlo%C5%BEak%282017%29.pdf


*Rounding to 2 decimals

From the above source, round function was implemented. 
Function receives 2 values: double - value which must be rounded, and int - number of decimal places.
Number is multiplied with 10 multiple times depending on number of decimal places. 
Each time when number is multiplied with 10 it is also rounded by using Math.round() function.
Function returns double value. 
 

Source: http://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places



 