package com.example.abscence_judoka.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.abscence_judoka.Metier.Telephone;

import java.util.ArrayList;

public class TelephoneDAO {
    private SQLiteAbsence dbAbsence;

    // déclaration des outils nécessaires à la base
    private static final String TABLE_TELEPHONE = "TELEPHONE";
    private static final String COL_ID_TELEPHONE = "IDTELEPHONE";
    private static final String COL_NUMERO = "NUMEROTELEPHONE";

    private SQLiteDatabase db;

    public TelephoneDAO(Context context){ dbAbsence = new SQLiteAbsence(context); }

    public void open(){ db = dbAbsence.getWritableDatabase(); }

    public void close(){ dbAbsence.close(); }

    public void insert(Telephone obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_NUMERO,obj.getNumeroTelephone());
        db.insert(TABLE_TELEPHONE,null,valeurs);
    }
    // insertion de la matière dans la base

    public void update(Telephone obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_NUMERO,obj.getNumeroTelephone());
        db.update(TABLE_TELEPHONE, valeurs, COL_ID_TELEPHONE+" = "+obj.getIdTelephone(),null);
    }
    // modification du nom et coefficient de la matière en fonction du numéro

    public void delete(Telephone obj) {
        db.delete(TABLE_TELEPHONE, COL_ID_TELEPHONE+" = "+obj.getIdTelephone(),null);
    }
    // suppression de la matière en fonction de son numéro

    public Telephone read(int id){
        Telephone clRetour;
        int idT;
        String numTelephone;
        clRetour = null;

        Cursor curseurQuery = db.query(TABLE_TELEPHONE, null, COL_ID_TELEPHONE+" = "+id, null, null, null, null);
        curseurQuery.moveToFirst();
        if (!curseurQuery.isAfterLast()) {
            idT = curseurQuery.getInt(0);
            numTelephone = curseurQuery.getString(1);
        }
        curseurQuery.close();
        return (clRetour);
    }
    // Recherche le numéro de la matière dans la base et la retourne

    public ArrayList<Telephone> read() {
        ArrayList<Telephone> Telephones;
        Telephones = new ArrayList<Telephone>();

        Cursor curseurQuery = db.query(TABLE_TELEPHONE, null, null, null, null, null, null);
        curseurQuery.moveToFirst();

        while(!curseurQuery.isAfterLast()) {
            Telephones.add(new Telephone(curseurQuery.getInt(0),curseurQuery.getString(1)));
            curseurQuery.moveToNext();
        }
        curseurQuery.close();
        return (Telephones);
    }
    // Retourne la liste de toutes les matières enregistrées dans la base.
}
