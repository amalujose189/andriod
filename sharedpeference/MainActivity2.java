package com.example.sharedpreference;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView textViewUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewUserInfo = findViewById(R.id.txt1);

        SharedPreferences sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE);
        String firstName = sharedPreferences.getString("firstName", "N/A");
        String lastName = sharedPreferences.getString("lastName", "N/A");
        String email = sharedPreferences.getString("email", "N/A");
        String phone = sharedPreferences.getString("phone", "N/A");
        String dob = sharedPreferences.getString("dob", "N/A");
        String gender = sharedPreferences.getString("gender", "N/A");

        String userInfo = "First Name: " + firstName + "\n"
                + "Last Name: " + lastName + "\n"
                + "Email: " + email + "\n"
                + "Phone: " + phone + "\n"
                + "Date of Birth: " + dob + "\n"
                + "Gender: " + gender;

        textViewUserInfo.setText(userInfo);
    }
}


