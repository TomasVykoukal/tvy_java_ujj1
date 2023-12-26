package org.example;

public class Kap_8_Prvocisla { /*ToDo: pochopit zvnitønit ...*/
    public static final int MAX = 10;
    public static final int cisla[] = new int[MAX];

    static { //statický inicializaèní blok - zaèátek
        int pocet = 2;
        cisla[0] = 1;
        cisla[1] = 2;

    dalsi:
        for (int i = 3; pocet < MAX; i += 2) { //3, 5, 7, 9, ..., 99 (MAX-1)
            System.out.println("i, pocet: " + i + " / " + pocet); //unit test (souèást viz ní¾e)
            for (int j = 2; j < pocet; j++) { //3: 2..2, 5: 2..4, 7: 2..6, 9: 2..8, ..., 99: 2..98
                /*if (i % cisla[j] == 0) {
                    continue dalsi;
                }*/
                if (i % cisla[j] == 0) { //varianta unit test
                    System.out.println("i, pocet, j, cisla[j]: " + i + " / " + pocet + " / " + j + " / " + cisla[j] + " => i NENÍ prvoèíslo");
                    continue dalsi;
                } else
                    System.out.println("i, pocet, j, cisla[j]: " + i + " / " + pocet + " / " + j + " / " + cisla[j] + " => i JE prvoèíslo");
            }
            cisla[pocet] = i;
            System.out.println("i, pocet, cisla[pocet]: " + i + " / " + pocet + " / " + cisla[pocet]); //unit test (souèást viz vý¹e)
            System.out.println("--------------------------------------------------------"); //unit test (souèást viz vý¹e)
            pocet++;
        }
    } //statický inicializaèní blok - konec

    public static void main(String[] args) {
        System.out.println("Prvních " + MAX + " prvoèísel:");
        for (int i = 0; i < cisla.length; i++) {
            System.out.print(cisla[i] + " ");
        }
    }
}
