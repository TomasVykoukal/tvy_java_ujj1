package org.example;

public class Kap_8_Pokus {
    public static int promTridy;
    public int promInstance;

    public Kap_8_Pokus(int promInstance, int promTridy) {
        this.promInstance = promInstance; //standard pro pøístup k promìnným INSTANCE ve TØÍDÌ (inst. a její ref. prom. je¹tì neex.)
        this.promTridy = promTridy; //techn. mo¾né ale nedoporuèeníhodné
        Kap_8_Pokus.promTridy = promTridy; //standard pro pøístup k promìnným TØÍDY ve TØÍDÌ
    }

    public static void main(String[] args) {
        Kap_8_Pokus p = new Kap_8_Pokus(1, 2);
        System.out.println(p.promInstance); //standard pro pøístup k promìnným INSTANCE v INSTANCI (mimo deklaraci tøídy)
        System.out.println(Kap_8_Pokus.promTridy); //standard pro pøístup k promìnným TØÍDY v INSTANCI (mimo deklaraci tøídy)
        //System.out.println(promInstance); //java: non-static variable promInstance cannot be referenced from a static context
        System.out.println(promTridy); //techn. mo¾né ale ménì pøehledné
    }
}
