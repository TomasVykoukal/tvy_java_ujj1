package org.example;

public class Kap_7_cviceni {

    //cvičení 1
    public static void eratosthenes(int n) {
        boolean[] sito = new boolean[n+1];
        //inicializace
        for (int i = 2; i < (n+1); i++) {
            sito[i] = true;
            //System.out.print(i + ": " + sito[i] + ", "); //unit test
        }
        //zjištění //ToDo: optimalizace (viz https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
        for (int i = 2; i < (n+1); i++) {
            for (int j = i+1; j < (n+1); j++) {
                if (j % i == 0) {
                    sito[j] = false;
                }
            }
        }
        //výpis (+ kontrola)
        for (int i = 2; i < (n+1); i++) {
            System.out.println(i + ": " + sito[i] + " // KO: " + (Kap_6_cviceni.jePrvocislo(i) ? " JE prvočíslo" : " NENÍ prvočíslo"));
        }
    }

    //cvičení 2, 3, 4 -> viz main()

    public static void main(String[] args) {
        //cvičení 1
        /*System.out.print("Zadej celé číslo pro zjištění prvočísel (Eratosthenovo síto): ");
        eratosthenes(Kap_4_VstupInt.ctiInt());*/

        //cvičení 2
        /*System.out.print("Zadejte celé číslo LONG: ");
        long cislo2 = Kap_4_VstupLong.ctiLong();
        String str2 = Long.toString(cislo2);
        System.out.println("Bylo zadáno číslo " + cislo2 + " o délce " + str2.length() + ".");
        for (int i = 0; i < str2.length(); i++)
            System.out.print(str2.charAt(i) + "  ");
        System.out.println();*/

        //cvičení 3
        //zdroj: http://fyzika.jreichl.com/main.article/view/1321-prevod-cisla-z-dekadicke-soustavy-do-soustavy-o-jinem-zakladu
        System.out.print("Zadejte celé číslo INT: ");
        int cislo_vstup = Kap_4_VstupInt.ctiInt();
        int cislo_mezist = cislo_vstup;
        int vysl_celocis = cislo_vstup;
        int zbytek = 0;
        String bin = "";
        do {
            //krok dělení
            vysl_celocis = cislo_mezist / (int) 2;
            zbytek = cislo_mezist % (int) 2;
            //krok zpracování a přípravy další iterace
            bin = zbytek + bin;
            cislo_mezist = vysl_celocis;
        } while (vysl_celocis != 0);
        System.out.println("binární zápis vypočtený: " + bin + " (" + bin.length() + ")");
        System.out.println("binární zápis knihovní:  " + Integer.toBinaryString(cislo_vstup));

        //cvičení 4
        System.out.print("Zadejte celé číslo LONG: ");
        long cislo_bin4 = Kap_4_VstupLong.ctiLong();
        String str4 = Long.toString(cislo_bin4);
        int mocnitel4;
        int cislo_dec_m4 = 0; //mezivýpočet
        int cislo_dec4 = 0;
        System.out.println("Bylo zadáno číslo " + cislo_bin4 + " o délce " + str4.length() + ".");
        System.out.print("Průběh výpočtu: ");
        for (int i = 0; i < str4.length(); i++) {
            mocnitel4 = str4.length() - 1 - i;
            cislo_dec_m4 = ((int) Math.pow((double) 2, (double) mocnitel4)) * (str4.charAt(i) == '0' ? 0 : 1);
            cislo_dec4 = cislo_dec4 + cislo_dec_m4;
            //průběh výpočtu
            System.out.print(i + "/" + mocnitel4 + "/" + cislo_dec_m4 + "/" + cislo_dec4 + "  ");

            //test způsobů převodu CHAR na INT
            /*System.out.print(str4.charAt(i) + "/"); //-> textový znak
            System.out.print(Integer.valueOf(str4.charAt(i)).intValue() + "/"); //-> ASCII hodnota znaku
            System.out.print(Character.getNumericValue(str4.charAt(i)) + "/"); //-> číselná hodnota znaku
            System.out.print(Integer.parseInt(String.valueOf(str4.charAt(i))) + "  "); //-> dito*/
        }
        System.out.println();
        System.out.println("dekadický zápis vypočtený: " + cislo_dec4);
    }
}