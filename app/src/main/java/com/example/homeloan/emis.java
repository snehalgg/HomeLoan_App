package com.example.homeloan;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class emis extends AppCompatActivity {

    private EditText loanAmountEditText, loanTenureEditText, creditScoreEditText;
    private TextView eligibilityResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emis);

        loanAmountEditText = findViewById(R.id.editTextLoanAmount);
        loanTenureEditText = findViewById(R.id.editTextLoanTenure);
        creditScoreEditText = findViewById(R.id.editTextCreditScore);
        eligibilityResultTextView = findViewById(R.id.textViewEligibilityResult);

        Button checkEligibilityButton = findViewById(R.id.buttonCheckEligibility);
        checkEligibilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateLoanEligibility();
            }
        });
    }

    private void calculateLoanEligibility() {
        try {
            // Get user input values
            long loanAmount = Long.parseLong(loanAmountEditText.getText().toString());
            int loanTenureYears = Integer.parseInt(loanTenureEditText.getText().toString());
            int creditScore = Integer.parseInt(creditScoreEditText.getText().toString());

            // Define eligibility criteria (you can customize this)
            long minimumLoanAmount = 500000; // Minimum loan amount in INR
            int minimumLoanTenure = 1; // Minimum tenure in years
            int minimumCreditScore = 600; // Minimum credit score required

            if (loanAmount >= minimumLoanAmount && loanTenureYears >= minimumLoanTenure && creditScore >= minimumCreditScore) {
                // Eligible for the loan
                eligibilityResultTextView.setText("Congratulations! You are eligible for the loan.");
            } else {
                // Not eligible for the loan
                eligibilityResultTextView.setText("Sorry, you are not eligible for the loan.");
            }
        } catch (NumberFormatException e) {
            // Handle invalid input
            eligibilityResultTextView.setText("Please enter valid values.");
        }
    }
}
