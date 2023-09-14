package com.example.homeloan;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class appln extends AppCompatActivity {

    private EditText etName, etEmail, etPhone, etAddress, etLoanAmount, etInterestRate, etTenure, etEmploymentStatus, etIncome;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appln);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        // Initialize other EditTexts similarly

        btnSubmit = findViewById(R.id.btnsSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data from EditTexts and process it
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                // Get other form data similarly

                // Perform validation if needed

                // Submit the data (e.g., save to a database or send an API request)
            }
        });
    }
}

