package org.example;

//20.6.3 vl�kno ukon�� p�ed�asn� jin� vl�kno
//20.6.4 vl�kno je n�siln� probuzeno
public class Kap_20_Vlakno10 extends Thread {

    public void run() {
        while (!Kap_20_ReadV1.hotovo) {
            //System.out.print("Pr�b�n� �daje - ");
            //System.out.print("��slo: " + Kap_20_ReadV1.cislo + ", ");
            //System.out.println("sou�et: " + Kap_20_ReadV1.suma + "\r");
            System.out.println("Pr�b�n� �daje - ��slo: " + Kap_20_ReadV1.cislo + ", sou�et: " + Kap_20_ReadV1.suma /*+ "\r"*/);
            if (false) { //20.6.3 ...
                Thread.yield();
                if (interrupted()) { //true: aktu�ln� vl�kno bylo p�eru�eno z jin�ho vl�kna metodou interrupt()
                    return;
                }
            }
            else { //20.6.4 ...
                try {
                    Thread.sleep(2);
                }
                catch (InterruptedException e) {
                    System.out.println("P�ed�asn� vzbuzen (Kap_20_Vlakno10::run())");
                    break;
                    //return; //=> Ukon�� celou metodu RUN(), nikoliv jen cyklus WHILE.
                }
            }
        }
        //System.out.print("KONE�N� �DAJE  - ");
        //System.out.print("��SLO: " + Kap_20_ReadV1.cislo + ", ");
        //System.out.println("SOU�ET: " + Kap_20_ReadV1.suma + "\r");
        System.out.println("KONE�N� �DAJE  - ��SLO: " + Kap_20_ReadV1.cislo + ", SOU�ET: " + Kap_20_ReadV1.suma /*+ "\r"*/);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Kap_20_Vlakno10::main() Thread.currentThread(): " + Thread.currentThread());
        System.out.println("Kap_20_Vlakno10::main() Thread.currentThread().getState(): " + Thread.currentThread().getState());
        long zac = System.currentTimeMillis();

        Kap_20_ReadV1 vlCteni = new Kap_20_ReadV1("20_2_data.txt");
        vlCteni.start();

        Kap_20_Vlakno10 vlVypis = new Kap_20_Vlakno10();
        vlVypis.start();
        vlVypis.join(25); //po vypr�en� timeoutu bude vl�kno skute�n� ukon�eno - viz interrupt() n�e
        if (vlVypis.isAlive()) {
            System.out.println("\tVypr�el ti �as - kon��! (Kap_20_Vlakno10::main())");
            vlVypis.interrupt(); //p�eru�� jin� vl�kno (zde vlVypis)
        }

        long kon = System.currentTimeMillis();
        System.out.println("�asov� bilance (Kap_20_Vlakno10::main()): " + (kon - zac));
        System.out.println("Kap_20_Vlakno10::main() vlCteni.getPriority(): " + vlCteni.getPriority());
        System.out.println("Kap_20_Vlakno10::main() vlVypis.getPriority(): " + vlVypis.getPriority());
        System.out.println("Kap_20_Vlakno10::main() Thread.currentThread().getState(): " + Thread.currentThread().getState());

    }
}

/*varianty v�stup� 20.6.3:
vlVypis.join(100); dostate�n� vysok� timeout => vl�kno main �ek� na ukon�en� vl�kna vlVypis (tot� chov�n� jako varianta "if (true) {vlVypis.join();}" v t�. Vlakno2):
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=56979:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno10
Kap_20_Vlakno10::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE
Pr�b�n� �daje - ��slo: 0, sou�et: 1606528
Pr�b�n� �daje - ��slo: 5136, sou�et: 13191816
Pr�b�n� �daje - ��slo: 5136, sou�et: 13191816
Pr�b�n� �daje - ��slo: 5136, sou�et: 13191816
Pr�b�n� �daje - ��slo: 5136, sou�et: 13191816
Pr�b�n� �daje - ��slo: 5145, sou�et: 13465455
...
Pr�b�n� �daje - ��slo: 100000, sou�et: 5000050000
KONE�N� �DAJE  - ��SLO: 100000, SOU�ET: 5000050000
�asov� bilance (Kap_20_Vlakno10::main()): 48
Kap_20_Vlakno10::main() vlCteni.getPriority(): 5
Kap_20_Vlakno10::main() vlVypis.getPriority(): 5
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0


vlVypis.join(10); nedostate�n� vysok� timeout => vl�kno main utne vl�kno vlVypis (je� se nedokon��):
----------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=57359:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno10
Kap_20_Vlakno10::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE
Pr�b�n� �daje - ��slo: 0, sou�et: 2598060
Pr�b�n� �daje - ��slo: 6618, sou�et: 22147840
Pr�b�n� �daje - ��slo: 6705, sou�et: 22696953
Pr�b�n� �daje - ��slo: 6775, sou�et: 22953700
Pr�b�n� �daje - ��slo: 6775, sou�et: 22953700
Pr�b�n� �daje - ��slo: 6775, sou�et: 22953700
...
Pr�b�n� �daje - ��slo: 19171, sou�et: 185252376
Pr�b�n� �daje - ��slo: 19390, sou�et: 189667026
Pr�b�n� �daje - ��slo: 19600, sou�et: 192089800
	 Vypr�el ti �as - kon��! (Kap_20_Vlakno10::main())
�asov� bilance (Kap_20_Vlakno10::main()): 20
Kap_20_Vlakno10::main() vlCteni.getPriority(): 5
Kap_20_Vlakno10::main() vlVypis.getPriority(): 5
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0
*/

/*varianty v�stup� 20.6.4:
Thread.sleep(2); => vl�kno vlVypis sv�j b�h p��li� neprotahuje
vlVypis.join(100); dostate�n� vysok� timeout => vl�kno main �ek� na ukon�en� vl�kna vlVypis () a k p�eru�en� vlVypis (interrupt()) v�bec nedojde
------------------------------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=49660:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno10
Kap_20_Vlakno10::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE
Pr�b�n� �daje - ��slo: 0, sou�et: 0
Pr�b�n� �daje - ��slo: 8823, sou�et: 38927076
Pr�b�n� �daje - ��slo: 14139, sou�et: 99962730
Pr�b�n� �daje - ��slo: 19552, sou�et: 191150128
Pr�b�n� �daje - ��slo: 27793, sou�et: 386239321
Pr�b�n� �daje - ��slo: 34446, sou�et: 593280681
Pr�b�n� �daje - ��slo: 40498, sou�et: 820064251
Pr�b�n� �daje - ��slo: 49391, sou�et: 1219760136
Pr�b�n� �daje - ��slo: 58416, sou�et: 1706243736
Pr�b�n� �daje - ��slo: 70412, sou�et: 2478960078
Pr�b�n� �daje - ��slo: 88164, sou�et: 3886489530
KONE�N� �DAJE  - ��SLO: 100000, SOU�ET: 5000050000
�asov� bilance (Kap_20_Vlakno10::main()): 43
Kap_20_Vlakno10::main() vlCteni.getPriority(): 5
Kap_20_Vlakno10::main() vlVypis.getPriority(): 5
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0


Thread.sleep(2); => dtto
vlVypis.join(25); nedostate�n� vysok� timeout => vl�kno main utne vl�kno vlVypis, je� se dokon�� jen zd�nliv�
   (BREAK ukon�� cyklus WHILE, tj. nedokon�� se na��t�n�, KONE�N� �DAJE jsou vyti�t�ny, ov�em s nekompletn�mi daty)
-------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=50571:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno10
Kap_20_Vlakno10::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE
Pr�b�n� �daje - ��slo: 0, sou�et: 0
Pr�b�n� �daje - ��slo: 13052, sou�et: 85183878
Pr�b�n� �daje - ��slo: 19185, sou�et: 184041705
Pr�b�n� �daje - ��slo: 25647, sou�et: 328897128
Pr�b�n� �daje - ��slo: 34451, sou�et: 593452926
Pr�b�n� �daje - ��slo: 41449, sou�et: 859030525
	Vypr�el ti �as - kon��! (Kap_20_Vlakno10::main())
P�ed�asn� vzbuzen (Kap_20_Vlakno10::run())
KONE�N� �DAJE  - ��SLO: 45827, SOU�ET: 1050079878
�asov� bilance (Kap_20_Vlakno10::main()): 28
Kap_20_Vlakno10::main() vlCteni.getPriority(): 5
Kap_20_Vlakno10::main() vlVypis.getPriority(): 5
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0
*/