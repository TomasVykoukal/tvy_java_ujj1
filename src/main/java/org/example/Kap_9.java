package org.example;

import java.util.Locale;

public class Kap_9 {
    //java.lang.String
    public static void main(String[] args) {
        //nejjed. a nejefekt. zp�sob vytvo�en� obj. �et�zce p�i�azen�m textu do p��sl. prom�nn�
        String s = "Ahoj!";

        //ostatn� zp�soby vytvo�en� obj. �et�zce pomoc� konstruktor� a jejich v�pis
        byte[] bajty = {(byte)'E', (byte)'v', (byte)'a'}; //pole bajt�
        char[] znaky = {'M', 'a', 'r', 't', 'i', 'n', 'a'}; //pole znak�
        StringBuffer buf = new StringBuffer("Dobr� den!"); //"m�niteln�" �et�zec

        System.out.println("(" + bajty.length + "): " + bajty[0] + " " + bajty[1] + " " + bajty[2]); //-->69 118 97 (p��m� v�stup => ��seln� interpretace)
        System.out.println("(" + bajty.length + "): " + (char)bajty[0] + " " + (char)bajty[1] + " " + (char)bajty[2]); //-->E v a (p�etypov�n� => textov� interpretace)
        System.out.println("(" + znaky.length + "): " + znaky[0] + " " + znaky[1] + " " + znaky[2] + " " + znaky[3] + " " + znaky[4] + " " + znaky[5] + " " + znaky[6]);
        System.out.println("(" + buf.length() + "): " + buf);
        //Pozn. k "length" viz n�e.
        System.out.println();

        //p�et�en� konstruktory t��dy String
        String s1_1 = new String("Ciao!");
        String s1_2 = new String(s1_1);
        String s1_3 = new String(bajty); //-->Eva (String => textov� interpretace)
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
        //Pozn. k "length": pole --> prom�nn� => length; �et�zec + StringBuffer --> metoda => length()
        System.out.println();

        //inicializovan� pole �et�zc�
        String[] pole = {"Dana", "Eva", "Martina"};
        for (int i = 0; i < pole.length; i++) {
            System.out.print(pole[i] + " ");
        }
        System.out.println('\n'); //--> 2x nov� ��dek

        //pr�ce s cel�mi �et�zci - porovn�v�n�
        //porovn�n� �et�zc� pomoc� funkce => srovn�v� obsah �et�zc� (nikoliv ref. prom�nn�)
        String s2_1a = new String("ahoi!");
        String s2_1b = new String("ahoi!");
        String s2_2  = new String("ahoj!");
        String s2_3  = new String("AHOJ!");

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

        //porovn�n� �et�zc� pomoc� oper�toru "==" => srovn�v� ref. prom�nn�, nikoliv obsah �et�zc�
        if (s2_1a == s2_1b) {
            System.out.println("s2_1a == s2_1b");
        } else {
            System.out.println("neplat� s2_1a == s2_1b");
        }
        if (s2_1a == s2_1a) {
            System.out.println("s2_1a == s2_1a");
        } else {
            System.out.println("neplat� s2_1a == s2_1a");
        }
        System.out.println();

        //pr�ce s cel�mi �et�zci - p�evody na mal� �i velk� p�smena
        String s3 = "mal� a VELK� (�ti��n ��������������� �����ͥ��ة��ݮ)";
        System.out.println("s3:               " + s3);
        System.out.println("s3.toLowerCase(): " + s3.toLowerCase());
        System.out.println("s3.toUpperCase(): " + s3.toUpperCase());
        System.out.println();

        //pr�ce s cel�mi �et�zci - spojen� �et�zc�
        String s3_1 = "mal� a ";
        String s3_2 = "VELK�";
        System.out.println(s3_1 + s3_2);
        System.out.println(s3_1.concat(s3_2)); //s1.concat(s2) => s1 + s2
        System.out.println(s3_2.concat(s3_1));
        System.out.println();

        //pr�ce s cel�mi �et�zci - n�hrada v�ech znak� v �et�zci
        String s4_2, s4_1 = "cacao";
        s4_2 = s4_1.replace('c', 'k');
        System.out.println(s4_1 + " --> " + s4_2);
        System.out.println();

        //pr�ce s ��st� �et�zce - z�sk�n� ��sti �et�zce
        String s5_2, s5_3, s5_1 = "mal� a VELK�";
        String istr;
        for (int i = 0; i < s5_1.length(); i++) {
            //System.out.print(i);  //�patn� - od 10. pozice tiskne 2-m�stn� pozi�n� ��slo
            istr = String.valueOf(i);
            //System.out.print(istr); //dtto
            System.out.print(istr.substring(istr.length()-1)); //tisk posl. znaku jako 1-cifern�ho pozi�n�ho ��sla
        }
        System.out.println();
        for (int i = 0; i < s5_1.length(); i++) {
            System.out.print(s5_1.charAt(i));
        }
        System.out.println();

        s5_2 = s5_1.substring(5);
        s5_3 = s5_1.substring(5, 9); //d�le�it�: koncov� index ukazuje na index PRVN�HO NEPOU�IT�HO znaku ("endIndex: the ending index, exclusive")
        System.out.println(s5_2);    //          �e�eno jinak: kon�� znakem v zadan�m po�ad� v�etn� (zde 9. znak tj. znak s indexem 8)
        System.out.println(s5_3);
        System.out.println();

        //um�st�n� pod�et�zce do pole znak�
        char znaky2[] = new char[10];
        s5_1.getChars(2, 9, znaky2, 0); //d�le�it�: viz SUBSTRING ("srcEnd: index after the last character in the string to copy")
        System.out.println(znaky2);
        System.out.println();

        //pr�ce se za��tkem a koncem �et�zce
        if (s5_1.startsWith("mal�") == true) {
            System.out.println("�et�zec \"" + s5_1 + "\" za��n� na \"mal�\"");
        }
        if (s5_1.endsWith("mal�") == false) {
            System.out.println("�et�zec \"" + s5_1 + "\" nekon�� na \"mal�\"");
        }
        System.out.println();

        //o��znut� b�l�ch znak� na okraj�ch
        String s6_2, s6_1 = "\r\n\t ahoj\t \r\n";
        s6_2 = s6_1.trim();
        System.out.println("Za��tek:" + s6_1 + ":konec");
        System.out.println("Za��tek:" + s6_2 + ":konec");
        System.out.println();

        //pr�ce s jednotliv�mi zna�ky �et�zce - viz charAt()

        //hled�n� znaku
        String s7 = "mala a VELKA";
        int i7;
        i7 = s7.indexOf('a');
        System.out.println(s7 + ": Prvn� \'a\' je na " + i7 + ". pozici");
        i7 = s7.indexOf('a', i7 + 1);
        System.out.println(s7 + ": Dal�� \'a\' je na " + i7 + ". pozici");
        i7 = s7.lastIndexOf('a');
        System.out.println(s7 + ": Posledn� \'a\' je na " + i7 + ". pozici");
        i7 = s7.lastIndexOf('a', i7 - 1);
        System.out.println(s7 + ": P�edposledn� \'a\' je na " + i7 + ". pozici");
        i7 = s7.lastIndexOf("VEL");
        System.out.println(s7 + ": Posledn� \"VEL\" je na " + i7 + ". pozici");
        System.out.println();

        //konverze z�kl. dat. typ� na �et�zec
        boolean b8 = true;
        byte bt8 = 125;
        short sh8 = 32000;
        int i8 = 1234567;
        long l8 = 45000000000L; //L nutn�, jinak "java: integer number too large" (v�echny celo��s. konstanty jsou implicitn� typu INT)
        float f8 = 3.14F; //F nutn�, jinak "java: incompatible types: possible lossy conversion from double to float" (re�ln� konstanta je automaticky typu DOUBLE)
        double d8 = Math.PI;

        String s_b8 = String.valueOf(b8);
        String s_bt8 = String.valueOf(bt8);
        String s_sh8 = String.valueOf(sh8);
        String s_i8 = String.valueOf(i8);
        String s_l8 = String.valueOf(l8);
        String s_f8 = String.valueOf(f8);
        String s_d8 = String.valueOf(d8);

        //... print[ln] d�l� tot�
        System.out.println("b8: "  + b8  + " / valueOf: " + s_b8);
        System.out.println("bt8: " + bt8 + " / valueOf: " + s_bt8);
        System.out.println("sh8: " + sh8 + " / valueOf: " + s_sh8);
        System.out.println("i8: "  + i8  + " / vauleOf: " + s_i8);
        System.out.println("l8: "  + l8  + " / valueOf: " + s_l8);
        System.out.println("f8: "  + f8  + " / valueOf: " + s_f8);
        System.out.println("d8: "  + d8  + " / valueOf: " + s_d8);
        System.out.println();

        //... konverze nutn� p�i dal��m textov�m zpracov�n�
        System.out.println(Math.PI);
        s_d8 = String.valueOf(Math.PI);
        i8 = s_d8.indexOf('.');
        s_d8 = s_d8.substring(0, i8 + 6);
        System.out.print("5 desetinn�ch m�st: " + s_d8);
        System.out.println(" [s_d8.indexOf('.'): " + i8 + "]");
        System.out.println();

        //... do jin� ��seln� soustavy
        bt8 = 124; //Pro Byte obdobn� metody (viz n�e) meexistuj�.
        sh8 = 254; //Pro Short dtto.

        i8 = 254;
        System.out.println("(int) " + i8 + ":");
        System.out.println("Integer.toBinaryString(): " + Integer.toBinaryString(i8));
        System.out.println("Integer.toOctalString(): " + Integer.toOctalString(i8));
        System.out.println("Integer.toHexString(): " + Integer.toHexString(i8));
        System.out.println();

        l8 = 254;
        System.out.println("(long) " + l8 + ":");
        System.out.println("Long.toBinaryString(): " + Long.toBinaryString(l8));
        System.out.println("Long.toOctalString(): " + Long.toOctalString(l8));
        System.out.println("Long.toHexString(): " + Long.toHexString(l8));
        System.out.println();

        System.out.println("Dec: Bin / Oct / Hex");
        for (int i = 0; i <= 25; i++) {
            System.out.print(i + ": ");
            System.out.print(Integer.toBinaryString(i) + " / ");
            System.out.print(Integer.toOctalString(i) + " / ");
            System.out.println(Integer.toHexString(i));
        }
        System.out.println();

        //konverze �et�zce na z�kl. dat. typy
        String s_b9 = "true";
        String s_bt9 = "125";
        String s_sh9 = "32000";
        String s_i9 = "1450000";
        String s_l9 = "45000000000";
        String s_f9 = "3.14";
        String s_d9 = "3.14";

        boolean b9  = Boolean.valueOf(s_b9).booleanValue();
        byte    bt9 = Byte.valueOf(s_bt9, 10).byteValue();
        short   sh9 = Short.valueOf(s_sh9, 10).shortValue();
        int     i9  = Integer.valueOf(s_i9, 10).intValue();
        int     i9a = Integer.valueOf(s_i9, 10); //?
        int     i9b = Integer.parseInt(s_i9, 10); //existuj� i metody t��dy parseXXX
        long    l9  = Long.valueOf(s_l9, 10).longValue();
        float   f9  = Float.valueOf(s_f9).floatValue();
        double  d9  = Double.valueOf(s_d9).doubleValue();

        System.out.println("b9: "  + s_b9  + " / booleanValue: " + b9);
        System.out.println("bt9: " + s_bt9 + " / byteValue: "    + bt9);
        System.out.println("sh9: " + s_sh9 + " / shortValue: "   + sh9);
        System.out.println("i9: "  + s_i9  + " / intValue: "     + i9);
        System.out.println("i9a: " + s_i9  + " / intValue: "     + i9a);
        System.out.println("i9b: " + s_i9  + " / intValue: "     + i9b + " (metoda t��dy parseXXX)");
        System.out.println("l9: "  + s_l9  + " / longValue: "    + l9);
        System.out.println("f9: "  + s_f9  + " / floatValue: "   + f9);
        System.out.println("d9: "  + s_d9  + " / doubleValue: "  + d9);
        System.out.println();

        boolean b9c   = new Boolean(s_b9).booleanValue(); //deprecated varianty
        byte    bt9c  = new Byte(s_bt9).byteValue();
        short   sh9c  = new Short(s_sh9).shortValue();
        int     i9c   = new Integer(s_i9).intValue();
        long    l9c   = new Long(s_l9).longValue();
        float   f9c   = new Float(s_f9).floatValue();
        double  d9c   = new Double(s_d9).doubleValue();
        double  d9c_2 = new Double(s_d9); //?

        System.out.println("b9c:   " + s_b9  + " / booleanValue: " + b9c);
        System.out.println("bt9c:  " + s_bt9 + " / byteValue: "    + bt9c);
        System.out.println("sh9c:  " + s_sh9 + " / shortValue: "   + sh9c);
        System.out.println("i9c:   " + s_i9  + " / intValue: "     + i9c);
        System.out.println("l9c:   " + s_l9  + " / longValue: "    + l9c);
        System.out.println("f9c:   " + s_f9  + " / floatValue: "   + f9c);
        System.out.println("d9c:   " + s_d9  + " / doubleValue: "  + d9c);
        System.out.println("d9c_2: " + s_d9  + " / doubleValue: "  + d9c_2);
        System.out.println();

        //vol�n� v�ce metod jedn�m p��kazem
        int i10 =  "\r\n\t cacao\t \r\n".trim().toUpperCase().substring(2).indexOf('O');
        System.out.println("\'O\' je " + (i10 + 1) + ". znak");
        System.out.println();

        //Metoda toString() - viz t�. Kap_9_MujString

        //T��da stringBuffer - "m�niteln� �et�zec"
        System.out.print("\\u0000: ");
        System.out.println('\u0000');

        //... vytvo�en� �et�zce
        StringBuffer b11_1 = new StringBuffer();
        StringBuffer b11_2 = new StringBuffer(100);
        StringBuffer b11_3 = new StringBuffer("Ahoj");

        System.out.println("b11_1: " + b11_1);
        System.out.println("b11_3: " + b11_2);
        System.out.println("b11_3: " + b11_3);
        System.out.println();

        //... d�lka �et�zce
        System.out.println("length, capacity:");
        System.out.println("b11_1: " + b11_1.length() + ", " + b11_1.capacity());
        System.out.println("b11_2: " + b11_2.length() + ", " + b11_2.capacity());
        System.out.println("b11_3: " + b11_3.length() + ", " + b11_3.capacity());
        b11_1.setLength(18);
        b11_2.ensureCapacity(110);
        b11_3.setLength(3);
        System.out.println("b11_1: " + b11_1.length() + ", " + b11_1.capacity());
        System.out.println("b11_2: " + b11_2.length() + ", " + b11_2.capacity());
        System.out.println("b11_3: " + b11_3.length() + ", " + b11_3.capacity());

        //zm�na cel�ho �et�zce
        b11_3 = new StringBuffer("Ahoj!");
        System.out.println(b11_3.reverse());
        System.out.println();

        //zm�ny ��sti �et�zce
        StringBuffer b12 = new StringBuffer("Ahoj ");
        System.out.println(b12);

        b12.append(true);
        System.out.println(b12);
        b12.append(7);
        System.out.println(b12);

        b12.delete(5, 9); //d�le�it�: viz SUBSTRING
        System.out.println(b12);

        b12.deleteCharAt(0);
        System.out.println(b12);

        b12.insert(0, 3.14);
        System.out.println(b12);
        b12.insert(1, "HOJ");
        System.out.println(b12);

        b12.replace(0, 5, "3,"); //d�le�it�: viz SUBSTRING
        System.out.println(b12);

        System.out.println(b12.charAt(1));
        b12.setCharAt(1, '!');
        System.out.println(b12);

        //konverze na String
        StringBuffer b13 = new StringBuffer("Ahoj");
        String s13_1, s13_2;
        s13_1 = b13.toString();
        s13_2 = b13.substring(1);
        System.out.println(s13_1);
        System.out.println(s13_2);
        System.out.println();

        //t��da Character - pr�ce s jednotl. znaky
        //rozpozn�v�n� druhu znak�
        System.out.println("tamilsk� ��slice: \u0BE7 \u0BEF");

        System.out.println(Character.isDigit('1'));
        System.out.println(Character.isDigit('\u0BE7'));
        System.out.println(Character.isLetter('A'));
        System.out.println(Character.isLetterOrDigit('?'));
        System.out.println(Character.isLowerCase('b'));
        System.out.println(Character.isUpperCase('B'));
        System.out.println(Character.isWhitespace('\n'));
        System.out.println();

        //zm�na velikosti p�smene
        char c14, d14 = 'A';
        c14 = Character.toLowerCase(d14);
        System.out.println(d14 + " --> " + c14);
        d14 = '\u00FD';
        c14 = Character.toUpperCase(d14);
        System.out.println(d14 + " --> " + c14);
        System.out.println();

        //p�evod jednotliv�ch znak� na ��sla
        int i15 = Character.digit('5', 10);
        int j15 = Character.digit('F', 16);
        int k15 = Character.digit('\u0BE7', 10);
        System.out.println("i15 = " + i15 + ", j15 = " + j15 + ", k15 = " + k15);
    }
}
