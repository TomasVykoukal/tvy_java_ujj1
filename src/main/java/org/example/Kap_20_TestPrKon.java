package org.example;

//20.6.7 synchronizace èasové posloupnosti vláken (producent - konzument)
//centrální tøída; vytvoøí inst. Cteni a odkaz na ni pøedá objektu  tøídy Producent i Konzument
public class Kap_20_TestPrKon {
    public static void main(String[] args) {
        Kap_20_Cteni ct1        = new Kap_20_Cteni("20_6_7_data10.txt");
        Kap_20_Producent vlPr1  = new Kap_20_Producent(ct1);
        Kap_20_Konzument vlKon1 = new Kap_20_Konzument(ct1);

        Kap_20_Cteni ct2        = new Kap_20_Cteni("20_6_7_data20.txt");
        Kap_20_Producent vlPr2  = new Kap_20_Producent(ct2);
        Kap_20_Konzument vlKon2 = new Kap_20_Konzument(ct2);

        vlPr1.start();
        vlKon1.start(); //zámìrnì pozdìji ne¾ producent

        vlPr2.start();
        vlKon2.start(); //dtto
    }
}
//todo mo¾ný test: zajistit správné støídání výpisu dvou slov pomocí zde realizovaného øe¹ení

/*Producent - - - - - - - - - - - - - - - - - - - - - - -> Konzument
  ----------------------------------------------------------------------------------------------------------------------------
  1. PØPRAVÍ (DAL©Í) DATA a ...                            èeká WAIT()
     uvìdomí k. o pøipravenosti nových dat NOTIFY[ALL]()   "
  ----------------------------------------------------------------------------------------------------------------------------
  2. èeká WAIT()                                           ZKONZUMUJE DATA a ...
     "                                                     uvìdomí p., ¾e mù¾e pokraèovat v pøípravì dal¹ích dat NOTIFY[ALL]()
  ----------------------------------------------------------------------------------------------------------------------------
*/
