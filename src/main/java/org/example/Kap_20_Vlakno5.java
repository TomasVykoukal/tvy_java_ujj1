package org.example;

//20.4 rozhraní Runnable
public class Kap_20_Vlakno5 implements Runnable {
    //toto je odli¹né oproti dìdìní od tøídy Thread - zaèátek
    private Thread zobrazV1 = null;

    public void start() {
        zobrazV1 = new Thread(this);
        zobrazV1.start();
    }
    //toto je odli¹né oproti dìdìní od tøídy Thread - konec

    public void run() {
        while (!Kap_20_ReadV1.hotovo) {
            System.out.print("Prùbì¾né údaje - ");
            System.out.print("èíslo: " + Kap_20_ReadV1.cislo + ", ");
            System.out.println("souèet: " + Kap_20_ReadV1.suma + "\r");
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException e) {}
        }
        System.out.print("KONEÈNÉ ÚDAJE  - ");
        System.out.print("ÈÍSLO: " + Kap_20_ReadV1.cislo + ", ");
        System.out.println("SOUÈET: " + Kap_20_ReadV1.suma + "\r");
    }

    public static void main(String[] args) {
        Kap_20_ReadV1 vlCteni = new Kap_20_ReadV1("20_2_data.txt");
        vlCteni.start();

        Kap_20_Vlakno5 vlVypis = new Kap_20_Vlakno5();
        vlVypis.start();
    }
}
