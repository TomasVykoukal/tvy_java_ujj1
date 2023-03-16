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

        System.out.println("(" + bajty.length + "): " + bajty[0] + " " + bajty[1] + " " + bajty[2]); //-->69 118 97 (přímý výstup => číselná interpretace)
        System.out.println("(" + znaky.length + "): " + znaky[0] + " " + znaky[1] + " " + znaky[2] + " " + znaky[3] + " " + znaky[4] + " " + znaky[5] + " " + znaky[6]);
        System.out.println("(" + buf.length() + "): " + buf);
        //Pozn. k "length" viz níže.

        //přetížené konstruktory třídy String
        String s1_1 = new String("Ciao!");
        String s1_2 = new String(s1_1);
        String s1_3 = new String(bajty); //-->Eva (String => textová interpretace)
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
        //porovnání řetězců pomocí funkce => srovnává obsah řetězců (nikoliv ref. proměnné)
        String s2_1a = new String("ahoi!");
        String s2_1b = new String("ahoi!");
        String s2_2 = new String("ahoj!");
        String s2_3 = new String("AHOJ!");

        System.out.println("s2_1a: " + s2_1a);
        System.out.println("s2_1b: " + s2_1b);
        System.out.println("s2_2: " + s2_2);
        System.out.println("s2_3: " + s2_3);
        System.out.println("--------------");
        System.out.println("s2_1a.compareTo(s2_2): "  + s2_1a.compareTo(s2_2)  + " | " + s2_1a + " < " + s2_2 + " => <0");
        System.out.println("s2_1a.compareTo(s2_1b): " + s2_1a.compareTo(s2_1b) + " | " + s2_1a + " = " + s2_1b + " => 0");
        System.out.println("s2_2.compareTo(s2_1a):  " + s2_2.compareTo(s2_1a)  + " | " + s2_2 + " > " + s2_1a + " => >0");
        System.out.println("--------------");
        System.out.println("s2_3.compareTo(s2_2):         "   + s2_3.compareTo(s2_2)           + " | " + s2_3 + " < " + s2_2 + " => <0");
        System.out.println("s2_3.compareToIgnoreCase(s2_2): " + s2_3.compareToIgnoreCase(s2_2) + " | " + s2_3 + " = " + s2_2 + " => 0 (ignore case)");
        System.out.println("s2_2.compareTo(s2_3):          "  + s2_2.compareTo(s2_3)           + " | " + s2_2 + " > " + s2_3 + " => >0");
        /* s1.compareTo(s2):
              - s1 < s2 => <0
              - s1 = s2 => 0
              - s1 > s2 => >0 */
        System.out.println("--------------");
        System.out.println("s2_2.equals(s2_3):           " + s2_2.equals(s2_3)           +  " | " + s2_2 + " <> " + s2_3 + " => false");
        System.out.println("s2_2.equalsIgnoreCase(s2_3): " + s2_2.equalsIgnoreCase(s2_3) + "  | " + s2_2 + " =  " + s2_3 + " => true (ignore case)");
        System.out.println("--------------");

        //porovnání řetězců pomocí operátoru "==" => srovnává ref. proměnné, nikoliv obsah řetězců
        if (s2_1a == s2_1b) {
            System.out.println("s2_1a == s2_1b");
        } else {
            System.out.println("neplatí s2_1a == s2_1b");
        }
        if (s2_1a == s2_1a) {
            System.out.println("s2_1a == s2_1a");
        } else {
            System.out.println("neplatí s2_1a == s2_1a");
        }

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
        String istr;
        for (int i = 0; i < s5_1.length(); i++) {
            istr = String.valueOf(i);
            System.out.print(istr.substring(istr.length()-1)); //tisk 1-ciferného pozičního čísla
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

        //umístění podřetězce do pole znaků
        char znaky2[] = new char[10];
        s5_1.getChars(2, 9, znaky2, 0);
        System.out.println(znaky2);

        //práce se začátkem a koncem řetězce
        if (s5_1.startsWith("malá") == true) {
            System.out.println(s5_1 + " začíná na \"malá\"");
        }
        if (s5_1.endsWith("malá") == false) {
            System.out.println(s5_1 + " nekončí na \"malá\"");
        }

        //oříznutí bílých znaků na okrajích
        String s6_2, s6_1 = "\r\n\t ahoj\t \r\n";
        s6_2 = s6_1.trim();
        System.out.println("Začátek:" + s6_1 + ":konec");
        System.out.println("Začátek:" + s6_2 + ":konec");
        System.out.println();

        //práce s jednotlivými značky řetězce - viz charAt()

        //hledání znaku
        String s7 = "mala a VELKA";
        int i7;
        i7 = s7.indexOf('a');
        System.out.println(s7 + ": První \'a\' je na " + i7 + ". pozici");
        i7 = s7.indexOf('a', i7 + 1);
        System.out.println(s7 + ": Další \'a\' je na " + i7 + ". pozici");
        i7 = s7.lastIndexOf('a');
        System.out.println(s7 + ": Poslední \'a\' je na " + i7 + ". pozici");
        i7 = s7.lastIndexOf('a', i7 - 1);
        System.out.println(s7 + ": Předposlední \'a\' je na " + i7 + ". pozici");

        i7 = s7.lastIndexOf("VEL");
        System.out.println(s7 + ": Poslední \"VEL\" je na " + i7 + ". pozici");
        System.out.println();

        //konverze zákl. dat. typů na řetězec
        boolean b8 = true;
        byte bt8 = 125;
        short sh8 = 32000;
        int i8 = 1234567;
        long l8 = 45000000000L; //L nutné, jinak "java: integer number too large"
        float f8 = 3.14F; //F nutné, jinak "java: incompatible types: possible lossy conversion from double to float"
        double d8 = Math.PI;

        String s_b8 = String.valueOf(b8);
        String s_bt8 = String.valueOf(bt8);
        String s_sh8 = String.valueOf(sh8);
        String s_i8 = String.valueOf(i8);
        String s_l8 = String.valueOf(l8);
        String s_f8 = String.valueOf(f8);
        String s_d8 = String.valueOf(d8);

        //... print[ln] dělá totéž
        System.out.println("b8: " + b8 + " / valueOf: " + s_b8);
        System.out.println("bt8: " + bt8 + " / valueOf: " + s_bt8);
        System.out.println("sh8: " + sh8 + " / valueOf: " + s_sh8);
        System.out.println("i8: " + i8 + " / vauleOf: " + s_i8);
        System.out.println("l8: " + l8 + " / valueOf: " + s_l8);
        System.out.println("f8: " + f8 + " / valueOf: " + s_f8);
        System.out.println("d8: " + d8 + " / valueOf: " + s_d8);
        System.out.println();

        //... konverze nutná při dalším textovém zpracování
        System.out.println(Math.PI);
        s_d8 = String.valueOf(Math.PI);
        i8 = s_d8.indexOf('.');
        s_d8 = s_d8.substring(0, i8 + 6);
        System.out.println("5 Nachkommastellen: " + s_d8);
        System.out.println();

        //... do jiné číselné soustavy
        i8 = 254;
        System.out.println(i8 + ":");
        System.out.println("Integer.toBinaryString(): " + Integer.toBinaryString(i8));
        System.out.println("Integer.toOctalString(): " + Integer.toOctalString(i8));
        System.out.println("Integer.toHexString(): " + Integer.toHexString(i8));
        System.out.println();

        System.out.println("Dec: Bin / Oct / Hex");
        for (int i = 0; i <= 25; i++) {
            System.out.print(i + ": ");
            System.out.print(Integer.toBinaryString(i) + " / ");
            System.out.print(Integer.toOctalString(i) + " / ");
            System.out.println(Integer.toHexString(i));
        }
        System.out.println();

        //konverze řetězce na zákl. dat. typy
        String s_b9 = "true";
        String s_bt9 = "125";
        String s_sh9 = "32000";
        String s_i9 = "1450000";
        String s_l9 = "45000000000";
        String s_f9 = "3.14";
        String s_d9 = "3.14";

        boolean b9 = Boolean.valueOf(s_b9).booleanValue();
        byte bt9 = Byte.valueOf(s_bt9, 10).byteValue();
        short sh9 = Short.valueOf(s_sh9, 10).shortValue();
        //int i9 = Integer.valueOf(s_i9, 10).intValue();
        //int i9 = Integer.valueOf(s_i9, 10); //?
        int i9 = Integer.parseInt(s_i9, 10); //existují i metody třídy parseXXX
        long l9 = Long.valueOf(s_l9, 10).longValue();
        float f9 = Float.valueOf(s_f9).floatValue();
        double d9 = Double.valueOf(s_d9).doubleValue();

        System.out.println("b9: " + s_b9 + " / booleanValue: " + b9);
        System.out.println("bt9: " + s_bt9 + " / byteValue: " + bt9);
        System.out.println("sh9: " + s_sh9 + " / shortValue: " + sh9);
        System.out.println("i9: " + s_i9 + " / intValue: " + i9);
        System.out.println("l9: " + s_l9 + " / longValue: " + l9);
        System.out.println("f9: " + s_f9 + " / floatValue: " + f9);
        System.out.println("d9: " + s_d9 + " / doubleValue: " + d9);
        System.out.println();

        double d9_2 = new Double("3.14").doubleValue();
        double d9_3 = new Double("3.14"); //?
        System.out.println(d9_2 + " / " + d9_3);
        System.out.println();

        //volání více metod jedním příkazem
        int i10 =  "\r\n\t cacao\t \r\n".trim().toUpperCase().substring(2).indexOf('O');
        System.out.println("\'O\' je " + (i10 + 1) + ". znak");
        System.out.println();

        //Metoda toString() - viz tř. Kap_9_MujString

        //Třída stringBuffer
        System.out.println('\u0000');

        StringBuffer b11_1 = new StringBuffer();
        StringBuffer b11_2 = new StringBuffer(100);
        StringBuffer b11_3 = new StringBuffer("Ahoj");

        System.out.println(b11_1);
        System.out.println(b11_2);
        System.out.println(b11_3);

        System.out.println(b11_1.length() + ", " + b11_1.capacity());
        System.out.println(b11_2.length() + ", " + b11_2.capacity());
        System.out.println(b11_3.length() + ", " + b11_3.capacity());
        b11_1.setLength(18);
        b11_2.ensureCapacity(110);
        b11_3.setLength(3);
        System.out.println(b11_1.length() + ", " + b11_1.capacity());
        System.out.println(b11_2.length() + ", " + b11_2.capacity());
        System.out.println(b11_3.length() + ", " + b11_3.capacity());

        b11_3 = new StringBuffer("Ahoj!");
        System.out.println(b11_3.reverse());





    }
}
