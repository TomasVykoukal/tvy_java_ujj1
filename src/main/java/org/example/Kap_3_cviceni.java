package org.example;

public class Kap_3_cviceni {

    public static void main(String[] args) {
        //cvičení 1+2 viz Druha
        //cvičení 3
        double delenec = 0.5;
        double delitel = 0.0;
        double vysledek = delenec / delitel;

        if (Double.isInfinite(vysledek) == true) {
            System.out.println("Dělitel je příliš malé číslo.");
        } else if (Double.isNaN(vysledek)) {
            System.out.println("Výsledek není číslo.");
        } else {
            System.out.println(vysledek);
        }

        //cvičení 4
        System.out.println("písknutí");
        //System.out.println('\a'); //illegal escape character
        System.out.println('\u0007');

        //cvičení 5
        double d = Math.PI;
        //?

        //cvičení 6+7
        byte i = 1, j = 2, k = 3;
        //if (i == 2 && ++j == 3)
        if (i == 2 & ++j == 3)
            k = 4;
        System.out.println("i = " + i + ", j = " + j + ", k = " + k);

        i = 1; j = 2; k = 3;
        //if (i == 1 || ++j == 2)
        if (i == 1 | ++j == 2)
            k = 4;
        System.out.println("i = " + i + ", j = " + j + ", k = " + k);
    }

}
