package org.example;

class Obdelnik {
    public int sirka;
    public int vyska;

    public Obdelnik(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
    }

    public double delkaUhlopricky() {
        double pom;
        pom = Math.pow(sirka, 2) + Math.pow(vyska, 2);
        return Math.sqrt(pom);
    }

    public int hodnotaSirky() {
        return sirka;
    }
}

public class Kap_11_Kvadr extends Obdelnik { //{odvozen�|zd�d�n�|dce�inn�} t��da/potomek t��dy Obdelnik
    public int hloubka;

    public Kap_11_Kvadr(int sirka, int vyska, int hloubka) {
        super(sirka, vyska); //vol�n� konstruktoru rodi�ovsk� t��dy (super + skut. param. konstr. rodi�ovsk� t��dy)
        this.hloubka = hloubka;
    }

    public double delkaUhlopricky() { //p�ekryt�/zast�n�n� metody delkaUhlopricky
        double pom = super.delkaUhlopricky(); //vol�n� p�ekryt� metody z rodi�ovsk� t��dy (kl��. slovo super pou�it� nyn� jako jm�no objektu)
        pom = Math.pow(pom, 2) + Math.pow(hloubka, 2);
        return Math.sqrt(pom);
    }

    public static void main(String[] args) {
        Kap_11_Kvadr kva = new Kap_11_Kvadr(6, 8, 10);
        System.out.println("���ka / v��ka / hloubka: " + kva.hodnotaSirky() + " / " + kva.vyska + " / " + kva.hloubka);
        System.out.println("Uhlop���ka: " + kva.delkaUhlopricky());
    }
}
