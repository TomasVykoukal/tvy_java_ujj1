package org.example;
//Při využití dědičnosti musíme dát VŽDY možnost, aby byl vyvolán konstruktor rodiče:
//- v rodiči konstr. bez param. n. implicitní => konstr. v potomkovi může být implicitní
//- v rodiči konstr. alespoň s 1 param. => konstr. v potomkovi MUSÍ existovat a jako 1. příkaz MUSÍ volat pomocí super(...) konstr. rodiče

class Rodic_konstr {
    public int i;
    public Rodic_konstr(int parI) { i = parI; } //konstruktor s parametrem (a konstr. bez param. zakomentován) => tř. Potomek musí mí svůj konstruktor, z něhož pomocí super() vyvolá konstr. předka
                                                //není-li:
                                                //  java: constructor Rodic_konstr in class org.example.Rodic_konstr cannot be applied to given types;
                                                //    required: int
                                                //    found:    no arguments
                                                //    reason: actual and formal argument lists differ in length
    public Rodic_konstr() {i = 5;} //konstruktor bez parametrů => tř. Potomek nemusí mít žádný konstruktor
}

public class Kap_11_Potomek_konstr extends Rodic_konstr {

    /*public Kap_11_Potomek_konstr() {
        super(8);
    }*/
    public static void main(String[] args) {
        Kap_11_Potomek_konstr pot = new Kap_11_Potomek_konstr();
        System.out.println(pot.toString() + " / pot.i = " + pot.i);
    }
}
