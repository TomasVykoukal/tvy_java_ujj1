package org.example;

//13.4 implementace více rozhraní jednou tøídou
public class Kap_13_KouleDalsi implements Kap_13_Info, Kap_13_InfoDalsi {
    int polomer;
    Kap_13_KouleDalsi(int polomer) {this.polomer = polomer;}

    public void kdoJsem() {
        System.out.print("Koule (dal¹í)");
    } //implementace z rozhraní Info
    public void vlastnosti() {
        System.out.println(" = " + this.polomer);
    } //implementace z rozhraní InfoDalsi

    //èást spoleèná pro Kap_13_UseckaDalsi a Kap_13_KouleDalsi
    public static void main(String[] args) {
        //13.4 implementace více rozhraní jednou tøídou
        Kap_13_UseckaDalsi u = new Kap_13_UseckaDalsi(5);
        Kap_13_KouleDalsi  k = new Kap_13_KouleDalsi(3);
        u.kdoJsem();
        u.vlastnosti();
        k.kdoJsem();
        k.vlastnosti();
        System.out.println();

        //(13.3 pou¾ití rozhraní jako typu referenèní promìnné)
        //13.5 instance rozhraní mù¾e vyu¾ívat jen metody rozhraní
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
