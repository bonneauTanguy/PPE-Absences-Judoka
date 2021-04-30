package com.example.abscence_judoka.IHM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.abscence_judoka.MainActivity;
import com.example.abscence_judoka.R;

public class eleves extends AppCompatActivity {
    private Button calendrier;
    private Button accueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleves);
        calendrier = (Button) findViewById(R.id.bCalendrier);
        calendrier.setOnClickListener(calendrierListener);
        accueil = (Button) findViewById(R.id.accueil);
        accueil.setOnClickListener(accueilListener);

    }

    private View.OnClickListener calendrierListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), com.example.abscence_judoka.IHM.calendrier.class);
            startActivityForResult(intent, 0);
        }
    };

    private View.OnClickListener accueilListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            startActivityForResult(intent, 0);
        }
    };
}