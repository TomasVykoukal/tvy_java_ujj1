package org.example;

//20.4 rozhran� Runnable
public class Kap_20_Vlakno5 implements Runnable {
    //toto je odli�n� oproti d�d�n� od t��dy Thread - za��tek
    private Thread zobrazV1 = null;

    public void start() {
        zobrazV1 = new Thread(this);
        zobrazV1.start();
    }
    //toto je odli�n� oproti d�d�n� od t��dy Thread - konec

    public void run() {
        while (!Kap_20_ReadV1.hotovo) {
            System.out.print("Pr�b�n� �daje - ");
            System.out.print("��slo: " + Kap_20_ReadV1.cislo + ", ");
            System.out.println("sou�et: " + Kap_20_ReadV1.suma + "\r");
            try {
                Thread.sleep(5);
            }
            catch (InterruptedException e) {}
        }
        System.out.print("KONE�N� �DAJE  - ");
        System.out.print("��SLO: " + Kap_20_ReadV1.cislo + ", ");
        System.out.println("SOU�ET: " + Kap_20_ReadV1.suma + "\r");
    }

    public static void main(String[] args) {
        Kap_20_ReadV1 vlCteni = new Kap_20_ReadV1("20_2_data.txt");
        vlCteni.start();

        Kap_20_Vlakno5 vlVypis = new Kap_20_Vlakno5();
        vlVypis.start();
    }
}
