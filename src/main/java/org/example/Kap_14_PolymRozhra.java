package org.example;

//realizace polymorfismu pomocí implementace rozhraní
class Clovek implements Kap_14_Vazitelny {
    int vaha;
    String profese;

    Clovek(String povolani, int vaha) {
        this.profese = new String(povolani);
        this.vaha = vaha;
    }

    public void vypisHmotnost() {
        System.out.println(this.profese + ": " + this.vaha);
    }

    public int getHmotnost() {return vaha;}
}

class Zvire implements Kap_14_Vazitelny {
    int vaha;
    String druh;
    Zvire(String druh, int vaha) {
        this.druh = druh;
        this.vaha = vaha;
    }

    public void vypisHmotnost() {
        System.out.println(this.druh + ": " + this.vaha);
    }

    public int getHmotnost() {return this.vaha;}
}

class Kufr implements Kap_14_Vazitelny {
    int vaha;
    Kufr(int vaha) {this.vaha = vaha;}

    public void vypisHmotnost() {
        System.out.println("kufr: " + this.vaha);
    }

    public int getHmotnost() {return this.vaha;}
}

public class Kap_14_PolymRozhra {
    public static void main(String[] args) {
        int vahaLidi = 0;
        Kap_14_Vazitelny[] kusJakoKus = new Kap_14_Vazitelny[7];
        kusJakoKus[0] = new Clovek("programátor", 100);
        kusJakoKus[1] = new Zvire("koèka", 2);
        kusJakoKus[2] = new Kufr(20);
        kusJakoKus[3] = new Clovek("modelka", 51);
        kusJakoKus[4] = new Kufr(8);
        kusJakoKus[5] = new Clovek("dùchodkynì", 75);
        kusJakoKus[6] = new Zvire("pun»a", 6);

        System.out.println("ÈD - individuální pøístup");
        for (int i = 0; i < kusJakoKus.length; i++) {
            kusJakoKus[i].vypisHmotnost();
            if (!(kusJakoKus[i] instanceof Kufr)) {
                vahaLidi += kusJakoKus[i].getHmotnost();
                //vahaLidi += ((Clovek) kusJakoKus[i]).getHmotnost(); //díky nápravì chyby v návrhu není nutné pøetypování
            }
        }
        System.out.println("¾ivá váha: " + vahaLidi);
    }
}
