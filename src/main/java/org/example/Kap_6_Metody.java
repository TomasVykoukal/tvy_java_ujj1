package org.example;

//místa deklarací promìnných a metod (tøída: prostor jmen, oblast viditelnosti)
// - deklarace (statické) promìnné za deklarací MAIN()
// - deklarace metody za místem volání
public class Kap_6_Metody {
    static void tiskni1() {
        int i = 6;
        System.out.println("lokální promìnná: " + i);
        System.out.println("nelokální promìnná (plnì kvalifikovaná): " + Kap_6_Metody.i);
    }

    public static void main(String[] args) {
        tiskni1();
        tiskni2();
    }

    static int i = 5;

    static void tiskni2() {
        System.out.println("nelokální promìnná: " + i);
    }
}
