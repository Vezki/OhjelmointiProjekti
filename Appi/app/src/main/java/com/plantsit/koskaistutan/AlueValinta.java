package com.plantsit.koskaistutan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class AlueValinta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alue_valinta);

        Spinner cmbAlueValinta = (Spinner) findViewById(R.id.cmbAlueValinta);

        String[] alueet = new String[] {"Ia","Ib", "II","III","IV","IV/V", "V", "V/VI", "VI", "VI/VII", "VII", "VIII"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alueet);
        cmbAlueValinta.setAdapter(adapter);
        /* Simppeli kovakoodaus comboboksille */


        ImageButton btnNuoli = findViewById(R.id.btnNuoli);

        btnNuoli.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AlueValinta.this, KasviValinta.class));
                finish();
            }
        });



    }
}