package org.example;

//20.6.7 synchronizace �asov� posloupnosti vl�ken (producent - konzument)
//centr�ln� t��da; vytvo�� inst. Cteni a odkaz na ni p�ed� objektu  t��dy Producent i Konzument
public class Kap_20_TestPrKon {
    public static void main(String[] args) {
        Kap_20_Cteni ct1        = new Kap_20_Cteni("20_6_7_data10.txt");
        Kap_20_Producent vlPr1  = new Kap_20_Producent(ct1);
        Kap_20_Konzument vlKon1 = new Kap_20_Konzument(ct1);

        Kap_20_Cteni ct2        = new Kap_20_Cteni("20_6_7_data20.txt");
        Kap_20_Producent vlPr2  = new Kap_20_Producent(ct2);
        Kap_20_Konzument vlKon2 = new Kap_20_Konzument(ct2);

        vlPr1.start();
        vlKon1.start(); //z�m�rn� pozd�ji ne� producent

        vlPr2.start();
        vlKon2.start(); //dtto
    }
}
//todo mo�n� test: zajistit spr�vn� st��d�n� v�pisu dvou slov pomoc� zde realizovan�ho �e�en�

/*Producent - - - - - - - - - - - - - - - - - - - - - - -> Konzument
  ----------------------------------------------------------------------------------------------------------------------------
  1. P�PRAV� (DAL��) DATA a ...                            �ek� WAIT()
     uv�dom� k. o p�ipravenosti nov�ch dat NOTIFY[ALL]()   "
  ----------------------------------------------------------------------------------------------------------------------------
  2. �ek� WAIT()                                           ZKONZUMUJE DATA a ...
     "                                                     uv�dom� p., �e m��e pokra�ovat v p��prav� dal��ch dat NOTIFY[ALL]()
  ----------------------------------------------------------------------------------------------------------------------------
*/
