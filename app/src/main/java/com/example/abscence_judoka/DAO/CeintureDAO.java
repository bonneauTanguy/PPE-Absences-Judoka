package com.example.abscence_judoka.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.abscence_judoka.Metier.Ceinture;

import java.util.ArrayList;

public class CeintureDAO extends DAO<Ceinture> {
    private SQLiteAbsence dbAbsence;

    // déclaration des outils nécessaires à la base
    private static final String TABLE_CEINTURE = "CEINTURE";
    private static final String COL_ID_CEINTURE = "IDCEINTURE";
    private static final String COL_LIBELLE = "LIBELLECEINTURE";

    private SQLiteDatabase db;

    public CeintureDAO(Context context){ dbAbsence = new SQLiteAbsence(context); }

    public void open(){ db = dbAbsence.getWritableDatabase(); }

    public void close(){ dbAbsence.close(); }

    public void insert(Ceinture obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_LIBELLE,obj.getLibelleCeinture());
        db.insert(TABLE_CEINTURE,null,valeurs);
    }
    // insertion de la matière dans la base

    public void update(Ceinture obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_LIBELLE,obj.getLibelleCeinture());
        db.update(TABLE_CEINTURE, valeurs, COL_ID_CEINTURE+" = "+obj.getIdCeinture(),null);
    }
    // modification du nom et coefficient de la matière en fonction du numéro

    public void delete(Ceinture obj) {
        Log.v("Supp","ça marche");
        db.delete(TABLE_CEINTURE, COL_ID_CEINTURE+" = "+obj.getIdCeinture(),null);
    }
    // suppression de la matière en fonction de son numéro

    public Ceinture read(int id){
        Ceinture clRetour;
        int idCl;
        String libCeinture;
        clRetour = null;

        Cursor curseurQuery = db.query(TABLE_CEINTURE, null, COL_ID_CEINTURE+" = "+id, null, null, null, null);
        curseurQuery.moveToFirst();
        if (!curseurQuery.isAfterLast()) {
            idCl = curseurQuery.getInt(0);
            libCeinture = curseurQuery.getString(1);
        }
        curseurQuery.close();
        return (clRetour);
    }
    // Recherche le numéro de la matière dans la base et la retourne

    public ArrayList<Ceinture> read() {
        ArrayList<Ceinture> Ceintures;
        Ceintures = new ArrayList<Ceinture>();

        Cursor curseurQuery = db.query(TABLE_CEINTURE, null, null, null, null, null, null);
        curseurQuery.moveToFirst();

        while(!curseurQuery.isAfterLast()) {
            Ceintures.add(new Ceinture(curseurQuery.getInt(0),curseurQuery.getString(1)));
            curseurQuery.moveToNext();
        }
        curseurQuery.close();
        return (Ceintures);
    }
    // Retourne la liste de toutes les matières enregistrées dans la base.
}