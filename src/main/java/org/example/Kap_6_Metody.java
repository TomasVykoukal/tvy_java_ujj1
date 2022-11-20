package org.example;

public class Kap_6_Metody {
    static void tiskni1() {
        int i = 6;
        System.out.println("lok. prom.: " + i);
        System.out.println("nelok. prom. (plně kvalifikovaná): " + Kap_6_Metody.i);
    }
    public static void main(String[] args) {
        tiskni1();
        tiskni2();
    }
    static int i = 5;
    static void tiskni2() {
        System.out.println("nelok. prom.: " + i);
    }
}
