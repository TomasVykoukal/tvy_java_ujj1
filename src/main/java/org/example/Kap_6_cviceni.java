package org.example;

public class Kap_6_cviceni {

    //cvi�en� 1
    static void power(double x, int n) {
        double x_mocn = x;
        for (int i1 = 1; i1 <= n; i1++) {
            System.out.println("x^" + i1 + " = " + x_mocn);
            x_mocn = x_mocn * x;
        }
    }

    //cvi�en� 2
    static boolean jePrvocislo(int i) {
        for (int i2 = 2; i2 < i; i2++) {
            if (i % i2 == 0) return false;
        }
        return true;
    }

    //cvi�en� 3
    static double mocnina(double x, int n) {
        if (n > 1)
            return x * mocnina(x, n - 1);
        else return x;
    }

    //cvi�en� 4
    static double vypoctiE() {
        Double e = 0., inkrE = 1.; //princip v�po�tu viz Kap. 5, cv. 8 (vlastn� �e�en�) n. MAIN() n�e
        int i = 0;
        while (inkrE > 1e-7) {
            e = e + inkrE;
            inkrE = inkrE/++i;
        }
        return e;
    }
    static double vypoctiE(double presnost) {
        Double e = 0., inkrE = 1.; //princip v�po�tu viz Kap. 5, cv. 8 (vlastn� �e�en�) n. MAIN() n�e
        int i = 0;
        while (inkrE > presnost) {
            e = e + inkrE;
            inkrE = inkrE/++i;
        }
        return e;
    }

    public static void main(String[] args) {
        //cvi�en� 1
        System.out.println("*** cvi�en� 1 ***");
        power(4.5, 15);

        //cvi�en� 2
        System.out.println("*** cvi�en� 2 ***");
        for (int i2 = 2; i2 <= 100; i2++)
            System.out.println(i2 + (jePrvocislo(i2) ? " JE prvo��slo" : " NEN� prvo��slo"));
            //if (jePrvocislo(i2)) System.out.println(i2);

        //cvi�en� 3
        System.out.println("*** cvi�en� 3 ***");
        double x3 = 4.5;
        int n3 = 5;
        System.out.println("mocnina " + x3 + "^" + n3 + " = " + mocnina(x3, n3));

        //cvi�en� 4
        //Kap. 5, cv. 8 (vlastn� �e�en�):
        Double e = 0., inkrE = 1.; //inicia�n� hodnota inkr.: 1/0! tj. 1
        int i = 0;
        while (inkrE > 1e-15) { //exponent oproti zad�n� -7 zm�n�n na -15 pro v�t�� p�esnost
            e = e + inkrE;
            inkrE = inkrE/++i; //prvn� iterace: inkr. = 1/1! tj. 1 (kum. 2), dal�� iterace: 1/i! (algoritmicky: p�edch. inkr. * 1/i)
        }
        System.out.println("*** cvi�en� 4 ***");
        System.out.println("Vypo�ten� e: " + e);
        System.out.println("Knihovn�  e: " + Math.E);
        System.out.println("vypoctiE():  " + vypoctiE());
        System.out.println("vypoctiE(p): " + vypoctiE(1e-15));
    }
}
