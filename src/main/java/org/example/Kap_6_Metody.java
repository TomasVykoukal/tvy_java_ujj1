package org.example;

//m�sta deklarac� prom�nn�ch a metod (t��da: prostor jmen, oblast viditelnosti)
// - deklarace (statick�) prom�nn� za deklarac� MAIN()
// - deklarace metody za m�stem vol�n�
public class Kap_6_Metody {
    static void tiskni1() {
        int i = 6;
        System.out.println("lok�ln� prom�nn�: " + i);
        System.out.println("nelok�ln� prom�nn� (pln� kvalifikovan�): " + Kap_6_Metody.i);
    }

    public static void main(String[] args) {
        tiskni1();
        tiskni2();
    }

    static int i = 5;

    static void tiskni2() {
        System.out.println("nelok�ln� prom�nn�: " + i);
    }
}
