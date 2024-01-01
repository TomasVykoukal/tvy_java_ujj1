package org.example;

class PraceSPolem {
    public void NastavPole(final int[] p, final int h) {
        for (int i = 0; i < p.length; i++) {
            p[i] = h + i;
            //h++; //Cannot assign a value to final variable 'h'
            //p = null; //Cannot assign a value to final variable 'p'
        }
    }

    public static void TiskniPole(int[] p) {
        for (int i = 0; i < p.length; i++) {
            System.out.print("[" + i + "] = " + p[i] + ", ");
        }
        System.out.print("\b\b \n");
    }

    public void NastavPrvek(int prvek, int h) {
        prvek = h;
    }
}

public class Kap_10_PoleOdkazem {
    public static void main(String[] args) {
        PraceSPolem obj = new PraceSPolem();
        int[] pole = {5, 4, 3, 2, 1};
        PraceSPolem.TiskniPole(pole);
        obj.NastavPole(pole, 3); //předání hodnotou ale pro obsah pole de facto odkazem => má efekt na obsah pole
        PraceSPolem.TiskniPole(pole);
        obj.NastavPrvek(pole[0], 5); //předání hodnotou => bez efektu na obsah pole
        PraceSPolem.TiskniPole(pole);
    }
}
