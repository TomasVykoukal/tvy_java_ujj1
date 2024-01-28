package org.example;
import java.io.*;

//podmno�ina �. 2 (kompletn� o�et�en� v�jimky) - specifika viz n�e
public class Kap_16_Vyjimka_2_2 {
    public static int ctiInt() {
        byte[] pole = new byte[20];
        String nacteno;
        int i = 0;

        try {
            System.in.read(pole);
            nacteno = new String(pole).trim();
            i = Integer.valueOf(nacteno).intValue();
        }
        catch (IOException e) {
            //��dn� k�d //naprosto nejhor�� reakce na v�jimku
            e.printStackTrace(); //rozumn� reakce na v�jimku
        }
        catch (NumberFormatException e) {
            //��dn� k�d //naprosto nejhor�� reakce na v�jimku
            e.printStackTrace(); //rozumn� reakce na v�jimku

            //dal�� metody
            String msg = e.getMessage();
            System.out.println("getMessage: " + msg);
            msg = e.getLocalizedMessage();
            System.out.println("getLocalizedMessage: " + msg);
            msg = e.toString();
            System.out.println("e.toString: " + msg);
            msg = e.getClass().toString();
            System.out.println("getClass().toString(): " + msg);
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.print("Zadej po�et cihel: ");
        int i = ctiInt();
        System.out.println("Cihel je: " + i);
    }
}
