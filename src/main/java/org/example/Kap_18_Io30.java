package org.example;
import java.io.*;

public class Kap_18_Io30 {
    public static Reader vyber(
              Reader vstup
            , int    index
            , char   znak
    ) throws IOException {
        BufferedReader bufVstup        = new BufferedReader(vstup);    //BufferedReader pou�ita jen kv�li readLine()

        PipedWriter    rouraVystup     = new PipedWriter();            //princip roury ve 2 ��dc�ch: za��tek (rouraVystup/PipedWriter) a konec (rouraVstup/PipedReader) jedn� roury
        PipedReader    rouraVstup      = new PipedReader(rouraVystup); //... (pomoc� rouraVystup do roury zapsat, pomoc� rouraVstup z roury p�e��st)
                                                                       //mnemotechn. pom�cky:
                                                                       //  - pojmy writer a reader z pohledu roury (writer = z�pis/vstup do roury, reader = �ten�/v�stup z roury)
                                                                       //  - pojmy vstup a v�stup z�ejm� z pohledu okoln�ho prost�ed� (V�STUP z prost�. = vstup do roury, VSTUP do prost�. = v�stup z roury)
        PrintWriter    formRouraVystup = new PrintWriter(rouraVystup); //PrintWriter pou�ita jen kv�li vlastnosti form�tovan�ho z�pisu (println())

        String radka;
        while ((radka = bufVstup.readLine()) != null) {
            if (index < radka.length() && radka.charAt(index) == znak) { //zkr�cen� vyhodnocen� zamez� chyb� p�i neexist. indexu v charAt()
                formRouraVystup.println(radka); //(form�tovan�) vstup do roury (v�stup z prost�ed�)
            }
        }
        formRouraVystup.close();
        return rouraVstup; //v�stup z roury (vstup do prost�ed�)
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
