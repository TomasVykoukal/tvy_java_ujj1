package org.example;

class Datum {
    //public int den, mesic, rok;
    private int den, mesic, rok;
    public Datum(int den, int mesic, int rok) {
        if (den >= 1 && den <= 31) //správnì obsah metody setDen
            this.den = den;
        this.mesic = mesic;
        this.rok = rok;
    }
    public Datum(Datum d) {
        this(d.den, d.mesic, d.rok);
    }
    public String toString() {
        StringBuffer b = new StringBuffer(100);
        b.append(this.den).append(".").append(this.mesic).append(".").append(this.rok);
        return b.toString();
    }
}

class Zamestnanec {
    public String jmeno;
    public Datum narozeni, nastup;

    public Zamestnanec(String jmeno, Datum narozeni, Datum nastup) {
        //varianta vlastní testovací
        this.jmeno = jmeno;
        this.narozeni = narozeni;
        this.nastup = nastup;
        //varianta dle knihy
        /*this.jmeno = new String(jmeno);
        this.narozeni = new Datum(narozeni);
        this.nastup = new Datum(nastup);*/
    }

    public String toString() {
        StringBuffer b = new StringBuffer(200);
        b.append(this.jmeno);
        b.append(", narozen: ").append(this.narozeni.toString());
        b.append("\nnastoupil: ").append(this.nastup.toString());
        return b.toString();
    }
}
public class Kap_10_Kompozice {
    public static void main(String[] args) {
        Datum narozeni = new Datum(25, 05, 1960);
        Zamestnanec zam = new Zamestnanec(
                "Josef Novák",
                narozeni, //varianta dle knihy
                //new Datum(narozeni), //varianta vlastní dle logiky viz vı¹e
                new Datum(01, 10, 1990)
        );
        System.out.println(zam.toString());
    }
}
