package org.example;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//Producent i Konzument jsou potomky tø. Thread => jejich inst. zaji¹»ují bìhy vláken, zejm. øízení cyklù.
//Ptz. obì pracují nad jedním obj. tø. Cteni, jsou pomocí met. WAIT() a NOTIFY*() volaných v této tøídì synchronizována vlákna vlPr# a vlKon#.
public class Kap_20_Konzument extends Thread {
    private Kap_20_Cteni c;
    private int suma = 0;

    Kap_20_Konzument(Kap_20_Cteni c) {
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
