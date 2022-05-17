package com.plantsit.koskaistutan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.util.ArrayList;

public class IstutusAjat extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<String> kasviNimet = new ArrayList<>();
    ArrayList<String> kasvuAlue = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istutusajat);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        try {

            JSONObject obj = new JSONObject(loadJSONfromAssets());

            JSONArray listaArray = obj.getJSONArray("lista");

            for (int i=0 ; i<listaArray.length() ; i++) {

                JSONObject listaDetail = listaArray.getJSONObject(i);

                kasviNimet.add(listaDetail.getString("kasvit"));
                kasvuAlue.add(listaDetail.getString("alue"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapterMain customAdapterMain = new CustomAdapterMain( kasviNimet, kasvuAlue, IstutusAjat.this);
        recyclerView.setAdapter(customAdapterMain);

    }

    private String loadJSONfromAssets() {

        String json = null;

        try {

            InputStream is = getAssets().open("asetukset.json");
            int size = is.available();

            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");

        }

        catch (IOException e) {

            e.printStackTrace();
            return null;

        }

        return json;

    }
}
