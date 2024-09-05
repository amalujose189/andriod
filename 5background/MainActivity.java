package com.example.a5background;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText et;
    private ConstraintLayout mainLayout;
    private Button button;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        mainLayout=findViewById(R.id.main_layout);
        button=findViewById(R.id.bt1);
        tv1=findViewById(R.id.t1);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et=(EditText)findViewById(R.id.t1);
    }

    public void bt1(View view)
    {

        mainLayout.setBackgroundColor(Color.parseColor("#18191a"));
        et.setText("Success");
        et.setTextColor(Color.parseColor("#062896"));
        button.setBackgroundColor(Color.parseColor("#0a83f5"));
        tv1.setBackgroundColor(Color.parseColor("#f5f7fa"));

    }
}