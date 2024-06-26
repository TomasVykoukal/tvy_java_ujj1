package org.example;

//20.6.7 synchronizace �asov� posloupnosti vl�ken (producent - konzument)
//20.7.3 vl�kna typu d�mon
public class Kap_20_cvic_KonzumentDae extends Thread {
    private Kap_20_cvic_CteniDae c;
    private int suma = 0;

    Kap_20_cvic_KonzumentDae(Kap_20_cvic_CteniDae c) {
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
