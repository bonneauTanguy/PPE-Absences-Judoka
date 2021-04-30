package com.example.abscence_judoka.Metier;

public class Telephone {
    private int idTelephone;
    private String numeroTelephone;

    /* Pas encore prévu */
    // private String TypeTelephone;

    public Telephone(int idTel, String numeroTel) {
        this.idTelephone = idTel;
        this.numeroTelephone = numeroTel;
    }

    public int getIdTelephone() {
        return idTelephone;
    }

    public void setIdTelephone(int idTelephone) {
        this.idTelephone = idTelephone;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
}
