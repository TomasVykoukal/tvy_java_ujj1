package org.example;

//20.6.7 synchronizace �asov� posloupnosti vl�ken (producent - konzument)
//20.7.3 vl�kna typu d�mon
public class Kap_20_ProducentDae extends Thread {
    private Kap_20_CteniDae c;

    Kap_20_ProducentDae(Kap_20_CteniDae c) {
        this.c = c;
    }

    //zde prob�h� cyklus vol�n� na��t�n� za sou�asn�ho vyhodnocov�n� INTERRUPTED()
    public void run() {
        //while (!interrupted()) { - �prava pro Dae
        while (true) {
            this.c.nacti();
        }
        //System.out.println("   " + this.c.jmenoSouboru + " - konec �ten�  "); - �prava pro Dae (unreachable statement)
    }
}
