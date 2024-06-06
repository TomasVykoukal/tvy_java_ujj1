package org.example;

import java.io.IOException;

//20.5 čekání na vstup či výstup (další část -> Kap_20_Vlakno7)
public class Kap_20_Vstup extends Thread {
    static public boolean hotovo = false;

    public void run() {
        byte[] pole = new byte[10];
        Thread.currentThread().setPriority(MAX_PRIORITY);
        while (!hotovo) {
            try {
                System.in.read(pole);
                if (pole[0] == 'K') {
                    hotovo = true;
                }
            }
            catch (IOException e) {
                System.out.println("Chyba vstupu");
            }
        }
    }
}
