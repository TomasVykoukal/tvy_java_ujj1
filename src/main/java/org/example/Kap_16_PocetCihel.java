package org.example;

public class Kap_16_PocetCihel {
    public static void main(String[] args) {
        System.out.print("Zadej poèet cihel: ");
        int i = Kap_4_VstupInt.ctiInt();
        System.out.println("poèet cihel = " + i);
    }
}
/*výpis e.printStackTrace():
    Zadej poèet cihel: hodnì
    Èíslo For input string: "hodnì" nebylo zadáno dobøe.
    poèet cihel = 0
    java.lang.NumberFormatException: For input string: "hodnì"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        at java.base/java.lang.Integer.parseInt(Integer.java:668)
        at java.base/java.lang.Integer.valueOf(Integer.java:995)
        at org.example.Kap_4_VstupInt.ctiInt(Kap_4_VstupInt.java:14)
        at org.example.Kap_16_PocetCihel.main(Kap_16_PocetCihel.java:6)
*/