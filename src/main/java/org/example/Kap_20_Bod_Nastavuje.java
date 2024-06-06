package org.example;

//20.6.5 kritické sekce - synchronizované metody: zkouška fungování dle str. 331
public class Kap_20_Bod_Nastavuje extends Thread {
    public static int MaxHodnota = 1_000_000;
    private Kap_20_Bod b;

    public Kap_20_Bod_Nastavuje(Kap_20_Bod bod) {
        b = bod;
    }

    public void run() {
        for (int i = 1; i <= MaxHodnota; i++) {
            b.nastav(i, i);
            System.out.println("i " + i);
        }
        //Thread.currentThread().interrupt();
    }
}
