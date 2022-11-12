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
        int i4j, sum3;
        for (i4j = 1, sum3 = 0; i4j <= 10;
             sum3 += i4j, System.out.println("i4j: " + i4j + " / sum3: " + sum3), i4j++) ;
        //2.5
        for (int i4k = 1, sum4 = 0; i4k <= 10; i4k++) {
            sum4 += i4k;
            System.out.println("i4k: " + i4k + " / sum4: " + sum4);
        }
        //System.out.println("i4k: " + i4k + " / sum4: " + sum4); //java: cannot find symbol
                                                                //  symbol:   variable i4k
                                                                //  location: class org.example.Kap_5
        //Zpracování příkazu FOR:
        //1. iterace:    výraz_start -> test výraz_stop (true) -> příkaz -> výraz_iter
        //další iterace:                test výraz_stop (true) -> příkaz -> výraz_iter

        long pred, mezi, po;
        long pred_nano, mezi_nano, po_nano;
        pred = System.currentTimeMillis();
        pred_nano = System.nanoTime();
        int i5, soucin5;
        for (i5 = 1, soucin5 = 1; i5 <= 900; i5++)
            if (i5 % 2 == 1) {
                soucin5 *= i5;
                System.out.println("i5 = " + i5 + " / soucin5 = " + soucin5);
            }
        mezi = System.currentTimeMillis();
        mezi_nano = System.nanoTime();
        int i6, soucin6;
        for (i6 = 1, soucin6 = 1; i6 <= 900; i6 += 2) {
            soucin6 *= i6;
            System.out.println("i6 = " + i6 + " / soucin6 = " + soucin6);
        }
        po = System.currentTimeMillis();
        po_nano = System.nanoTime();
        System.out.println("mezi - pred: " + (mezi - pred));
        System.out.println("po - pred: " + (po - mezi));
        System.out.println("mezi - pred (nano): " + (mezi_nano - pred_nano));
        System.out.println("po - pred (nano): " + (po_nano - mezi_nano));

        //BREAK s návěštím dokáže ukončit i blok (nejen cyklus)
        System.out.print("Začátek ");
        odskok:
        {
            for (int i7 = 1; i7 < 10; i7++) {
                if (i7 == 5)
                    break odskok; //=> Za?�tek 1 2 3 4 Konec
                    //break;      //=> Za?�tek 1 2 3 4 St?ed Konec
                System.out.print(i7 + " ");
            }
            System.out.print("Střed ");
        }
        System.out.println("Konec");

        navesti:
        for (int n8 = 0; n8 < 4; n8++) {
            for (int m8 = 0; m8 < 2; m8++) {
                if (n8 == 2 && m8 == 1)
                    continue navesti; //0-0 0-1 1-0 1-1 2-0 3-0 3-1
                    //break navesti;  //0-0 0-1 1-0 1-1 2-0
                    //continue;         //0-0 0-1 1-0 1-1 2-0 3-0 3-1
                System.out.print(n8 + "-" + m8 + " ");
            }
        }
        System.out.println();

        /*chyba:
        {
            for (int i9 = 0; i9 < 10; i9++) {
                for (int j9 = 0; j9 < 10; j9++) {
                    for (int k9 = 0; k9 < 10; k9++) {
                        if (x[k9] == 0)
                            break chyba;
                        a[i9] = a[i9] + b[j9] / x[k9];
                    }
                }
            }
        }*/

        //Příkaz SWITCH
        /*switch (Kap_4_VstupZnaku.ctiZnak()) {
            case 'a':
            case 'b':
            case 'c':
                System.out.print("1");
                //break;
            case 'd':
                System.out.print("2");
                //break;
            default:
                System.out.print("3");
                //break;
        }*/

        //Příkaz SWITCH - umístění DEFAULT kdekoliv
        /*switch (Kap_4_VstupZnaku.ctiZnak()) {
            default:
                System.out.println("Nestiskl jsi ani '1' ani '2'.");
                break;
            case '0':
            case '1':
                System.out.println("Stiskl jsi '1'.");
                break;
            case '2':
                System.out.println("Stiskl jsi '2'.");
                break;
        }*/

        //odstrašující přklad
        char c10 = 'a';
        /*while (c10 != '*') {
            switch (c10 = Kap_4_VstupZnaku.ctiZnak()) {
                case ' ':
                case '\t':
                    System.out.print('#');
                    continue; //=> odskok na konec smyčky WHILE; žádná relevance pro SWITCH
                case '*':
                    break;
                default:
                    System.out.print(c10);
                    break;
            }
        }*/
        //lepší řešení
        /*while ((c10 = Kap_4_VstupZnaku.ctiZnak()) != '*') {
            switch (c10) {
                case ' ':
                case '\t':
                    System.out.print('#');
                    break;
                default:
                    System.out.print(c10);
                    break;
            }
        }*/
        //kratší ale méně přehledné
        while ((c10 = Kap_4_VstupZnaku.ctiZnak()) != '*') {
            switch (c10) {
                case ' ':
                case '\t':
                    c10 = '#';
                default:
                    System.out.print(c10);
                    break;
            }
        }
    }
}
