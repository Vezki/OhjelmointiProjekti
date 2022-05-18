package com.plantsit.koskaistutan;

import android.os.Bundle;
import android.util.Log;

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
    ArrayList<String> istutusTapa = new ArrayList<>();
    ArrayList<String> aIstutusAika = new ArrayList<>();
    ArrayList<String> vIstutusAika = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istutusajat);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        try {

            JSONObject objAsetukset = new JSONObject(loadJSONfromAssets("asetukset.json"));
            JSONArray listaArray = objAsetukset .getJSONArray("lista");
            JSONObject listaDetail = listaArray.getJSONObject(0);
            JSONArray kasvitAsetuksetArray = listaDetail.getJSONArray("kasvit");

            JSONObject objPlants = new JSONObject(loadJSONfromAssets("plants.json"));
            JSONArray kasvitPlantsArray = objPlants.getJSONArray("kasvit");





            for (int i = 0; i < kasvitAsetuksetArray.length(); i++) {
                String tamanKasvinNimi = kasvitAsetuksetArray.getString(i);
                kasviNimet.add(tamanKasvinNimi);
                kasvuAlue.add(listaDetail.getString("alue"));
                for(int y = 0; y < kasvitPlantsArray.length(); y++){
                    JSONObject kasvitPlantsDetail = kasvitPlantsArray.getJSONObject(y);
                    String kasvinNimiObjektissa = kasvitPlantsDetail.getString("kasvi");
                   if(kasvinNimiObjektissa.equals(tamanKasvinNimi)){
                       aIstutusAika.add(kasvitPlantsDetail.get("aikaisintaan").toString());
                       vIstutusAika.add(kasvitPlantsDetail.get("viimeistaan").toString());
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapterMain customAdapterMain = new CustomAdapterMain(kasviNimet, kasvuAlue, aIstutusAika, vIstutusAika, IstutusAjat.this);
        recyclerView.setAdapter(customAdapterMain);
    }

    private String loadJSONfromAssets(String tiedosto) {

        String json = null;

        try {

            InputStream is = getAssets().open(tiedosto);
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
