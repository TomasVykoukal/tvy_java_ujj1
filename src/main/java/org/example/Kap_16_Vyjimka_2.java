package org.example;
import java.io.*;

//kompletn� o�et�en� v�jimky
public class Kap_16_Vyjimka_2 {
    public static int ctiInt() {
        byte[] pole = new byte[20];
        String nacteno;
        int i;

        try {
            System.in.read(pole);
            nacteno = new String(pole).trim();
            i = Integer.valueOf(nacteno).intValue();
            return i;
        }
        catch (IOException e) {
            System.out.println("Chyba p�i �ten�");
            return -1;
        }
        catch (NumberFormatException e) {
            System.out.println("Chyba form�tu");
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.print("Zadej po�et cihel: ");
        int i = ctiInt();
        if (i != -1) {
            System.out.println("Cihel je: " + i);
        }
    }
}
