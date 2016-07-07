package com.example.ruben.project4;

/**
 * Created by elif on 06/07/16.
 */
public enum RotterdamDistricts {
    CENTRUM("Centrum", "DISTRICT 4"),
    CHARLOIS("Charlois", "DISTRICT 10"),
    DELFSHAVEN("Delfshaven", "DISTRICT 3"),
    FEIJENOORD("Feijenoord", "DISTRICT 9"),
    KRALINGEN("Kralingen", "DISTRICT 6"),
    NOORD("Noord", "DISTRICT 5"),
    // not certain about this
    OVERSCHIE("Overschie", "DISTRICT 1")

    // WEST("West", "DISTRICT 1") // only 1 row exists, ignoring...
    // OMMOORD("Omoord", ) // only 1 row exists, ignoring...
    // PERNIS("Pernis", ) // only 2 rows exist, ignoring...
    // HILLEGERSBERG("Hillegersberg", "DISTRICT 5") // shares streets with noord
    ;

    final String trommelText;
    final String diefstalText;

    RotterdamDistricts(String trommelText, String diefstalText) {
        this.trommelText = trommelText;
        this.diefstalText = diefstalText;
    }
}
