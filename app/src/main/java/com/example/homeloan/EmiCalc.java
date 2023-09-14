package com.example.homeloan;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;



public class EmiCalc extends AppCompatActivity {



    private EditText loanAmountEditText, interestRateEditText, loanTenureEditText;

    private Button calculateButton;

    private TextView emiResultTextView;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.emicalc);



        loanAmountEditText = findViewById(R.id.loanAmountEditText);

        interestRateEditText = findViewById(R.id.interestRateEditText);

        loanTenureEditText = findViewById(R.id.loanTenureEditText);

        calculateButton = findViewById(R.id.calculateButton);

        emiResultTextView = findViewById(R.id.emiResultTextView);



        calculateButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                calculateEMI();

            }

        });

    }



    private void calculateEMI() {

        // Get input values

        double loanAmount = Double.parseDouble(loanAmountEditText.getText().toString());

        double interestRate = Double.parseDouble(interestRateEditText.getText().toString());

        int loanTenure = Integer.parseInt(loanTenureEditText.getText().toString());



        // Calculate EMI using the formula

        double monthlyInterestRate = (interestRate / 12) / 100;

        double emi = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTenure)) /

                (Math.pow(1 + monthlyInterestRate, loanTenure) - 1);



        // Display the result

        emiResultTextView.setText(String.format("EMI: %.2f", emi));

    }

}