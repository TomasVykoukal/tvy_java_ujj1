package org.example;
import java.io.*;

public class Kap_4_VstupFloat {
    public static float ctiFloat(){
        byte[] pole = new byte[20];
        String nacteno;
        float f;

        try {
            System.in.read(pole);
            nacteno = new String(pole).trim();
            f = Float.valueOf(nacteno).floatValue();
            return f;
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
        float f = ctiFloat();
        System.out.println("f = " + f);
    }
}
