package org.example;

class PraceSPolemPoli {
    public static void TiskniPole(int[][] p) {
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].length; j++) {
                System.out.print(p[i][j] + ", ");
            }
            System.out.print("\b\b \n");
        }
    }

    public static void nastavATiskniRadku(int[] r, int h) {
        for (int i = 0; i < r.length; i++) {
            r[i] = h + i;
            System.out.print(r[i] + ", ");
        }
        System.out.print("\b\b \n");
    }
}

public class Kap_10_PolePoliOdkazem {
    public static void main(String[] args) {
        int[][] pole1 = {{4, 3, 2, 1}, {1, 2, 3, 4}};
        int[][] pole2 = {{1}, {2, 3}, {4, 5, 6}};
        PraceSPolemPoli.TiskniPole(pole1);
        System.out.println();
        PraceSPolemPoli.TiskniPole(pole2);
        System.out.println();
        PraceSPolemPoli.nastavATiskniRadku(pole1[0], 5);
    }
}
