package com.example.ruben.project4.data;

import java.util.Date;

/**
 * Created by elif on 05/07/16.
 */
public class FietsDiefstal {
    // 0 Voorval nummer
    // 1 Kennisname
    // 2 MK
    // 3 MK omschrijving
    // 4 Poging
    // 5 District
    //6 Werkgebied
    //7 Plaats
    //8 Buurt
    //9 Straat
    //10 Begin dagsoort
    //11 Begindatum
    //12 Begintijd
    //13 Eind dagsoort
    //14 Einddatum
    //15 Eindtijd
    //16 Gemiddelde jaar
    //17 Gemiddelde maand
    //18 Gemiddelde dagsoort
    //19 Gemiddelde dagdeel (6 uren)
    //20 Trefwoord
    //21 object
    //22 merk
    //23 type
    //24 kleur

    String description; // 2
    String city;        // 7
    String district;    // 5
    Date noticeDate;    // 1
    String brand;       // 22
    String color;       // 24

    public FietsDiefstal(String description, String city, String district, Date noticeDate, String brand, String color) {
        this.description = description;
        this.city = city;
        this.district = district;
        this.noticeDate = noticeDate;
        this.brand = brand;
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
}
