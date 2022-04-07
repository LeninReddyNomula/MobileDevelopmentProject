package com.leninreddy.lenin.worklog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {



    public void clickDay(View view){
        //TextView tv = findViewById(R.id.Monday);


        Intent intent = new Intent(Home.this,WorkDeck.class);

        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}