package org.example;

//13.4 implementace více rozhraní jednou tøídou
public class Kap_13_UseckaDalsi implements Kap_13_Info, Kap_13_InfoDalsi {
    int delka;
    Kap_13_UseckaDalsi(int delka) {this.delka = delka;}

    public void kdoJsem() {
        System.out.print("Úseèka (dal¹í)");
    } //implementace z rozhraní Info
    public void vlastnosti() {
        System.out.println(" = " + this.delka);
    } //implementace z rozhraní InfoDalsi

    public int getDelka() { return delka; } //metoda mimo rozhraní
}
