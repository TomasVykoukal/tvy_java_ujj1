package org.example;

class Nasobeni_Hodn {
    public static int nasobDvema(int i) {return i*2;}
    public int nasobTremi(int i) {return i*3;}
}

public class Kap_10_Hodnotou {
    public static void main(String[] args) {
        int prvni = 5, druhy = 7;
        Nasobeni_Hodn n = new Nasobeni_Hodn();
        prvni = Nasobeni_Hodn.nasobDvema(prvni);
        druhy = n.nasobTremi(druhy);
        System.out.println("první: " + prvni + ", druhý: " + druhy);
    }
}
