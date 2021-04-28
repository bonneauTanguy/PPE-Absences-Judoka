package com.example.abscence_judoka.Metier;

import java.util.Date;

public class Eleve {
    private int idEleve;
    private String nomEleve;
    private String prenomEleve;
    private Date dateNaissanceEleve;
    private int idCategorieEleve;
    private int idCeintureEleve;

    public Eleve(int idEl, String nomEl, String prenEl, Date dateNaisEl, int idCat, int idCeint) {
        this.idEleve = idEl;
        this.nomEleve = nomEl;
        this.prenomEleve = prenEl;
        this.dateNaissanceEleve = dateNaisEl;
        this.idCategorieEleve = idCat;
        this.idCeintureEleve = idCeint;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public Date getDateNaissanceEleve() {
        return dateNaissanceEleve;
    }

    public void setDateNaissanceEleve(Date dateNaissanceEleve) {
        this.dateNaissanceEleve = dateNaissanceEleve;
    }

    public int getIdCategorieEleve() {
        return idCategorieEleve;
    }

    public void setIdCategorieEleve(int idCategorieEleve) {
        this.idCategorieEleve = idCategorieEleve;
    }

    public int getIdCeintureEleve() {
        return idCeintureEleve;
    }

    public void setIdCeintureEleve(int idCeintureEleve) {
        this.idCeintureEleve = idCeintureEleve;
    }
}
