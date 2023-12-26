package org.example;

public class Kap_5 {
    public static void main(String[] args) {

        //podmínìný výraz - ternární operátor
        int i1, k1, j1 = 2;
        i1 = (j1 == 2) ? 1 : 3;
        System.out.println("i1 = " + i1);
        k1 = (i1 > j1) ? i1 : j1;
        System.out.println("k1 = " + k1);
        //(i1 == 1) ? i1++ : j1++; //java: not a statement
        System.out.println("i1 = " + i1);

        //ternární operátor vs. IF-ELSE pøi øízení výpisu obsahu
        System.out.println("----------pøíkaz if-else----------");
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

        //ITERAÈNÍ PØÍKAZY - CYKLY
        //pøíkaz WHILE
        int x1 = 0;
        while (x1 < 10) x1++;
        System.out.println("x1 = " + x1);

        //*** komplexní pøíklad *** s variantami WHILE, WHILE (nekoneèný cyklus s BREAK a CONTINUE) a DO-WHILE
        char c1;
        System.out.print("Zaèni zadávat znaky (\'z\' = konec): ");

        //Varianta WHILE - základní (oproti kní¾ce vylep¹eno o filtrování nového øádku)
        /*while ((c1 = Kap_4_VstupZnaku.ctiZnak()) != 'z') {
            if (c1 != '\n') {
                if (c1 >= 'a')
                    System.out.println(c1);
                System.out.print("Zadej dal¹í znak: ");
            }
        }*/
        //Varianta WHILE - s nekoneèným cyklem (lehce odchylná oproti kní¾ce)
        /*while (true) {
            c1 = Kap_4_VstupZnaku.ctiZnak();
            if (c1 == 'z') break;
            if (c1 == '\n') continue;
            if (c1 >= 'a') System.out.println(c1);
            System.out.print("Zadej dal¹í znak: ");
        }*/
        //Varianta DO-WHILE
        /*do {
            c1 = Kap_4_VstupZnaku.ctiZnak();
            if (c1 == '\n') continue;
            if (c1 >= 'a') System.out.println(c1);
            if (c1 != 'z') System.out.print("Zadej dal¹í znak: ");
        } while (c1 != 'z');*/

        System.out.println("\nÈtení znakù bylo ukonèeno.");
        //*** komplexní pøíklad *** konec

        //pøíkaz DO-WHILE
        int i2 = 10;
        do {
            System.out.println("i2 = " + i2);
            i2--;
        } while (i2 > 0);

        //pøíkaz FOR
        for (int i3 = 1; i3 <= 10; i3++)
            System.out.println("i: " + i3);
        //pøeformulace FOR pomocí WHILE
        int i3b = 1;
        while (i3b <= 10) {
            System.out.println("i3b: " + i3b);
            i3b++;
        }

        //technicky mo¾né varianty FOR
        System.out.println("*** komplexní pøíklad: technicky mo¾né varianty FOR ***");
        //1.1
        System.out.print("i4a:");
        for (int i4a = 0; i4a < 10; i4a++)
            System.out.print(" " + i4a);
        System.out.println();
        //1.2
        int i4b = 0;
        System.out.print("i4b:");
        for (; i4b < 10; i4b++)
            System.out.print(" " + i4b);
        System.out.println();
        //1.3
        int i4c = 0;
        System.out.print("i4c:");
        for (; i4c < 10;)
            System.out.print(" " + i4c++);
        System.out.println();
        //1.4
        int i4d = 0;
        System.out.print("i4d:");
        for (; i4d < 10; System.out.print(" " + (i4d - 1))) //VÝRAZ_ITER se provádí a¾ po pøíkazu (zde "i4d++;"), proto "- 1"
            i4d++;
        System.out.println();
        //1.5
        int i4e = 0;
        System.out.print("i4e:");
        for (; i4e < 10; System.out.print(" " + i4e++));
        System.out.println();
        //1.6
        int i4f = 0;
        System.out.print("i4f:");
        for ( ; ; ) {
            if (i4f >= 10) break;
            System.out.print(" " + i4f++);
        };
        System.out.println();

        //2.1
        System.out.print("i4g:");
        for (int i4g = 0; i4g < 10; System.out.print(" " + i4g), i4g++);
        System.out.println();
        //2.2
        int i4h, sum;
        System.out.print("i4h/sum: ");
        for (i4h = 1, sum = 0; i4h <= 10; i4h++) {
            sum += i4h;
            System.out.print(" " + i4h + "/" + sum);
        }
        System.out.println();
        //2.3
        //int sum2; //java: variable sum is already defined in method main(java.lang.String[])
        System.out.print("i4i/sum2:");
        for (int i4i = 1, sum2 = 0; i4i <= 10; i4i++) {
            sum2 += i4i;
            System.out.print(" " + i4i + "/" + sum2);
        }
        System.out.println();
        //2.4
        int i4j, sum3;
        System.out.print("i4j/sum3:");
        for (i4j = 1, sum3 = 0; i4j <= 10;
             sum3 += i4j, System.out.print(" " + i4j + "/" + sum3), i4j++)
                ;
        System.out.println();
        //2.5
        System.out.print("i4k/sum4:");
        for (int i4k = 1, sum4 = 0; i4k <= 10; i4k++) {
            sum4 += i4k;
            System.out.print(" " + i4k + "/" + sum4);
        }
        System.out.println();
        //System.out.println("i4k: " + i4k + " / sum4: " + sum4); //java: cannot find symbol
                                                                //  symbol:   variable i4k
                                                                //  location: class org.example.Kap_5

        //Zpracování pøíkazu FOR:
        //1. iterace:    výraz_start -> test výraz_stop (true) -> pøíkaz -> výraz_iter
        //dal¹í iterace:                test výraz_stop (true) -> pøíkaz -> výraz_iter

        //souèin lichých èísel - srovnání èasù bìhu programu
        long pred, mezi, po;
        long pred_nano, mezi_nano, po_nano;
        pred = System.currentTimeMillis();
        pred_nano = System.nanoTime();

        int i5;
        long soucin5;
        for (i5 = 1, soucin5 = 1; i5 <= 30; i5++)
            if (i5 % 2 == 1) {
                soucin5 *= i5;
                System.out.println("i5 = " + i5 + " / soucin5 = " + soucin5);
            }
        mezi = System.currentTimeMillis();
        mezi_nano = System.nanoTime();

        int i6;
        long soucin6;
        for (i6 = 3, soucin6 = 1; i6 <= 30; i6 += 2) {
            soucin6 *= i6;
            System.out.println("i6 = " + i6 + " / soucin6 = " + soucin6);
        }

        po = System.currentTimeMillis();
        po_nano = System.nanoTime();
        System.out.println("mezi - pred (ms): " + (mezi - pred));
        System.out.println("po - mezi (ms): " + (po - mezi));
        System.out.println("mezi - pred (nano) (ms): " + ((mezi_nano - pred_nano)/1000000)); //1 ms = 1.000.000 ns
        System.out.println("po - mezi (nano) (ms): " + ((po_nano - mezi_nano)/1000000));
        //souèin lichých èísel - konec

        //BREAK s návì¹tím doká¾e ukonèit i blok (nejen cyklus)
        System.out.print("Zaèátek ");
        odskok:
        {
            for (int i7 = 1; i7 < 10; i7++) {
                if (i7 == 5)
                    //break odskok; //=> Zaèátek 1 2 3 4 Konec
                    break;      //=> Zaèátek 1 2 3 4 Støed Konec
                System.out.print(i7 + " ");
            }
            System.out.print("Støed ");
        }
        System.out.println("Konec");

        //CONTINUE s návì¹tím ve vnoøených cyklech FOR
        navesti:
        for (int n8 = 0; n8 < 4; n8++) {     //0 1 (2) 3
            for (int m8 = 0; m8 < 2; m8++) { //0   (1)
                if (n8 == 2 && m8 == 1)
                    continue navesti; //0-0 0-1 1-0 1-1 2-0 3-0 3-1
                    //continue;       //0-0 0-1 1-0 1-1 2-0 3-0 3-1
                    //break navesti;  //0-0 0-1 1-0 1-1 2-0
                System.out.print(n8 + "-" + m8 + " ");
            }
        }
        System.out.println();

        //typické pou¾ití BREAK: výskok z vnoøených cyklù
        int[] a = new int[10];
        int[] b = new int[10];
        int[] x = new int[10];
        chyba:
        {
            for (int i9 = 0; i9 < 10; i9++) {
                a[i9] = i9;
                for (int j9 = 0; j9 < 10; j9++) {
                    b[j9] = j9;
                    for (int k9 = 9; k9 >= 0; k9--) {
                        x[k9] = k9;
                        if (x[k9] == 0)
                            break chyba;
                        a[i9] = a[i9] + b[j9] / x[k9];
                        System.out.println("Dobøe (" + a[i9] + " + " + b[j9]  + " / " +  x[k9] + ")");
                    }
                }
            }
        }
        System.out.println("Nulový dìlitel");

        //Pøíkaz SWITCH
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

        //Pøíkaz SWITCH - umístìní DEFAULT kdekoliv
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

        //odstra¹ující pøklad
        char c10 = 'a';
        /*while (c10 != '*') {
            switch (c10 = Kap_4_VstupZnaku.ctiZnak()) {
                case ' ':
                case '\t':
                    System.out.print('#');
                    continue; //=> odskok na konec smyèky WHILE; ¾ádná relevance pro SWITCH
                    //break; //funguje toto¾nì s BREAK
                case '*':
                    break;
                default:
                    System.out.print(c10);
                    break;
            }
        }*/
        //lep¹í øe¹ení
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
        //krat¹í ale ménì pøehledné
        /*while ((c10 = Kap_4_VstupZnaku.ctiZnak()) != '*') {
            switch (c10) {
                case ' ':
                case '\t':
                    c10 = '#';
                default:
                    System.out.print(c10);
                    break;
            }
        }*/

        //RETURN ukonèí metodu (funkci) nebo celý program (main)
        //return;
        //System.out.println("Toto se ji¾ neprovede ..."); //java: unreachable statement

        System.exit(45);
        System.out.println("Toto se ji¾ neprovede ...");
    }
}
