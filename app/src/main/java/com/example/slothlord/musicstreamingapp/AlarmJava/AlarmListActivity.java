package com.example.slothlord.musicstreamingapp.AlarmJava;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.slothlord.musicstreamingapp.R;

import java.io.FileOutputStream;


public class AlarmListActivity extends AppCompatActivity implements AlarmListAdapter.customButtonListener {

    private ListView alarmListView;
    private FloatingActionButton newAlarm;
    // Setup the data source
    //ArrayList<Alarm> itemsArrayList = generateItemsList(); // calls function to get items list
    private Alarms alarms;
    // instantiate the custom list adapter
    AlarmListAdapter adapter;
    private final  int ALARMCODE = 123;

    // get the ListView and attach the adapter




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_list);
        newAlarm = (FloatingActionButton) findViewById(R.id.newAlarmButton);
        alarmListView = (ListView) findViewById(R.id.alarmListView);
        alarms = new Alarms();
        //alarms.addAlarm(new Alarm(10,59, "peter"));
        adapter = new AlarmListAdapter(this, alarms.getAlarms());
        alarmListView.setAdapter(adapter);
        adapter.setCustomButtonListner(this);


    }


    public void setNewAlarm(View view){
        //alarms.addAlarm(new Alarm(7,5,"peter"));
        //adapter.notifyDataSetChanged();
        Intent intent = new Intent(this, CreateAlarmActivity.class);
        startActivityForResult(intent, ALARMCODE);

    }

    public void deleteAlarm(View view){

        adapter.notifyDataSetChanged();
    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode == ALARMCODE && resultCode == RESULT_OK ){
            if (intent.hasExtra("hour") && intent.hasExtra("min") ){
                alarms.addAlarm(new Alarm(intent.getExtras().getInt("hour"),intent.getExtras().getInt("min"),
                        intent.getExtras().getInt("month"), intent.getExtras().getInt("day"), intent.getExtras().getInt("year"),
                        intent.getExtras().getString("title")));
                adapter.notifyDataSetChanged();

                String filename = "Alarmfile";
                Alarm alarm = new Alarm(intent.getExtras().getInt("hour"),intent.getExtras().getInt("min"));
                String alarmString = alarm.toString();
                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    outputStream.write(alarmString.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void onButtonClickListener(int position, String value) {
        alarms.removeAlarm(position);
        adapter.notifyDataSetChanged();
    }
}

