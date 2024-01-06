package org.example;

class Rodic_final_met {
    public int i;
    public Rodic_final_met() {i = 1;}
    final int getI() {return i;} //final => metodu nelze v odvozených třídách překrýt (přetížit ano)
}

public class Kap_11_Potomek_final_met extends Rodic_final_met {
    //int getI() {return i * 2;} //java: getI() in org.example.Kap_11_Potomek_final_met cannot override getI() in org.example.Rodic_final_met
                               //  overridden method is final
    public static void main(String[] args) {
        Kap_11_Potomek_final_met pot = new Kap_11_Potomek_final_met();
        System.out.println("Hodnota je: " + pot.getI());
    }
}
