package org.example;

public class Kap_8_Pokus {
    public int promInstance;
    public static int promTridy;

    public Kap_8_Pokus(int promInstance, int promTridy) {
        this.promInstance = promInstance; //standard pro přístup k proměnným INSTANCE ve TŘÍDĚ (inst. a její ref. prom. ještě neex.)
        this.promTridy = promTridy; //techn. možné ale nedoporučeníhodné
        Kap_8_Pokus.promTridy = promTridy; //standard pro přístup k proměnným TŘÍDY ve TŘÍDĚ
    }

    public static void main(String[] args) {
        Kap_8_Pokus p = new Kap_8_Pokus(1, 2);
        System.out.println(p.promInstance); //standard pro přístup k proměnným INSTANCE v INSTANCI (mimo deklaraci třídy)
        System.out.println(Kap_8_Pokus.promTridy); //standard pro přístup k proměnným TŘÍDY v INSTANCI (mimo deklaraci třídy)
        //System.out.println(promInstance); //java: non-static variable promInstance cannot be referenced from a static context
        System.out.println(promTridy); //techn. možné ale méně přehledné
    }
}
