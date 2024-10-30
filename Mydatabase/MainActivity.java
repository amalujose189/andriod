package com.example.dbconnection;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText Name,Mark,Surname;
    TextView DataV;
    MyDatabase database=new MyDatabase(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Name=findViewById(R.id.et1);
        Surname=findViewById(R.id.et2);
        Mark=findViewById(R.id.et3);
        DataV=findViewById(R.id.dv);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void SaveData(View view) {
        String userVal=Name.getText().toString();
        String surnameVal=Surname.getText().toString();
        Integer passVal=Integer.parseInt(Mark.getText().toString());
        Boolean result=database.insertdata(userVal,passVal,surnameVal);
        if(result==true)
        {
            Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Data Insertion Failed", Toast.LENGTH_SHORT).show();
        }

    }
    public void read(View view){
        Cursor res=database.getAllData();
        StringBuffer sb=new StringBuffer();
        if(res!=null&&res.getCount()>0){
            while(res.moveToNext()){
                sb.append("Id:"+res.getString(0)+"\n");
                sb.append("Name:"+res.getString(1)+"\n");
                sb.append("Surname:"+res.getString(2)+"\n");
                sb.append("marks:"+res.getString(3)+"\n");

            }
            DataV.setText(sb.toString());
        }
        else {
            Toast.makeText(getApplicationContext(), "Data Retrieved Successfully", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getApplicationContext(), "Data Retrieved Successfully", Toast.LENGTH_SHORT).show();
    }


    public void delete(View view){
        String userVal=Name.getText().toString();
        int result=database.deletedata(userVal);
        Toast.makeText(getApplicationContext(), "Rows affected", Toast.LENGTH_SHORT).show();
    }

    public void update(View view){
        String userVal=Name.getText().toString();
        String surnameVal=Surname.getText().toString();
        Integer passVal=Integer.parseInt(Mark.getText().toString());
        Boolean result=database.updateData(userVal,passVal,surnameVal);
        if(result==true){
            Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "No Rows Affected", Toast.LENGTH_SHORT).show();
        }
    }

}
