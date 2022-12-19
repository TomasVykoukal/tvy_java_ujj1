package org.example;

public class Kap_8_Pokus {
    public int promInstance;
    public static int promTridy;

    public Kap_8_Pokus(int promInstance, int promTridy) {
        this.promInstance = promInstance;
        this.promTridy = promTridy; //možné ale nedoporučeníhodné
        Kap_8_Pokus.promTridy = promTridy;
    }

    public static void main(String[] args) {
        Kap_8_Pokus p = new Kap_8_Pokus(1, 2);
        System.out.println(p.promInstance + " " + Kap_8_Pokus.promTridy);
        //System.out.println(promInstance + " " + promTridy); //java: non-static variable promInstance cannot be referenced from a static context
    }
}
