package com.example.abscence_judoka.IHM;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abscence_judoka.DAO.EleveDAO;
import com.example.abscence_judoka.MainActivity;
import com.example.abscence_judoka.Metier.Eleve;
import com.example.abscence_judoka.R;

import java.util.ArrayList;

public class formAjoutEleve extends AppCompatActivity {
    private Button retour;
    private EditText nom;
    private EditText prenom;
    private EditText dateNaiss;
    private Button ajouter;
    private SQLiteDatabase db;
    private boolean verifVide;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        retour = (Button) findViewById(R.id.bRetour);
        retour.setOnClickListener(retourListener);
        ajouter = (Button) findViewById(R.id.bAjouter1);
        retour.setOnClickListener(ajoutListener);
        nom = (EditText)findViewById(R.id.sNom);
        prenom = (EditText)findViewById(R.id.sPrenom);
        dateNaiss = (EditText)findViewById(R.id.sDateNaiss);

    }

    private View.OnClickListener retourListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), eleves.class);
            startActivityForResult(intent, 0);
        }
    };

    public void verifTextevide(){
        String verifNom, verifPrenom, verifDate;
        verifNom = nom.getText().toString() ;
        verifPrenom = prenom.getText().toString();
        verifDate = dateNaiss.getText().toString();


        if(TextUtils.isEmpty(verifNom) || TextUtils.isEmpty(verifPrenom)){
            verifVide = false ;
        }
        else {
            verifVide = true ;
        }
    }

    public void insertionEleve(Eleve eleveAjout){
        if(verifVide==true){
            EleveDAO bdd = new EleveDAO(this);
            bdd.open();
            bdd.insert(eleveAjout);
            Toast.makeText(formAjoutEleve.this,"élève ajouter", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(formAjoutEleve.this, "veuillez remplir tout les champs", Toast.LENGTH_LONG).show();
        }
    }

    private View.OnClickListener ajoutListener = new View.OnClickListener(){

        @Override
        public void onClick(View v) {

        }
    };

}



