package org.example;

class IntADouble {
    private int i;
    private double d;

    IntADouble(int i, double d) {this.i = i; this.d = d;}

    public void vypis() {
        System.out.println("i = " + this.i + ", d = " + this.d);
    }
}

public class Kap_10_PoleObjektu {
    public static void main(String[] args) {
        IntADouble[] louka; //1. deklarace ref. proměnné na pole objektů typu IntADouble
        louka = new IntADouble[5]; //2. vytvoří pole referencí(!) na objekty typu IntADouble a přiřadí jej do ref. proměnné louka
        for (int j = 0; j < louka.length; j++) {
            //3. pro jednotl. prvky pole louka volá konstruktor IntADouble(), kterým se vytvoří jednotl. objekty typu IntADouble
            louka[j] = new IntADouble(j, (double) (j*2));
        }
        for (int j = 0; j < louka.length; j++) {
            louka[j].vypis();
        }
    }
}
