package org.example;

class B { //modifik�tor PUBLIC nem� => m��e le�et v souboru spole�n� s jinou t��dou
    int b;
    public B(int par) {this.b = par;}
    public void setB (int par) {this.b = par;}
    public int getB() {return this.b;}
}
public class Kap_10_Hlavni {
    public static void main(String[] args) {
        B b = new B(3);
        Kap_10_A a = new Kap_10_A(5);
        System.out.println("a = " + a.getA() + ", b = " + b.getB());
    }
}
