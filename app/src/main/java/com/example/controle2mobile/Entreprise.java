package com.example.controle2mobile;

import java.io.Serializable;

public class Entreprise implements Serializable {
    private int id;
    private String RaisonSociale;
    private String Adresse;
    private double Capitale;

    public Entreprise() {
    }

    public Entreprise(int id, String raisonSociale, String adresse, double capitale) {
        this.id = id;
        RaisonSociale = raisonSociale;
        Adresse = adresse;
        Capitale = capitale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return RaisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        RaisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public double getCapitale() {
        return Capitale;
    }

    public void setCapitale(double capitale) {
        Capitale = capitale;
    }
}
