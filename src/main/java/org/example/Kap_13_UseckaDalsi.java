package org.example;

//13.4 implementace v�ce rozhran� jednou t��dou
public class Kap_13_UseckaDalsi implements Kap_13_Info, Kap_13_InfoDalsi {
    int delka;
    Kap_13_UseckaDalsi(int delka) {this.delka = delka;}

    public void kdoJsem() {
        System.out.print("�se�ka (dal��)");
    } //implementace z rozhran� Info
    public void vlastnosti() {
        System.out.println(" = " + this.delka);
    } //implementace z rozhran� InfoDalsi

    public int getDelka() { return delka; } //metoda mimo rozhran�
}
