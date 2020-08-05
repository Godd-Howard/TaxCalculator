package com.example.taxcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radGroup;
    private RadioButton radButton;
    private EditText taxNumber;
    private Button submitButton;
    private String status, check;
    private double number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.button);
        taxNumber = findViewById(R.id.editText);
        radGroup = findViewById(R.id.radioG);

        taxNumber.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(30,2)});


        radGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    // Check which radio button has been clicked
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {

                        // Get the selected Radio Button
                        radButton = radGroup.findViewById(checkedId);

                        Toast.makeText(MainActivity.this,
                                radButton.getText(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        // Add the Listener to the Submit Button
        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                check = taxNumber.getText().toString();

                //Make sure an option is selected
                int selectedId = radGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this,
                            "No status has been selected",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else if(check.matches("") || check.matches("[\\.]")) {
                    Toast.makeText(MainActivity.this,
                            "No valid number entered",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else{
                    number = Double.parseDouble(taxNumber.getText().toString());
                    status = ((RadioButton)findViewById(radGroup.getCheckedRadioButtonId() )).getText().toString();

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("number", number);
                    intent.putExtra("status", status);

                    startActivity(intent);
                }

            }
        });
    }
}