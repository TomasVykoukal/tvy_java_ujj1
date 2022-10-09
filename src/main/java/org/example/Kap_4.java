package org.example;
import java.io.*;

public class Kap_4 {
    public static void main(String[] args){
        System.out.println('\u004A');
        System.out.println("\u004A");
        //System.out.println('\u004A\u0032'); //unclosed character literal
        System.out.println("\u004A\u0032");

        String cis1 = "945";
        String cis2 = new String("1945");
        System.out.println(cis1 + " " + cis2);
        System.out.println((String.valueOf(cis1) + String.valueOf(cis2)));

        int i = 4, j = 7;
        System.out.println("Součet je " + i + j);
        System.out.println("Součet je " + (i + j));
        System.out.println("Součet je " + (i + j) + "\tSoučin je " + (i*j));
        System.out.println("\007Chyba, pokus dělení nulou");
        System.out.println("\u0009Chyba, pokus dělení nulou");
        System.out.println("Toto je \"backslash\": '\\'");
        System.out.println("Toto je 'backslash': '\\'");

        char c2 = '\n'; //10
        int i2 = 5;
        System.out.println(i2 + c2);
        System.out.println(i2 + '\n');
        System.out.println("i2 " + i2 + '\n');
        System.out.println(i2 + '\n' + " i2");

        char c3 = 'A';
        System.out.println("Znak " + c3 + " má ASCII hodnotu: " + (int) c3);
        System.out.println("Znak " + c2 + " má ASCII hodnotu: " + (int) c2);
        System.out.println("Znak " + i2 + " má ASCII hodnotu: " + (int) i2);

        //viz public class Kap_4_VstupInt


    }
}
