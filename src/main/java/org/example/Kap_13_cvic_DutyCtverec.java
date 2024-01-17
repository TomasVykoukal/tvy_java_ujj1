package org.example;

//cvièení 2
public class Kap_13_cvic_DutyCtverec extends Kap_13_cvic_Ctverec {

    public Kap_13_cvic_DutyCtverec(int sirka, int vyska) {
        super(sirka, vyska);
    }

    public void zobraz() {
        if (this.sirka < 3 || this.vyska < 3) { //náhradní øe¹ení za TRY-CATCH
            System.out.println("Rozmìry ètverce jsou nevyhovující.");
            return;
        }
        for (int v = 1; v <= this.vyska; v++) {
            for (int s = 1; s <= this.sirka; s++) {
                if (v > 1 & v < this.vyska & s > 1 & s < this.sirka) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println('\b');
        }
    }

    public static void main(String[] args) {
        Kap_13_cvic_DutyCtverec dc = new Kap_13_cvic_DutyCtverec(7, 5);
        dc.zobraz();
    }
}
