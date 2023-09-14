package com.example.homeloan;


import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class faq extends AppCompatActivity {

    private String[] faqItems = {
            "What is the minimum down payment required?",
            "How is the interest rate calculated?",
            "What are the eligibility criteria for a home loan?",
            "What documents are required for a home loan application?",
            "How long does it take to get approval for a home loan?"
    };

    private String[] answers = {
            "The minimum down payment required varies depending on the lender. It's typically a percentage of the property's value, often around 20%.",
            "The interest rate is calculated based on various factors, including your credit score, loan amount, and market conditions.",
            "Eligibility criteria include factors like age, income, employment status, and credit history. It's best to check with your lender for specific details.",
            "Common documents required include proof of identity, address, income, property details, and bank statements. Consult your lender for a complete list.",
            "The approval process can vary. It may take a few days to a few weeks, depending on factors like documentation, verification, and the lender's process."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq_main);

        LinearLayout faqContainer = findViewById(R.id.faq_container);

        for (int i = 0; i < faqItems.length; i++) {
            View faqItemView = getLayoutInflater().inflate(R.layout.faq_item, null);

            TextView questionTextView = faqItemView.findViewById(R.id.question_text);
            questionTextView.setText(faqItems[i]);

            TextView answerTextView = faqItemView.findViewById(R.id.answer_text);
            answerTextView.setText(answers[i]);

            questionTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toggle visibility of the answer
                    int visibility = answerTextView.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE;
                    answerTextView.setVisibility(visibility);
                }
            });

            faqContainer.addView(faqItemView);
        }
    }
}



