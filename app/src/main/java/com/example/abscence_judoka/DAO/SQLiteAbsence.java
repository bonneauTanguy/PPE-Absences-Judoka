package com.example.abscence_judoka.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;

import com.example.abscence_judoka.Metier.Eleve;
import com.example.abscence_judoka.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SQLiteAbsence extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "GestionAbsences";
    private Context context=null;

    public SQLiteAbsence(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open("absences")));
            String line;
            while((line = reader.readLine()) != null){
                String[] lines = line.split(";");
                db.execSQL(lines[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   /* public SimpleCursorAdapter ListViewBDD(){
        EleveDAO eleve = new EleveDAO(context);
        List<Eleve> listeEleve= eleve.read();
        SimpleCursorAdapter listeEleveAdapter = new SimpleCursorAdapter(
                context,
                R.layout.single_item,
                listeEleve,
        );
        return  listeEleveAdapter;
    }*/


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onCreate(db);
    }
}
