package org.example;

public class Kap_11_Klon2 implements Cloneable {
    int i;
    Kap_11_Klon2(int i) {this.i = i;}

    protected Object clone() {
        Kap_11_Klon2 k = null;
        try {
            k = (Kap_11_Klon2) super.clone();
            k.i = this.i;
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return k;
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        Kap_11_Klon2 kopie, orig = new Kap_11_Klon2(5);
        kopie = (Kap_11_Klon2) orig.clone();
        System.out.println("orig:  " + orig.i);
        System.out.println("kopie: " + kopie.i);
    }
}
