package com.plantsit.koskaistutan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class AlueValinta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alue_valinta);

        Spinner cmbAlueValinta = (Spinner) findViewById(R.id.cmbAlueValinta);

        String[] alueet = new String[] {"Ia","Ib", "II","III","IV","IV/V", "V", "V/VI", "VI", "VI/VII", "VII", "VIII"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, alueet);
        cmbAlueValinta.setAdapter(adapter);
        /* Simppeli kovakoodaus comboboksille */


        ImageButton btnNuoli = findViewById(R.id.btnNuoli);

        btnNuoli.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlueValinta.this, KasviValinta.class));
                String comboItem = cmbAlueValinta.getSelectedItem().toString();

            try{

                JSONObject obj = new JSONObject(loadJSONfromAssets());

                JSONArray asetuksetArray = obj.getJSONArray("lista");

                JSONObject asetuksetTieto = asetuksetArray.getJSONObject(0);
                asetuksetTieto.put("alue", comboItem);

            }catch (Exception e){
                e.printStackTrace();
            }

            }
        });

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
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return json;

    }
}