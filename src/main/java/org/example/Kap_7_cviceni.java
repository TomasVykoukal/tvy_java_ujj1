package org.example;

public class Kap_7_cviceni {

    //cvi�en� 1
    public static void eratosthenes(int n) {
        boolean[] sito = new boolean[n+1];
        //inicializace
        for (int i = 2; i < (n+1); i++) {
            sito[i] = true;
            //System.out.print(i + ": " + sito[i] + (i < n ? "," + (i % 10 == 0 ? '\n' : ' ') : '\n')); //unit test
            //pozn.: ��rka v uvozovk�ch, aby nedo�lo k aritmetick�mu s��t�n� ',' + '\n'/' ' = "... true769: true7610: true5411: true7612: ..."
        }
        //zji�t�n� (info viz https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
        for (int i = 2; i < (n+1); i++) {
            if (sito[i]) { //optimalizace: zji��ov�n� pouze pro prvo��sla
                //for (int j = i + 1; j < (n + 1); j++) {
                for (int j = i*i; j < (n + 1); j++) { //optimalizace: starting from prime's square
                //for (int j = (i*i < (n + 1) ? i*i : (n + 1)); j < (n + 1); j++) { //todo optimalizace: p�edejit� "Index ... out of bounds for length ..." jinak max n cca 46.300
                    if (j % i == 0) {
                        sito[j] = false;
                    }
                }
            }
        }
        //v�pis (a kontrola)
        for (int i = 2; i < (n+1); i++) {
            //System.out.println(i + ": " + sito[i] + " // KO: " + (Kap_6_cviceni.jePrvocislo(i) ? " JE prvo��slo" : " NEN� prvo��slo"));
            if (sito[i] != Kap_6_cviceni.jePrvocislo(i))
                 System.out.println(i + ": " + sito[i] + " // KO: " + (Kap_6_cviceni.jePrvocislo(i) ? " JE prvo��slo" : " NEN� prvo��slo") + " --> nesoulad");
        }
    }

    //cvi�en� 2, 3, 4 -> viz main()

    public static void main(String[] args) {
        //cvi�en� 1
        /*long cas_pred, cas_po;
        int erast;
        System.out.print("Zadej cel� ��slo pro zji�t�n� prvo��sel (Eratosthenovo s�to): ");
        erast = Kap_4_VstupInt.ctiInt();
        cas_pred = System.currentTimeMillis();
        eratosthenes(erast);
        cas_po = System.currentTimeMillis();
        System.out.println("d�lka zpracov�n� (ms): " + (cas_po - cas_pred)); //10.000: 142 / 35 / 20 // 46.300: 2903 / 504 / 197
        */

        //cvi�en� 2
        /*System.out.print("Zadejte cel� ��slo LONG: ");
        long cislo2 = Kap_4_VstupLong.ctiLong();
        String str2 = Long.toString(cislo2);
        System.out.println("Bylo zad�no ��slo " + cislo2 + " o d�lce " + str2.length() + ".");
        for (int i = 0; i < str2.length(); i++)
            System.out.print(str2.charAt(i) + "  ");
        System.out.println();*/

        //cvi�en� 3
        //zdroj: http://fyzika.jreichl.com/main.article/view/1321-prevod-cisla-z-dekadicke-soustavy-do-soustavy-o-jinem-zakladu
        /*System.out.print("Zadejte cel� ��slo INT: ");
        int cislo_vstup = Kap_4_VstupInt.ctiInt();
        int cislo_mezist = cislo_vstup;
        int vysl_celocis = cislo_vstup;
        int zbytek = 0;
        String bin = "";
        do {
            //krok d�len�
            vysl_celocis = cislo_mezist / (int) 2;
            zbytek = cislo_mezist % (int) 2;
            //krok zpracov�n� a p��pravy dal�� iterace
            bin = zbytek + bin;
            cislo_mezist = vysl_celocis;
        } while (vysl_celocis != 0);
        System.out.println("bin�rn� z�pis vypo�ten�: " + bin + " (" + bin.length() + ")");
        System.out.println("bin�rn� z�pis knihovn�:  " + Integer.toBinaryString(cislo_vstup));*/

        //cvi�en� 4
        System.out.print("Zadejte cel� ��slo LONG: ");
        long cislo_bin4 = Kap_4_VstupLong.ctiLong();
        String str4 = Long.toString(cislo_bin4);
        int mocnitel4;
        int cislo_dec_m4 = 0; //meziv�po�et
        int cislo_dec4 = 0;
        System.out.println("Bylo zad�no ��slo " + cislo_bin4 + " o d�lce " + str4.length() + ".");
        System.out.print("Pr�b�h v�po�tu: ");
        for (int i = 0; i < str4.length(); i++) {
            mocnitel4 = str4.length() - 1 - i;
            cislo_dec_m4 = ((int) Math.pow((double) 2, (double) mocnitel4)) * (str4.charAt(i) == '0' ? 0 : 1);
            cislo_dec4 = cislo_dec4 + cislo_dec_m4;
            //pr�b�h v�po�tu
            System.out.print(i + "/" + mocnitel4 + "/" + cislo_dec_m4 + "/" + cislo_dec4 + "  ");

            //test zp�sob� p�evodu CHAR na INT //todo: nech�pu ...
            System.out.print(str4.charAt(i) + "/"); //-> textov� znak
            System.out.print(Integer.valueOf(str4.charAt(i)).intValue() + "/"); //-> ASCII hodnota znaku
            System.out.print(Character.getNumericValue(str4.charAt(i)) + "/"); //-> ��seln� hodnota znaku
            System.out.print(Integer.parseInt(String.valueOf(str4.charAt(i))) + "  "); //-> dito
        }
        System.out.println();
        System.out.println("dekadick� z�pis vypo�ten�: " + cislo_dec4);
    }
}