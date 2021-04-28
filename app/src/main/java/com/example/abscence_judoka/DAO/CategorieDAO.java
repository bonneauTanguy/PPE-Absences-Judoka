package com.example.abscence_judoka.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.abscence_judoka.Metier.Categorie;

import java.util.ArrayList;

public class CategorieDAO extends DAO<Categorie> {
    private SQLiteAbsence dbAbsence;

    // déclaration des outils nécessaires à la base
    private static final String TABLE_CATEGORIE = "CATEGORIE";
    private static final String COL_ID_CATEGORIE = "IDCATEGORIE";
    private static final String COL_LIBELLE = "LIBELLECATEGORIE";

    private SQLiteDatabase db;

    public CategorieDAO(Context context){ dbAbsence = new SQLiteAbsence(context); }

    public void open(){ db = dbAbsence.getWritableDatabase(); }

    public void close(){ dbAbsence.close(); }

    public void insert(Categorie obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_LIBELLE,obj.getLibelleCategorie());
        db.insert(TABLE_CATEGORIE,null,valeurs);
    }
    // insertion de la matière dans la base

    public void update(Categorie obj) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(COL_LIBELLE,obj.getLibelleCategorie());
        db.update(TABLE_CATEGORIE, valeurs, COL_ID_CATEGORIE+" = "+obj.getIdCategorie(),null);
    }
    // modification du nom et coefficient de la matière en fonction du numéro

    public void delete(Categorie obj) {
        Log.v("Supp","ça marche");
        db.delete(TABLE_CATEGORIE, COL_ID_CATEGORIE+" = "+obj.getIdCategorie(),null);
    }
    // suppression de la matière en fonction de son numéro

    public Categorie read(int id){
        Categorie clRetour;
        int idCl;
        String libCategorie;
        clRetour = null;

        Cursor curseurQuery = db.query(TABLE_CATEGORIE, null, COL_ID_CATEGORIE+" = "+id, null, null, null, null);
        curseurQuery.moveToFirst();
        if (!curseurQuery.isAfterLast()) {
            idCl = curseurQuery.getInt(0);
            libCategorie = curseurQuery.getString(1);
        }
        curseurQuery.close();
        return (clRetour);
    }
    // Recherche le numéro de la matière dans la base et la retourne

    public ArrayList<Categorie> read() {
        ArrayList<Categorie> Categories;
        Categories = new ArrayList<Categorie>();

        Cursor curseurQuery = db.query(TABLE_CATEGORIE, null, null, null, null, null, null);
        curseurQuery.moveToFirst();

        while(!curseurQuery.isAfterLast()) {
            Categories.add(new Categorie(curseurQuery.getInt(0),curseurQuery.getString(1)));
            curseurQuery.moveToNext();
        }
        curseurQuery.close();
        return (Categories);
    }
    // Retourne la liste de toutes les matières enregistrées dans la base.

}