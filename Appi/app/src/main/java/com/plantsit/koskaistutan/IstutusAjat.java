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



        /*    switch(tähän alue)
            {
                case: "Ia":
                    aikaisintaan = aikaisintaan;
                    viimeistään = viimeistään;
                    break;
                case: "Ib":
                    aikaisintaan = aikaisintaan.plusdays(3);
                    viimeistään = viimeistään.plusdays(3);
                    break;
                case: "II":
                    aikaisintaan = aikaisintaan.plusdays(7);
                    viimeistään = viimeistään.plusdays(7);
                    break;
                case: "III":
                    aikaisintaan = aikaisintaan.plusdays(11);
                    viimeistään = viimeistään.plusdays(11);
                    break;
                case: "IV":
                    aikaisintaan = aikaisintaan.plusdays(15);
                    viimeistään = viimeistään.plusdays(15);
                    break;
                case: "IV/V":
                    aikaisintaan = aikaisintaan.plusdays(18);
                    viimeistään = viimeistään.plusdays(18);
                    break;
                case: "V":
                    aikaisintaan = aikaisintaan.plusdays(21);
                    viimeistään = viimeistään.plusdays(21);
                    break;
                case: "V/VI":
                    aikaisintaan = aikaisintaan.plusdays(24);
                    viimeistään = viimeistään.plusdays(24);
                    break;
                case: "VI":
                    aikaisintaan = aikaisintaan.plusdays(27);
                    viimeistään = viimeistään.plusdays(27);
                    break;
                case: "VI/VII":
                    aikaisintaan = aikaisintaan.plusdays(30);
                    viimeistään = viimeistään.plusdays(30);
                    break;
                case: "VII":
                    aikaisintaan = aikaisintaan.plusdays(33);
                    viimeistään = viimeistään.plusdays(33);
                    break;
                case: "VIII":
                    aikaisintaan = aikaisintaan.plusdays(37);
                    viimeistään = viimeistään.plusdays(37);
                    break;
            } */


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
                       istutusTapa.add(kasvitPlantsDetail.get("tyyli").toString());
                    }
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapterMain customAdapterMain = new CustomAdapterMain(kasviNimet, kasvuAlue, aIstutusAika, vIstutusAika, istutusTapa, IstutusAjat.this);
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
