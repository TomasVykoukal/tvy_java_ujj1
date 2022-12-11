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

    //výpočet faktoriálu
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

    //výpočet Fibonacciho řady
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
            long n_ret_m2 = 0; //předposlední (pozice minus 2)
            long n_ret_m1 = 1; //poslední (pozice minus 1)
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
    //explicitní zúžující typová k.
    static int konv1(double d) {
        return (int) d;
    }
    //implicitní rozšiřující typová k.
    static double konv2(int d) {
        return d;
    }

    //předávání parametrů hodnotou (call by value)
    static int zmena(int i) {
        i++;
        return i;
    }

    //přetížené metody
    static int ctverec(int i) {return i * i;};
    static double ctverec(double i) {return i * i;};
    //static long ctverec(int i) {return i * i;}; //java: method ctverec(int) is already defined in class org.example.Kap_6
    static long ctverec(long i) {return i * i;};

    static void tiskPenez(int koruny) {
        System.out.println("Cena: " + koruny + ",-- Kč");
    }
    static void tiskPenez(int koruny, int halere) {
        System.out.println("Cena: " + koruny + "," + halere + " Kč");
    }

    //viditelnost nelokálních proměnných
    //proměnná třídy/instance => nelokální "globální" proměnná; inicializace nepovinná/volitelná
    static int i_nelok; //... neinicializovaná
    static int i_nelok_init = 5; //... volitelně inicializovaná


    public static void main(String[] args){
        System.out.println("Větší z čísel je: " + max(45, 88));
        //System.out.println("Součet dvou zadaných čísel je: " + secti());

        //výpočet faktoriálu
        long cas_zacatek = System.nanoTime();
        System.out.println("faktoriál (rekurs) = " + fakt_rekurs(20));
        long cas_trv_rekurs = System.nanoTime() - cas_zacatek;
        System.out.println("Doba trvání rekurze: " + cas_trv_rekurs);
        cas_zacatek = System.nanoTime();
        System.out.println("faktoriál (for)    = " + fakt_for(20));
        long cas_trv_for = System.nanoTime() - cas_zacatek;
        System.out.println("Doba trvání for: " + cas_trv_for);
        System.out.println("Neefektivnost rekurs (abs): " + (cas_trv_rekurs - cas_trv_for));
        double neefekt_fakt = (cas_trv_rekurs/cas_trv_for);
        System.out.print("Násobek trvání rekurz proti for: ");
        System.out.format(Locale.GERMANY, "%-10.2f%n%n", neefekt_fakt); //todo: dokončit zobr. efektivnosti
        System.out.format(Locale.GERMANY, "%-10.4f%n%n", Math.PI);

        //výpočet Fibonacciho řady
        System.out.print("fib (rekurs): ");
        for (long fib_i = 0; fib_i <= 20; fib_i++)
            System.out.print(fib_rekurs(fib_i) + " ");
        System.out.print("\nfib (for)   : ");
        for (long fib_i = 0; fib_i <= 20; fib_i++)
            System.out.print(fib_for(fib_i) + " ");
        System.out.println();

        cas_zacatek = System.nanoTime();
        System.out.println("Fibonacci (rekurs) = " + fib_rekurs(30));
        cas_trv_rekurs = System.nanoTime() - cas_zacatek;
        System.out.println("Doba trvání rekurze: " + cas_trv_rekurs);
        cas_zacatek = System.nanoTime();
        System.out.println("Fibonacci (for)    = " + fib_for(30));
        cas_trv_for = System.nanoTime() - cas_zacatek;
        System.out.println("Doba trvání for: " + cas_trv_for);
        System.out.println("Neefektivnost rekurs (abs): " + (cas_trv_rekurs - cas_trv_for));
        neefekt_fakt = (cas_trv_rekurs/cas_trv_for);
        System.out.print("Násobek trvání rekurz proti for: ");
        System.out.format(Locale.GERMANY, "%-10.2f%n%n", neefekt_fakt); //todo: dokončit zobr. efektivnosti

        //konverze
        int k = konv1(4);
        double j = konv2((int) 4.5);

        //předávání parametrů hodnotou (call by value)
        int j2, k2 = 4;
        j2 = zmena(k2);
        System.out.println("k2 = " + k2 + ", j2 = " + j2);

        //přetížené metody
        int j3 = ctverec(5);
        double d3 = ctverec(5.5);
        long l3 = ctverec(12345L);
        System.out.println("j3 = " + j3 + ", d3 = " + d3 + ", l3 = " + l3);

        tiskPenez(25);
        tiskPenez(25, 50);

        //viditelnost lokálních a nelokálních proměnných
        System.out.println("VIDITELNOST PROMĚNNÝCH - PŘEHLED:");
        System.out.println("---------------------------------");

        System.out.println("nelokální proměnná neinicializovaná: " + i_nelok);
        System.out.println("nelokální proměnná inicializovaná: " + i_nelok_init);

        //redeklarace (překrytí) nelokálních proměnných => lokální proměnná (v metodě); inicializace povinná
        int i_nelok;
        int i_nelok_init = 55;
        //System.out.println("lokální (překrytá nelok.) proměnná neinicializovaná: " + i_nelok); //java: variable i_nelok might not have been initialized
        System.out.println("lokální (překrytá nelok.) proměnná neinicializovaná: java: variable i_nelok might not have been initialized");
        System.out.println("lokální (překrytá nelok.) proměnná inicializovaná: " + i_nelok_init);
        System.out.println("nelokální proměnná inicializovaná (plně kvalif. jméno): " + Kap_6.i_nelok_init);

        //lokální proměnná (v metodě); inicializace povinná
        int i_lok_met;
        int i_lok_met_init = 6;
        //System.out.println("lokální proměnná (v metodě) neinicializovaná: " + i_lok_met); //java: variable i_lok_met might not have been initialized
        System.out.println("lokální proměnná (v metodě) neinicializovaná: java: variable i_lok_met might not have been initialized");
        System.out.println("lokální proměnná (v metodě) inicializovaná: " + i_lok_met_init);

        { //programový blok
            //redeklarace (překrytí) lokálních proměnných
            //int i_lok_met = 7; //java: variable lok_met is already defined in method main(java.lang.String[])
            //long i_lok_met = 7; //dito
            //int i_lok_met_init = 7; //java: variable lok_met_init is already defined in method main(java.lang.String[])
            //long i_lok_met_init = 7; //dito

            //lokální proměnná (v bloku {}); inicializace povinná
            int i_lok_blok;
            int i_lok_blok_init = 8;
            //System.out.println("lokální proměnná (v bloku) neinicializovaná" + i_lok_blok); //java: variable i_lok_blok might not have been initialized
            System.out.println("lokální proměnná (v bloku) neinicializovaná: java: variable i_lok_blok might not have been initialized");
            System.out.println("lokální proměnná (v bloku) inicializovaná: " + i_lok_blok_init);
        }
        //System.out.println(j4); //java: cannot find symbol, symbol:   variable j4, location: class org.example.Kap_6
        //System.out.println("lokální proměnná (v bloku) inicializovaná vyvolaná mimo blok: " + i_lok_blok_init); //java: cannot find symbol; symbol: variable i_lok_blok_init; location: class org.example.Kap_6
        System.out.println("lokální proměnná (v bloku) inicializovaná vyvolaná mimo blok: java: cannot find symbol; symbol: variable i_lok_blok_init; location: class org.example.Kap_6");

        //lokální proměnná (v bloku FOR); inicializace povinná
        for (int i_lok_for_init = 1; i_lok_for_init <= 1; i_lok_for_init++) {
            System.out.println("lokální proměnná (v bloku FOR) inicializovaná: " + i_lok_for_init);
        }
        //System.out.println("lokální proměnná (v bloku FOR) inicializovaná vyvolaná mimo blok: " + i_lok_for_init); //java: cannot find symbol; symbol: variable i_lok_for_init; location: class org.example.Kap_6
        System.out.println("lokální proměnná (v bloku FOR) inicializovaná vyvolaná mimo blok: java: cannot find symbol; symbol: variable i_lok_for_init; location: class org.example.Kap_6");
    }
}