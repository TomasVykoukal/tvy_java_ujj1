package org.example;
import java.io.*;

public class Kap_4_VstupLong {
    public static long ctiLong() {
        byte[] pole = new byte[20];
        String nacteno;
        long i;

        try {
            System.in.read(pole);
            nacteno = new String(pole).trim();
            i = Long.valueOf(nacteno).longValue();
            return i;
        }
        catch (NumberFormatException e) {
            System.out.print("Číslo " + e.getMessage());
            System.out.println(" nebylo zadáno dobře.");
            return 0;
        }
        catch (IOException e) {
            System.out.println("Chyba čtení");
            return 0;
        }
    }
    public static void main(String[] args) {
        System.out.print("Zadej celé číslo LONG: ");
        long i = ctiLong();
        System.out.println("i = " + i);
    }
}

