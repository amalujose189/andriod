package com.example.optionview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.GridView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize GridView
        gridView = findViewById(R.id.gridview);

        // Array of items to display in GridView
        String[] courses = {"MCA", "MBA", "BBA", "BCA", "B.Tech", "M.Tech", "PhD", "Diploma"};

        // ArrayAdapter to adapt the data to the GridView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, courses);

        // Set the adapter to the GridView
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected course name
                String selectedCourse = (String) parent.getItemAtPosition(position);

                // Display the Toast message
                Toast.makeText(MainActivity.this, "Hello " + selectedCourse + " student", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
