package com.leninreddy.lenin.worklog;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener{
    TextView tv;
    public static double total;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch(item.getItemId()){
            case R.id.actionReset:
                setContentView(R.layout.activity_home);
                Toast.makeText(this, "RESET IS COMPLETED", Toast.LENGTH_SHORT).show();
            default:

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv=findViewById(R.id.totalEarnings);
        tv.setText("total Earnings : $"+total);

        Button mondaySwipeIn = (Button) findViewById(R.id.mondayswipein);
        mondaySwipeIn.setOnClickListener(this);

        Button mondaySwipeOut = (Button) findViewById(R.id.mondayswipeout);
        mondaySwipeOut.setOnClickListener(this);

        Button tuesdaySwipeIn = (Button) findViewById(R.id.tuesdayswipein);
        tuesdaySwipeIn.setOnClickListener(this);

        Button tuesdaySwipeOut = (Button) findViewById(R.id.tuesdayswipeout);
        tuesdaySwipeOut.setOnClickListener(this);

        Button wednesdaySwipeIn = (Button) findViewById(R.id.wednesdayswipein);
        wednesdaySwipeIn.setOnClickListener(this);

        Button wednesdaySwipeOut = (Button) findViewById(R.id.wednesdayswipeout);
        wednesdaySwipeOut.setOnClickListener(this);

        Button thursdaySwipeIn = (Button) findViewById(R.id.thursdayswipein);
        thursdaySwipeIn.setOnClickListener(this);

        Button thursdaySwipeOut = (Button) findViewById(R.id.thursdayswipeout);
        thursdaySwipeOut.setOnClickListener(this);

        Button fridaySwipeIn = (Button) findViewById(R.id.fridayswipein);
        fridaySwipeIn.setOnClickListener(this);

        Button fridaySwipeOut = (Button) findViewById(R.id.fridayswipeout);
        fridaySwipeOut.setOnClickListener(this);

        Button saturdaySwipeIn = (Button) findViewById(R.id.saturdayswipein);
        saturdaySwipeIn.setOnClickListener(this);

        Button saturdaySwipeOut = (Button) findViewById(R.id.saturdayswipeout);
        saturdaySwipeOut.setOnClickListener(this);

        Button sundaySwipeIn = (Button) findViewById(R.id.sundayswipein);
        sundaySwipeIn.setOnClickListener(this);

        Button sundaySwipeOut = (Button) findViewById(R.id.sundayswipeout);
        sundaySwipeOut.setOnClickListener(this);

    }

    public void mondayDeck(View view) {
        tv=findViewById(R.id.Monday);
        WorkDeck.id = 1;

        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void tuesdayDeck(View view) {
        tv=findViewById(R.id.Tuesday);
        WorkDeck.id = 2;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void wednesdayDeck(View view) {
        tv=findViewById(R.id.Wednesday);
        WorkDeck.id = 3;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void thursdayDeck(View view) {
        tv=findViewById(R.id.thursday);
        WorkDeck.id = 4;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void fridayDeck(View view) {
        tv=findViewById(R.id.friday);
        WorkDeck.id = 5;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void saturdayDeck(View view) {
        tv=findViewById(R.id.saturday);
        WorkDeck.id = 6;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    public void sundayDeck(View view) {
        tv=findViewById(R.id.sunday);
        WorkDeck.id = 7;
        Intent intent = new Intent(this,WorkDeck.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mondayswipein:
                Button mondayswipeinclicked=(Button) findViewById(R.id.mondayswipein);
                Toast.makeText(this, "MONDAY swiped-in", Toast.LENGTH_SHORT).show();
                mondayswipeinclicked.setBackgroundResource(R.color.white);
                mondayswipeinclicked.setText("SWIPED-IN");
                break;
            case R.id.mondayswipeout:
                Button mondayswipeoutclicked=(Button) findViewById(R.id.mondayswipeout);
                Toast.makeText(this, "monday swiped-out", Toast.LENGTH_SHORT).show();
                mondayswipeoutclicked.setBackgroundResource(R.color.white);
                mondayswipeoutclicked.setText("SWIPED-OUT");
                break;
            case R.id.tuesdayswipeout:
                Button tuesdayswipeoutclicked=(Button) findViewById(R.id.tuesdayswipeout);
                Toast.makeText(this, "TUESDAY swiped-out", Toast.LENGTH_SHORT).show();
                tuesdayswipeoutclicked.setBackgroundResource(R.color.white);
                tuesdayswipeoutclicked.setText("SWIPED-OUT");
                break;
            case R.id.wednesdayswipeout:
                Button wednesdayswipeoutclicked=(Button) findViewById(R.id.wednesdayswipeout);
                Toast.makeText(this, "WEDNESDAY SWIPE-OUT", Toast.LENGTH_SHORT).show();
                wednesdayswipeoutclicked.setBackgroundResource(R.color.white);
                wednesdayswipeoutclicked.setText("SWIPED-OUT");
                break;
            case R.id.thursdayswipeout:
                Button thursdayswipeoutclicked=(Button) findViewById(R.id.thursdayswipeout);
                Toast.makeText(this, "THURSDAY SWIPED-OUT", Toast.LENGTH_SHORT).show();
                thursdayswipeoutclicked.setBackgroundResource(R.color.white);
                thursdayswipeoutclicked.setText("SWIPED-OUT");
                break;
            case R.id.fridayswipeout:
                Button fridayswipeoutclicked=(Button) findViewById(R.id.fridayswipeout);
                Toast.makeText(this, "FRIDAY swiped-out", Toast.LENGTH_SHORT).show();
                fridayswipeoutclicked.setBackgroundResource(R.color.white);
                fridayswipeoutclicked.setText("SWIPED-OUT");
                break;
            case R.id.saturdayswipeout:
                Button saturdayswipeoutclicked=(Button) findViewById(R.id.saturdayswipeout);
                Toast.makeText(this, "SATURDAY swiped-out", Toast.LENGTH_SHORT).show();
                saturdayswipeoutclicked.setBackgroundResource(R.color.white);
                saturdayswipeoutclicked.setText("SWIPED-OUT");
                break;
            case R.id.sundayswipeout:
                Button sundayswipeoutclicked=(Button) findViewById(R.id.sundayswipeout);
                Toast.makeText(this, "SUNDAY swiped-out", Toast.LENGTH_SHORT).show();
                sundayswipeoutclicked.setBackgroundResource(R.color.white);
                sundayswipeoutclicked.setText("SWIPED-OUT");
                break;
            case R.id.tuesdayswipein:
                Button tuesdayswipeinclicked=(Button) findViewById(R.id.tuesdayswipein);
                Toast.makeText(this, "TUESDAY swiped-in", Toast.LENGTH_SHORT).show();
                tuesdayswipeinclicked.setBackgroundResource(R.color.white);
                tuesdayswipeinclicked.setText("SWIPED-IN");
                break;
            case R.id.wednesdayswipein:
                Button wednesdayswipeinclicked=(Button) findViewById(R.id.wednesdayswipein);
                Toast.makeText(this, "WEDNESDAY SWIPE-IN", Toast.LENGTH_SHORT).show();
                wednesdayswipeinclicked.setBackgroundResource(R.color.white);
                wednesdayswipeinclicked.setText("SWIPED-IN");
                break;
            case R.id.thursdayswipein:
                Button thursdayswipeinclicked=(Button) findViewById(R.id.thursdayswipein);
                Toast.makeText(this, "THURSDAY SWIPED-IN", Toast.LENGTH_SHORT).show();
                thursdayswipeinclicked.setBackgroundResource(R.color.white);
                thursdayswipeinclicked.setText("SWIPED-IN");
                break;
            case R.id.fridayswipein:
                Button fridayswipeinclicked=(Button) findViewById(R.id.fridayswipein);
                Toast.makeText(this, "FRIDAY swiped-in", Toast.LENGTH_SHORT).show();
                fridayswipeinclicked.setBackgroundResource(R.color.white);
                fridayswipeinclicked.setText("SWIPED-IN");
                break;
            case R.id.saturdayswipein:
                Button saturdayswipeinclicked=(Button) findViewById(R.id.saturdayswipein);
                Toast.makeText(this, "SATURDAY swiped-in", Toast.LENGTH_SHORT).show();
                saturdayswipeinclicked.setBackgroundResource(R.color.white);
                saturdayswipeinclicked.setText("SWIPED-IN");
                break;
            case R.id.sundayswipein:
                Button sundayswipeinclicked=(Button) findViewById(R.id.sundayswipein);
                Toast.makeText(this, "SUNDAY swiped-in", Toast.LENGTH_SHORT).show();
                sundayswipeinclicked.setBackgroundResource(R.color.white);
                sundayswipeinclicked.setText("SWIPED-IN");
                break;
        }
    }




}