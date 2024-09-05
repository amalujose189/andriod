package com.example.calculator;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText t1;
    EditText t2;
    EditText t3;
    Button sum, sub, div, mul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI elements
        t1 = findViewById(R.id.txt1);
        t2 = findViewById(R.id.txt2);
        t3 = findViewById(R.id.res);

        sum = findViewById(R.id.sum1);
        sub = findViewById(R.id.bt1);
        div = findViewById(R.id.bt3);
        mul = findViewById(R.id.button4);

        // Set up button click listeners
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(t1.getText().toString());
                double n2 = Double.parseDouble(t2.getText().toString());
                double r1 = n1 + n2;
                t3.setText(String.valueOf(r1));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(t1.getText().toString());
                double n2 = Double.parseDouble(t2.getText().toString());
                double r1 = n1 - n2;
                t3.setText(String.valueOf(r1));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(t1.getText().toString());
                double n2 = Double.parseDouble(t2.getText().toString());
                double r1 = n1 * n2;
                t3.setText(String.valueOf(r1));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double n1 = Double.parseDouble(t1.getText().toString());
                double n2 = Double.parseDouble(t2.getText().toString());
                if (n2 != 0) {
                    double r1 = n1 / n2;
                    t3.setText(String.valueOf(r1));
                } else {
                    Toast.makeText(MainActivity.this, "Division by zero is not allowed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


