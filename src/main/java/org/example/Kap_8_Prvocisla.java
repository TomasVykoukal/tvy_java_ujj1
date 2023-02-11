package org.example;

public class Kap_8_Prvocisla {
    public static final int MAX = 10;
    public static final int cisla[] = new int[MAX];

    static { //statický inicializační blok - zač.
        int pocet = 2;
        cisla[0] = 1;
        cisla[1] = 2;

    dalsi:
        for (int i = 3; pocet < MAX; i += 2) {
            for (int j = 2; j < pocet; j++) {
                if (i % cisla[j] == 0) {
                    continue dalsi;
                }
            }
            cisla[pocet] = i;
            pocet++;
        }
    } //statický inicializační blok - konec

    public static void main(String[] args) {
        /*System.out.println("Prvních " + MAX + " prvočísel:");
        for (int i = 0; i < cisla.length; i++) {
            System.out.print(cisla[i] + " ");
        }*/

        /*ToDo: nechápu ...*/
            int pocet = 2;
            cisla[0] = 1;
            cisla[1] = 2;

            dalsi:
            for (int i = 3; pocet < MAX; i += 2) {
                System.out.print(" vne " + i);
                for (int j = 2; j < pocet; j++) {
                    System.out.print(" vni1 " + j);
                    if (i % cisla[j] == 0) {
                        System.out.println(" vni2 " + j);
                        continue dalsi;
                    }
                }
                System.out.print(" prvo " + i);
                cisla[pocet] = i;
                pocet++;
                System.out.println(" poc " + i);
            }

    }
}
