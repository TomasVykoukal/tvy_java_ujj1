package org.example;
import java.io.*;

//kompletní o¹etøení výjimky
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
            System.out.println("Chyba pøi ètení");
            return -1;
        }
        catch (NumberFormatException e) {
            System.out.println("Chyba formátu");
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.print("Zadej poèet cihel: ");
        int i = ctiInt();
        if (i != -1) {
            System.out.println("Cihel je: " + i);
        }
    }
}
