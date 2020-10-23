package com.example.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class showmedicine extends AppCompatActivity {

    private static final String TAG="ListDataActivity";
    DatabaseHelper db;
    public int notid=1;
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmedicine);

        listView=(ListView)findViewById(R.id.listview);
        db=new DatabaseHelper(this);

        papulate();

    }
    public void papulate()
    {
        Log.d(TAG,"displaying daya");
        Cursor data=db.getData();
        ArrayList<HashMap<String,String>> list1;
        list1=new ArrayList<HashMap<String, String>>();

        ArrayList<String> n1=new ArrayList<>();
       //ArrayList<String> h1=new ArrayList<>();
       // ArrayList<String> m1=new ArrayList<>();
        while (data.moveToNext()){
            n1.add(data.getString(1));
           // h1.add(data.getString(2));

            Intent intent=new Intent(this,AlarmReciver.class);
            intent.putExtra("notid",notid);
            intent.putExtra("medicine",data.getString(1));
            PendingIntent alarmIntent=PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
            Calendar starttime=Calendar.getInstance();
            AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);
            int minutes=data.getInt(3);
            int hours=data.getInt(2);
            starttime.set(Calendar.HOUR_OF_DAY,hours);
            starttime.set(Calendar.MINUTE,minutes);
            starttime.set(Calendar.SECOND,0);
            long alarmstarttime=starttime.getTimeInMillis();

            alarm.set(AlarmManager.RTC_WAKEUP,alarmstarttime,alarmIntent);


            //m1.add(data.getString(3));


        }
        Toast.makeText(this,"Done!!!!1",Toast.LENGTH_SHORT).show();
        ListAdapter adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,n1);
        //ListAdapter adapter1=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,h1);

        //listView.setAdapter(adapter1);
        listView.setAdapter(adapter);
    }
}
