package org.example;
import java.io.*;

public class Kap_7 {
    public static void main(String[] args) {
        //deklarace a inicializace (přidělení paměti) pole (ve dvou krocích)
        int poleInt[];
        poleInt = new int[20];
        System.out.println("Počet prvků pole: " + poleInt.length);
        for (int i1 = 0; i1 <= (poleInt.length - 2); i1++)
            System.out.print(poleInt[i1] + ", ");
        System.out.print(poleInt[poleInt.length - 1]);
        System.out.println();

        //inicializované pole (statický inicializátor)
        int[] prvocisla = {1, 2, 3, 5, 7, 11};
        for (int i2 = 0; i2 < prvocisla.length; i2++) {
            System.out.print(prvocisla[i2] + " -> ");
            prvocisla[i2] = i2 + 1;
            System.out.print(prvocisla[i2] + "  ");
        }
        System.out.println();

        //2-rozměrné pole
        int[][] a3 = new int[5][4];
        System.out.println("Počet řádek pole: " + a3.length);
        System.out.println("Počet sloupců (rovnoměrného) pole: " + a3[0].length);
        for (int i3 = 0; i3 < a3.length; i3++) {
            for (int j3 = 0; j3 < a3[i3].length; j3++) {
                a3[i3][j3] = i3 * 10 + j3;
                System.out.print(a3[i3][j3] + "  ");
            }
            System.out.println();
        }

        //2-rozměrné pole s proměnnou délkou řádek
        int[][] a3 = new int[4][]


    }
}