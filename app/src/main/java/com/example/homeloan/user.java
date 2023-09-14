package com.example.homeloan;

// UserActivity.java



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class user extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);

        Button applyNowButton = findViewById(R.id.apply_now_button);
        Button myLoanButton = findViewById(R.id.my_loan_button);
        Button trackApplicationButton = findViewById(R.id.track_application_button);
        Button earnRewardsButton = findViewById(R.id.loan_insurance_button);
        Button referNowButton = findViewById(R.id.refer_now_button);


// Repeat the above two lines for each button, replacing the IDs and colors


        // Add onClickListeners for the buttons if you want to handle click events.
        applyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Apply Now button click
            }
        });


        myLoanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user.this, myloan.class);
                startActivity(intent);// Handle My Loan button click
            }
        });

        trackApplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Track Application button click
            }
        });

        earnRewardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Earn Rewards button click
            }
        });

        referNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle Refer Now button click
            }
        });
        Button homeEmisCalculatorButton = findViewById(R.id.apply_now_button);

        homeEmisCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user.this, appln.class);
                startActivity(intent);
            }
        });

    }
}


