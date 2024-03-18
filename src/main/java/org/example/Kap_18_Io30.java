package org.example;
import java.io.*;

public class Kap_18_Io30 {
    public static Reader vyber(Reader vstup, int index, char znak) throws IOException {
        BufferedReader bufVstup        = new BufferedReader(vstup);    //BufferedReader pou�ita jen kv�li readLine()
        PipedWriter    rouraVystup     = new PipedWriter();            //princip roury ve 2 ��dc�ch: za��tek a konec jedn� roury
        PipedReader    rouraVstup      = new PipedReader(rouraVystup); //... (pomoc� rouraVystup do roury zapsat, pomoc� rouraVstup z roury p�e��st)
        PrintWriter    formRouraVystup = new PrintWriter(rouraVystup); //PrintWriter pou�ita jen kv�li vlastnosti form�tovan�ho z�pisu (println())

        String radka;
        while ((radka = bufVstup.readLine()) != null) {
            if (index < radka.length() && radka.charAt(index) == znak) {
                formRouraVystup.println(radka);
            }
        }
        formRouraVystup.close();
        return rouraVstup;
    }

    public static void main(String[] args) throws IOException {
        //18.6 vstup a v�stup do roury
        System.out.println("18.6 vstup a v�stup do roury");
        FileReader fr = new FileReader("18_4_10_buf.txt");
        Reader jednaDevet = vyber(vyber(fr, 0, '1'), 2, '9');
        fr.close();

        String radka; //z�v�re�n� tisk
        BufferedReader br = new BufferedReader(jednaDevet);
        while ((radka = br.readLine()) != null) {
            System.out.println(radka);
        }
        br.close();
    }
}
