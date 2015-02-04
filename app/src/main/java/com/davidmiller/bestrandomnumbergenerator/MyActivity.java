package com.davidmiller.bestrandomnumbergenerator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MyActivity extends Activity {

    Button b1, b2, b3;
    TextView results, numAnswer;
    EditText E1, E2, ENumber;
    int mynum3, resultsToDisplayNumber;
    RadioGroup selectionGroup;
    String menu_toast = "Swipe right for menu";
    String no_Selected_Toast = "No number of results to display selected";
    String numberSelected;
    Spinner numberOfResultsSpinner;
    private boolean isSpinnerinitial = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //initializes all user inputs, buttons, and textviews.
        initializeUserInputs();

        addNumbersToSpinner();

        addListenerToNumberOfResultsSpinner();

        //Gives each radio button a number
        selectionGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio1:
                        resultsToDisplayNumber = 1;
                        break;
                    case R.id.radio2:
                        resultsToDisplayNumber = 2;
                        break;
                    case R.id.radio3:
                        resultsToDisplayNumber = 3;
                        break;
                    case R.id.radio4:
                        resultsToDisplayNumber = 4;
                        break;
                    case R.id.radio5:
                        resultsToDisplayNumber = 5;
                        break;
                }
            }
        });
        //Toast.makeText(this, menu_toast, Toast.LENGTH_LONG).show();
    }

    private void addListenerToNumberOfResultsSpinner() {
        numberOfResultsSpinner = (Spinner) findViewById(R.id.number_select_spinner);

        numberOfResultsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(isSpinnerinitial == true){
                    isSpinnerinitial = false;
                }else {

                    numberSelected = adapterView.getItemAtPosition(i).toString();

                    switch (i) {
                        case 0:
                            resultsToDisplayNumber = 0;
                            break;
                        case 1:
                            selectionGroup.clearCheck();
                            resultsToDisplayNumber = 6;
                            break;
                        case 2:
                            selectionGroup.clearCheck();
                            resultsToDisplayNumber = 7;
                            break;
                        case 3:
                            selectionGroup.clearCheck();
                            resultsToDisplayNumber = 8;
                            break;
                        case 4:
                            selectionGroup.clearCheck();
                            resultsToDisplayNumber = 9;
                            break;
                        case 5:
                            selectionGroup.clearCheck();
                            resultsToDisplayNumber = 10;
                            break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addNumbersToSpinner() {
        numberOfResultsSpinner = (Spinner) findViewById(R.id.number_select_spinner);

        ArrayAdapter<CharSequence> addNumbersToSpinnerAdapter;
        addNumbersToSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.Spinner_Numbers, android.R.layout.simple_spinner_item);

        addNumbersToSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        numberOfResultsSpinner.setAdapter(addNumbersToSpinnerAdapter);

    }

    private void initializeUserInputs() {
        b1 = (Button) findViewById(R.id.FCbutton);
        b2 = (Button) findViewById(R.id.RanButton);
        b3 = (Button) findViewById(R.id.DRbutton);

        results = (TextView) findViewById(R.id.result);

        E1 = (EditText) findViewById(R.id.lowerlimit);
        E2 = (EditText) findViewById(R.id.upperlimit);
        //ENumber = (EditText) findViewById(R.id.result_EditText);

        selectionGroup = (RadioGroup) findViewById(R.id.radioNumSel);

        numAnswer = (TextView) findViewById(R.id.textView3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


        //When Randomize button is clicked do the following
    public void onRanButtonClick(View view) {

        final Random randombuttonnum = new Random();

        int lowerlimt = 1;
        int upperlimit = 1;

        //Get number entered into lower limit editText
        try{
            lowerlimt = Integer.parseInt(E1.getText().toString());
        }catch (NumberFormatException nfe){
            System.out.println("could not parse" + nfe);
        }

        //Get number entered into upper limit EditText
        try{
            upperlimit = Integer.parseInt(E2.getText().toString());
        }catch (NumberFormatException nfe){
            System.out.println("could not parse" + nfe);
        }

        final int min = lowerlimt;
        final int max = upperlimit;
        final int num = resultsToDisplayNumber;
        final String result = String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min);

        switch(num){
            case 1:
                results.setText("Result: " + result);
                break;
            case 2:
                results.setText("Result: " + result + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min));
                break;
            case 3:
                results.setText("Result: " + result + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min));
                break;
            case 4:
                results.setText("Result: " + result + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min)+ "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min)+ "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min));
                break;
            case 5:
                results.setText("Result: " + result + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min)+ "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min)+ "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min));
                break;
            case 6:
                results.setText("Result: " + result + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," +String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) );
                break;
            case 7:
                results.setText("Result: " + result + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min));
                break;
            case 8:
                results.setText("Result: " + result + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min));
                break;
            case 9:
                results.setText("Result: " + result + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min));
                break;
            case 10:
                results.setText("Result: " + result + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min) + "," + String.valueOf(randombuttonnum.nextInt(max - min +1 ) + min));
                break;
            default:
                Toast.makeText(this,no_Selected_Toast, Toast.LENGTH_SHORT ).show();
                break;
        }
    }


        //When Dice Button is clicked do the following
    public void onDiceButtonClick(View view) {
        final Random random2 = new Random();
        results.setText("Result: " + String.valueOf(random2.nextInt(6) + 1));
    }



        //When Flip Coin button is pressed do the follow
    public void onFlipButtonClick(View view) {
        final Random random = new Random();
        int d = random.nextInt(2);
        if(d == 1) {
            results.setText("Result: Heads");
        }else{
            results.setText("Result: Tails");
        }
    }
}
