package com.leninreddy.lenin.worklog;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WorkDeck extends AppCompatActivity {

    public SQLiteDatabase db;
    public String companyName;
    public String shiftstart;
    public String shiftend;
    public Integer rate;
    public Integer tips;
    public static Integer id;
    public float total;
    EditText companyNameED;
    EditText shiftStartED;
    EditText shiftEndED;
    EditText hourlyRateED;
    EditText tipsED;
    WebView wv;
    public int count=0;

    private SharedPreferences mPreferences;
    private String SharedPrefFileName="com.leninreddy.lenin.login";


    protected void createDatabase()
    {
        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS MyWork(id INTEGER PRIMARY KEY, day VARCHAR, name VARCHAR, shiftstart VARCHAR, shiftend VARCHAR, tips INTEGER,rate INTEGER,total INTEGER)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate,total) VALUES ('monday','xxx','','',10,15,0)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate,total)  VALUES ('tuesday','xxx','','',10,15,0)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate,total)  VALUES ('wednesday','xxx','','',10,15,0)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate,total)  VALUES ('thursday','xxx','','',10,15,0)");
            db.execSQL("INSERT INTO MyWork(day, name, shiftstart, shiftend, tips, rate,total)  VALUES ('friday','xxx','','',10,15,0)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate,total)  VALUES ('saturday','xxx','','',10,15,0)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate,total)  VALUES ('sunday','xxx','','',10,15,0)");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    protected void loadTableData()
    {
        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            Cursor query=db.rawQuery("SELECT * FROM MyWork",null);
            int nameIndex=query.getColumnIndex("name");
            int idIndex=query.getColumnIndex("id");
            int rateIndex=query.getColumnIndex("rate");
            int tipsIndex=query.getColumnIndex("tips");
            int dayIndex=query.getColumnIndex("day");
            int startIndex = query.getColumnIndex("shiftstart");
            int endIndex = query.getColumnIndex("shiftend");
            int totalIndex = query.getColumnIndex("total");

            //int workName=query.getColumnIndex("name");
            //Log.i("MyWork", String.valueOf(+nameIndex));
            query.moveToFirst();
            while(query!=null)
            {
                Log.i("MyWork: ","Name: "+query.getString(nameIndex)+" ID: "+query.getInt(idIndex)+" , rate : "+query.getString(rateIndex)+
                        " , tips : "+query.getString(tipsIndex)+" , day : "+query.getString(dayIndex)+" , start : "+query.getString(startIndex)+" , end : "
                        +query.getString(endIndex) +" , total : "+query.getDouble(totalIndex));
                query.moveToNext();
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    protected void getTotal(){
        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            Cursor query=db.rawQuery("SELECT SUM(total) FROM MyWork",null);
            int totalIndex = query.getColumnIndex("total");
            //int workName=query.getColumnIndex("name");
            //Log.i("MyWork", String.valueOf(+nameIndex));
            if(query.moveToFirst()){
                Home.total = query.getDouble(0);

            }
            Log.i("MyWork: ","  total : "+query.getDouble(0));

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    protected void updateTableRecord(){

        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            //db.execSQL("DELETE FROM MyWork");
            //db.execSQL("DELETE FROM MyTable WHERE age=70");
            //db.execSQL("UPDATE MyWork SET name='"+companyName+"',shiftstart='"+shiftstart+"',shiftend='"+shiftend+"',rate='"+rate+"',tips='"+tips+"' WHERE id="+id+"");

            db.execSQL("UPDATE MyWork SET name='"+companyName+"',shiftstart='"+shiftstart+"',shiftend='"+shiftend+"',rate='"+rate+"',tips='"+tips+"', total='"+total+"' WHERE id='"+id+"'");


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        db.close();
    }

    protected void deleteTable(){
        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            db.execSQL("DELETE FROM MyWork");
            //db.execSQL("DELETE FROM MyTable WHERE age=70");
            // db.execSQL("UPDATE MyWork SET name='"+companyName+"',shiftstart='"+shiftstart+"',shiftend='"+shiftend+"',rate='"+rate+"',tips='"+tips+"' WHERE id="+id+"");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        Log.i("MyWork","table deleted");
        db.close();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_deck);

        DownloadTask collectQuote = new DownloadTask();

        collectQuote.execute("https://api.kanye.rest");



/*
        mPreferences=getSharedPreferences(SharedPrefFileName, MODE_PRIVATE);
        int countSaved=mPreferences.getInt("count",1);
        if(countSaved==0) {
            createDatabase();
            loadTableData();
            count++;
            //deleteTable();
        }else{
            loadTableData();
        }*/
    }




    public void onclickSave(View view) throws ParseException {




        companyNameED=findViewById(R.id.companyName);
        companyName=companyNameED.getText().toString();

        shiftStartED=findViewById(R.id.shiftstart);
        shiftstart=shiftStartED.getText().toString();

        shiftEndED = findViewById(R.id.shiftend);
        shiftend=shiftEndED.getText().toString();

        hourlyRateED=findViewById(R.id.hourlyrate);
        rate=Integer.parseInt(hourlyRateED.getText().toString());

        tipsED=findViewById(R.id.tips);
        tips=Integer.parseInt(tipsED.getText().toString());


        //code to find time length in minutes
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date shiftstartFormat=format.parse(shiftstart);
        Date shiftendFormat=format.parse(shiftend);


        long difference = shiftendFormat.getTime()-shiftstartFormat.getTime();

        float mins= TimeUnit.MILLISECONDS.toMinutes(difference);
        float hours = mins/60;
        total = (hours * rate)+tips;
        updateTableRecord();
        loadTableData();
        //deleteTable();
        getTotal();
        Toast.makeText(this, "RECORD IS SAVED", Toast.LENGTH_SHORT).show();
    }

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
                deleteTable();
                Home.total=0;
                Toast.makeText(this, "RESET IS COMPLETED", Toast.LENGTH_SHORT).show();
            case R.id.actionDataBase:
                createDatabase();
                loadTableData();
                Toast.makeText(this, "DATABASE is created", Toast.LENGTH_SHORT).show();
            default:

        }
        return super.onOptionsItemSelected(item);
    }

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls){
            String result = "";
            URL url;
            HttpURLConnection urlConnection=null;

            try {
                url=new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                int responseCode = urlConnection.getResponseCode();
                Log.i("Response Code: ", Integer.toString(responseCode));
                if(responseCode == HttpURLConnection.HTTP_OK){
                    BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String inputLine;
                    while ((inputLine = br.readLine()) != null) {
                        result += inputLine;
                    }
                    br.close();
                }
                else
                {
                    Log.i("Error: ", "You have exceeded the daily access limit! Please Try again tomorrow.");
                }
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            String titleLink="";
            //Log.i("downloaded website content",s);

            JSONObject jsonObject = null;
            JSONObject articleObject = null;
            int numberOfTopNews;
            try {
                jsonObject = new JSONObject(s);
                if (!jsonObject.isNull("quote"))
                {


                    String strings=jsonObject.getString("quote");
                    Log.i("string"," "+strings);
                    TextView tv=findViewById(R.id.quote);
                    tv.setText(strings);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}