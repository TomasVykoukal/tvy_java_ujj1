package org.example;

//13.2 pou�it� jednoho rozhran�
public class Kap_13_Koule implements Kap_13_Info {
    int polomer;
    Kap_13_Koule(int polomer) {this.polomer = polomer;}

    public void kdoJsem() {
        System.out.println("Koule; polom�r = " + this.polomer);
    }

    //metoda pro test 13.3.1 n�e
    public void mimoRozhr() { System.out.println("metoda mimo rozhran� (koule)"); }

    //��st spole�n� pro Kap_13_Usecka a Kap_13_Koule
    public static void main(String[] args) {
        //13.2 pou�it� jednoho rozhran�
        Kap_13_Usecka u = new Kap_13_Usecka(5);
        Kap_13_Koule  k = new Kap_13_Koule(3);
        u.kdoJsem();
        k.kdoJsem();
        System.out.println();

        //13.3 pou�it� rozhran� jako typu referen�n� prom�nn�
        Kap_13_Info i = new Kap_13_Usecka(50);
        i.kdoJsem();
        System.out.println();

        //13.3.1 pokusy o p��stup k prom�nn�m a metod�m t��dy ale mimo definici rozhran� a jejich �e�en� p�etypov�n�m
        //System.out.println("p��stup k prom. d�lka �se�ky: " + i.delka); //Cannot resolve symbol 'delka'
        System.out.println("p��stup k prom. d�lka �se�ky: " + ((Kap_13_Usecka) i).delka);
        //i.mimoRozhr(); //Cannot resolve method 'mimoRozhr' in 'Kap_13_Info'
                         //doporu�en� IDE: Cast qualifier to 'org.example.Kap_13_Usecka'
        ((Kap_13_Usecka) i).mimoRozhr();
        System.out.println();

        //13.3 ...
        i = k;
        i.kdoJsem();
        System.out.println();

        //13.3.1 ...
        //System.out.println("p��stup k prom. polom�r koule: " + i.polomer); //Cannot resolve symbol 'polomer'
        System.out.println("p��stup k prom. polom�r koule: " + ((Kap_13_Koule) i).polomer);
        //i.mimoRozhr(); //Cannot resolve method 'mimoRozhr' in 'Kap_13_Info'
                         //doporu�en� IDE: ��dn�; na�ept�va� p��mo nab�z� pro i metodu mimoRozhr() s automatick�m dopln�n�m p�etypov�n�
        ((Kap_13_Koule) i).mimoRozhr();
    }
}
