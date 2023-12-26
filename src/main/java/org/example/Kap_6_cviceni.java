package org.example;

public class Kap_6_cviceni {

    //cvièení 1
    static void power(double x, int n) {
        double x_mocn = x;
        for (int i1 = 1; i1 <= n; i1++) {
            System.out.println("x^" + i1 + " = " + x_mocn);
            x_mocn = x_mocn * x;
        }
    }

    //cvièení 2
    static boolean jePrvocislo(int i) {
        for (int i2 = 2; i2 < i; i2++) {
            if (i % i2 == 0) return false;
        }
        return true;
    }

    //cvièení 3
    static double mocnina(double x, int n) {
        if (n > 1)
            return x * mocnina(x, n - 1);
        else return x;
    }

    //cvièení 4
    static double vypoctiE() {
        Double e = 0., inkrE = 1.; //princip výpoètu viz Kap. 5, cv. 8 (vlastní øe¹ení) n. MAIN() ní¾e
        int i = 0;
        while (inkrE > 1e-7) {
            e = e + inkrE;
            inkrE = inkrE/++i;
        }
        return e;
    }
    static double vypoctiE(double presnost) {
        Double e = 0., inkrE = 1.; //princip výpoètu viz Kap. 5, cv. 8 (vlastní øe¹ení) n. MAIN() ní¾e
        int i = 0;
        while (inkrE > presnost) {
            e = e + inkrE;
            inkrE = inkrE/++i;
        }
        return e;
    }

    public static void main(String[] args) {
        //cvièení 1
        System.out.println("*** cvièení 1 ***");
        power(4.5, 15);

        //cvièení 2
        System.out.println("*** cvièení 2 ***");
        for (int i2 = 2; i2 <= 100; i2++)
            System.out.println(i2 + (jePrvocislo(i2) ? " JE prvoèíslo" : " NENÍ prvoèíslo"));
            //if (jePrvocislo(i2)) System.out.println(i2);

        //cvièení 3
        System.out.println("*** cvièení 3 ***");
        double x3 = 4.5;
        int n3 = 5;
        System.out.println("mocnina " + x3 + "^" + n3 + " = " + mocnina(x3, n3));

        //cvièení 4
        //Kap. 5, cv. 8 (vlastní øe¹ení):
        Double e = 0., inkrE = 1.; //iniciaèní hodnota inkr.: 1/0! tj. 1
        int i = 0;
        while (inkrE > 1e-15) { //exponent oproti zadání -7 zmìnìn na -15 pro vìt¹í pøesnost
            e = e + inkrE;
            inkrE = inkrE/++i; //první iterace: inkr. = 1/1! tj. 1 (kum. 2), dal¹í iterace: 1/i! (algoritmicky: pøedch. inkr. * 1/i)
        }
        System.out.println("*** cvièení 4 ***");
        System.out.println("Vypoètené e: " + e);
        System.out.println("Knihovní  e: " + Math.E);
        System.out.println("vypoctiE():  " + vypoctiE());
        System.out.println("vypoctiE(p): " + vypoctiE(1e-15));
    }
}
