package org.example;
import java.io.*;

public class Kap_16_TryFin {
    public static void main(String[] args) throws IOException {
        File frJm = new File("a.txt");
        FileInputStream fr = new FileInputStream(frJm);
        int c;

        try {
            while ((c = fr.read()) != -1) {
                if (c != 'K')
                    System.out.print((char)c);
                else
                    return;
            }
        }
        finally {
            System.out.println("Soubor uzavøen");
            fr.close();
        }
    }
}
