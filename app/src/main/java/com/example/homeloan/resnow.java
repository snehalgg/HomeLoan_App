package com.example.homeloan;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.content.SharedPreferences;
import com.example.homeloan.DatabaseHelper;


import androidx.appcompat.app.AppCompatActivity;

public class resnow extends AppCompatActivity {

    private EditText etUsername;
    private EditText etEmail;
    private EditText etMobileNumber;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button btnRegister;
    private ProgressBar progressBar;
    private TextView tvSuccess;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_now);

        Button btnRegister = findViewById(R.id.btnRegister);
        TextView signupText = findViewById(R.id.signupText);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle registration logic here

                // Once registration is successful, navigate to login screen
                Intent intent = new Intent(resnow.this, login.class);
                startActivity(intent);
            }
        });

        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to login screen
                Intent intent = new Intent(resnow.this, login.class);
                startActivity(intent);
            }
        });

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etMobileNumber = findViewById(R.id.etMobileNumber);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        progressBar = findViewById(R.id.progressBar);
//        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        tvSuccess = findViewById(R.id.tvSuccess);
        dbHelper = new DatabaseHelper(this);
        // ...


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    // ... Rest of your existing code ...

                    String username = etUsername.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();

                    // Save username and password in SQLite database
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put(DatabaseHelper.COLUMN_USERNAME, username);
                    values.put(DatabaseHelper.COLUMN_PASSWORD, password);

                    long newRowId = db.insert(DatabaseHelper.TABLE_USERS, null, values);


                    if (newRowId != -1) {
                        // Data inserted successfully
                    } else {
                        // Error occurred while inserting data
                    }
                }
            }
        });

// ...

    }

    private boolean validateInput() {
        boolean isValid = true;

        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String mobileNumber = etMobileNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        if (username.isEmpty()) {
            etUsername.setError("Username is required");
            isValid = false;
        }

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Invalid email address");
            isValid = false;
        }

        if (mobileNumber.isEmpty()) {
            etMobileNumber.setError("Mobile number is required");
            isValid = false;
        } else if (!Patterns.PHONE.matcher(mobileNumber).matches()) {
            etMobileNumber.setError("Invalid mobile number");
            isValid = false;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            isValid = false;
        } else if (password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            isValid = false;
        }

        if (!confirmPassword.equals(password)) {
            etConfirmPassword.setError("Passwords do not match");
            isValid = false;
        }

        return isValid;
    }


    public void createaccount(View view){
        setContentView(R.layout.register_now);
    }

    public void loginaccount(View view){
        setContentView(R.layout.activity_main);
    }


}







