package com.plantsit.koskaistutan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aluevalintaBtn = findViewById(R.id.aluevalintaBtn);

        aluevalintaBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AlueValinta.class));
            }
        });

        Button kasvivalintaBtn = findViewById(R.id.kasvivalintaBtn);

        kasvivalintaBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, KasviValinta.class));
            }
        });

        Button mainBtn = findViewById(R.id.mainBtn);

        mainBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, IstutusAjat.class));
            }
        });
    }
}