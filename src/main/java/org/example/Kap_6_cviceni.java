package org.example;

public class Kap_6_cviceni {

    //cvičení 1
    static void power(double x, int n) {
        double x_mocn = x;
        for (int i1 = 1; i1 <= n; i1++) {
            System.out.println("x^" + i1 + " = " + x_mocn);
            x_mocn = x_mocn * x;
        }
    }

    //cvičení 2
    static boolean jePrvocislo(int i) {
        for (int i2 = 2; i2 < i; i2++) {
            if (i % i2 == 0) return false;
        }
        return true;
    }

    //cvičení 3
    static double mocnina(double x, int n) {
        if (n > 1)
            return x * mocnina(x, n - 1);
        else return x;
    }

    //cvičení 4
    static double vypoctiE() {
        Double e = 0., inkrE = 1.; //princip výpočtu viz Kap. 5, cv. 8 (vlastní řešení) n. MAIN() níže
        int i = 0;
        while (inkrE > 1e-7) {
            e = e + inkrE;
            inkrE = inkrE/++i;
        }
        return e;
    }
    static double vypoctiE(double presnost) {
        Double e = 0., inkrE = 1.; //princip výpočtu viz Kap. 5, cv. 8 (vlastní řešení) n. MAIN() níže
        int i = 0;
        while (inkrE > presnost) {
            e = e + inkrE;
            inkrE = inkrE/++i;
        }
        return e;
    }

    public static void main(String[] args) {
        //cvičení 1
        power(4.5, 15);

        //cvičení 2
        for (int i2 = 2; i2 <= 100; i2++)
            System.out.println(i2 + (jePrvocislo(i2) ? " JE prvočíslo" : " NENÍ prvočíslo"));
            //if (jePrvocislo(i2)) System.out.println(i2);

        //cvičení 3
        double x3 = 4.5;
        int n3 = 5;
        System.out.println("mocnina " + x3 + "^" + n3 + " = " + mocnina(x3, n3));

        //cvičení 4
        //Kap. 5, cv. 8 (vlastní řešení):
        Double e = 0., inkrE = 1.; //iniciační hodnota inkr.: 1/0! tj. 1
        int i = 0;
        while (inkrE > 1e-15) { //exponent oproti zadání -7 změněn na -15 pro větší přesnost
            e = e + inkrE;
            inkrE = inkrE/++i; //první iterace: inkr. = 1/1! tj. 1 (kum. 2), další iterace: 1/i! (algoritmicky: předch. inkr. * 1/i)
        }
        System.out.println("Vypočtené e: " + e);
        System.out.println("Knihovní  e: " + Math.E);
        System.out.println("vypoctiE():  " + vypoctiE());
        System.out.println("vypoctiE(p): " + vypoctiE(1e-15));
    }
}
