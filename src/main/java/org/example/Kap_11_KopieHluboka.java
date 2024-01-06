package org.example;
//hluboká kopie: pro ka¾dou ref. promìnnou musíme vytvoøit obj. a pøekopírovat jeho obsah

class Pomocna_hluboka implements Cloneable {
    double d;
    Pomocna_hluboka(double d) {this.d = d;}

    protected Object clone() {
        Pomocna_hluboka k = null;
        try {
            k = (Pomocna_hluboka) super.clone();
            k.d = this.d;
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return k;
    }
}

public class Kap_11_KopieHluboka implements Cloneable {
    int i;
    Pomocna_hluboka dTrida;

    Kap_11_KopieHluboka(int i, Pomocna_hluboka dt) {
        this.i = i;
        this.dTrida = dt;
    }

    protected Object clone() {
        Kap_11_KopieHluboka k = null;
        try {
            k = (Kap_11_KopieHluboka) super.clone();
            k.i = this.i;
            k.dTrida = (Pomocna_hluboka) this.dTrida.clone();
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return k;
    }

    public static void main(String[] args) {
        Pomocna_hluboka p = new Pomocna_hluboka(3.14);
        Kap_11_KopieHluboka kopie, orig = new Kap_11_KopieHluboka(5, p);
        kopie = (Kap_11_KopieHluboka) orig.clone();
        System.out.println("Stav pøed zmìnou originálu:");
        System.out.println("orig:  " + orig.i + "; " + orig.dTrida.d);
        System.out.println("kopie: " + kopie.i + "; " + kopie.dTrida.d);
        orig.i = orig.i * 2;
        orig.dTrida.d = orig.dTrida.d * 2;
        System.out.println("Stav po zmìnì originálu:");
        System.out.println("orig:  " + orig.i + "; " + orig.dTrida.d);
        System.out.println("kopie: " + kopie.i + "; " + kopie.dTrida.d);
    }
}
