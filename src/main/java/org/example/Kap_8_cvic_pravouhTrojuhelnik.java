package org.example;

public class Kap_8_cvic_pravouhTrojuhelnik {
    //cvičení 5
    private int stranaA;
    private int stranaB;
    private double stranaC;

    public Kap_8_cvic_pravouhTrojuhelnik (int stranaA, int stranaB) {
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.stranaC = delkaPrepony();
    }

    public double delkaPrepony() {
        return Math.sqrt(Math.pow(this.stranaA, 2) + Math.pow(this.stranaB, 2));
    }

    public void vypisUdaje() {
        System.out.println("pravoúhlý trojúhelník přep. A: " + this.stranaA + ", přep. B: " + this.stranaB + ", přep.: " + this.stranaC);
    }

    //cvičení 6

    public static void main(String[] args) {
        Kap_8_cvic_pravouhTrojuhelnik pravTrojuh = new Kap_8_cvic_pravouhTrojuhelnik(4, 5);
        pravTrojuh.vypisUdaje();
    }
}
