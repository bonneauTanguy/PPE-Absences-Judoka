package com.example.abscence_judoka.Metier;

import java.util.Date;

public class Cours {
    private int idCours;
    private Date dateCours;
    private int heureDebutCours;
    private int heureFinCours;

    public Cours(int idC, Date dateC, int heureDebutC, int heureFinC) {
        this.idCours = idC;
        this.dateCours = dateC;
        this.heureDebutCours = heureDebutC;
        this.heureFinCours = heureFinC;
    }

    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public Date getDateCours() {
        return dateCours;
    }

    public void setDateCours(Date dateCours) {
        this.dateCours = dateCours;
    }

    public int getHeureDebutCours() {
        return heureDebutCours;
    }

    public void setHeureDebutCours(int heureDebutCours) {
        this.heureDebutCours = heureDebutCours;
    }

    public int getHeureFinCours() {
        return heureFinCours;
    }

    public void setHeureFinCours(int heureFinCours) {
        this.heureFinCours = heureFinCours;
    }
}
