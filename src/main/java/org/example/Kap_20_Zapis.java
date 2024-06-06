package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class Kap_20_Zapis {
    public static void main(String[] args) throws IOException {
        int i_max;
        try {
            i_max = Integer.valueOf(args[0]).intValue(); //varianta spuštění s parametrem
        }
        catch (ArrayIndexOutOfBoundsException e) {
            i_max = 10_000_000; //varianta spuštění bez parametru (viz pozn. níže)
        }

        //FileWriter fw = new FileWriter("20_cvic_Zapis.txt");
        FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\" + "20_cvic_Zapis.txt"); //fixace umístění výstupu (viz pozn. níže)
        //použití vlastnosti PrintWriter => zápis se zjednoduší na xxx.println(i) (netřeba formátování na text a explicitní odřádkování)

        System.out.println(i_max);
        for (int i = 1; i <= i_max; i++) {
            System.out.println(i);
            fw.write(Integer.toString(i));
            fw.write('\n');
        }
        fw.close();
    }
}
/*Pozn.:
umístění výstupního souboru závisí na adr., ze kt. je program spuštěn:
  - při spuštění z adr. souboru .java => java.class.path=C:\Doku\Know-How\git\tvy_spielwiese\t...
    příklad: PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example> java .\Kap_20_Zapis.java
             PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example> java .\Kap_20_Zapis.java 45

  - při spuštění z uživatelského adr. => user.dir=C:\Doku\Know-How\git\tvy_spielwiese
    příklad: PS C:\Doku\Know-How\git\tvy_spielwiese> java src\main\java\org\example\Kap_20_Zapis.java
             PS C:\Doku\Know-How\git\tvy_spielwiese> java src\main\java\org\example\Kap_20_Zapis.java 45

  - při spuštění z IDE:
    - Run Current File => běh bez parametru; user.dir=C:\Doku\Know-How\git\tvy_spielwiese
    - jinak podle nastavení v Run Configuration (CLI arguments to your application; Working directory)
*/
