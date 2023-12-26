package org.example;

public class Kap_8_cvic_pravouhTrojuhelnik {
    //cvièení 5
    private int stranaA;
    private int stranaB;
    private double stranaC;

    public Kap_8_cvic_pravouhTrojuhelnik (int stranaA, int stranaB) {
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.stranaC = delkaPrepony();
    }

    //cvièení 6
    public Kap_8_cvic_pravouhTrojuhelnik () {
        this.stranaA = 1;
        this.stranaB = 1;
        this.stranaC = delkaPrepony();
    }
    public double delkaPrepony() {
        return Math.sqrt(Math.pow(this.stranaA, 2) + Math.pow(this.stranaB, 2));
    }

    public double obsah() {
        return (this.stranaA * this.stranaB) / 2.0; //nutný desetinný zápis, jinak celoèíselné dìlení (a výsledek neúplný)
    }
    public void vypisUdaje() {
        System.out.println("pravoúhlý trojúhelník pøep. A: " + this.stranaA + ", pøep. B: " + this.stranaB + ", pøep.: " + this.stranaC);
    }

    public static void main(String[] args) {
        Kap_8_cvic_pravouhTrojuhelnik pravTrojuh = new Kap_8_cvic_pravouhTrojuhelnik(4, 5);
        pravTrojuh.vypisUdaje();
        System.out.println("obsah 3úhelníka: " + pravTrojuh.obsah());
        Kap_8_cvic_pravouhTrojuhelnik pravTrojuh2 = new Kap_8_cvic_pravouhTrojuhelnik();
        pravTrojuh2.vypisUdaje();
        System.out.println("obsah 3úhelníka: " + pravTrojuh2.obsah());
    }
}
