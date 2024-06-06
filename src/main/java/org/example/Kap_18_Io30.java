package org.example;
import java.io.*;

public class Kap_18_Io30 {
    public static Reader vyber(
              Reader vstup
            , int    index
            , char   znak
    ) throws IOException {
        BufferedReader bufVstup        = new BufferedReader(vstup);    //BufferedReader pou¾ita jen kvùli readLine()

        PipedWriter    rouraVystup     = new PipedWriter();            //princip roury ve 2 øádcích: zaèátek (rouraVystup/PipedWriter) a konec (rouraVstup/PipedReader) jedné roury
        PipedReader    rouraVstup      = new PipedReader(rouraVystup); //... (pomocí rouraVystup do roury zapsat, pomocí rouraVstup z roury pøeèíst)
                                                                       //mnemotechn. pomùcky:
                                                                       //  - pojmy writer a reader z pohledu roury (writer = zápis/vstup do roury, reader = ètení/výstup z roury)
                                                                       //  - pojmy vstup a výstup zøejmì z pohledu okolního prostøedí (VÝSTUP z prostø. = vstup do roury, VSTUP do prostø. = výstup z roury)
        PrintWriter    formRouraVystup = new PrintWriter(rouraVystup); //PrintWriter pou¾ita jen kvùli vlastnosti formátovaného zápisu (println())

        String radka;
        while ((radka = bufVstup.readLine()) != null) {
            if (index < radka.length() && radka.charAt(index) == znak) { //zkrácené vyhodnocení zamezí chybì pøi neexist. indexu v charAt()
                formRouraVystup.println(radka); //(formátovaný) vstup do roury (výstup z prostøedí)
            }
        }
        formRouraVystup.close();
        return rouraVstup; //výstup z roury (vstup do prostøedí)
    }

    public static void main(String[] args) throws IOException {
        //18.6 vstup a výstup do roury
        System.out.println("18.6 vstup a výstup do roury");
        FileReader fr = new FileReader("18_4_10_buf.txt");
        Reader jednaDevet = vyber(vyber(fr, 0, '1'), 2, '9');
        fr.close();

        String radka; //závìreèný tisk
        BufferedReader br = new BufferedReader(jednaDevet);
        while ((radka = br.readLine()) != null) {
            System.out.println(radka);
        }
        br.close();
    }
}
