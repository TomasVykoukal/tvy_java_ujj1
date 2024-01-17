package org.example;

//cvičení 1
public class Kap_13_cvic_Usecka implements Kap_13_cvic_Zobrazitelny {
    private int delka;
    public Kap_13_cvic_Usecka(int delka) {
        this.delka = delka;
    }

    public void zobraz() {
        for (int i = 1; i <= this.delka; i++) {
            System.out.print("* ");
        }
        System.out.println('\b');
    }

    public static void main(String[] args) {
        Kap_13_cvic_Usecka u = new Kap_13_cvic_Usecka(7);
        u.zobraz();
    }
}
