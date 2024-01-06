package org.example;

public class Kap_11_cvic_Motocykl extends Kap_11_cvic_1stopeVozidlo {
    //typy motocykl�: supersportovn�, expedi�n�, cestovn�, silni�n�, do 125 ccm, sk�try a ter�nn�
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
        System.out.println("druh 1-stop�ho vozidla: " + this.getDruh());
        System.out.println("typ motocyklu: " + this.getTyp());
        System.out.println("obsah n�dr�e: " + this.getObsahNadrze() + " ccm");
    }

    public static void main(String[] args) {
        Kap_11_cvic_Motocykl motorka = new Kap_11_cvic_Motocykl("silni�n�", 1250);
        motorka.vypisCoJsiZac();
    }
}
