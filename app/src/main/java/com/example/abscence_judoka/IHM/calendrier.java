package com.example.abscence_judoka.IHM;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.abscence_judoka.DAO.CoursDAO;
import com.example.abscence_judoka.DAO.EleveDAO;
import com.example.abscence_judoka.MainActivity;
import com.example.abscence_judoka.Metier.Cours;
import com.example.abscence_judoka.Metier.Eleve;
import com.example.abscence_judoka.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class calendrier extends AppCompatActivity {
    private Button accueil;
    private Button eleves;
    private Button ajouter;
    private Spinner hDebut;
    private Spinner hFin;
    private CalendarView calendrier;
    private Date dateFinal;

    private ArrayList<Eleve> allCours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier);
        accueil = (Button) findViewById(R.id.bAccueil);
        accueil.setOnClickListener(accueilListener);
        eleves = (Button) findViewById(R.id.bEleves);
        eleves.setOnClickListener(eleveListener);
        ajouter = (Button) findViewById(R.id.bAjCours);
        ajouter.setOnClickListener(ajouterListener);
        calendrier = (CalendarView) findViewById(R.id.cCours);
        hDebut = (Spinner) findViewById(R.id.sHeureD);
        hFin = (Spinner) findViewById(R.id.sHeureF);
        String[] arraySpinner = new String[]{
                "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hDebut.setAdapter(adapter);
        hFin.setAdapter(adapter);

        allCours = new ArrayList<Eleve>();
        EleveDAO bdd2 = new EleveDAO(this);
        bdd2.open();
        allCours = bdd2.read();
        bdd2.close();

        calendrier.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dateChoisi = year + "-" + month + "-" + dayOfMonth;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    dateFinal = dateFormat.parse(dateChoisi);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });
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

    public void insertionCours(Cours cours){
        CoursDAO bdd1 = new CoursDAO(this);
        bdd1.open();
        bdd1.insert(cours);
        Toast.makeText(calendrier.this,"Cours ajouter avec succès !", Toast.LENGTH_LONG).show();
    }

    private View.OnClickListener ajouterListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Cours cours = new Cours(allCours.size()+1, dateFinal, Integer.parseInt(hDebut.getSelectedItem().toString()), Integer.parseInt(hFin.getSelectedItem().toString()));
            insertionCours(cours);
        }
    };
}