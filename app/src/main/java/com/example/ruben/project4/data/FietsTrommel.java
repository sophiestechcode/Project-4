package com.example.ruben.project4.data;

import java.util.Date;

/**
 * Created by elif on 05/07/16.
 */
public class FietsTrommel {
    // Inventarisnr;Omschrijving;Straat;Thv;XCoord;YCoord;Deelgem;Mutdatum;Dooruser
    String description;
    String street;
    String addition;
    double xcoord;
    double ycoord;
    String district;
    Date installationDate;

    public FietsTrommel(String description, String street, String addition, double xcoord, double ycoord, String district, Date installationDate) {
        this.description = description;
        this.street = street;
        this.addition = addition;
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.district = district;
        this.installationDate = installationDate;
    }

    public String getDescription() {
        return description;
    }

    public String getStreet() {
        return street;
    }

    public String getAddition() {
        return addition;
    }

    public double getXcoord() {
        return xcoord;
    }

    public double getYcoord() {
        return ycoord;
    }

    public String getDistrict() {
        return district;
    }

    public Date getInstallationDate() {
        return installationDate;
    }
}
