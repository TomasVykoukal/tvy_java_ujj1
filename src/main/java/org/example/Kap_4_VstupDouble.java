package org.example;
import java.io.*;

public class Kap_4_VstupDouble {
    public static double ctiDouble(){
        byte[] pole = new byte[20];
        String nacteno;
        double d;

        try {
            System.in.read(pole);
            nacteno = new String(pole).trim();
            d = Double.valueOf(nacteno).doubleValue();
            return d;
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
    public static void main(String[] args){
        System.out.print("Zadej reálné číslo: ");
        double d = ctiDouble();
        System.out.println("d = " + d);
    }
}
