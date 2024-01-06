package org.example;

class Rodic_GetClass {
    public int i;
    public Rodic_GetClass() {this.i = 1;}
}

public class Kap_11_Potomek_GetClass extends Rodic_GetClass{
    public static void main(String[] args) {
        Kap_11_Potomek_GetClass dite = new Kap_11_Potomek_GetClass();
        System.out.println("Jméno tøídy: " + dite.getClass().getName());
        System.out.println("Jméno rodièovské tøídy: " + dite.getClass().getSuperclass().getName());
        System.out.println("Jméno prarodiè. tøídy: " + dite.getClass().getSuperclass().getSuperclass().getName());

        //System.out.println(dite.getClass().get...());
    }
}
