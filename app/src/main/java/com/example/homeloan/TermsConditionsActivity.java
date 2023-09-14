package com.example.homeloan;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TermsConditionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terms_conditions);

        TextView termsTextView = findViewById(R.id.terms_text);

        // Set your terms and conditions here
        String termsAndConditions = "1.  Lorem ipsum dolor sit amet, consectetur adipiscing \n" +
                "2. Nullam in dui mauris. \n" +
                "3. Nulla dui felis, adipiscing congue. \n" +
                "4. Vivamus elementum semper nisi. \n" +
                "5. Aenean vulputate eleifend tellus. \n" ;

        termsTextView.setText(termsAndConditions);
    }
}

