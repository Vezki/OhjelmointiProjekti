package com.plantsit.koskaistutan;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class IstutusAjat extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<String> kasviNimet = new ArrayList<>();
    ArrayList<String> kasvuAlue = new ArrayList<>();
    ArrayList<String> istutusTapa = new ArrayList<>();
    ArrayList<String> aIstutusAika = new ArrayList<>();
    ArrayList<String> vIstutusAika = new ArrayList<>();

    LocalDate aik;
    LocalDate viim;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istutusajat);

        ImageButton btnAsetukset = findViewById(R.id.btnAsetukset);


        btnAsetukset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IstutusAjat.this, AlueValinta.class));
            }
            });


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
                String KasvuAlueenNro = listaDetail.getString("alue");
                kasvuAlue.add(listaDetail.getString("alue"));
                for(int y = 0; y < kasvitPlantsArray.length(); y++){
                    JSONObject kasvitPlantsDetail = kasvitPlantsArray.getJSONObject(y);
                    String kasvinNimiObjektissa = kasvitPlantsDetail.getString("kasvi");
                   if(kasvinNimiObjektissa.equals(tamanKasvinNimi)){
                       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                       String hoopo = kasvitPlantsDetail.get("aikaisintaan").toString();
                       LocalDate hoopoToDate = LocalDate.parse(hoopo, formatter);
                       String hoopoTwo = kasvitPlantsDetail.get("viimeistaan").toString();
                       LocalDate hoopoTwoToDate = LocalDate.parse(hoopoTwo, formatter);
                        switch(KasvuAlueenNro)
                        {
                            case "Ia":
                                aik = hoopoToDate;
                                viim = hoopoTwoToDate;
                                break;
                            case "Ib":
                                aik = hoopoToDate.plusDays(3);
                                viim = hoopoTwoToDate.plusDays(3);
                                break;
                            case "II":
                                aik = hoopoToDate.plusDays(7);
                                viim = hoopoTwoToDate.plusDays(7);
                                break;
                            case "III":
                                aik = hoopoToDate.plusDays(11);
                                viim = hoopoTwoToDate.plusDays(11);
                                break;
                            case "IV":
                                aik = hoopoToDate.plusDays(15);
                                viim = hoopoTwoToDate.plusDays(15);
                                break;
                            case "IV/V":
                                aik = hoopoToDate.plusDays(18);
                                viim = hoopoTwoToDate.plusDays(18);
                                break;
                            case "V":
                                aik = hoopoToDate.plusDays(21);
                                viim = hoopoTwoToDate.plusDays(21);
                                break;
                            case "V/VI":
                                aik = hoopoToDate.plusDays(24);
                                viim = hoopoTwoToDate.plusDays(24);
                                break;
                            case "VI":
                                aik = hoopoToDate.plusDays(27);
                                viim = hoopoTwoToDate.plusDays(27);
                                break;
                            case "VI/VII":
                                aik = hoopoToDate.plusDays(30);
                                viim = hoopoTwoToDate.plusDays(30);
                                break;
                            case "VII":
                                aik = hoopoToDate.plusDays(33);
                                viim = hoopoTwoToDate.plusDays(33);
                                break;
                            case "VIII":
                                aik = hoopoToDate.plusDays(37);
                                viim = hoopoTwoToDate.plusDays(37);
                                break;
                        }

                       String formattedAik = aik.format(DateTimeFormatter
                               .ofLocalizedDate(FormatStyle.SHORT));

                       String[] aiks = formattedAik.split("/", 3);
                       String entiia = aiks[1] + "." + aiks[0];

                      String formattedViim = viim.format(DateTimeFormatter
                               .ofLocalizedDate(FormatStyle.SHORT));

                       String[] viims = formattedViim.split("/", 3);
                       String huhuh = viims[1] + "." + viims[0];

<<<<<<< HEAD
/*
                       String strAik = hoopoToDate.toString();
=======
                       String strAik = aik.toString();
>>>>>>> 063ce4a3bddb44f5a13ea16b8ffa7805d0321bbb
                       LocalDate ldAik = LocalDate.parse(strAik);
                       DateTimeFormatter dtfAik = DateTimeFormatter.ofPattern("d.M"); //Jos haluat ajan esim 01.01, niin dd.MM, jos ilman nollia esim 1.1 niin d.M. Vuoden kanssa formaatti on d.M.yyyy
                       String strFAik = dtfAik.format(ldAik);

                       String strVim = viim.toString();
                       LocalDate ldVim = LocalDate.parse(strVim);
                       DateTimeFormatter dtfVim = DateTimeFormatter.ofPattern("d.M"); //Jos haluat ajan esim 01.01, niin dd.MM, jos ilman nollia esim 1.1 niin d.M. Vuoden kanssa formaatti on d.M.yyyy
                       String strFVim = dtfVim.format(ldVim);*/

                       aIstutusAika.add(entiia);
                       vIstutusAika.add(huhuh);
                       istutusTapa.add(kasvitPlantsDetail.getString("tyyli"));
                  //     Log.i("blagh", aik.toString());
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
