package com.example.abscence_judoka.IHM;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.abscence_judoka.DAO.CategorieDAO;
import com.example.abscence_judoka.DAO.CeintureDAO;
import com.example.abscence_judoka.DAO.EleveDAO;
import com.example.abscence_judoka.Metier.Categorie;
import com.example.abscence_judoka.Metier.Ceinture;
import com.example.abscence_judoka.Metier.Eleve;
import com.example.abscence_judoka.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class formModifEleve extends AppCompatActivity {

    private Button supprimer;
    private Button retour;
    private Button modifier;
    private EditText nom;
    private EditText prenom;
    private EditText dateNaiss;
    private Spinner categorie;
    private Spinner ceinture;

    private ArrayList<Categorie> listCateg;
    private ArrayList<Ceinture> listCeint;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier);
        nom = (EditText)findViewById(R.id.sNom);
        prenom = (EditText)findViewById(R.id.sPrenom);
        dateNaiss = (EditText)findViewById(R.id.sDateNaiss);
        retour = (Button) findViewById(R.id.bRetour);
        retour.setOnClickListener(retourListener);
        modifier = (Button) findViewById(R.id.bModifier);
        modifier.setOnClickListener(modifierListener);
        supprimer = (Button) findViewById(R.id.bSupprimer);
        supprimer.setOnClickListener(supprimerListener);
        categorie = (Spinner)findViewById(R.id.listCeinture);
        ceinture = (Spinner)findViewById(R.id.listCateg);

        listCateg = new ArrayList<Categorie>();
        CategorieDAO bdd = new CategorieDAO(this);
        bdd.open();
        listCateg = bdd.read();
        ArrayList<String> c = new ArrayList<>();
        for (int i = 0; i < listCateg.size(); i++){
            c.add(listCateg.get(i).getLibelleCategorie());
        }
        bdd.close();
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, c);
        categorie.setAdapter(spinnerAdapter);

        listCeint = new ArrayList<Ceinture>();
        CeintureDAO bd = new CeintureDAO(this);
        bd.open();
        listCeint = bd.read();
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < listCeint.size(); i++){
            a.add(listCeint.get(i).getLibelleCeinture());
        }
        bd.close();
        ArrayAdapter<String> spinnerAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, a);
        ceinture.setAdapter(spinnerAdapter1);

        prenom.setText(eleves.idEleve.getPrenomEleve());
        nom.setText(eleves.idEleve.getNomEleve());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateNaiss.setText(dateFormat.format(eleves.idEleve.getDateNaissanceEleve()));
    }

    private View.OnClickListener retourListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), eleves.class);
            startActivityForResult(intent, 0);
        }
    };

    private View.OnClickListener modifierListener = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
            AtomicInteger itCat = new AtomicInteger();
            AtomicInteger itCeint = new AtomicInteger();

            listCateg.forEach(cat -> {
                if(cat.getLibelleCategorie().equals(categorie.getSelectedItem().toString())){
                    itCat.set(cat.getIdCategorie());
                }
            });

            listCeint.forEach(ceint -> {
                if(ceint.getLibelleCeinture().equals(ceinture.getSelectedItem().toString())){
                    itCeint.set(ceint.getIdCeinture());
                }
            });

            if(verifTextevide()) {
                Date date = null;
                try {
                    date = dateFormat.parse(dateNaiss.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Eleve eleve = new Eleve(eleves.idEleve.getIdEleve(), nom.getText().toString(), prenom.getText().toString(), date, itCat.get(),itCeint.get());
                updateEleve(eleve);

                Intent intent = new Intent(v.getContext(), eleves.class);
                startActivityForResult(intent, 0);
            } else {
                Toast.makeText(formModifEleve.this, "Veuillez remplir tous les champs !", Toast.LENGTH_LONG).show();
            }
        }
    };

    public void updateEleve(Eleve eleveModif){
        EleveDAO bdd = new EleveDAO(this);
        bdd.open();
        bdd.update(eleveModif);
        Toast.makeText(formModifEleve.this,"Élève modifier avec succès !", Toast.LENGTH_LONG).show();
    }

    public void deleteEleve(Eleve elevesupprimer){
        EleveDAO bdd = new EleveDAO(this);
        bdd.open();
        bdd.delete(elevesupprimer);
        Toast.makeText(formModifEleve.this, "Élève supprimer avec succès !", Toast.LENGTH_LONG).show();
    }

    public boolean verifTextevide(){
        String verifNom, verifPrenom, verifDate;
        verifNom = nom.getText().toString() ;
        verifPrenom = prenom.getText().toString();
        verifDate = dateNaiss.getText().toString();

        if(TextUtils.isEmpty(verifNom) || TextUtils.isEmpty(verifPrenom)|| TextUtils.isEmpty(verifDate)){
            return false;
        }

        return true;
    }

    private View.OnClickListener supprimerListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            deleteEleve(eleves.idEleve);
            Intent intent = new Intent(v.getContext(), eleves.class);
            startActivityForResult(intent, 0);
        }
    };
}