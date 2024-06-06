package org.example;

//20.6.5 kritické sekce - synchronizované metody: zkouška fungování dle str. 331 a dodatečných tříd ze zdrojových programů
//info: lépší řízení vláken, synchronizace --> viz 20.6.7
public class Kap_20_Bod_Cte extends Thread {
    private Kap_20_Bod b;
    private int[] sour = {0, 0};

    public Kap_20_Bod_Cte(Kap_20_Bod bod) {
        b = bod;
    }

    public void run() {
        do {
            sour = b.cti();
            if (sour[0] != sour[1]) {
                System.out.println("x = " + sour[0] + ", y = " + sour[1]);
            }
            else {
                System.out.println(sour[0]);
            }
        } while ((sour[0] < Kap_20_Bod_Nastavuje.MaxHodnota) || (sour[1] < Kap_20_Bod_Nastavuje.MaxHodnota));
    }

    public static void main(String[] args) {
        Kap_20_Bod bod         = new Kap_20_Bod();
        Kap_20_Bod_Nastavuje n = new Kap_20_Bod_Nastavuje(bod);
        Kap_20_Bod_Cte c       = new Kap_20_Bod_Cte(bod);

        //obě vlákna po spuštění fungují na sobě zcela nezávisle
        n.start();
        c.start();
    }
}
