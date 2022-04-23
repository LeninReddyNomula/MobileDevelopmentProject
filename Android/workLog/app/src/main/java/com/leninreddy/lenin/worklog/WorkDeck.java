package com.leninreddy.lenin.worklog;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class WorkDeck extends AppCompatActivity {

    public SQLiteDatabase db;
    public String companyName;
    public String shiftstart="Today";
    public String shiftend="Tomorrow";
    public Integer rate;
    public Integer tips;
<<<<<<< Updated upstream
    public Integer id=2;
=======
    public static Integer id;
    public float total;
    EditText companyNameED;
    EditText shiftStartED;
    EditText shiftEndED;
    EditText hourlyRateED;
    EditText tipsED;
    WebView wv;


>>>>>>> Stashed changes

    protected void createDatabase()
    {
        try {
            db=this.openOrCreateDatabase("WorkDatabase",MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS MyWork(id INTEGER PRIMARY KEY, day VARCHAR, name VARCHAR, shiftstart VARCHAR, shiftend VARCHAR, tips INTEGER,rate INTEGER)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate) VALUES ('monday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('tuesday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('wednesday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('thursday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork(day, name, shiftstart, shiftend, tips, rate)  VALUES ('friday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('saturday','xxx','','',10,15)");
            db.execSQL("INSERT INTO MyWork (day, name, shiftstart, shiftend, tips, rate)  VALUES ('sunday','xxx','','',10,15)");

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
            int nameIndex=query.getColumnIndex("Name");
            int idIndex=query.getColumnIndex("id");
            int rateIndex=query.getColumnIndex("rate");
            int tipsIndex=query.getColumnIndex("tips");
            int dayIndex=query.getColumnIndex("day");
            //int workName=query.getColumnIndex("name");
            //Log.i("MyWork", String.valueOf(+nameIndex));
            query.moveToFirst();
            while(query!=null)
            {
                Log.i("MyWork: ","Name: "+query.getString(nameIndex)+" ID: "+query.getInt(idIndex)+" , rate : "+query.getString(rateIndex)+
                        " , tips : "+query.getString(tipsIndex)+" , day : "+query.getString(dayIndex)
                );
                query.moveToNext();
            }

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
            db.execSQL("UPDATE MyWork SET name='"+companyName+"',shiftstart='"+shiftstart+"',shiftend='"+shiftend+"',rate='"+rate+"',tips='"+tips+"' WHERE id="+id+"");
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
        db.close();
    }

<<<<<<< Updated upstream
=======
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_deck);

        DownloadTask collectQuote = new DownloadTask();

        collectQuote.execute("https://api.kanye.rest");



    }
>>>>>>> Stashed changes

    public void onclickSave(View view){

        TextView cn=findViewById(R.id.companyName);
        companyName= (String) cn.getText();

        /*TextView sd = findViewById(R.id.shiftstart);
        shiftstart = (String) sd.getText();

        TextView se = findViewById(R.id.shiftend);
        shiftend= (String) se.getText();*/

<<<<<<< Updated upstream
        TextView rt = findViewById(R.id.hourlyrate);
        String rateText= (String) rt.getText();
        rate=Integer.parseInt(rateText);
=======

>>>>>>> Stashed changes

        TextView tip = findViewById(R.id.tips);
        String tipText= (String) rt.getText();
        rate=Integer.parseInt(tipText);

        updateTableRecord();
        loadTableData();

    }

    @Override
<<<<<<< Updated upstream
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
=======
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
                Toast.makeText(this, "Database is created", Toast.LENGTH_SHORT).show();
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

>>>>>>> Stashed changes

        createDatabase();

        loadTableData();
    }
}