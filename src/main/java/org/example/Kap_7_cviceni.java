package org.example;

public class Kap_7_cviceni {

    //cvièení 1
    public static void eratosthenes(int n) {
        boolean[] sito = new boolean[n+1];
        //inicializace
        for (int i = 2; i < (n+1); i++) {
            sito[i] = true;
            //System.out.print(i + ": " + sito[i] + (i < n ? "," + (i % 10 == 0 ? '\n' : ' ') : '\n')); //unit test
            //pozn.: èárka v uvozovkách, aby nedo¹lo k aritmetickému sèítání ',' + '\n'/' ' = "... true769: true7610: true5411: true7612: ..."
        }
        //zji¹tìní (info viz https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
        for (int i = 2; i < (n+1); i++) {
            if (sito[i]) { //optimalizace: zji¹»ování pouze pro prvoèísla
                //for (int j = i + 1; j < (n + 1); j++) {
                for (int j = i*i; j < (n + 1); j++) { //optimalizace: starting from prime's square
                //for (int j = (i*i < (n + 1) ? i*i : (n + 1)); j < (n + 1); j++) { //todo optimalizace: pøedejití "Index ... out of bounds for length ..." jinak max n cca 46.300
                    if (j % i == 0) {
                        sito[j] = false;
                    }
                }
            }
        }
        //výpis (a kontrola)
        for (int i = 2; i < (n+1); i++) {
            //System.out.println(i + ": " + sito[i] + " // KO: " + (Kap_6_cviceni.jePrvocislo(i) ? " JE prvoèíslo" : " NENÍ prvoèíslo"));
            if (sito[i] != Kap_6_cviceni.jePrvocislo(i))
                 System.out.println(i + ": " + sito[i] + " // KO: " + (Kap_6_cviceni.jePrvocislo(i) ? " JE prvoèíslo" : " NENÍ prvoèíslo") + " --> nesoulad");
        }
    }

    //cvièení 2, 3, 4 -> viz main()

    public static void main(String[] args) {
        //cvièení 1
        /*long cas_pred, cas_po;
        int erast;
        System.out.print("Zadej celé èíslo pro zji¹tìní prvoèísel (Eratosthenovo síto): ");
        erast = Kap_4_VstupInt.ctiInt();
        cas_pred = System.currentTimeMillis();
        eratosthenes(erast);
        cas_po = System.currentTimeMillis();
        System.out.println("délka zpracování (ms): " + (cas_po - cas_pred)); //10.000: 142 / 35 / 20 // 46.300: 2903 / 504 / 197
        */

        //cvièení 2
        /*System.out.print("Zadejte celé èíslo LONG: ");
        long cislo2 = Kap_4_VstupLong.ctiLong();
        String str2 = Long.toString(cislo2);
        System.out.println("Bylo zadáno èíslo " + cislo2 + " o délce " + str2.length() + ".");
        for (int i = 0; i < str2.length(); i++)
            System.out.print(str2.charAt(i) + "  ");
        System.out.println();*/

        //cvièení 3
        //zdroj: http://fyzika.jreichl.com/main.article/view/1321-prevod-cisla-z-dekadicke-soustavy-do-soustavy-o-jinem-zakladu
        /*System.out.print("Zadejte celé èíslo INT: ");
        int cislo_vstup = Kap_4_VstupInt.ctiInt();
        int cislo_mezist = cislo_vstup;
        int vysl_celocis = cislo_vstup;
        int zbytek = 0;
        String bin = "";
        do {
            //krok dìlení
            vysl_celocis = cislo_mezist / (int) 2;
            zbytek = cislo_mezist % (int) 2;
            //krok zpracování a pøípravy dal¹í iterace
            bin = zbytek + bin;
            cislo_mezist = vysl_celocis;
        } while (vysl_celocis != 0);
        System.out.println("binární zápis vypoètený: " + bin + " (" + bin.length() + ")");
        System.out.println("binární zápis knihovní:  " + Integer.toBinaryString(cislo_vstup));*/

        //cvièení 4
        System.out.print("Zadejte celé èíslo LONG: ");
        long cislo_bin4 = Kap_4_VstupLong.ctiLong();
        String str4 = Long.toString(cislo_bin4);
        int mocnitel4;
        int cislo_dec_m4 = 0; //mezivýpoèet
        int cislo_dec4 = 0;
        System.out.println("Bylo zadáno èíslo " + cislo_bin4 + " o délce " + str4.length() + ".");
        System.out.print("Prùbìh výpoètu: ");
        for (int i = 0; i < str4.length(); i++) {
            mocnitel4 = str4.length() - 1 - i;
            cislo_dec_m4 = ((int) Math.pow((double) 2, (double) mocnitel4)) * (str4.charAt(i) == '0' ? 0 : 1);
            cislo_dec4 = cislo_dec4 + cislo_dec_m4;
            //prùbìh výpoètu
            System.out.print(i + "/" + mocnitel4 + "/" + cislo_dec_m4 + "/" + cislo_dec4 + "  ");

            //test zpùsobù pøevodu CHAR na INT //todo: nechápu ...
            System.out.print(str4.charAt(i) + "/"); //-> textový znak
            System.out.print(Integer.valueOf(str4.charAt(i)).intValue() + "/"); //-> ASCII hodnota znaku
            System.out.print(Character.getNumericValue(str4.charAt(i)) + "/"); //-> èíselná hodnota znaku
            System.out.print(Integer.parseInt(String.valueOf(str4.charAt(i))) + "  "); //-> dito
        }
        System.out.println();
        System.out.println("dekadický zápis vypoètený: " + cislo_dec4);
    }
}