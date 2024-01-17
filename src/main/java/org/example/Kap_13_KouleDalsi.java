package org.example;

//13.4 implementace v�ce rozhran� jednou t��dou
public class Kap_13_KouleDalsi implements Kap_13_Info, Kap_13_InfoDalsi {
    int polomer;
    Kap_13_KouleDalsi(int polomer) {this.polomer = polomer;}

    public void kdoJsem() {
        System.out.print("Koule (dal��)");
    } //implementace z rozhran� Info
    public void vlastnosti() {
        System.out.println(" = " + this.polomer);
    } //implementace z rozhran� InfoDalsi

    //��st spole�n� pro Kap_13_UseckaDalsi a Kap_13_KouleDalsi
    public static void main(String[] args) {
        //13.4 implementace v�ce rozhran� jednou t��dou
        Kap_13_UseckaDalsi u = new Kap_13_UseckaDalsi(5);
        Kap_13_KouleDalsi  k = new Kap_13_KouleDalsi(3);
        u.kdoJsem();
        u.vlastnosti();
        k.kdoJsem();
        k.vlastnosti();
        System.out.println();

        //(13.3 pou�it� rozhran� jako typu referen�n� prom�nn�)
        //13.5 instance rozhran� m��e vyu��vat jen metody rozhran�
        Kap_13_Info      i  = new Kap_13_UseckaDalsi(2);
        Kap_13_InfoDalsi id = new Kap_13_UseckaDalsi(2);

        i.kdoJsem();
        //i.vlastnosti(); //Cannot resolve method 'vlastnosti' in 'Kap_13_Info'

        //id.kdoJsem(); //Cannot resolve method 'kdoJsem' in 'Kap_13_InfoDalsi'
        id.vlastnosti();

        //System.out.println(i.getDelka()); //Cannot resolve method 'getDelka' in 'Kap_13_Info'
        //System.out.println(id.getDelka()); //Cannot resolve method 'getDelka' in 'Kap_13_Info'
    }
}
