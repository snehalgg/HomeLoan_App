package com.example.homeloan;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager2.widget.ViewPager2;


public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private ImageAdapter adapter;
    private TextView goToTop;
    private ScrollView scrollView;
    private Dialog chatbotDialog;
    private TextView chatViewPopup;
    private EditText userInputPopup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatbotDialog = new Dialog(this);
        chatbotDialog.setContentView(R.layout.chat_popup);
        chatbotDialog.setCancelable(false);

        // Initialize chatViewPopup and userInputPopup
        chatViewPopup = chatbotDialog.findViewById(R.id.chatViewPopup);
        userInputPopup = chatbotDialog.findViewById(R.id.userInputPopup);
        View button = findViewById(R.id.button);

        View closeButtonPopup = chatbotDialog.findViewById(R.id.closeButtonPopup);
        closeButtonPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatbotDialog.dismiss();
            }
        });



        // ... your existing code

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatbotDialog.show();
                chatViewPopup.setVisibility(View.VISIBLE);
                chatViewPopup.setText("Welcome to apna home loan, what help do you need?");
                userInputPopup.setVisibility(View.VISIBLE);
            }
        });

        // ... your existing code
        Button homeEmiCalculatorButton = findViewById(R.id.homeEmiCalculatorButton);

        homeEmiCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmiCalc.class);
                startActivity(intent);
            }
        });

        Button homeEmisCalculatorButton = findViewById(R.id.homeEmisCalculatorButton);

        homeEmisCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, emis.class);
                startActivity(intent);
            }
        });
        TextView FAQsTextView = findViewById(R.id.faqs);

        // Set an OnClickListener on the TextView
        FAQsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the login activity
                Intent intent = new Intent(MainActivity.this,com.example.homeloan.faq.class);
                startActivity(intent);
            }
        });

        TextView view_terms_buttonTextView = findViewById(R.id.view_terms_button);

        // Set an OnClickListener on the TextView
        view_terms_buttonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the login activity
                Intent intent = new Intent(MainActivity.this,com.example.homeloan.TermsConditionsActivity.class);
                startActivity(intent);
            }
        });

        TextView applyOnlineTextView = findViewById(R.id.apply);

        // Set an OnClickListener on the TextView
        applyOnlineTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the login activity
                Intent intent = new Intent(MainActivity.this,com.example.homeloan.login.class);
                startActivity(intent);
            }
        });

        TextView contactUsTextView = findViewById(R.id.contactUsTextView);

        // Set a click listener on the "Contact Us" TextView
        contactUsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the ContactActivity
                Intent intent = new Intent(MainActivity.this, contact.class);
                startActivity(intent);
            }
        });


        showNotificationPermissionDialog();

        viewPager = findViewById(R.id.viewPager);
        adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        // Set the images in your adapter
        adapter.setImages(new int[]{R.drawable.hl1, R.drawable.hl2, R.drawable.hl3});

        // Start auto-carousel
        startAutoCarousel();
        scrollView = findViewById(R.id.scrollView);
        goToTop = findViewById(R.id.goToTop);

        // Set click listener for goToTop TextView
        goToTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(View.FOCUS_UP);
            }
        });

        TextView cibilScoreLink = findViewById(R.id.cibilScoreLink);

        // Set a click listener on the link
        cibilScoreLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define the URL to open
                String cibilScoreUrl = "https://www.paisabazaar.com/cibil-credit-report/";

                // Create an Intent to open the URL
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(cibilScoreUrl));

                // Start the activity to open the URLs
                startActivity(intent);
            }
        });

        VideoView videoView = findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // Set the video source
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.a);
        videoView.setVideoURI(videoUri);
    }

    public static final int MENU_HOME = R.id.menu_home;
    public static final int MENU_CONTACT = R.id.menu_contact;
    public static final int MENU_ABOUT = R.id.menu_about;
    public static final int MENU_SERVICES = R.id.menu_services;
    public static final int MENU_BLOG = R.id.menu_blog;

    public void showDropdownMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_dropdown, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();



                return true;
            }
        });
        popupMenu.show();
    }


    // Add method for sending message in popup
    public void onSendClickPopup(View view) {
        String userQuestion = userInputPopup.getText().toString();
        // Handle user's question here
        chatViewPopup.setText("You asked: " + userQuestion);
    }

    // Add method for closing popup
    public void onCloseClickPopup(View view) {
        chatbotDialog.dismiss();
    }

    private void showNotificationPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Notification Permission");
        builder.setMessage("Apna Home Loan wants to send you notifications.");
        builder.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle permission granted
                // You can add your notification logic here
            }
        });
        builder.setNegativeButton("Block", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Handle permission denied
                // You can add alternative logic here
            }
        });
        builder.setCancelable(false); // User can't dismiss dialog by clicking outside
        builder.show();
    }
    private void startAutoCarousel() {
        final Handler handler = new Handler(Looper.getMainLooper());

        Runnable runnable = new Runnable() {
            int position = 0;

            @Override
            public void run() {
                if (position >= adapter.getItemCount()) {
                    position = 0;
                }

                viewPager.setCurrentItem(position, true);
                position++;

                // Repeat this runnable after 0.5 seconds (adjust as needed)
                handler.postDelayed(this, 1500);
            }
        };

        // Start the initial runnable
        handler.postDelayed(runnable, 1500);
    }
}
