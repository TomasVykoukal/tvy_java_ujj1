package org.example;

//pøíkazy IMPORT se vlo¾ily samy bìhem kódování pøísl. tøíd (IDE IntelliJ IDEA 2023.2.5 (Community Edition))
//øe¹il by jediný import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Kap_16_TryCatchFin {
    public static long vypisSoubor(String jmeno) throws IOException {
        File frJmeno = new File(jmeno);
        FileInputStream fr = null;
        try {
            fr = new FileInputStream(frJmeno);
            for (int i = 0; i < frJmeno.length(); i++) {
                System.out.print((char)fr.read());
            }
            //throw new ArithmeticException();
            return frJmeno.length();
        }
        catch (FileNotFoundException e) {
            System.out.println("Soubor neotevøen");
            throw  e;
        }
        finally {
            System.out.println("Konec");
            if (fr != null)
                fr.close();
        }
    }

    public static void main(String[] args) {
        try {
            long delka = vypisSoubor("Kap_16_TestBankomatu.java");
            System.out.println("Délka souboru: " + delka);
        }
        catch (FileNotFoundException e) { }
        catch (IOException e) {}
    }
}
