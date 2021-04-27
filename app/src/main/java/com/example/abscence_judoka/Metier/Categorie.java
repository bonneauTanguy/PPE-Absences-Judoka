package com.example.abscence_judoka.Metier;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    private int idCategorie;
    private String libelleCategorie;
    private List<Eleve> eleves;

    public Categorie(int idCateg, String libelCateg) {
        this.idCategorie = idCateg;
        this.libelleCategorie = libelCateg;
        this.eleves = new ArrayList<Eleve>();
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
}
