package org.example;
import java.util.*;

public class Kap_10_Bankomat {
    private int penize;

    private boolean overPIN(int pin) {
        return (pin == 1234 ? true : false);
    }

    void setPenize(int kolik) {
        Date d = new Date();
        if (kolik > 0) {
            this.penize += kolik;
            System.out.println(d.toString() + " vlo¾eno: " + kolik);
        } else {
            System.out.println(d.toString() + " podezøelý vklad: " + kolik);
        }
    }

    int getPenize(int kolik) {
        Date d = new Date();
        System.out.print("Zadejte PIN: ");
        int pin = Kap_4_VstupInt.ctiInt();
        if (overPIN(pin)) {
            if (this.penize >= kolik) {
                this.penize -= kolik;
                System.out.println(d.toString() + " vybráno: " + kolik);
                return kolik;
            } else {
                System.out.println("Nedostatek hotovosti!");
            }
        } else {
            System.out.println(d.toString() + " PIN nesouhlasí");
        }
        return 0;
    }
}
