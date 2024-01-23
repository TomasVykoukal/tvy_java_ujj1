package org.example;

//13.7 d�d�n� t��dy a sou�asn� implementace rozhran�
public class Kap_13_ObdelnikDalsi extends Kap_13_Usecka implements Kap_13_InfoDalsi {
    int sirka;
    Kap_13_ObdelnikDalsi (int delka, int sirka) {
        super(delka);
        this.sirka = sirka;
    }

    public void kdoJsem() {System.out.print("Obd�ln�k");}
    public void vlastnosti() {System.out.println(" = " + this.delka + " (d�lka), " + this.sirka + " (���ka)");}

    public void vypisSirka() {System.out.println(this.sirka);} //metoda mimo rozhran�

    public static void main(String[] args) {
        Kap_13_ObdelnikDalsi o   = new Kap_13_ObdelnikDalsi(2, 4);
        Kap_13_Info          io  = new Kap_13_ObdelnikDalsi(3, 6);
        Kap_13_InfoDalsi     iod = new Kap_13_ObdelnikDalsi(5, 7);

        o.kdoJsem();
        o.vlastnosti();

        io.kdoJsem();
        ((Kap_13_ObdelnikDalsi) io).vlastnosti();

        ((Kap_13_ObdelnikDalsi) iod).kdoJsem();
        iod.vlastnosti();

        //Kap_13_InfoDalsi idu = new Kap_13_Usecka(6); //Required type: Kap_13_InfoDalsi / Provided: Kap_13_Usecka
                                                       //doporu�en� IDE: Cast expression to 'org.example.Kap_13_InfoDalsi'
                                                       //p���ina probl�mu: t�. Kap_13_Usecka neimplementuje rozhran� Kap_13_InfoDalsi
        //Kap_13_InfoDalsi idu = (Kap_13_InfoDalsi) new Kap_13_Usecka(6);
            //chyba nikoliv b�hem kompilace ale b�hu:
            //Exception in thread "main" java.lang.ClassCastException: class org.example.Kap_13_Usecka cannot be cast to class org.example.Kap_13_InfoDalsi (org.example.Kap_13_Usecka and org.example.Kap_13_InfoDalsi are in unnamed module of loader 'app')
            //at org.example.Kap_13_ObdelnikDalsi.main(Kap_13_ObdelnikDalsi.java:32)
            //mo�n� p���ina probl�mu: instance t��dy je p�etypov�na na rozhran�, kter� neimplementuje
        Kap_13_InfoDalsi iud = new Kap_13_UseckaDalsi(6); //bez probl�mu: t�. Kap_13_InfoDalsi implementuje rozhran� Kap_13_InfoDalsi

        //metoda mimo rozhran�
        o.vypisSirka();
        ((Kap_13_ObdelnikDalsi) io).vypisSirka();
        ((Kap_13_ObdelnikDalsi) iod).vypisSirka();
    }
}
