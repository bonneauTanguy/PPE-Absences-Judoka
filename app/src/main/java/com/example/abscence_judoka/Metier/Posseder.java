package com.example.abscence_judoka.Metier;

public class Posseder {
    private int idEleve;
    private int idTelephone;

    public Posseder(int idEl, int idTel) {
        this.idEleve = idEl;
        this.idTelephone = idTel;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public int getIdTelephone() {
        return idTelephone;
    }

    public void setIdTelephone(int idTelephone) {
        this.idTelephone = idTelephone;
    }
}
