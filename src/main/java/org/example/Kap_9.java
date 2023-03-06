package org.example;

import java.util.Locale;

public class Kap_9 {
    //java.lang.String
    public static void main(String[] args) {
        //nejjed. a nejefekt. způsob vytvoření obj. řetězce přiřazením textu do přísl. proměnné
        String s = "Ahoj!";

        //ostatní způsoby vytvoření obj. řetězce pomocí konstruktorů a jejich výpis
        byte[] bajty = {(byte)'E', (byte)'v', (byte)'a'}; //pole bajtů
        char[] znaky = {'M', 'a', 'r', 't', 'i', 'n', 'a'}; //pole znaků
        StringBuffer buf = new StringBuffer("Dobrý den!");

        System.out.println("(" + bajty.length + "): " + bajty[0] + " " + bajty[1] + " " + bajty[2]); //-->69 118 97
        System.out.println("(" + znaky.length + "): " + znaky[0] + " " + znaky[1] + " " + znaky[2] + " " + znaky[3] + " " + znaky[4] + " " + znaky[5] + " " + znaky[6]);
        System.out.println("(" + buf.length() + "): " + buf);

        //přetížené konstruktory třídy String
        String s1_1 = new String("Ciao!");
        String s1_2 = new String(s1_1);
        String s1_3 = new String(bajty); //-->Eva
        String s1_4 = new String(bajty, 1, 2);
        String s1_5 = new String(znaky);
        String s1_6 = new String(znaky, 3, 4);
        String s1_7 = new String(buf);

        System.out.println("s1_1(" + s1_1.length() + "): " + s1_1);
        System.out.println("s1_2(" + s1_2.length() + "): " + s1_2);
        System.out.println("s1_3(" + s1_3.length() + "): " + s1_3);
        System.out.println("s1_4(" + s1_4.length() + "): " + s1_4);
        System.out.println("s1_5(" + s1_5.length() + "): " + s1_5);
        System.out.println("s1_6(" + s1_6.length() + "): " + s1_6);
        System.out.println("s1_7(" + s1_7.length() + "): " + s1_7);
        //Pozn. k "length": pole --> proměnná => length; řetězec + StringBuffer --> metoda => length()

        //inicializované pole řetězců
        String[] pole = {"Dana", "Eva", "Martina"};
        for (int i = 0; i < pole.length; i++) {
            System.out.print(pole[i] + " ");
        }
        System.out.println();

        //práce s celými řetězci - porovnávání
        String s2_1a = new String("ahoi!");
        String s2_1b = new String("ahoi!");
        String s2_2 = new String("ahoj!");
        String s2_3 = new String("AHOJ!");

        System.out.println("s2_1a: " + s2_1a);
        System.out.println("s2_1b: " + s2_1b);
        System.out.println("s2_2: " + s2_2);
        System.out.println("s2_3: " + s2_3);
        System.out.println("--------------");
        System.out.println("s2_1a.compareTo(s2_2): " + s2_1a.compareTo(s2_2));
        System.out.println("s2_1a.compareTo(s2_1b): " + s2_1a.compareTo(s2_1b));
        System.out.println("s2_2.compareTo(s2_1a): " + s2_2.compareTo(s2_1a));
        System.out.println("--------------");
        System.out.println("s2_3.compareTo(s2_2): " + s2_3.compareTo(s2_2));
        System.out.println("s2_3.compareToIgnoreCase(s2_2): " + s2_3.compareToIgnoreCase(s2_2));
        System.out.println("s2_2.compareTo(s2_3): " + s2_2.compareTo(s2_3));
        /* s1.compareTo(s2):
              - s1 < s2 => <0
              - s1 = s2 => 0
              - s1 > s2 => >0 */
        System.out.println("--------------");
        System.out.println("s2_2.equals(s2_3): " + s2_2.equals(s2_3));
        System.out.println("s2_2.equalsIgnoreCase(s2_3): " + s2_2.equalsIgnoreCase(s2_3));
        System.out.println("--------------");

        //porovnání řetězců pomocí operátoru == (srovnává ref. proměnné, nikoliv obsah řetězců)
        if (s2_1a == s2_1b) {
            System.out.println("s2_1a == s2_1b");
        } else {
            System.out.println("neplatí s2_1a == s2_1b");
        }
        if (s2_1a == s2_1a) {System.out.println("s2_1a == s2_1a");}

        //práce s celými řetězci - převody na malá či velká písmena
        String s3 = "malá a VELKÁ";
        System.out.println(s3.toLowerCase());
        System.out.println(s3.toUpperCase());
        System.out.println();

        //práce s celými řetězci - spojení řetězců
        String s3_1 = "malá a ";
        String s3_2 = "VELKÁ";
        System.out.println(s3_1 + s3_2);
        System.out.println(s3_1.concat(s3_2));
        System.out.println();

        //práce s celými řetězci - náhrada všech znaků v řetězci
        String s4_2, s4_1 = "cacao";
        s4_2 = s4_1.replace('c', 'k');
        System.out.println(s4_1 + " --> " + s4_2);
        System.out.println();

        //práce s částí řetězce - získání části řetězce
        String s5_2, s5_3, s5_1 = "malá a VELKÁ";
        for (int i = 0; i < s5_1.length(); i++) {
            System.out.print(i);
        }
        System.out.println();
        for (int i = 0; i < s5_1.length(); i++) {
            System.out.print(s5_1.charAt(i));
        }
        System.out.println();
        s5_2 = s5_1.substring(5);
        s5_3 = s5_1.substring(5, 9);
        System.out.println(s5_2);
        System.out.println(s5_3);
        System.out.println();



    }
}
