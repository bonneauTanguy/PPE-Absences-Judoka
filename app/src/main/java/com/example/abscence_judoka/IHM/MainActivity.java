package com.example.abscence_judoka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.abscence_judoka.IHM.calendrier;
import com.example.abscence_judoka.R;

public class MainActivity extends AppCompatActivity {
    private Button calendrier;
    private Button eleves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendrier = (Button) findViewById(R.id.calendrier);
        calendrier.setOnClickListener(calendrierListener);
        eleves = (Button) findViewById(R.id.eleves);
        eleves.setOnClickListener(eleveListener);

    }
     private View.OnClickListener calendrierListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), com.example.abscence_judoka.IHM.calendrier.class);
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
