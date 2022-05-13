package com.plantsit.koskaistutan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class KasviValinta extends AppCompatActivity {

    ArrayList<String> kasviNimet = new ArrayList<>();
    ArrayList<String> aikaisintaanAjat = new ArrayList<>();
    ArrayList<String> viimeistaanAjat = new ArrayList<>();
    ArrayList<String> istutusTyyli = new ArrayList<>();


    /*JSONista hakemiseen kaytetty pohjana koodia taalta Example 2 https://abhiandroid.com/programming/json*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasvi_valinta);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        try{
            JSONObject obj = new JSONObject(loadJSONFromRaw());

            JSONArray kasvitArray = obj.getJSONArray("Kasvit");
            for (int i = 0; i < kasvitArray.length(); i++){
                JSONObject kasvitDetail = kasvitArray.getJSONObject(i);
                kasviNimet.add(kasvitDetail.getString("kasvi"));
                aikaisintaanAjat.add(kasvitDetail.getString("aikaisintaan"));
                viimeistaanAjat.add(kasvitDetail.getString("viimeistaan"));
                istutusTyyli.add(kasvitDetail.getString("viimeistaan"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




    public String loadJSONFromRaw() {
        String json = null;
        try {
            InputStream is = getResources().openRawResource(R.raw.plants);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



}