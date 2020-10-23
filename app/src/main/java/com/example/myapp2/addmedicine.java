package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addmedicine extends AppCompatActivity {
    DatabaseHelper dbhelper;
    public Button add;
    public EditText name,hr,min;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmedicine);
        add=(Button)findViewById(R.id.button4);

        name=(EditText)findViewById(R.id.editText);
        hr=(EditText)findViewById(R.id.editText2);
        min=(EditText)findViewById(R.id.editText3);
        dbhelper=new DatabaseHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String s1=hr.getText().toString();
                String s2=min.getText().toString();
                int h=Integer.parseInt(s1);
                int m=Integer.parseInt(s2);

                if (n.length()!=0)
                {
                    addData(n,h,m);
                    name.setText("");
                    hr.setText("");
                    min.setText("");
                }
                else {
                    tostMsg("Data in not Entered");
                }

            }
        });



    }

    public void addData(String name,int hrs,int mins)
    {
        boolean insertData=dbhelper.addData(name,hrs,mins);
        if (insertData)
        {
            tostMsg("New Medicine added!");
            Intent intent=new Intent(this,showmedicine.class);
            startActivity(intent);
        }
        else {
            tostMsg("Something went wrong");
        }
    }
    private void tostMsg(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

}
