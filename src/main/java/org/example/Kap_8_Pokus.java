package org.example;

public class Kap_8_Pokus {
    public static int promTridy;
    public int promInstance;

    public Kap_8_Pokus(int promInstance, int promTridy) {
        this.promInstance = promInstance; //standard pro p��stup k prom�nn�m INSTANCE ve T��D� (inst. a jej� ref. prom. je�t� neex.)
        this.promTridy = promTridy; //techn. mo�n� ale nedoporu�en�hodn�
        Kap_8_Pokus.promTridy = promTridy; //standard pro p��stup k prom�nn�m T��DY ve T��D�
    }

    public static void main(String[] args) {
        Kap_8_Pokus p = new Kap_8_Pokus(1, 2);
        System.out.println(p.promInstance); //standard pro p��stup k prom�nn�m INSTANCE v INSTANCI (mimo deklaraci t��dy)
        System.out.println(Kap_8_Pokus.promTridy); //standard pro p��stup k prom�nn�m T��DY v INSTANCI (mimo deklaraci t��dy)
        //System.out.println(promInstance); //java: non-static variable promInstance cannot be referenced from a static context
        System.out.println(promTridy); //techn. mo�n� ale m�n� p�ehledn�
    }
}
