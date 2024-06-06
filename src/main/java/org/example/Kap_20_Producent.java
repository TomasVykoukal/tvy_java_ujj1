package org.example;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//Producent i Konzument jsou potomky tø. Thread => jejich inst. zaji¹»ují bìhy vláken, zejm. øízení cyklù.
//Ptz. obì pracují nad jedním obj. tø. Cteni, jsou pomocí met. WAIT() a NOTIFY*() volaných v této tøídì synchronizována vlákna vlPr# a vlKon#.
public class Kap_20_Producent extends Thread {
    private Kap_20_Cteni c;

    Kap_20_Producent(Kap_20_Cteni c) {
        this.c = c;
    }

    //zde probíhá cyklus volání naèítání za souèasného vyhodnocování INTERRUPTED()
    public void run() {
        while (!interrupted()) {
            this.c.nacti();
        }
        System.out.println("   " + this.c.jmenoSouboru + " - konec ètení  ");
    }
}
