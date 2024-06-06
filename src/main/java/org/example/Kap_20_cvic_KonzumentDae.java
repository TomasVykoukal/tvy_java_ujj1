package org.example;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//20.7.3 vlákna typu démon
public class Kap_20_cvic_KonzumentDae extends Thread {
    private Kap_20_cvic_CteniDae c;
    private int suma = 0;

    Kap_20_cvic_KonzumentDae(Kap_20_cvic_CteniDae c) {
        this.c = c;
    }

    //zde probíhá cyklus volání pøedávky za souèasného vyhodnocování INTERRUPTED()
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
        System.out.println("   " + this.c.jmenoSouboru + " - výsledná suma: " + this.suma);
    }
}
