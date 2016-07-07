package com.example.ruben.project4;



import java.io.Serializable;


public class M4 implements Serializable {
    private String MK_omschrijving;
    private String Merk;
    private String Kleur;

    public M4(String MK_omschrijving, String Merk, String Kleur) {
        this.MK_omschrijving = MK_omschrijving;
        this.Merk = Merk;
        this.Kleur = Kleur;
    }

    public String getMK_omschrijving() {
        return MK_omschrijving;
    }

    public String getMerk() {
        return Merk;
    }

    public String getKleur() {
        return Kleur;
    }

    @Override
    public String toString() {
        return "M4: " +
                "MK_omschrijving='" + MK_omschrijving + '\'' +
                ", Merk='" + Merk + '\'' +
                ", Kleur='" + Kleur + '\'' +
                '}';
    }
}
