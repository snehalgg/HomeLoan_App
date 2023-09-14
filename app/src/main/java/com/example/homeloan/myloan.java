package com.example.homeloan;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class myloan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myloan);

        String[] remainingEMIs = new String[115]; // 120 total EMIs - 5 EMIs paid

        for (int i = 0; i < remainingEMIs.length; i++) {
            int emiNumber = i + 1;
            double emiAmount = calculateEMIAmount(); // You need to implement this function
            boolean emiPaid = i < 5; // First 5 EMIs are paid

            String emiInfo = "EMI #" + emiNumber + " - Amount: ₹" + emiAmount + " - Paid: " + (emiPaid ? "Yes" : "No");
            remainingEMIs[i] = emiInfo;
        }

        ListView emiListView = findViewById(R.id.emiListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, remainingEMIs);
        emiListView.setAdapter(adapter);
    }

    private double calculateEMIAmount() {
        // Implement the logic to calculate EMI amount here
        // You can use the loan amount, interest rate, and EMI term for this calculation
        // For example: return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -emiTerm));
        return 10000; // Placeholder value, replace with actual calculation
    }
}
