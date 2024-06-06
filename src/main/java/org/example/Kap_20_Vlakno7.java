package org.example;

//20.5 čekání na vstup či výstup (další část -> Kap_20_Vstup)
public class Kap_20_Vlakno7 extends Thread {
    public void run() {
        long i = 0;
        while (!Kap_20_Vstup.hotovo) {
            System.out.print(i++ + "\r");
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Kap_20_Vstup vlVstup = new Kap_20_Vstup();
        vlVstup.start();
        Kap_20_Vlakno7 vlVypis = new Kap_20_Vlakno7();
        vlVypis.start();
    }
}
