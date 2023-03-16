package org.example;

public class Kap_9_MujString {
    int hodnota;

    Kap_9_MujString(int h) {this.hodnota = h;}

    public String toString() {
        String jmenoTridy = new String(getClass().getName());
        //String jmenoTridy = getClass().getName();
        return ("[" + super.toString() + "] třída: " + jmenoTridy + " / stav: hodnota=" + this.hodnota);
    }

    void puvodniToString() {
        System.out.println(super.toString());
    }

    public static void main(String[] args) {
        Kap_9_MujString s1 = new Kap_9_MujString(5);
        s1.puvodniToString();
        System.out.println(s1.toString());
    }
}
