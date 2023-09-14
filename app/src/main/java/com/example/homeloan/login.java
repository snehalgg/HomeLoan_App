package com.example.homeloan;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;


public class login extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private ProgressBar progressBar;
    private TextView tvErrorMessage;
    private DatabaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginn);
        dbHelper = new DatabaseHelper(this);
        TextView signupText = findViewById(R.id.signupText);

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, resnow.class);
                startActivity(intent);
            }
        });

        etUsername = findViewById(R.id.etsUsername);
        etPassword = findViewById(R.id.etsPassword);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);
        tvErrorMessage = findViewById(R.id.tvErrorMessage);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {
        // Reset errors
        etUsername.setError(null);
        etPassword.setError(null);
        tvErrorMessage.setVisibility(View.GONE);

        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        boolean cancel = false;
        View focusView = null;

        // Validate username and password (add your validation logic)
        if (username.isEmpty()) {
            etUsername.setError("Username is required");
            focusView = etUsername;
            cancel = true;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            focusView = etPassword;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            // Show loading animation
            progressBar.setVisibility(View.VISIBLE);
            btnLogin.setEnabled(false);

            // Check if entered username and password match the values in the SQLite database
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            String[] projection = {
                    DatabaseHelper.COLUMN_USERNAME,
                    DatabaseHelper.COLUMN_PASSWORD
            };

            String selection = DatabaseHelper.COLUMN_USERNAME + " = ?";
            String[] selectionArgs = {username};

            Cursor cursor = db.query(
                    DatabaseHelper.TABLE_USERS,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
            );

            if (cursor.moveToFirst()) {
                String storedPassword = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PASSWORD));

                if (password.equals(storedPassword)) {
                    // Successful login logic here
                    Intent intent = new Intent(login.this, user.class);
                    startActivity(intent);
                    finish(); // Optional: This closes the current activity to prevent going back to the login screen with the back button
                } else {
                    // Password does not match
                    tvErrorMessage.setVisibility(View.VISIBLE);
                    tvErrorMessage.setText("Invalid credentials. Please try again.");
                }
            } else {
                // Username not found
                tvErrorMessage.setVisibility(View.VISIBLE);
                tvErrorMessage.setText("Invalid credentials. Please try again.");
            }

            cursor.close();

            // Hide loading animation
            progressBar.setVisibility(View.GONE);
            btnLogin.setEnabled(true);
        }
    }



    public void createaccount(View view){
        setContentView(R.layout.register_now);
    }

    public void loginaccount(View view){
        setContentView(R.layout.loginn);
    }
}


