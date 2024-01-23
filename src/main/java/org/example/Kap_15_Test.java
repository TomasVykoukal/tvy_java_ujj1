package org.example;

//vnitøní tøídy
class Usecka {
    int delka;
    Usecka(int delka) {this.delka = delka;}

    //1. implementace rozhraní pomocí metody vyu¾ívající vnitøní tøídu
    public Kap_13_Info informace_1() { //tato metoda vrací referenci na rozhraní Info, které je reprezentováno novým objektem/instancí tøídy UseckaInfo
        return new UseckaInfo();
    }

    //2. implementace rozhraní pomocí metody vyu¾ívající anonymní vnitøní tøídu
    public Kap_13_Info informace_2() {
        return new Kap_13_Info() { //definice anonymní tøídy (místo uvedení identifikátoru jinde definované pojmenované tøídy)
                                   //zde se vyrábí instance rozhraní; "konstruktor" Kap_13_Info(); následuje tìlo implementovaného rozhraní
            public void kdoJsem() {
                System.out.println("úseèka délky " + delka);
            }
        }; //konec pøíkazu RETURN, proto støedník
    }

    //3. promìnná typu rozhraní vyu¾ívající anonymní vnitøní tøídu
    public Kap_13_Info i_3 = new Kap_13_Info() {
        public void kdoJsem() {
            System.out.println("Úseèka délky " + delka);
        }
    }; //konec deklarace promìnné i_3, proto støedník

    class UseckaInfo implements Kap_13_Info { //vnitøní tøída (x statická vnoøená tøída)
        public void kdoJsem() {
            System.out.println("úseèka délky " + delka);
        }
    }
}

public class Kap_15_Test {
    public static void main(String[] args) {
        Usecka u_1 = new Usecka(5);
        Usecka u_2 = new Usecka(55);
        Usecka u_3 = new Usecka(555);

        //u_1.kdoJsem(); //Cannot resolve method 'kdoJsem' in 'Usecka'
                         //tø. Usecka neimplementuje rozhraní Kap_13_Info tj. ani metodu kdoJsem()
        //Kap_13_Info i = u_1; //Required type: Kap_13_Info / Provided: Usecka
                               //doporuèení IDE: Cast expression to 'org.example.Kap_13_Info'
                               //pøíèina problému: tø. Usecka neimplementuje rozhraní Kap_13_Info
        //Kap_13_Info i = (Kap_13_Info) u_1;
            //chyba nikoliv bìhem kompilace ale bìhu:
            //Exception in thread "main" java.lang.ClassCastException: class org.example.Usecka cannot be cast to class org.example.Kap_13_Info (org.example.Usecka and org.example.Kap_13_Info are in unnamed module of loader 'app')
            //at org.example.Kap_15_Test.main(Kap_15_Test.java:27)
            //mo¾ná pøíèina problému: instance tøídy je pøetypována na rozhraní, které neimplementuje
        //... analogická situace ve tø. Kap_13_ObdelnikDalsi.java
        //u_2.kdoJsem(); //Cannot resolve method 'kdoJsem' in 'Usecka'
                         //dtto jako vý¹e

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
