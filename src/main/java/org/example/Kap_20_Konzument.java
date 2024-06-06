package org.example;

//20.6.7 synchronizace �asov� posloupnosti vl�ken (producent - konzument)
//Producent i Konzument jsou potomky t�. Thread => jejich inst. zaji��uj� b�hy vl�ken, zejm. ��zen� cykl�.
//Ptz. ob� pracuj� nad jedn�m obj. t�. Cteni, jsou pomoc� met. WAIT() a NOTIFY*() volan�ch v t�to t��d� synchronizov�na vl�kna vlPr# a vlKon#.
public class Kap_20_Konzument extends Thread {
    private Kap_20_Cteni c;
    private int suma = 0;

    Kap_20_Konzument(Kap_20_Cteni c) {
        this.c = c;
    }

    //zde prob�h� cyklus vol�n� p�ed�vky za sou�asn�ho vyhodnocov�n� INTERRUPTED()
    public void run() {
        int cislo;
        while (true) {
            cislo = this.c.predej();
            if (!interrupted()) {
                this.suma += cislo;
            }
            else {
                break;
            }
        }
        System.out.println("   " + this.c.jmenoSouboru + " - v�sledn� suma: " + this.suma);
    }
}
