package com.example.abscence_judoka.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.example.abscence_judoka.Metier.Eleve;

import java.util.ArrayList;
import java.util.Date;

public class EleveDAO extends DAO<Eleve> {
    private SQLiteAbsence dbAbsence;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // déclaration des outils nécessaires à la base
    private static final String TABLE_ELEVE = "ELEVE";
    private static final String COL_ID_ELEVE = "IDELEVE";
    private static final String COL_NOMELEVE = "NOMELEVE";
    private static final String COL_PRENOMELEVE = "PRENOMELEVE";
    private static final String COL_DATENAISSANCEELEVE = "DATENAISSANCEELEVE";
    private static final String COL_ID_CATEGORIE_ELEVE = "IDCATEGORIEELEVE";
    private static final String COL_ID_CEINTURE_ELEVE = "IDCEINTUREELEVE";

    private SQLiteDatabase db;

    public EleveDAO(Context context){ dbAbsence = new SQLiteAbsence(context); }

    public void open(){ db = dbAbsence.getWritableDatabase(); }

    public void close(){ dbAbsence.close(); }

    public void insert(Eleve obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_NOMELEVE,obj.getNomEleve());
        valeurs.put(COL_PRENOMELEVE,obj.getPrenomEleve());
        valeurs.put(COL_DATENAISSANCEELEVE,dateFormat.format(obj.getDateNaissanceEleve()));
        valeurs.put(COL_ID_CATEGORIE_ELEVE,obj.getIdCategorieEleve());
        valeurs.put(COL_ID_CEINTURE_ELEVE,obj.getIdCeintureEleve());
        db.insert(TABLE_ELEVE,null,valeurs);
    }
    // insertion de la matière dans la base

    public void update(Eleve obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_NOMELEVE,obj.getNomEleve());
        valeurs.put(COL_PRENOMELEVE,obj.getPrenomEleve());
        valeurs.put(COL_DATENAISSANCEELEVE,dateFormat.format(obj.getDateNaissanceEleve()));
        valeurs.put(COL_ID_CATEGORIE_ELEVE,obj.getIdCategorieEleve());
        valeurs.put(COL_ID_CEINTURE_ELEVE,obj.getIdCeintureEleve());
        db.update(TABLE_ELEVE, valeurs, COL_ID_ELEVE+" = "+obj.getIdEleve(),null);
    }
    // modification du nom et coefficient de la matière en fonction du numéro

    public void delete(Eleve obj) {
        db.delete(TABLE_ELEVE, COL_ID_ELEVE+" = "+obj.getIdEleve(),null);
    }
    // suppression de la matière en fonction de son numéro

    public Eleve read(int id){

        Eleve eleveRetour;
        String prenomEleve, nomEleve;
        Date dateNaissance;
        int idEleve, idCategorieEleve, idCeintureEleve;

        eleveRetour = null;
        dateNaissance = null;
        db.isOpen();
        Cursor curseurQuery = db.query(TABLE_ELEVE, null, COL_ID_ELEVE+" = "+id, null, null, null, null);
        curseurQuery.moveToFirst();
        if (!curseurQuery.isAfterLast()) {
            idEleve = curseurQuery.getInt(0);
            nomEleve = curseurQuery.getString(1);
            prenomEleve = curseurQuery.getString(2);
            try {
                dateNaissance = dateFormat.parse(curseurQuery.getString(3));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            idCategorieEleve = curseurQuery.getInt(4);
            idCeintureEleve = curseurQuery.getInt(5);
            eleveRetour = new Eleve(nomEleve, prenomEleve, dateNaissance, idCategorieEleve, idCeintureEleve);
        }
        curseurQuery.close();

        return (eleveRetour);
    }
    // Recherche le numéro de la matière dans la base et la retourne

    public ArrayList<Eleve> read() {
        ArrayList<Eleve> eleves;
        eleves = new ArrayList<Eleve>();
        Eleve eleve;
        String prenomEleve, nomEleve;
        Date dateNaissance;
        int idEleve, idCategorieEleve, idCeintureEleve;

        eleve = null;
        dateNaissance = null;
        db.isOpen();
        Cursor curseurQuery = db.query(TABLE_ELEVE /*new String[]{"IDELEVE, NOMELEVE, PRENOMELEVE"}*/,null, null, null, null, null, null);
        curseurQuery.moveToFirst();
        for(int i=1; i<= curseurQuery.getCount(); i++){
            Date date = null;
            try {
                date = dateFormat.parse(curseurQuery.getString(3));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            eleve= new Eleve(curseurQuery.getString(1), curseurQuery.getString(2),date, curseurQuery.getInt(4), curseurQuery.getInt(5));

            eleves.add(eleve);
            curseurQuery.moveToNext();
        }

        /*while(!curseurQuery.isAfterLast()) {
            idEleve = curseurQuery.getInt(0);
            nomEleve = curseurQuery.getString(1);
            prenomEleve = curseurQuery.getString(2);
            try {
                dateNaissance = dateFormat.parse(curseurQuery.getString(3));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            idCategorieEleve = curseurQuery.getInt(4);
            idCeintureEleve = curseurQuery.getInt(5);

            eleves.add(new Eleve(nomEleve, prenomEleve, dateNaissance, idCategorieEleve, idCeintureEleve));

            curseurQuery.moveToNext();
        }*/
        curseurQuery.close();

        return (eleves);
    }
    // Retourne la liste de toutes les matières enregistrées dans la base.
}