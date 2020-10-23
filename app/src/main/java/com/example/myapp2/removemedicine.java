package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class removemedicine extends AppCompatActivity {
    private EditText name;
    private Button remove;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removemedicine);
        name=(EditText)findViewById(R.id.et);
        remove=(Button)findViewById(R.id.button5);
        db=new DatabaseHelper(this);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                if(n.length()!=0)
                {
                    db.deleteName(n);
                    name.setText("");
                    Intent intent=new Intent(removemedicine.this,showmedicine.class);
                    startActivity(intent);
                    Toast.makeText(removemedicine.this,"Medicine Removed",Toast.LENGTH_SHORT).show();
                }
                else {

                }

            }
        });
    }
}
