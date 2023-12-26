package org.example;
import java.io.*;

public class Kap_7 {
    public static void main(String[] args) {
        //deklarace a inicializace (pøidìlení pamìti) pole (ve dvou krocích)
        int poleInt[];
        poleInt = new int[20];
        System.out.println("Poèet prvkù pole: " + poleInt.length);
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

        //2-rozmìrné pole
        int[][] a3 = new int[5][4];
        System.out.println("Poèet øádek pole: " + a3.length);
        System.out.println("Poèet sloupcù (rovnomìrného) pole: " + a3[0].length);
        for (int i3 = 0; i3 < a3.length; i3++) {
            for (int j3 = 0; j3 < a3[i3].length; j3++) {
                a3[i3][j3] = i3 * 10 + j3;
                System.out.print(a3[i3][j3] + "  ");
            }
            System.out.println();
        }

        //2-rozmìrné pole s promìnnou délkou øádek
        int[][] a4 = new int[5][];
        System.out.println("Poèet øádek pole: " + a4.length);
        //System.out.println("Poèet sloupcù pole: " + a4[0].length); //Exception in thread "main" java.lang.NullPointerException: Cannot read the array length because "a4[0]" is null at org.example.Kap_7.main(Kap_7.java:39)
        for (int i4 = 0; i4 < a4.length; i4++) {
            a4[i4] = new int[i4 + 1];
            System.out.println("Poèet sloupcù (nerovnomìrného) pole: " + a4[i4].length);
            for (int j4 = 0; j4 < a4[i4].length; j4++) {
                a4[i4][j4] = i4 * 10 + j4;
                System.out.print(a4[i4][j4] + "  ");
            }
            System.out.println();
        }

        //statický inicializátor
        int[][] b4 = {{ 1,  2,  3},
                      {11, 12, 13},
                      {21, 22, 23}};
        System.out.println("Poèet øádek pole: " + b4.length);
        System.out.println("Poèet sloupcù (rovnomìrného) pole: " + b4[0].length);

        int[][] c4 = {{ 1,  2,  3},
                      {11, 12},
                      {21}};
        System.out.println("Poèet øádek pole: " + c4.length);
        System.out.print("Poèet sloupcù (nerovnomìrného) pole: ");
        for (int i4b = 0; i4b < c4.length; i4b++) {
            System.out.print(c4[i4b].length + "  ");
        }
        System.out.println();

        //3- a vícerozmìrná pole
        int[][][] d4 = new int[5][5][5];

        int[][][] e4 = new int[5][5][];
        e4[0][0] = new int[5];

        //int[][][] f4 = new int[5][][5]; //java: ']' expected

        //více rozmìrù v 1-rozmìrném poli
        final int RADKY = 24;
        final int SLOUPCE = 80;
        byte[] obrazovka = new byte[RADKY * SLOUPCE];
        for (int i5 = 0; i5 < RADKY; i5++) {
            for (int j5 = 0; j5 < SLOUPCE; j5++) {
                obrazovka[i5 * SLOUPCE + j5] = 0;
                System.out.print((i5 * SLOUPCE + j5) + " ");
                //System.out.print(obrazovka[i5 * RADKY + j5] + " ");
            }
            System.out.println();
        }
    }
}