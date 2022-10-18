package org.example;

public class Kap_5 {
    public static void main(String[] args) {

        //podmíněný výraz - ternární operátor
        int i1, k1, j1 = 2;
        i1 = (j1 == 2) ? 1 : 3;
        System.out.println("i1 = " + i1);
        k1 = (i1 > j1) ? i1 : j1;
        System.out.println("k1 = " + k1);
        //(i1 == 1) ? i1++ : j1++; //java: not a statement
        System.out.println("i1 = " + i1);

        //ternární operátor vs. IF-ELSE při řízení výpisu obsahu
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

        //ITERAČNÍ PŘÍKAZY - CYKLY
        //příkaz WHILE
        int x1 = 0;
        while (x1 < 10) x1++;
        System.out.println("x1 = " + x1);

        //komplexní příklad s variantami WHILE, WHILE (nekonečný cyklus s BREAK a CONTINUE) a DO-WHILE
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
        //Varianta WHILE - s nekonečným cyklem (lehce odchylná oproti knížce)
        /*while (true) {
            c1 = Kap_4_VstupZnaku.ctiZnak();
            if (c1 == 'z') break;
            if (c1 == '\n') continue;
            if (c1 >= 'a') System.out.println(c1);
            System.out.print("Zadej další znak: ");
        }*/
        //Varianta DO-WHILE
        /*do {
            c1 = Kap_4_VstupZnaku.ctiZnak();
            if (c1 == '\n') continue;
            if (c1 >= 'a') System.out.println(c1);
            if (c1 != 'z') System.out.print("Zadej další znak: ");
        } while (c1 != 'z');*/
        System.out.println("\nČtení znaku bylo ukončeno.");

        //příkaz DO-WHILE
        int i2 = 10;
        do {
            System.out.println("i2 = " + i2);
            i2--;
        } while (i2 > 0);

        //příkaz FOR
        for (int i3 = 1; i3 <= 10; i3++)
            System.out.println("i: " + i3);
        //přeformulace FOR pomocí WHILE
        int i3b = 1;
        while (i3b <= 10) {
            System.out.println("i3b: " + i3b);
            i3b++;
        }

        //technicky možné varianty FOR
        //1.1
        for (int i4a = 0; i4a < 10; i4a++)
            System.out.println("i4a: " + i4a);
        //1.2
        int i4b = 0;
        for (; i4b < 10; i4b++)
            System.out.println("i4b: " + i4b);
        //1.3
        int i4c = 0;
        for (; i4c < 10;)
            System.out.println("i4c: " + i4c++);
        //1.4
        int i4d = 0;
        for (; i4d < 10; System.out.println("i4d: " + (i4d - 1)))
            i4d++;
        //1.5
        int i4e = 0;
        for (; i4e < 10; System.out.println("i4e: " + i4e++));
        //1.6
        int i4f = 0;
        for ( ; ; ) {
            if (i4f >= 10) break;
            System.out.println("i4f: " + i4f++);
        };
        //2.1
        for (int i4g = 0; i4g < 10; System.out.println("i4g: " + i4g), i4g++);
        //2.2
        int i4h, sum;
        for (i4h = 1, sum = 0; i4h <= 10; i4h++) {
            sum += i4h;
            System.out.println("i4h: " + i4h + " / sum: " + sum);
        }
        //2.3
        //int sum2; //java: variable sum is already defined in method main(java.lang.String[])
        for (int i4i = 1, sum2 = 0; i4i <= 10; i4i++) {
            sum2 += i4i;
            System.out.println("i4i: " + i4i + " / sum2: " + sum2);
        }
        //2.4
        for (int i4j = 1, sum3 = 0; i4j <= 10;
             sum3 += i4j, System.out.println("i4j: " + i4j + " / sum3: " + sum3), i4j++) ;
        //2.5
        

        //1.:    výraz_start -> test výraz_stop (true) -> příkaz -> výraz_iter
        //další:                test výraz_stop (true) -> příkaz -> výraz_iter
    }
}
