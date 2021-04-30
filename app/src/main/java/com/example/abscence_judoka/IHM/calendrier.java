package com.example.abscence_judoka.IHM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.abscence_judoka.MainActivity;
import com.example.abscence_judoka.R;

public class calendrier extends AppCompatActivity {
    private Button accueil;
    private Button eleves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);
        accueil = (Button) findViewById(R.id.bAccueil);
        accueil.setOnClickListener(accueilListener);
        eleves = (Button) findViewById(R.id.bEleves);
        eleves.setOnClickListener(eleveListener);
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