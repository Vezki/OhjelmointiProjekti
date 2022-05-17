package com.plantsit.koskaistutan;

import android.content.Context;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KasviValinta extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<String> kasvilista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasvi_valinta);

        recyclerView = findViewById(R.id.my_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(KasviValinta.this.getApplicationContext()));

        try {
            JSONObject obj = new JSONObject(loadJSONfromAssets());

            JSONArray kasvitArray = obj.getJSONArray("kasvit");

            for (int i = 0; i < kasvitArray.length(); i++) {
                JSONObject kasvitieto = kasvitArray.getJSONObject(i);

                kasvilista.add(kasvitieto.getString("kasvi"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapter customAdapter = new CustomAdapter(kasvilista, KasviValinta.this);
        recyclerView.setAdapter(customAdapter);


    }
    private String loadJSONfromAssets() {
        String json = null;

        try {
            InputStream is = getAssets().open("plants.json");
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;
    }
}
