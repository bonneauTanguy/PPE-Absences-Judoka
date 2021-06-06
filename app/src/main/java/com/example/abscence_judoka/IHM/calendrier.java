package com.example.abscence_judoka.IHM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.abscence_judoka.MainActivity;
import com.example.abscence_judoka.R;

public class calendrier extends AppCompatActivity {
    private Button accueil;
    private Button eleves;
    private Spinner hDebut;
    private Spinner hFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);
        accueil = (Button) findViewById(R.id.bAccueil);
        accueil.setOnClickListener(accueilListener);
        eleves = (Button) findViewById(R.id.bEleves);
        eleves.setOnClickListener(eleveListener);
        hDebut = (Spinner)findViewById(R.id.sHeureD);
        hFin = (Spinner)findViewById(R.id.sHeureF);
        String[] arraySpinner = new String[] {
                "7","8","9","10", "11", "12", "13","14","15","16","17","18","19","20","21","22"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hDebut.setAdapter(adapter);
        hFin.setAdapter(adapter);


    }

    private View.OnClickListener accueilListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            startActivityForResult(intent, 0);
        }
    };

    private View.OnClickListener eleveListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), com.example.abscence_judoka.IHM.eleves.class);
            startActivityForResult(intent, 0);
        }
    };
}