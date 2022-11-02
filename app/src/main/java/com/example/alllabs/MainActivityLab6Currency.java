package com.example.alllabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivityLab6Currency extends AppCompatActivity {
    private String url = "https://www.cbr-xml-daily.ru/daily_json.js";
    private ArrayList<String> result;
    private ArrayList<String> res;
    private ArrayAdapter adapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab6_currency);
        res = new ArrayList<>();
        result = new ArrayList<>();
        listView = findViewById(R.id.currencyList);
        adapter = new ArrayAdapter( MainActivityLab6Currency.this,
                android.R.layout.simple_expandable_list_item_1, result);
        listView.setAdapter(adapter);
        new jsonTask().execute();
        //System.out.println(result);
    }

    class jsonTask extends AsyncTask<Void,Void,ArrayList<String>>{


        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            try{
                URL myurl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) myurl.openConnection();
                InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                //StringBuffer builder = new StringBuffer();
                String line;

                while ((line = reader.readLine()) != null){
                    if(line.indexOf("CharCode")>-1)
                        res.add(line);
                    if(line.indexOf("Value")>-1)
                        res.add(line);
                }
                //result = builder.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return res;
        }

        @Override
        protected void onPostExecute(ArrayList<String> s){
            super.onPostExecute(s);
            try {
                for(int i = 0; i< s.size();i+=2) {
                    result.add(res.get(i).replace("\"CharCode\":","") + res.get(i+1).replace("\"Value\":",""));
                }


                adapter.notifyDataSetChanged();
                System.out.println(111111111);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void onClickLab5back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}