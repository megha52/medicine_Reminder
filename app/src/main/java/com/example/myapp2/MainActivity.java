package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public Button b1,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b2=(Button) findViewById(R.id.button2);
        b1=(Button) findViewById(R.id.button);
        b3=(Button) findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennew2();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennew1();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennew3();
            }
        });
    }
    public void opennew2()
    {
        Intent intent=new Intent(this,addmedicine.class);
        startActivity(intent);
    }
    public void opennew3()
    {
        Intent intent=new Intent(this,removemedicine.class);
        startActivity(intent);
    }
    public void opennew1()
    {
        Intent intent=new Intent(this,showmedicine.class);
        startActivity(intent);
    }
}
