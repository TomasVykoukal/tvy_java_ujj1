package org.example;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//20.7.3 vlákna typu démon
public class Kap_20_cvic_ProducentDae extends Thread {
    private Kap_20_cvic_CteniDae c;

    Kap_20_cvic_ProducentDae(Kap_20_cvic_CteniDae c) {
        this.c = c;
    }

    //zde probíhá cyklus volání naèítání za souèasného vyhodnocování INTERRUPTED()
    public void run() {
        //while (!interrupted()) { - úprava pro Dae
        while (true) {
            this.c.nacti();
        }
        //System.out.println("   " + this.c.jmenoSouboru + " - konec ètení  "); - úprava pro Dae (unreachable statement kvùli cyklu vý¹e; jinak u¾iteèný krok)
    }
}
