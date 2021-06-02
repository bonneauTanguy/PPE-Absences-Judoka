package com.example.abscence_judoka.IHM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abscence_judoka.MainActivity;
import com.example.abscence_judoka.R;

public class formAjoutEleve extends AppCompatActivity {
    private Button retour;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        retour = (Button) findViewById(R.id.bRetour);
        retour.setOnClickListener(retourListener);

    }

    private View.OnClickListener retourListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), eleves.class);
            startActivityForResult(intent, 0);
        }
    };

}



