package org.example;

public class Kap_10_TestBankomatu {
    public static void main(String[] args) {
        Kap_10_Bankomat b = new Kap_10_Bankomat();
        //b.penize = 5000; //'penize' has private access in 'org.example.Kap_10_Bankomat'
        b.setPenize(-5);
        b.setPenize(1000);
        System.out.println("vybr�no: " + b.getPenize(200));
    }
}
