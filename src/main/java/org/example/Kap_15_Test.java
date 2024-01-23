package org.example;

//vnit�n� t��dy
class Usecka {
    int delka;
    Usecka(int delka) {this.delka = delka;}

    //1. implementace rozhran� pomoc� metody vyu��vaj�c� vnit�n� t��du
    public Kap_13_Info informace_1() { //tato metoda vrac� referenci na rozhran� Info, kter� je reprezentov�no nov�m objektem/instanc� t��dy UseckaInfo
        return new UseckaInfo();
    }

    //2. implementace rozhran� pomoc� metody vyu��vaj�c� anonymn� vnit�n� t��du
    public Kap_13_Info informace_2() {
        return new Kap_13_Info() { //definice anonymn� t��dy (m�sto uveden� identifik�toru jinde definovan� pojmenovan� t��dy)
                                   //zde se vyr�b� instance rozhran�; "konstruktor" Kap_13_Info(); n�sleduje t�lo implementovan�ho rozhran�
            public void kdoJsem() {
                System.out.println("�se�ka d�lky " + delka);
            }
        }; //konec p��kazu RETURN, proto st�edn�k
    }

    //3. prom�nn� typu rozhran� vyu��vaj�c� anonymn� vnit�n� t��du
    public Kap_13_Info i_3 = new Kap_13_Info() {
        public void kdoJsem() {
            System.out.println("�se�ka d�lky " + delka);
        }
    }; //konec deklarace prom�nn� i_3, proto st�edn�k

    class UseckaInfo implements Kap_13_Info { //vnit�n� t��da (x statick� vno�en� t��da)
        public void kdoJsem() {
            System.out.println("�se�ka d�lky " + delka);
        }
    }
}

public class Kap_15_Test {
    public static void main(String[] args) {
        Usecka u_1 = new Usecka(5);
        Usecka u_2 = new Usecka(55);
        Usecka u_3 = new Usecka(555);

        //u_1.kdoJsem(); //Cannot resolve method 'kdoJsem' in 'Usecka'
                         //t�. Usecka neimplementuje rozhran� Kap_13_Info tj. ani metodu kdoJsem()
        //Kap_13_Info i = u_1; //Required type: Kap_13_Info / Provided: Usecka
                               //doporu�en� IDE: Cast expression to 'org.example.Kap_13_Info'
                               //p���ina probl�mu: t�. Usecka neimplementuje rozhran� Kap_13_Info
        //Kap_13_Info i = (Kap_13_Info) u_1;
            //chyba nikoliv b�hem kompilace ale b�hu:
            //Exception in thread "main" java.lang.ClassCastException: class org.example.Usecka cannot be cast to class org.example.Kap_13_Info (org.example.Usecka and org.example.Kap_13_Info are in unnamed module of loader 'app')
            //at org.example.Kap_15_Test.main(Kap_15_Test.java:27)
            //mo�n� p���ina probl�mu: instance t��dy je p�etypov�na na rozhran�, kter� neimplementuje
        //... analogick� situace ve t�. Kap_13_ObdelnikDalsi.java
        //u_2.kdoJsem(); //Cannot resolve method 'kdoJsem' in 'Usecka'
                         //dtto jako v��e

        Kap_13_Info i_1 = u_1.informace_1();
        Kap_13_Info i_2 = u_2.informace_2();

        i_1.kdoJsem();
        i_2.kdoJsem();
        u_3.i_3.kdoJsem();

        System.out.println();
        if (u_1 instanceof  Kap_13_Info) {System.out.println("u_1 implementuje Info");} //ne
        if (i_1 instanceof Kap_13_Info) {System.out.println("i_1 implementuje Info");} //ano
        if (i_1 instanceof Kap_13_Info) {System.out.println(i_1.getClass().getName() + " implementuje Info");} //ano

        if (u_2 instanceof  Kap_13_Info) {System.out.println("u_2 implementuje Info");} //ne
        if (i_2 instanceof Kap_13_Info) {System.out.println("i_2 implementuje Info");} //ano
        if (i_2 instanceof Kap_13_Info) {System.out.println(i_2.getClass().getName() + " implementuje Info");} //ano

        if (u_3 instanceof Kap_13_Info) {System.out.println("u_3 implementuje Info");} //ne
        if (u_3.i_3 instanceof Kap_13_Info) {System.out.println("u_3.i_3 implementuje Info");} //ano
        if (u_3.i_3 instanceof Kap_13_Info) {System.out.println(u_3.i_3.getClass().getName() + " implementuje Info");} //ano
    }
}
