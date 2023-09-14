package com.example.homeloan;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class contact extends AppCompatActivity {

    private EditText nameEditText, emailEditText, messageEditText;
    private Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.Button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check if all fields are filled and email format is correct
                if (validateFields()) {
                    // If everything is correct, show a message
                    Toast.makeText(contact.this, "Thanks for contacting us, we will soon get in touch with you", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateFields() {
        String name = nameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String message = messageEditText.getText().toString().trim();

        if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
            // Display an error message if any field is empty
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            // Check if email format is correct
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

