package org.example;

//20.2.1 vlákna se pravidelnì støídají
//20.2.2 vlákna se støídají nepravidelnì
//20.3.4 praktické ovìøení a plánování priorit
//20.6   synchronizace vláken
//výpisové vlákno (ètecí vlákno -> Kap_20_ReadV1)
public class Kap_20_Vlakno2 extends Thread {
    public void run() {
        long zac = System.currentTimeMillis();

        while (!Kap_20_ReadV1.hotovo) {
            //System.out.print("Prùbì¾né údaje - ");                      //Tisk prùbì¾ných údajù není dokonalý - nezobrazují se v¹echna èísla,
            //System.out.print("èíslo: " + Kap_20_ReadV1.cislo + ", ");   //... poèáteèní a koneèná pøíp. opakovanì. Souèet v poøádku, tj. prùbìh V1 v poøádku,
            //System.out.println("souèet: " + Kap_20_ReadV1.suma + "\r"); //... øízení vláken (volání V2) pøíp. zpùsob výpisu zøejmì nedokonalé.
            //následuje varianta v jednom øádku, aby výpis nebyl zmateènì prolo¾en výstupy z main()
            System.out.println("Prùbì¾né údaje - èíslo: " + Kap_20_ReadV1.cislo + ", souèet: " + Kap_20_ReadV1.suma + "\r");

            if (false) { //pomalá varianta 20.2.1
                Thread.yield();
            }
            else { //rychlá varianta 20.2.2 (20.6.1)
                try {
                    Thread.sleep(1); //100
                }
                catch (InterruptedException e) {}
            }
        }
        //System.out.print("KONEÈNÉ ÚDAJE  - ");
        //System.out.print("ÈÍSLO: " + Kap_20_ReadV1.cislo + ", ");
        //System.out.println("SOUÈET: " + Kap_20_ReadV1.suma + "\r");
        System.out.println("KONEÈNÉ ÚDAJE  - ÈÍSLO: " + Kap_20_ReadV1.cislo + ", SOUÈET: " + Kap_20_ReadV1.suma + "\r");

        long kon = System.currentTimeMillis();
        System.out.println("èasová bilance (Kap_20_Vlakno2::run()): " + (kon - zac));
    }

    public static void main(String[] args) throws InterruptedException {
        //ve skuteènosti bì¾í 3 vlákna: ètení, výpis, main() (viz Kap_20_Vlakno2::main() Thread.currentThread())
        System.out.println("Kap_20_Vlakno2::main() Thread.currentThread(): " + Thread.currentThread());
        System.out.println("Kap_20_Vlakno2::main() Thread.currentThread().getState(): " + Thread.currentThread().getState());
        long zac = System.currentTimeMillis();

        Kap_20_ReadV1 vlCteni = new Kap_20_ReadV1("20_2_data.txt");
        //vlCteni.setPriority(NORM_PRIORITY); //20.3.4 praktické ovìøení a plánování priorit
        //vlCteni.setPriority(MIN_PRIORITY);
        //vlCteni.setPriority(MAX_PRIORITY);
        vlCteni.start();

        Kap_20_Vlakno2 vlVypis = new Kap_20_Vlakno2();
        //vlVypis.setPriority(NORM_PRIORITY); //20.3.4 praktické ovìøení a plánování priorit
        vlVypis.start();

        if (false) { //20.6 synchronizace vláken - 20.6.1 vlákno èeká trpìlivì na konec jiného vlákna
            vlVypis.join(); //Waits for this thread to die.
        }
        if (true) { //... - 20.6.2 vlákno èeká netrpìlivì na konec jiného vlákna
            while (vlVypis.isAlive()) { //Tests if this thread is alive. A thread is alive if it has been started and has not yet died.
                vlVypis.join(250); //Waits at most millis milliseconds for this thread to die. A timeout of 0 behaves in exactly the same way as the invocation JOIN(0).
                System.out.println("\t Kde se fláká¹?! (Kap_20_Vlakno2::main())");
            }
        }

        long kon = System.currentTimeMillis();
        System.out.println("èasová bilance (Kap_20_Vlakno2::main()): " + (kon - zac));
        System.out.println("Kap_20_Vlakno2::main() vlCteni.getPriority(): " + vlCteni.getPriority());
        System.out.println("Kap_20_Vlakno2::main() vlVypis.getPriority(): " + vlVypis.getPriority());
        System.out.println("Kap_20_Vlakno2::main() Thread.currentThread().getState(): " + Thread.currentThread().getState());
    }
}

/*varianty výstupù 20.6:
if (false) {vlVypis.join();} => vlákno main neèeká na ukonèení vlákna vlVypis (výstupy z main() spu¹tìné po startu vlákna vlVystup prokládají výstupy z výpisového vlákna):
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=57530:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno2
Kap_20_Vlakno2::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
èasová bilance (Kap_20_Vlakno2::main()): 2
Prùbì¾né údaje - èíslo: 0, souèet: 0
Kap_20_Vlakno2::main() vlCteni.getPriority(): 5
Kap_20_Vlakno2::main() vlVypis.getPriority(): 5
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
Prùbì¾né údaje - èíslo: 4585, souèet: 10513405
Prùbì¾né údaje - èíslo: 8413, souèet: 35393491
Prùbì¾né údaje - èíslo: 14139, souèet: 99962730
Prùbì¾né údaje - èíslo: 18705, souèet: 174947865
Prùbì¾né údaje - èíslo: 30304, souèet: 459181360
Prùbì¾né údaje - èíslo: 35262, souèet: 621721953
Prùbì¾né údaje - èíslo: 39495, souèet: 779947260
Prùbì¾né údaje - èíslo: 45173, souèet: 1020277378
Prùbì¾né údaje - èíslo: 52917, souèet: 1400130903
Prùbì¾né údaje - èíslo: 66251, souèet: 2194630626
Prùbì¾né údaje - èíslo: 78236, souèet: 3060474966
Prùbì¾né údaje - èíslo: 90357, souèet: 4082238903
KONEÈNÉ ÚDAJE  - ÈÍSLO: 100000, SOUÈET: 5000050000
èasová bilance (Kap_20_Vlakno2::run()): 37

Process finished with exit code 0


if (true) {vlVypis.join();} => vlákno main èeká na ukonèení vlákna vlVypis:
---------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=57623:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno2
Kap_20_Vlakno2::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
Prùbì¾né údaje - èíslo: 0, souèet: 0
Prùbì¾né údaje - èíslo: 10880, souèet: 59181760
Prùbì¾né údaje - èíslo: 14597, souèet: 106543503
Prùbì¾né údaje - èíslo: 19546, souèet: 191032831
Prùbì¾né údaje - èíslo: 26606, souèet: 353952921
Prùbì¾né údaje - èíslo: 35859, souèet: 642951870
Prùbì¾né údaje - èíslo: 43572, souèet: 949281378
Prùbì¾né údaje - èíslo: 52917, souèet: 1400130903
Prùbì¾né údaje - èíslo: 60560, souèet: 1833787080
Prùbì¾né údaje - èíslo: 71635, souèet: 2565822430
Prùbì¾né údaje - èíslo: 80710, souèet: 3257092405
Prùbì¾né údaje - èíslo: 92051, souèet: 4236739326
KONEÈNÉ ÚDAJE  - ÈÍSLO: 100000, SOUÈET: 5000050000
èasová bilance (Kap_20_Vlakno2::run()): 40
èasová bilance (Kap_20_Vlakno2::main()): 43
Kap_20_Vlakno2::main() vlCteni.getPriority(): 5
Kap_20_Vlakno2::main() vlVypis.getPriority(): 5
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0
*/

/*varianty výstupù 20.6.2:
vlVypis.join(10); (milis < trvání programu) => cyklus èekání (vè. expresivní hlá¹ky) probìhne za dobu bìhu výpisu nìkolikrát
----------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=49366:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno2
Kap_20_Vlakno2::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
Prùbì¾né údaje - èíslo: 0, souèet: 0
Prùbì¾né údaje - èíslo: 8780, souèet: 38548590
	 Kde se fláká¹?! (Kap_20_Vlakno2::main())
Prùbì¾né údaje - èíslo: 11408, souèet: 65076936
Prùbì¾né údaje - èíslo: 15287, souèet: 116853828
Prùbì¾né údaje - èíslo: 20965, souèet: 219776095
Prùbì¾né údaje - èíslo: 26989, souèet: 364216555
Prùbì¾né údaje - èíslo: 33315, souèet: 554961270
	 Kde se fláká¹?! (Kap_20_Vlakno2::main())
Prùbì¾né údaje - èíslo: 39966, souèet: 798660561
Prùbì¾né údaje - èíslo: 45921, souèet: 1054392081
Prùbì¾né údaje - èíslo: 52941, souèet: 1401401211
Prùbì¾né údaje - èíslo: 59765, souèet: 1785957495
Prùbì¾né údaje - èíslo: 66698, souèet: 2224344951
Prùbì¾né údaje - èíslo: 74213, souèet: 2753821791
	 Kde se fláká¹?! (Kap_20_Vlakno2::main())
Prùbì¾né údaje - èíslo: 81006, souèet: 3281026521
Prùbì¾né údaje - èíslo: 90396, souèet: 4085763606
Prùbì¾né údaje - èíslo: 100000, souèet: 5000050000
KONEÈNÉ ÚDAJE  - ÈÍSLO: 100000, SOUÈET: 5000050000
èasová bilance (Kap_20_Vlakno2::run()): 39
	 Kde se fláká¹?! (Kap_20_Vlakno2::main())
èasová bilance (Kap_20_Vlakno2::main()): 43
Kap_20_Vlakno2::main() vlCteni.getPriority(): 5
Kap_20_Vlakno2::main() vlVypis.getPriority(): 5
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0


vlVypis.join(250); (milis > trvání programu) => cyklus èekání (vè. expresivní hlá¹ky) probìhne jednou a sice po ukonèení výpisového vlákna
------------------------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=50854:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno2
Kap_20_Vlakno2::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE
Prùbì¾né údaje - èíslo: 0, souèet: 0
Prùbì¾né údaje - èíslo: 610, souèet: 186355
Prùbì¾né údaje - èíslo: 1591, souèet: 1266436
Prùbì¾né údaje - èíslo: 3498, souèet: 6119751
Prùbì¾né údaje - èíslo: 6775, souèet: 22953700
Prùbì¾né údaje - èíslo: 10043, souèet: 50435946
Prùbì¾né údaje - èíslo: 13563, souèet: 91984266
Prùbì¾né údaje - èíslo: 17982, souèet: 161685153
Prùbì¾né údaje - èíslo: 23696, souèet: 280762056
Prùbì¾né údaje - èíslo: 30111, souèet: 453351216
Prùbì¾né údaje - èíslo: 36820, souèet: 677874610
Prùbì¾né údaje - èíslo: 42811, souèet: 916412266
Prùbì¾né údaje - èíslo: 50008, souèet: 1250425036
Prùbì¾né údaje - èíslo: 56458, souèet: 1593781111
Prùbì¾né údaje - èíslo: 64098, souèet: 2054308851
Prùbì¾né údaje - èíslo: 75438, souèet: 2845483641
Prùbì¾né údaje - èíslo: 87325, souèet: 3812871475
Prùbì¾né údaje - èíslo: 99001, souèet: 4900648501
KONEÈNÉ ÚDAJE  - ÈÍSLO: 100000, SOUÈET: 5000050000
èasová bilance (Kap_20_Vlakno2::run()): 45
	 Kde se fláká¹?! (Kap_20_Vlakno2::main())
èasová bilance (Kap_20_Vlakno2::main()): 50
Kap_20_Vlakno2::main() vlCteni.getPriority(): 5
Kap_20_Vlakno2::main() vlVypis.getPriority(): 5
Kap_20_Vlakno2::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0
*/