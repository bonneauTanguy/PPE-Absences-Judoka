package com.example.abscence_judoka.Metier;

public class Participer {
    private int idEleve;
    private int idCours;
    private boolean coursParticiper;

    public Participer(int idEl, int idCo, boolean particip) {
        this.idEleve = idEl;
        this.idCours = idCo;
        this.coursParticiper = particip;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public boolean isCoursParticiper() {
        return coursParticiper;
    }

    public void setCoursParticiper(boolean coursParticiper) {
        this.coursParticiper = coursParticiper;
    }
}
