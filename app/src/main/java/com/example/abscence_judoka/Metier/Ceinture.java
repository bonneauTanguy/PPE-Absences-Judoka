package com.example.abscence_judoka.Metier;

import java.util.ArrayList;
import java.util.List;

public class Ceinture {
    private int idCeinture;
    private String libelleCeinture;
    private List<Eleve> eleves;

    public Ceinture(int idCeint, String libelCeint) {
        this.idCeinture = idCeint;
        this.libelleCeinture = libelCeint;
        this.eleves = new ArrayList<Eleve>();
    }

    public int getIdCeinture() {
        return idCeinture;
    }

    public void setIdCeinture(int idCeinture) {
        this.idCeinture = idCeinture;
    }

    public String getLibelleCeinture() {
        return libelleCeinture;
    }

    public void setLibelleCeinture(String libelleCeinture) {
        this.libelleCeinture = libelleCeinture;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
}
