package com.example.a2pagelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText User;
    private EditText pass;
    private Button Login;
    private Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        User = findViewById(R.id.et1);
        pass = findViewById(R.id.et2);
        Login = findViewById(R.id.l1);
        clear = findViewById(R.id.cl1);

        // Set OnClickListener for Login button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = User.getText().toString();
                String password = pass.getText().toString();

                if (username.equals("admin") && password.equals("password")) {

                    Toast.makeText(MainActivity.this, "login successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                } else {

                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.setText("");
                pass.setText("");
            }
        });
    }
}
