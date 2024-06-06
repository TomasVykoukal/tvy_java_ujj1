package org.example;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//20.7.3 vlákna typu démon
public class Kap_20_TestPrKonDae {
    public static void main(String[] args) {
        Kap_20_CteniDae ct1        = new Kap_20_CteniDae("20_6_7_data10.txt");
        Kap_20_ProducentDae vlPr1  = new Kap_20_ProducentDae(ct1);
        Kap_20_KonzumentDae vlKon1 = new Kap_20_KonzumentDae(ct1);

        Kap_20_CteniDae ct2        = new Kap_20_CteniDae("20_6_7_data20.txt");
        Kap_20_ProducentDae vlPr2  = new Kap_20_ProducentDae(ct2);
        Kap_20_KonzumentDae vlKon2 = new Kap_20_KonzumentDae(ct2);

        vlPr1.setDaemon(true); //úprava (pøídavek) pro Dae; Vysvìtlení k poloze viz ní¾e
        vlPr1.start();
        vlKon1.start();

        vlPr2.setDaemon(true); //dtto
        vlPr2.start();
        vlKon2.start();
    }
}
/*Vysvìtlení:
  This method must be invoked before the thread is started.
    public final void setDaemon(boolean on) { ...
    if (isAlive()) {throw new IllegalThreadStateException();} ...
*/