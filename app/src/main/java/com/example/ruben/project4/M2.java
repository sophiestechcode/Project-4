package com.example.ruben.project4;

import java.io.Serializable;
/**
 * Created by elif on 4-7-2016.
 */


public class M2 implements Serializable {
    private String MK_omschrijving;
    private int Gemiddelde_maand;

    public M2(String MK_omschrijving, int Gemiddelde_maand) {
        this.MK_omschrijving = MK_omschrijving;
        this.Gemiddelde_maand = Gemiddelde_maand;
    }

    public String getMK_omschrijving() {
        return MK_omschrijving;
    }

    public int getGemiddelde_maand() {
        return Gemiddelde_maand;
    }

    @Override
    public String toString() {
        return "M2: Omschrijving='" + MK_omschrijving + "'" +
                ", Gemiddelde_maand=" + Gemiddelde_maand + '}';
    }
}
