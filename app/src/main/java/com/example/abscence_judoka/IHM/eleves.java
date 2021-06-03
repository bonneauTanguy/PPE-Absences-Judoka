package com.example.abscence_judoka.IHM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.abscence_judoka.DAO.EleveDAO;
import com.example.abscence_judoka.DAO.SQLiteAbsence;
import com.example.abscence_judoka.MainActivity;
import com.example.abscence_judoka.Metier.Eleve;
import com.example.abscence_judoka.R;

import java.util.ArrayList;

public class eleves extends AppCompatActivity {
    private Button calendrier;
    private Button accueil;
    private Button ajouter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleves);
        calendrier = (Button) findViewById(R.id.bCalendrier);
        calendrier.setOnClickListener(calendrierListener);
        accueil = (Button) findViewById(R.id.accueil);
        accueil.setOnClickListener(accueilListener);
        ajouter = (Button) findViewById(R.id.bAjouter1);
        ajouter.setOnClickListener(ajouterListener);
        /*SimpleCursorAdapter curseurAdapter = SQLiteAbsence.ListViewBDD();
        lvEleve.setAdapter(curseurAdapter);
        lvEleve.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) SimpleCursorAdapter.getItem(position);
                String nom = cursor.getString(1);

                Toast.makeText(eleves.this, nom, Toast.LENGTH_LONG).show();
            }
        });*/
        ListView lvEleve = (ListView) findViewById(R.id.lvEleve);
        ArrayList<Eleve> values = new ArrayList<Eleve>();
        EleveDAO bdd = new EleveDAO(this);
        bdd.open();

        values = bdd.read();

        //log.v("test",values.toString());
        ArrayList<String> prenom = new ArrayList<>();
        for (int i = 0; i < values.size(); i++){
            prenom.add(values.get(i).getNomEleve()+ " "+values.get(i).getPrenomEleve());
        }
        Log.v("test",prenom.toString());
        ArrayAdapter<String> listEleveAdaptater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, prenom);
        lvEleve.setAdapter(listEleveAdaptater);
        //ArrayAdapter<Eleve> listEleveAdaptater = new ArrayAdapter<Eleve>(this, android.R.layout.simple_list_item_1, values);
        //lvEleve.setAdapter(listEleveAdaptater);
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

    private View.OnClickListener ajouterListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), formAjoutEleve.class);
            startActivityForResult(intent, 0);
        }
    };

}