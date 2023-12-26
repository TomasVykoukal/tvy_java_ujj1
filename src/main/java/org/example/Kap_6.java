package org.example;
import java.io.*;
import java.util.Locale;

public class Kap_6 {
    static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    static int secti() {
        int a = Kap_4_VstupInt.ctiInt();
        int b = Kap_4_VstupInt.ctiInt();
        return (a + b);
    }

    //v�po�et faktori�lu
    public static long fakt_rekurs(long n) {
        if (n > 1)
            return n * fakt_rekurs(n - 1);
        else
            return 1;
    }

    public static long fakt_for(long n) {
        long n_ret = 1;
        for (long i = 2; i <= n; i++)
            n_ret = n_ret * i;
        return n_ret;
    }

    //v�po�et Fibonacciho �ady
    public static long fib_rekurs(long n) {
        if (n == 0 || n == 1)
            return n;
        else
            return fib_rekurs(n - 1) + fib_rekurs(n - 2);
    }

    //pozice:  1   2   3   4   5   6   7    8   9  10  11  12   13
    //hodnota: 0   1   1   2   3   5   8   13  21  34  55  89  144
    public static long fib_for(long n) {
        long n_ret = 0;
        if (n >= 2) {
            long n_ret_m2 = 0; //p�edposledn� (pozice minus 2)
            long n_ret_m1 = 1; //posledn� (pozice minus 1)
            for (long i = 2; i <= n; i++) {
                n_ret = n_ret_m2 + n_ret_m1;
                n_ret_m2 = n_ret_m1;
                n_ret_m1 = n_ret;
            }
        }
        else n_ret = n;
        return n_ret;
    }

    //konverze
    //explicitn� z��uj�c� typov� k.
    static int konv1(double d) {
        return (int) d;
    }
    //implicitn� roz�i�uj�c� typov� k.
    static double konv2(int d) {
        return d;
    }

    //p�ed�v�n� parametr� hodnotou (call by value)
    static int zmena(int i) {
        i++;
        return i;
    }

    //p�et�en� metody
    static int ctverec(int i) {return i * i;};
    static double ctverec(double i) {return i * i;};
    //static long ctverec(int i) {return i * i;}; //java: method ctverec(int) is already defined in class org.example.Kap_6
    static long ctverec(long i) {return i * i;};

    static void tiskPenez(int koruny) {
        System.out.println("Cena: " + koruny + ",-- K�");
    }
    static void tiskPenez(int koruny, int halere) {
        System.out.println("Cena: " + koruny + "," + halere + " K�");
    }

    //viditelnost nelok�ln�ch prom�nn�ch
    //prom�nn� t��dy/statick� prom�nn� => nelok�ln� "glob�ln�" prom�nn�; inicializace nepovinn�/voliteln�
    static int i_nelok; //... neinicializovan�
    static int i_nelok_init = 5; //... voliteln� inicializovan�


    public static void main(String[] args){
        System.out.println("V�t�� z ��sel je: " + max(45, 88));
        //System.out.println("Sou�et dvou zadan�ch ��sel je: " + secti());

        //v�po�et faktori�lu
        long cas_zacatek = System.nanoTime();
        System.out.println("faktori�l (rekurs) = " + fakt_rekurs(20));
        long cas_trv_rekurs = System.nanoTime() - cas_zacatek;
        System.out.println("Doba trv�n� rekurze: " + cas_trv_rekurs);
        cas_zacatek = System.nanoTime();
        System.out.println("faktori�l (for)    = " + fakt_for(20));
        long cas_trv_for = System.nanoTime() - cas_zacatek;
        System.out.println("Doba trv�n� for: " + cas_trv_for);
        System.out.println("Neefektivnost rekurs (abs): " + (cas_trv_rekurs - cas_trv_for));
        double neefekt_fakt = (cas_trv_rekurs/(float) cas_trv_for); //p�etypov�n� jednoho z operand� (nebo obou) nutn�; jinak celo��s. d�len� s celo��s. v�sledkem
        System.out.print("N�sobek trv�n� rekurz proti for: ");
        System.out.format(Locale.GERMANY, "%-10.2f%n%n", neefekt_fakt);
        System.out.format(Locale.GERMANY, "%-10.4f%n%n", Math.PI);

        //v�po�et Fibonacciho �ady
        System.out.print("fib (rekurs): ");
        for (long fib_i = 0; fib_i <= 20; fib_i++)
            System.out.print(fib_rekurs(fib_i) + " ");
        System.out.print("\nfib (for)   : ");
        for (long fib_i = 0; fib_i <= 20; fib_i++)
            System.out.print(fib_for(fib_i) + " ");
        System.out.println();

        cas_zacatek = System.nanoTime();
        System.out.println("Fibonacci (rekurs) = " + fib_rekurs(20));
        cas_trv_rekurs = System.nanoTime() - cas_zacatek;
        System.out.println("Doba trv�n� rekurze: " + cas_trv_rekurs);
        cas_zacatek = System.nanoTime();
        System.out.println("Fibonacci (for)    = " + fib_for(20));
        cas_trv_for = System.nanoTime() - cas_zacatek;
        System.out.println("Doba trv�n� for: " + cas_trv_for);
        System.out.println("Neefektivnost rekurs (abs): " + (cas_trv_rekurs - cas_trv_for));
        neefekt_fakt = (cas_trv_rekurs/(float) cas_trv_for);
        System.out.print("N�sobek trv�n� rekurz proti for: ");
        System.out.format(Locale.GERMANY, "%-10.2f%n%n", neefekt_fakt);

        //konverze
        int k = konv1(4);
        double j = konv2((int) 4.5);

        //p�ed�v�n� parametr� hodnotou (call by value)
        int j2, k2 = 4;
        j2 = zmena(k2);
        System.out.println("k2 = " + k2 + ", j2 = " + j2);

        //p�et�en� metody
        int j3 = ctverec(5);
        double d3 = ctverec(5.5);
        long l3 = ctverec(12345L);
        System.out.println("j3 = " + j3 + ", d3 = " + d3 + ", l3 = " + l3);

        tiskPenez(25);
        tiskPenez(25, 50);

        //viditelnost lok�ln�ch a nelok�ln�ch prom�nn�ch
        System.out.println();
        System.out.println("VIDITELNOST PROM�NN�CH - P�EHLED:");
        System.out.println("---------------------------------");

        System.out.println("<<prom�nn� t��dy/statick� prom�nn� => nelok�ln� \"glob�ln�\" prom�nn�; inicializace nepovinn�/voliteln�>>");
        System.out.println("nelok�ln� prom�nn� (prom. t��dy/statick�) neinicializovan�: " + i_nelok);
        System.out.println("nelok�ln� prom�nn� (prom. t��dy/statick�) inicializovan�: " + i_nelok_init + '\n');

        //redeklarace (p�ekryt�, zast�n�n�) nelok�ln�ch prom�nn�ch => lok�ln� prom�nn� (v metod�); inicializace povinn�
        System.out.println("<<redeklarace (p�ekryt�, zast�n�n�) nelok�ln�ch prom�nn�ch => lok�ln� prom�nn� (v metod�); inicializace povinn�>>");
        int i_nelok;
        int i_nelok_init = 55;
        System.out.println("nelok�ln� prom�nn� neinicializovan� (pln� kvalif. jm�no): " + Kap_6.i_nelok);
        System.out.println("nelok�ln� prom�nn� inicializovan� (pln� kvalif. jm�no): " + Kap_6.i_nelok_init);
        //System.out.println("lok�ln� (p�ekryt� nelok.) prom�nn� neinicializovan�: " + i_nelok); //java: variable i_nelok might not have been initialized
        System.out.println("lok�ln� (p�ekryt� nelok.) prom�nn� neinicializovan�: java: variable i_nelok might not have been initialized");
        System.out.println("lok�ln� (p�ekryt� nelok.) prom�nn� inicializovan�: " + i_nelok_init + '\n');

        //lok�ln� prom�nn� (v metod�); inicializace povinn�
        System.out.println("<<lok�ln� prom�nn� (v metod�); inicializace povinn�>>");
        int i_lok_met;
        int i_lok_met_init = 6;
        //System.out.println("lok�ln� prom�nn� (v metod�) neinicializovan�: " + i_lok_met); //java: variable i_lok_met might not have been initialized
        System.out.println("lok�ln� prom�nn� (v metod�) neinicializovan�: java: variable i_lok_met might not have been initialized");
        System.out.println("lok�ln� prom�nn� (v metod�) inicializovan�: " + i_lok_met_init + '\n');

        { //programov� blok
            //redeklarace (p�ekryt�) lok�ln�ch prom�nn�ch (z metody v prog. bloku)
            System.out.println("<<redeklarace (p�ekryt�) lok�ln�ch prom�nn�ch (z metody v prog. bloku)>>");
            //int i_lok_met = 7; //java: variable i_lok_met is already defined in method main(java.lang.String[])
            //long i_lok_met = 7; //dito
            System.out.println("lok�ln� (p�ekryt� z met. v bloku) prom�nn� neinicializovan�: java: variable i_lok_met is already defined in method main(java.lang.String[])");
            //int i_lok_met_init = 7; //java: variable i_lok_met_init is already defined in method main(java.lang.String[])
            //long i_lok_met_init = 7; //dito
            System.out.println("lok�ln� (p�ekryt� z met. v bloku) prom�nn� inicializovan�: java: variable i_lok_met_init is already defined in method main(java.lang.String[])" + '\n');

            //lok�ln� prom�nn� (v bloku {...}); inicializace povinn�
            System.out.println("<<lok�ln� prom�nn� (v bloku {...}); inicializace povinn�>>");
            int i_lok_blok;
            int i_lok_blok_init = 8;
            //System.out.println("lok�ln� prom�nn� (v bloku) neinicializovan�: " + i_lok_blok); //java: variable i_lok_blok might not have been initialized
            System.out.println("lok�ln� prom�nn� (v bloku) neinicializovan�: java: variable i_lok_blok might not have been initialized");
            System.out.println("lok�ln� prom�nn� (v bloku) inicializovan�: " + i_lok_blok_init + '\n');
        }
        //System.out.println("lok�ln� prom�nn� (v bloku) neinicializovan� vyvolan� mimo blok: " + i_lok_blok); //java: cannot find symbol; symbol: variable i_lok_blok; location: class org.example.Kap_6
        System.out.println("lok�ln� prom�nn� (v bloku) neinicializovan� vyvolan� mimo blok: java: cannot find symbol; symbol: variable i_lok_blok; location: class org.example.Kap_6");
        //System.out.println("lok�ln� prom�nn� (v bloku) inicializovan� vyvolan� mimo blok: " + i_lok_blok_init); //java: cannot find symbol; symbol: variable i_lok_blok_init; location: class org.example.Kap_6
        System.out.println("lok�ln� prom�nn� (v bloku) inicializovan� vyvolan� mimo blok: java: cannot find symbol; symbol: variable i_lok_blok_init; location: class org.example.Kap_6\n");

        //lok�ln� prom�nn� (v bloku FOR); inicializace povinn�
        System.out.println("<<lok�ln� prom�nn� (v bloku FOR); inicializace povinn�>>");
        for (int i_lok_for_init = 1; i_lok_for_init <= 1; i_lok_for_init++) {
            System.out.println("lok�ln� prom�nn� (v bloku FOR) neinicializovan�: java: variable i_lok_for_init might not have been initialized");
            System.out.println("lok�ln� prom�nn� (v bloku FOR) inicializovan�: " + i_lok_for_init + '\n');
        }
        //System.out.println("lok�ln� prom�nn� (v bloku FOR) inicializovan� vyvolan� mimo blok: " + i_lok_for_init); //java: cannot find symbol; symbol: variable i_lok_for_init; location: class org.example.Kap_6
        System.out.println("lok�ln� prom�nn� (v bloku FOR) inicializovan� vyvolan� mimo blok: java: cannot find symbol; symbol: variable i_lok_for_init; location: class org.example.Kap_6");
    }
}