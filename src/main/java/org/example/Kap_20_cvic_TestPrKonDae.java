package org.example;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//20.7.3 vlákna typu démon
public class Kap_20_cvic_TestPrKonDae {
    public static void main(String[] args) {
        Kap_20_cvic_CteniDae ct1        = new Kap_20_cvic_CteniDae("20_6_7_data10.txt");
        Kap_20_cvic_ProducentDae vlPr1  = new Kap_20_cvic_ProducentDae(ct1);
        Kap_20_cvic_KonzumentDae vlKon1 = new Kap_20_cvic_KonzumentDae(ct1);

        Kap_20_cvic_CteniDae ct2        = new Kap_20_cvic_CteniDae("20_6_7_data20.txt");
        Kap_20_cvic_ProducentDae vlPr2  = new Kap_20_cvic_ProducentDae(ct2);
        Kap_20_cvic_KonzumentDae vlKon2 = new Kap_20_cvic_KonzumentDae(ct2);

        vlPr1.setDaemon(true); //úprava (pøídavek) pro Dae
        vlPr1.start();
        vlKon1.start();

        vlPr2.setDaemon(true); //úprava (pøídavek) pro Dae
        vlPr2.start();
        vlKon2.start(); //dtto
    }
}
