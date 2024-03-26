package org.example;

public class Kap_19_CasFaktorialu {

    //19.3.1 informace o �ase
    //n�sl. 2 statick� funkce p�evzaty z doprovodn� diskety
    public static long faktRek(long n) {
        if (n > 1) {
            return n * faktRek(n - 1);
        }
        else {
            return 1;
        }
    }
    public static long faktCykl(long n) {
        long f = 1;
        for (; n > 1; n--) {
            f *= n;
        }
        return f;
    }

    public static void konec() {
        System.out.println("P�ed exit()");
        System.exit(-111);
        System.out.println("PO exit()");
    }

    public static void main(String[] args) {
        long z, k, f;

        for (long i = 6; i <= 20; i += 2) {
            System.out.print(i + "!\t");
            z = System.currentTimeMillis();
            for (int j = 1; j <= 10_500_000; j++) {
                f = faktRek(i);
            }
            k = System.currentTimeMillis();
            System.out.print((k - z) + "\t");

            z = System.currentTimeMillis();
            for (int j = 1; j <= 10_500_000; j++) {
                f = faktCykl(i);
            }
            k = System.currentTimeMillis();
            System.out.println((k - z));
        }

        //19.3.3 zji�t�n� velikosti dostupn� pam�ti
        Runtime r = Runtime.getRuntime();
        System.out.println("\nCel� pam�: " + r.totalMemory() + " B / " + r.totalMemory()/1024  + " kB");
        System.out.println("Voln� pam�: " + r.freeMemory() + " B / " + r.freeMemory()/1024 + " kB");
        int[] pole = new int[10_000_000];
        System.out.println("Voln� pam�: " + r.freeMemory() + " B / " + r.freeMemory()/1024 + " kB");
        pole = null;
        System.gc();
        System.out.println("Voln� pam�: " + r.freeMemory() + " B / " + r.freeMemory()/1024 + " kB");

        //19.3.5 n�siln� ukon�en� programu
        System.out.println("\nP�ed konec()");
        konec();
        System.out.println("PO konec()");
    }
}
