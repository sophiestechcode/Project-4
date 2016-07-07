package com.example.ruben.project4;
/**
 * Created by elif on 4-7-2016.
 */


public class M3 {
    private int Wijknummer;
    private String Naam;
    private int Trommels;
    private int Diefstallen;

    public M3(int Wijknummer, String Naam, int Trommels, int Diefstallen) {
        this.Wijknummer = Wijknummer;
        this.Naam = Naam;
        this.Trommels = Trommels;
        this.Diefstallen = Diefstallen;
    }

    public int getWijknummer() {
        return Wijknummer;
    }

    public String getNaam() {
        return Naam;
    }

    public int getTrommels() {
        return Trommels;
    }

    public int getDiefstallen() {
        return Diefstallen;
    }

    @Override
    public String toString() {
        return "M3: " +
                "Wijknummer=" + Wijknummer +
                ", Naam='" + Naam + '\'' +
                ", Trommels=" + Trommels +
                ", Diefstallen=" + Diefstallen +
                '}';
    }
}
