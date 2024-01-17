package org.example;

//cvičení 1
public class Kap_13_cvic_Ctverec implements Kap_13_cvic_Zobrazitelny {
    int sirka;
    int vyska;
    public Kap_13_cvic_Ctverec(int sirka, int vyska) {
        this.sirka = sirka;
        this.vyska = vyska;
    }

    public void zobraz() {
        for (int v = 1; v <= this.vyska; v++) {
            for (int s = 1; s <= this.sirka; s++) {
                System.out.print("* ");
            }
            System.out.println('\b');
        }
    }

    public static void main(String[] args) {
        Kap_13_cvic_Ctverec c = new Kap_13_cvic_Ctverec(7, 5);
        c.zobraz();
    }
}
