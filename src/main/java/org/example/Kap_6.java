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
    static int konv1(double d) {
        return (int) d;
    }
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
    static int i_nelok;


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
        int i4 = 6;
        System.out.println(i4);
        {
            //int i4 = 7; //java: variable i4 is already defined in method main(java.lang.String[])
            //long i4 = 7; //dito
            int j4 = 8;
            System.out.println(j4);
        }
        //System.out.println(j4); //java: cannot find symbol, symbol:   variable j4, location: class org.example.Kap_6
        int i_lok = 0; //java: variable i_lok might not have been initialized
        System.out.println("nelokální neinicializovaná proměnná: " + i_nelok);
        System.out.println("lokální neinicializovaná proměnná: " + i_lok);
    }
}