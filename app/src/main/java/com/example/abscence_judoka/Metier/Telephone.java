package com.example.abscence_judoka.Metier;

public class Telephone {
    private int idTelephone;
    private int numeroTelephone;

    /* Pas encore prévu */
    // private String TypeTelephone;

    public Telephone(int idTel, int numeroTel) {
        this.idTelephone = idTel;
        this.numeroTelephone = numeroTel;
    }

    public int getIdTelephone() {
        return idTelephone;
    }

    public void setIdTelephone(int idTelephone) {
        this.idTelephone = idTelephone;
    }

    public int getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(int numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
}
