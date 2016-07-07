package com.example.ruben.project4;
/**
 * Created by elif on 4-7-2016.
 */


public class M1 {
    private String omschrijving;
    private String deelgemeente;

    public M1(String omschrijving, String deelgemeente) {
        this.omschrijving = omschrijving;
        this.deelgemeente = deelgemeente;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public String getDeelgemeente() {
        return deelgemeente;
    }

    @Override
    public String toString() {
        return "M1: Omschrijving='" + omschrijving + '\'' +
                ", Deelgemeente='" + deelgemeente + "'}";
    }
}
