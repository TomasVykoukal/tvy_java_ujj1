package org.example;

public class Kap_16_PocetCihel {
    public static void main(String[] args) {
        System.out.print("Zadej po�et cihel: ");
        int i = Kap_4_VstupInt.ctiInt();
        System.out.println("po�et cihel = " + i);
    }
}
/*v�pis e.printStackTrace():
    Zadej po�et cihel: hodn�
    ��slo For input string: "hodn�" nebylo zad�no dob�e.
    po�et cihel = 0
    java.lang.NumberFormatException: For input string: "hodn�"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        at java.base/java.lang.Integer.parseInt(Integer.java:668)
        at java.base/java.lang.Integer.valueOf(Integer.java:995)
        at org.example.Kap_4_VstupInt.ctiInt(Kap_4_VstupInt.java:14)
        at org.example.Kap_16_PocetCihel.main(Kap_16_PocetCihel.java:6)
*/