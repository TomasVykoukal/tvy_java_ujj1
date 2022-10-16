package org.example;

public class Kap_5 {
    public static void main(String[] args) {

        int i1, k1, j1 = 2;
        i1 = (j1 == 2) ? 1 : 3;
        System.out.println("i1 = " + i1);
        k1 = (i1 > j1) ? i1 : j1;
        System.out.println("k1 = " + k1);
        //(i1 == 1) ? i1++ : j1++; //java: not a statement
        System.out.println("i1 = " + i1);

        System.out.println("----------příkaz if-else----------");
        for (int i = 1; i <= 100; i++) {
            System.out.print(i);
            if (i % 10 == 0)
                System.out.print("\n");
            else
                System.out.print(" ");
        }
        System.out.println("----------ternární operátor----------");
        for (int i = 1; i <= 100; i++) {
            System.out.print(i);
            System.out.print((i % 10 == 0) ? "\n" : " ");
        }

        int x1 = 0;
        while (x1 < 10) x1++;
        System.out.println("x1 = " + x1);

        char c1;
        System.out.print("Začni zadávat znaky (\'z\' = konec): ");
        //Varianta WHILE - základní (oproti knížce vylepšeno o filtrování nového řádku)
        /*while ((c1 = Kap_4_VstupZnaku.ctiZnak()) != 'z') {
            if (c1 != '\n') {
                if (c1 >= 'a')
                    System.out.println(c1);
                System.out.print("Zadej další znak: ");
            }
        }*/
        //Varianta WHILE - s nekonečným cyklem (lehce odchynlná oproti knížce)
        /*while (true) {
            c1 = Kap_4_VstupZnaku.ctiZnak();
            if (c1 == 'z') break;
            if (c1 == '\n') continue;
            if (c1 >= 'a') System.out.println(c1);
            System.out.print("Zadej další znak: ");
        }*/
        //Varianta DO-WHILE
        while (true) {
            c1 = Kap_4_VstupZnaku.ctiZnak();
            if (c1 == 'z') break;
            if (c1 == '\n') continue;
            if (c1 >= 'a') System.out.println(c1);
            System.out.print("Zadej další znak: ");
        }
        System.out.println("\nČtení znaku bylo ukončeno.");

        int i2 = 10;
        do {
            System.out.println("i2 = " + i2);
            i2--;
        } while (i2 > 0);

    }
}
