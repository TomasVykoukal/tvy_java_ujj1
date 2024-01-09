package org.example;

import org.example.editor.Kap_12_AProt;

public class Kap_12_ABProt extends org.example.editor.Kap_12_AProt {
    //PROTECTED: přístup v podtřídě v jiném balíku => ANO
    int j;
    Kap_12_ABProt() {
        super.i = 1;
        this.j = getI();
    }

    //[private] int getI() {return this.i;} //private n. bez specifikátoru nelze - zeslabení přístupových práv z protected; protected n. public lze - rozšíření příst. práv
                                            //java: getI() in org.example.Kap_12_ABProt cannot override getI() in org.example.editor.Kap_12_AProt
                                            //attempting to assign weaker access privileges; was protected

    //nezpochybnitelný test funkčnosti
    public static void main(String[] args) {
        Kap_12_ABProt ABProt = new Kap_12_ABProt();
        System.out.println("(super) i: " + ABProt.i + ", (this) j: " + ABProt.j);
    }
}

