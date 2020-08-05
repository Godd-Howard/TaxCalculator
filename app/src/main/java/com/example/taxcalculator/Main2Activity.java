package com.example.taxcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

            private TextView result1;
            private String status, currency, numResult;
            private double numberResult, tax;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main2);

                result1 = findViewById(R.id.textView);

                Intent intent = getIntent();
                status = intent.getStringExtra("status");
                numberResult = intent.getDoubleExtra("number", 0);

                NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);

                if(status.equals("Single"))
                {
                    if (numberResult > 49300) {
                        tax = 11158.50 + ((numberResult - 49300) * .31);
                        currency = format.format(tax);
                        numResult = format.format(numberResult);
                        result1.setText(status + " status" + " at an income level of " + numResult + ":\n\nYour income tax owed is " + currency);
                    } else {
                        result1.setText("Use a tax table instead.\nThere is no need to use a tax schedule.");
                    }
                }
                else if(status.equals("Married Filing Jointly")){
                    if(34000 < numberResult && numberResult < 82150)
                    {
                        tax = 5100.00 + ((numberResult - 34000)*.28);
                        currency = format.format(tax);
                        numResult = format.format(numberResult);
                        result1.setText(status + " status" + " at an income level of " + numResult + ":\n\nYour income tax owed is " + currency);
                    }
                    else if(numberResult > 82150)
                    {
                        tax = 18582.00 + ((numberResult - 82150)*.31);
                        currency = format.format(tax);
                        numResult = format.format(numberResult);
                        result1.setText(status + " status" + " at an income level of " + numResult + ":\n\nYour income tax owed is " + currency);
                    }
                    else{
                        result1.setText("Use a tax table instead.\nThere is no need to use a tax schedule.");
                    }
                }
                else if(status.equals("Married Filing Separately")){
                    if(numberResult > 41075)
                    {
                        tax = 9291.00 + ((numberResult - 41075)*.31);
                        currency = format.format(tax);
                        numResult = format.format(numberResult);
                        result1.setText(status + " status" + " at an income level of " + numResult + ":\n\nYour income tax owed is " + currency);
                    }
                    else{
                        result1.setText("Use a tax table instead.\nThere is no need to use a tax schedule.");
                    }

                }
                else if(status.equals("Head of Household")){
                    if(numberResult > 27300 && numberResult < 70450)
                    {
                        tax = 4095.00 + ((numberResult - 27300)*.28);
                        currency = format.format(tax);
                        numResult = format.format(numberResult);
                        result1.setText(status + " status" + " at an income level of " + numResult + ":\n\nYour income tax owed is " + currency);
                    }
                    else if(numberResult > 70450)
                    {
                        tax = 16177.00 + ((numberResult - 70450)*.31);
                        currency = format.format(tax);
                        numResult = format.format(numberResult);
                        result1.setText(status + " status" + " at an income level of " + numResult + ":\n\nYour income tax owed is " + currency);
                    }
                    else{
                        result1.setText("Use a tax table instead.\nThere is no need to use a tax schedule.");
                    }

                }
            }

}

