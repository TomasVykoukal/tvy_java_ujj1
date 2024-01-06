package org.example;

class Pomocna_melka {
    double d;
    Pomocna_melka(double d) {this.d = d;}
}

public class Kap_11_KopieMelka implements Cloneable {
    int i;
    Pomocna_melka dTrida;

    Kap_11_KopieMelka(int i, Pomocna_melka dt) {
        this.i = i;
        this.dTrida = dt;
    }

    protected Object clone() {
        Kap_11_KopieMelka k = null;
        try {
            k = (Kap_11_KopieMelka) super.clone();
            k.i = this.i;
            k.dTrida = this.dTrida;
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return k;
    }

    public static void main(String[] args) {
        Pomocna_melka p = new Pomocna_melka(3.14);
        Kap_11_KopieMelka kopie, orig = new Kap_11_KopieMelka(5, p);
        kopie = (Kap_11_KopieMelka) orig.clone();
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
