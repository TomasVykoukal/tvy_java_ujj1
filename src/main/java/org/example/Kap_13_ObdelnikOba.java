package org.example;

//13.8 dìdìní rozhraní a konstanty rozhraní
public class Kap_13_ObdelnikOba extends Kap_13_Usecka implements Kap_13_InfoOba {
    int sirka;
    Kap_13_ObdelnikOba (int delka, int sirka) {
        super(delka);
        this.sirka = sirka;
    }

    public void kdoJsem() { System.out.print(POCET + " Obdélník"); }
    public void vlastnosti() { System.out.println(" = " + delka + ", " + sirka); }

    public static void main(String[] args) {
        Kap_13_Info      i  = new Kap_13_ObdelnikOba(3, 6);
        Kap_13_InfoDalsi id = new Kap_13_ObdelnikOba(5, 7);
        Kap_13_InfoOba   io = new Kap_13_ObdelnikOba(2, 4);

        i.kdoJsem();
        ((Kap_13_ObdelnikOba) i).vlastnosti();

        ((Kap_13_ObdelnikOba) id).kdoJsem();
        id.vlastnosti();

        io.kdoJsem();
        io.vlastnosti();

        System.out.println("Poèet rozhraní = " + POCET); //zde pøímo pøístupná, jinak pou¾ít celé jméno (Kap_13_InfoOba.POCET)
        System.out.println();

        //13.9 vyu¾ití operátoru INSTANCEOF
        Kap_13_Usecka      u = new Kap_13_Usecka(5);
        Kap_13_ObdelnikOba o = new Kap_13_ObdelnikOba(3, 6);
        //hierarchie: Kap_13_ObdelnikOba << Kap_13_Usecka (<Kap_13_Info) < Kap_13_InfoOba

        if (u instanceof Kap_13_Info) {System.out.println("u implementuje Info");}       //ano
        if (o instanceof Kap_13_Info) {System.out.println("o implementuje Info");}       //ano (pøes úseèku)
        if (u instanceof Kap_13_InfoOba) {System.out.println("u implementuje InfoOba");} //ne
        if (o instanceof Kap_13_InfoOba) {System.out.println("o implementuje InfoOba");} //ano

        if (u instanceof Kap_13_Usecka) {System.out.println("u je instancí Usecka");}    //ano
        //if (u instanceof Kap_13_UseckaDalsi) {System.out.println("u je instancí UseckaDalsi");} //java: incompatible types: org.example.Kap_13_Usecka cannot be converted to org.example.Kap_13_UseckaDalsi
        if (o instanceof Kap_13_Usecka) {System.out.println("o je instancí Usecka");}    //ano (pøes úseèku)
        //if (o instanceof Kap_13_Obdelnik) {System.out.println("o je instancí Obdelnik");} //java: incompatible types: org.example.Kap_13_ObdelnikOba cannot be converted to org.example.Kap_13_Obdelnik
        //if (o instanceof Kap_13_ObdelnikDalsi) {System.out.println("o je instancí ObdelnikDalsi");} //java: incompatible types: org.example.Kap_13_ObdelnikOba cannot be converted to org.example.Kap_13_ObdelnikDalsi
        if (o instanceof Kap_13_ObdelnikOba) {System.out.println("o je instancí ObdelnikOba");} //ano
    }
}
