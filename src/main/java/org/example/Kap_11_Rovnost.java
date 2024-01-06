package org.example;

class Pomocna_rovnost {
    double d;
    Pomocna_rovnost(double d) {this.d = d;}
}

public class Kap_11_Rovnost {
    public static void main(String[] args) {
        Pomocna_rovnost p1 = new Pomocna_rovnost(3.14);
        System.out.print("jeden a tentý¾ objekt: ");
        if (p1.equals(p1)) System.out.println("p1 == p1");

        Pomocna_rovnost p2 = new Pomocna_rovnost(3.14);
        System.out.print("typovì a obsahovì stejné rùzné objekty: ");
        if (!p1.equals(p2)) System.out.println("p1 != p2");

        Pomocna_rovnost p3 = p1;
        System.out.print("rùzné ref. promìnné odkazující na tentý¾ objekt: ");
        if (p1.equals(p3)) System.out.println("p1 == p3");

        Double d1 = new Double(3.14);
        Double d2 = new Double(3.14);
        System.out.print("typovì a obsahovì stejné rùzné promìnné primitivního dat. typu: ");
        if (d1.equals(d2)) System.out.println("d1 == d2");
    }
}
