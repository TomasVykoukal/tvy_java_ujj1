package org.example;

public class Kap_11_cvic_Motocykl extends Kap_11_cvic_1stopeVozidlo {
    //typy motocyklù: supersportovní, expedièní, cestovní, silnièní, do 125 ccm, skútry a terénní
    private String typ;
    private int obsahNadrze;

    public void setTyp(String typ) {
        this.typ = typ;
    }
    public void setObsahNadrze(int obsahNadrze) {
        this.obsahNadrze = obsahNadrze;
    }

    public String getTyp() {
        return typ;
    }
    public int getObsahNadrze() {
        return obsahNadrze;
    }

    public Kap_11_cvic_Motocykl(String typ, int obsahNadrze) {
        super("motocykl");
        this.typ = typ;
        this.obsahNadrze = obsahNadrze;
    }

    public void vypisCoJsiZac() {
        System.out.println(this.toString());
        System.out.println(this.getClass().getName() + " (<-- " + this.getClass().getSuperclass().getName() + ")");
        System.out.println("druh 1-stopého vozidla: " + this.getDruh());
        System.out.println("typ motocyklu: " + this.getTyp());
        System.out.println("obsah nádr¾e: " + this.getObsahNadrze() + " ccm");
    }

    public static void main(String[] args) {
        Kap_11_cvic_Motocykl motorka = new Kap_11_cvic_Motocykl("silnièní", 1250);
        motorka.vypisCoJsiZac();
    }
}
