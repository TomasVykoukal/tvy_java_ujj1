package org.example;

//20.2.1 vl�kna se pravideln� st��daj�
//20.2.2 vl�kna se st��daj� nepravideln�
//20.3.4 praktick� ov��en� a pl�nov�n� priorit
//20.6   synchronizace vl�ken
//v�pisov� vl�kno (�tec� vl�kno -> Kap_20_ReadV1)
public class Kap_20_Vlakno2 extends Thread {
    public void run() {
        long zac = System.currentTimeMillis();

        while (!Kap_20_ReadV1.hotovo) {
            //System.out.print("Pr�b�n� �daje - ");                      //Tisk pr�b�n�ch �daj� nen� dokonal� - nezobrazuj� se v�echna ��sla,
            //System.out.print("��slo: " + Kap_20_ReadV1.cislo + ", ");   //... po��te�n� a kone�n� p��p. opakovan�. Sou�et v po��dku, tj. pr�b�h V1 v po��dku,
            //System.out.println("sou�et: " + Kap_20_ReadV1.suma + "\r"); //... ��zen� vl�ken (vol�n� V2) p��p. zp�sob v�pisu z�ejm� nedokonal�.
            //n�sleduje varianta v jednom ��dku, aby v�pis nebyl zmate�n� prolo�en v�stupy z main()
            System.out.println("Pr�b�n� �daje - ��slo: " + Kap_20_ReadV1.cislo + ", sou�et: " + Kap_20_ReadV1.suma + "\r");

            if (false) { //pomal� varianta 20.2.1
                Thread.yield();
            }
            else { //rychl� varianta 20.2.2 (20.6.1)
                try {
                    Thread.sleep(1); //100
                }
                catch (InterruptedException e) {}
            }
        }
        //System.out.print("KONE�N� �DAJE  - ");
        //System.out.print("��SLO: " + Kap_20_ReadV1.cislo + ", ");
        //System.out.println("SOU�ET: " + Kap_20_ReadV1.suma + "\r");
        System.out.println("KONE�N� �DAJE  - ��SLO: " + Kap_20_ReadV1.cislo + ", SOU�ET: " + Kap_20_ReadV1.suma + "\r");

        long kon = System.currentTimeMillis();
        System.out.println("�asov� bilance (Kap_20_Vlakno2::run()): " + (kon - zac));
    }

    public static void main(String[] args) throws InterruptedException {
        //ve skute�nosti b�� 3 vl�kna: �ten�, v�pis, main() (viz Kap_20_Vlakno2::main() Thread.currentThread())
        System.out.println("Kap_20_Vlakno2::main() Thread.currentThread(): " + Thread.currentThread());
        System.out.println("Kap_20_Vlakno2::main() Thread.currentThread().getState(): " + Thread.currentThread().getState());
        long zac = System.currentTimeMillis();

        Kap_20_ReadV1 vlCteni = new Kap_20_ReadV1("20_2_data.txt");
        //vlCteni.setPriority(NORM_PRIORITY); //20.3.4 praktick� ov��en� a pl�nov�n� priorit
        //vlCteni.setPriority(MIN_PRIORITY);
        //vlCteni.setPriority(MAX_PRIORITY);
        vlCteni.start();

        Kap_20_Vlakno2 vlVypis = new Kap_20_Vlakno2();
        //vlVypis.setPriority(NORM_PRIORITY); //20.3.4 praktick� ov��en� a pl�nov�n� priorit
        vlVypis.start();

        if (false) { //20.6 synchronizace vl�ken - 20.6.1 vl�kno �ek� trp�liv� na konec jin�ho vl�kna
            vlVypis.join(); //Waits for this thread to die.
        }
        if (true) { //... - 20.6.2 vl�kno �ek� netrp�liv� na konec jin�ho vl�kna
            while (vlVypis.isAlive()) { //Tests if this thread is alive. A thread is alive if it has been started and has not yet died.
                vlVypis.join(250); //Waits at most millis milliseconds for this thread to die. A timeout of 0 behaves in exactly the same way as the invocation JOIN(0).
                System.out.println("\t Kde se fl�k�?! (Kap_20_Vlakno2::main())");
            }
        }

        long kon = System.currentTimeMillis();
        System.out.println("�asov� bilance (Kap_20_Vlakno2::main()): " + (kon - zac));
        System.out.println("Kap_20_Vlakno2::main() vlCteni.getPriority(): " + vlCteni.getPriority());
        System.out.println("Kap_20_Vlakno2::main() vlVypis.getPriority(): " + vlVypis.getPriority());
        System.out.println("Kap_20_Vlakno2::main() Thread.currentThread().getState(): " + Thread.currentThread().getState());
    }
}

/*varianty v�stup� 20.6:
if (false) {vlVypis.join();} => vl�kno main ne�ek� na ukon�en� vl�kna vlVypis (v�stupy z main() spu�t�n� po startu vl�kna vlVystup prokl�daj� v�stupy z v�pisov�ho vl�kna):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=57530:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno2
Kap_20_Vlakno2::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
�asov� bilance (Kap_20_Vlakno2::main()): 2
Pr�b�n� �daje - ��slo: 0, sou�et: 0
Kap_20_Vlakno2::main() vlCteni.getPriority(): 5
Kap_20_Vlakno2::main() vlVypis.getPriority(): 5
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
Pr�b�n� �daje - ��slo: 4585, sou�et: 10513405
Pr�b�n� �daje - ��slo: 8413, sou�et: 35393491
Pr�b�n� �daje - ��slo: 14139, sou�et: 99962730
Pr�b�n� �daje - ��slo: 18705, sou�et: 174947865
Pr�b�n� �daje - ��slo: 30304, sou�et: 459181360
Pr�b�n� �daje - ��slo: 35262, sou�et: 621721953
Pr�b�n� �daje - ��slo: 39495, sou�et: 779947260
Pr�b�n� �daje - ��slo: 45173, sou�et: 1020277378
Pr�b�n� �daje - ��slo: 52917, sou�et: 1400130903
Pr�b�n� �daje - ��slo: 66251, sou�et: 2194630626
Pr�b�n� �daje - ��slo: 78236, sou�et: 3060474966
Pr�b�n� �daje - ��slo: 90357, sou�et: 4082238903
KONE�N� �DAJE  - ��SLO: 100000, SOU�ET: 5000050000
�asov� bilance (Kap_20_Vlakno2::run()): 37

Process finished with exit code 0


if (true) {vlVypis.join();} => vl�kno main �ek� na ukon�en� vl�kna vlVypis:
---------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=57623:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno2
Kap_20_Vlakno2::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
Pr�b�n� �daje - ��slo: 0, sou�et: 0
Pr�b�n� �daje - ��slo: 10880, sou�et: 59181760
Pr�b�n� �daje - ��slo: 14597, sou�et: 106543503
Pr�b�n� �daje - ��slo: 19546, sou�et: 191032831
Pr�b�n� �daje - ��slo: 26606, sou�et: 353952921
Pr�b�n� �daje - ��slo: 35859, sou�et: 642951870
Pr�b�n� �daje - ��slo: 43572, sou�et: 949281378
Pr�b�n� �daje - ��slo: 52917, sou�et: 1400130903
Pr�b�n� �daje - ��slo: 60560, sou�et: 1833787080
Pr�b�n� �daje - ��slo: 71635, sou�et: 2565822430
Pr�b�n� �daje - ��slo: 80710, sou�et: 3257092405
Pr�b�n� �daje - ��slo: 92051, sou�et: 4236739326
KONE�N� �DAJE  - ��SLO: 100000, SOU�ET: 5000050000
�asov� bilance (Kap_20_Vlakno2::run()): 40
�asov� bilance (Kap_20_Vlakno2::main()): 43
Kap_20_Vlakno2::main() vlCteni.getPriority(): 5
Kap_20_Vlakno2::main() vlVypis.getPriority(): 5
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0
*/

/*varianty v�stup� 20.6.2:
vlVypis.join(10); (milis < trv�n� programu) => cyklus �ek�n� (v�. expresivn� hl�ky) prob�hne za dobu b�hu v�pisu n�kolikr�t
----------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=49366:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno2
Kap_20_Vlakno2::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
Pr�b�n� �daje - ��slo: 0, sou�et: 0
Pr�b�n� �daje - ��slo: 8780, sou�et: 38548590
	 Kde se fl�k�?! (Kap_20_Vlakno2::main())
Pr�b�n� �daje - ��slo: 11408, sou�et: 65076936
Pr�b�n� �daje - ��slo: 15287, sou�et: 116853828
Pr�b�n� �daje - ��slo: 20965, sou�et: 219776095
Pr�b�n� �daje - ��slo: 26989, sou�et: 364216555
Pr�b�n� �daje - ��slo: 33315, sou�et: 554961270
	 Kde se fl�k�?! (Kap_20_Vlakno2::main())
Pr�b�n� �daje - ��slo: 39966, sou�et: 798660561
Pr�b�n� �daje - ��slo: 45921, sou�et: 1054392081
Pr�b�n� �daje - ��slo: 52941, sou�et: 1401401211
Pr�b�n� �daje - ��slo: 59765, sou�et: 1785957495
Pr�b�n� �daje - ��slo: 66698, sou�et: 2224344951
Pr�b�n� �daje - ��slo: 74213, sou�et: 2753821791
	 Kde se fl�k�?! (Kap_20_Vlakno2::main())
Pr�b�n� �daje - ��slo: 81006, sou�et: 3281026521
Pr�b�n� �daje - ��slo: 90396, sou�et: 4085763606
Pr�b�n� �daje - ��slo: 100000, sou�et: 5000050000
KONE�N� �DAJE  - ��SLO: 100000, SOU�ET: 5000050000
�asov� bilance (Kap_20_Vlakno2::run()): 39
	 Kde se fl�k�?! (Kap_20_Vlakno2::main())
�asov� bilance (Kap_20_Vlakno2::main()): 43
Kap_20_Vlakno2::main() vlCteni.getPriority(): 5
Kap_20_Vlakno2::main() vlVypis.getPriority(): 5
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0


vlVypis.join(250); (milis > trv�n� programu) => cyklus �ek�n� (v�. expresivn� hl�ky) prob�hne jednou a sice po ukon�en� v�pisov�ho vl�kna
------------------------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=50854:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno2
Kap_20_Vlakno2::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
Pr�b�n� �daje - ��slo: 0, sou�et: 0
Pr�b�n� �daje - ��slo: 610, sou�et: 186355
Pr�b�n� �daje - ��slo: 1591, sou�et: 1266436
Pr�b�n� �daje - ��slo: 3498, sou�et: 6119751
Pr�b�n� �daje - ��slo: 6775, sou�et: 22953700
Pr�b�n� �daje - ��slo: 10043, sou�et: 50435946
Pr�b�n� �daje - ��slo: 13563, sou�et: 91984266
Pr�b�n� �daje - ��slo: 17982, sou�et: 161685153
Pr�b�n� �daje - ��slo: 23696, sou�et: 280762056
Pr�b�n� �daje - ��slo: 30111, sou�et: 453351216
Pr�b�n� �daje - ��slo: 36820, sou�et: 677874610
Pr�b�n� �daje - ��slo: 42811, sou�et: 916412266
Pr�b�n� �daje - ��slo: 50008, sou�et: 1250425036
Pr�b�n� �daje - ��slo: 56458, sou�et: 1593781111
Pr�b�n� �daje - ��slo: 64098, sou�et: 2054308851
Pr�b�n� �daje - ��slo: 75438, sou�et: 2845483641
Pr�b�n� �daje - ��slo: 87325, sou�et: 3812871475
Pr�b�n� �daje - ��slo: 99001, sou�et: 4900648501
KONE�N� �DAJE  - ��SLO: 100000, SOU�ET: 5000050000
�asov� bilance (Kap_20_Vlakno2::run()): 45
	 Kde se fl�k�?! (Kap_20_Vlakno2::main())
�asov� bilance (Kap_20_Vlakno2::main()): 50
Kap_20_Vlakno2::main() vlCteni.getPriority(): 5
Kap_20_Vlakno2::main() vlVypis.getPriority(): 5
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0
*/