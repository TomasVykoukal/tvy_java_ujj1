package org.example;

class Pomocna_hash {
    double d;
    Pomocna_hash(double d) {this.d = d;}
}

public class Kap_11_Hash {
    public static void main(String[] args) {
        Pomocna_hash p1 = new Pomocna_hash(3.14);
        System.out.println("p1: " + p1.hashCode());
        Pomocna_hash p2 = new Pomocna_hash(3.14);
        System.out.println("p2: " + p2.hashCode());
        p1.d = p1.d * 2;
        System.out.println("p1: " + p1.hashCode());

        Integer i1 = new Integer(5);
        Integer i2 = new Integer(5);
        Byte b = new Byte((byte) 5);
        System.out.println("i1: " + i1.hashCode());
        System.out.println("i2: " + i2.hashCode());
        System.out.println("b:  " + b.hashCode());
    }
}
