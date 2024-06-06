package org.example;

//20.6.7 synchronizace �asov� posloupnosti vl�ken (producent - konzument)
//Producent i Konzument jsou potomky t�. Thread => jejich inst. zaji��uj� b�hy vl�ken, zejm. ��zen� cykl�.
//Ptz. ob� pracuj� nad jedn�m obj. t�. Cteni, jsou pomoc� met. WAIT() a NOTIFY*() volan�ch v t�to t��d� synchronizov�na vl�kna vlPr# a vlKon#.
public class Kap_20_Producent extends Thread {
    private Kap_20_Cteni c;

    Kap_20_Producent(Kap_20_Cteni c) {
        this.c = c;
    }

    //zde prob�h� cyklus vol�n� na��t�n� za sou�asn�ho vyhodnocov�n� INTERRUPTED()
    public void run() {
        while (!interrupted()) {
            this.c.nacti();
        }
        System.out.println("   " + this.c.jmenoSouboru + " - konec �ten�  ");
    }
}
