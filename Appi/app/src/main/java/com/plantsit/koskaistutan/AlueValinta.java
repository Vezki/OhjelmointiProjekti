package com.plantsit.koskaistutan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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

    }
}