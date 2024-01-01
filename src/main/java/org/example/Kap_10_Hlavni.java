package org.example;

class B { //modifikátor PUBLIC nemá => mù¾e le¾et v souboru spoleènì s jinou tøídou
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
