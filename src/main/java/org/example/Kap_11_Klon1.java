package org.example;

public class Kap_11_Klon1 {
    int i;
    Kap_11_Klon1(int i) {this.i = i;}

    public static void main(String[] args) throws CloneNotSupportedException {
        Kap_11_Klon1 kopie, orig = new Kap_11_Klon1(5);
        kopie = (Kap_11_Klon1) orig.clone();
        System.out.println("orig:  " + orig.i);
        System.out.println("kopie: " + kopie.i);
    }
}
/*
Exception in thread "main" java.lang.CloneNotSupportedException: org.example.Kap_11_Klon1
	at java.base/java.lang.Object.clone(Native Method)
	at org.example.Kap_11_Klon1.main(Kap_11_Klon1.java:9)
*/