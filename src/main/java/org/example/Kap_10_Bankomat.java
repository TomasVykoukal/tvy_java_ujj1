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
            System.out.println(d.toString() + " vlo�eno: " + kolik);
        } else {
            System.out.println(d.toString() + " podez�el� vklad: " + kolik);
        }
    }

    int getPenize(int kolik) {
        Date d = new Date();
        System.out.print("Zadejte PIN: ");
        int pin = Kap_4_VstupInt.ctiInt();
        if (overPIN(pin)) {
            if (this.penize >= kolik) {
                this.penize -= kolik;
                System.out.println(d.toString() + " vybr�no: " + kolik);
                return kolik;
            } else {
                System.out.println("Nedostatek hotovosti!");
            }
        } else {
            System.out.println(d.toString() + " PIN nesouhlas�");
        }
        return 0;
    }
}
