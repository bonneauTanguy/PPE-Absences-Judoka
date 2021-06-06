package com.example.abscence_judoka.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.abscence_judoka.Metier.Cours;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CoursDAO {
    private SQLiteAbsence dbAbsence;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    // déclaration des outils nécessaires à la base
    private static final String TABLE_COURS = "COURS";
    private static final String COL_ID_COURS = "IDCOURS";
    private static final String COL_DATE_COURS = "DATECOURS";
    private static final String COL_HEURE_DEBUT = "HEUREDEBUTCOURS";
    private static final String COL_HEURE_FIN = "HEUREFINCOURS";

    private SQLiteDatabase db;

    public CoursDAO(Context context){ dbAbsence = new SQLiteAbsence(context); }

    public void open(){ db = dbAbsence.getWritableDatabase(); }

    public void close(){ dbAbsence.close(); }

    public void insert(Cours obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_DATE_COURS,dateFormat.format(obj.getDateCours()));
        valeurs.put(COL_HEURE_DEBUT,obj.getHeureDebutCours());
        valeurs.put(COL_HEURE_FIN,obj.getHeureFinCours());
        db.insert(TABLE_COURS,null,valeurs);
    }
    // insertion de la matière dans la base

    public void update(Cours obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_DATE_COURS,dateFormat.format(obj.getDateCours()));
        valeurs.put(COL_HEURE_DEBUT,obj.getHeureDebutCours());
        valeurs.put(COL_HEURE_FIN,obj.getHeureFinCours());
        db.update(TABLE_COURS, valeurs, COL_ID_COURS+" = "+obj.getIdCours(),null);
    }
    // modification du nom et coefficient de la matière en fonction du numéro

    public void delete(Cours obj) {
        db.delete(TABLE_COURS, COL_ID_COURS+" = "+obj.getIdCours(),null);
    }
    // suppression de la matière en fonction de son numéro

    public Cours read(int id){
        Cours clRetour;
        int idC, heureDebutCours, heureFinCours;
        Date dateCours;
        clRetour = null;
        db.isOpen();
        Cursor curseurQuery = db.query(TABLE_COURS, null, COL_ID_COURS+" = "+id, null, null, null, null);
        curseurQuery.moveToFirst();
        if (!curseurQuery.isAfterLast()) {
            idC = curseurQuery.getInt(0);
            try {
                dateCours = dateFormat.parse(curseurQuery.getString(1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            heureDebutCours = curseurQuery.getInt(2);
            heureFinCours = curseurQuery.getInt(3);
        }
        curseurQuery.close();
        return (clRetour);
    }
    // Recherche le numéro de la matière dans la base et la retourne

    public ArrayList<Cours> read() {
        ArrayList<Cours> Courss;
        Courss = new ArrayList<Cours>();
        int idC, heureDebutCours, heureFinCours;
        Date dateCours;
        dateCours = null;
        db.isOpen();
        Cursor curseurQuery = db.query(TABLE_COURS, null, null, null, null, null, null);
        curseurQuery.moveToFirst();

        while(!curseurQuery.isAfterLast()) {
            idC = curseurQuery.getInt(0);
            try {
                dateCours = dateFormat.parse(curseurQuery.getString(1));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            heureDebutCours = curseurQuery.getInt(2);
            heureFinCours = curseurQuery.getInt(3);

            Courss.add(new Cours(idC, dateCours, heureDebutCours, heureFinCours));
            curseurQuery.moveToNext();
        }
        curseurQuery.close();
        return (Courss);
    }
    // Retourne la liste de toutes les matières enregistrées dans la base.
}