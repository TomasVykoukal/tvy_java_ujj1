package org.example;
import java.io.*;

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

    static void tiskPenez(int koruny) {
        System.out.println("Cena: " + koruny + " Kč");
    }

    public static void main(String[] args){
        System.out.println("Větší z čísel je: " + max(45, 88));
        //System.out.println("Součet dvou zadaných čísel je: " + secti());
        tiskPenez(25);





    }
}