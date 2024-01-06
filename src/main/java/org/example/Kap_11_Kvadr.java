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

public class Kap_11_Kvadr extends Obdelnik { //{odvozená|zdìdìná|dceøinná} tøída/potomek tøídy Obdelnik
    public int hloubka;

    public Kap_11_Kvadr(int sirka, int vyska, int hloubka) {
        super(sirka, vyska); //volání konstruktoru rodièovské tøídy (super + skut. param. konstr. rodièovské tøídy)
        this.hloubka = hloubka;
    }

    public double delkaUhlopricky() { //pøekrytí/zastínìní metody delkaUhlopricky
        double pom = super.delkaUhlopricky(); //volání pøekryté metody z rodièovské tøídy (klíè. slovo super pou¾ité nyní jako jméno objektu)
        pom = Math.pow(pom, 2) + Math.pow(hloubka, 2);
        return Math.sqrt(pom);
    }

    public static void main(String[] args) {
        Kap_11_Kvadr kva = new Kap_11_Kvadr(6, 8, 10);
        System.out.println("¹íøka / vý¹ka / hloubka: " + kva.hodnotaSirky() + " / " + kva.vyska + " / " + kva.hloubka);
        System.out.println("Uhlopøíèka: " + kva.delkaUhlopricky());
    }
}
