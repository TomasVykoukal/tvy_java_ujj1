package org.example;

public class Kap_19_Parametry {
    public static void main(String[] args) {
        Kap_19_Parametry ja = new Kap_19_Parametry();
        System.out.println("Program: " + ja.getClass().getName());
        System.out.println("poèet parametrù: " + args.length);
        //pau¹ální výpis parametrù jako textových øetìzcù
        for (int i = 0; i < args.length; i++) {
            System.out.println((i+1) + ": " + args[i]);
        }
        //pøedání èísel jako parametrù
        int    par4 = Integer.valueOf(args[3]).intValue();
        double par5 = Double.valueOf(args[4]).doubleValue();
        System.out.println("hodnota int: " + par4);
        System.out.println("hodnota double: " + par5);
    }
}

/* >_ Terminal:
Copyright (C) Microsoft Corporation. Alle Rechte vorbehalten.

Lernen Sie das neue plattformuebergreifende PowerShell kennen - https://aka.ms/pscore6

PS C:\Doku\Know-How\git\tvy_spielwiese> cd src\main\java\org\example
PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example> dir Kap_19*

    Verzeichnis: C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example

Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
-a----        20.03.2024     09:31           1771 Kap_19_Parametry.java

PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example> javac .\Kap_19_Parametry.java //preklad zrejme zbytecny (viz dale)
PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example> dir Kap_19*

    Verzeichnis: C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example

Mode                 LastWriteTime         Length Name
----                 -------------         ------ ----
-a----        20.03.2024     09:37           1167 Kap_19_Parametry.class
-a----        20.03.2024     09:36           1771 Kap_19_Parametry.java

PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example> java Kap_19_Parametry.java ahoj dobry den 123 45.3
Program: org.example.Kap_19_Parametry
po?et parametr?: 5
1: ahoj
2: dobry
3: den
4: 123
5: 45.3
hodnota int: 123
hodnota double: 45.3
PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example> java Kap_19_Parametry.java ahoj nazdar "dobry den" 123 45.3
Program: org.example.Kap_19_Parametry
po?et parametr?: 5
1: ahoj
2: nazdar
3: dobry den
4: 123
5: 45.3
hodnota int: 123
hodnota double: 45.3
PS C:\Doku\Know-How\git\tvy_spielwiese\src\main\java\org\example>
*/
