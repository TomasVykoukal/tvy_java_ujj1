package org.example;

//20.6.3 vlákno ukonèí pøedèasnì jiné vlákno
//20.6.4 vlákno je násilnì probuzeno
public class Kap_20_Vlakno10 extends Thread {

    public void run() {
        while (!Kap_20_ReadV1.hotovo) {
            //System.out.print("Prùbì¾né údaje - ");
            //System.out.print("èíslo: " + Kap_20_ReadV1.cislo + ", ");
            //System.out.println("souèet: " + Kap_20_ReadV1.suma + "\r");
            System.out.println("Prùbì¾né údaje - èíslo: " + Kap_20_ReadV1.cislo + ", souèet: " + Kap_20_ReadV1.suma /*+ "\r"*/);
            if (false) { //20.6.3 ...
                Thread.yield();
                if (interrupted()) { //true: aktuální vlákno bylo pøeru¹eno z jiného vlákna metodou interrupt()
                    return;
                }
            }
            else { //20.6.4 ...
                try {
                    Thread.sleep(2);
                }
                catch (InterruptedException e) {
                    System.out.println("Pøedèasnì vzbuzen (Kap_20_Vlakno10::run())");
                    break;
                    //return; //=> Ukonèí celou metodu RUN(), nikoliv jen cyklus WHILE.
                }
            }
        }
        //System.out.print("KONEÈNÉ ÚDAJE  - ");
        //System.out.print("ÈÍSLO: " + Kap_20_ReadV1.cislo + ", ");
        //System.out.println("SOUÈET: " + Kap_20_ReadV1.suma + "\r");
        System.out.println("KONEÈNÉ ÚDAJE  - ÈÍSLO: " + Kap_20_ReadV1.cislo + ", SOUÈET: " + Kap_20_ReadV1.suma /*+ "\r"*/);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Kap_20_Vlakno10::main() Thread.currentThread(): " + Thread.currentThread());
        System.out.println("Kap_20_Vlakno10::main() Thread.currentThread().getState(): " + Thread.currentThread().getState());
        long zac = System.currentTimeMillis();

        Kap_20_ReadV1 vlCteni = new Kap_20_ReadV1("20_2_data.txt");
        vlCteni.start();

        Kap_20_Vlakno10 vlVypis = new Kap_20_Vlakno10();
        vlVypis.start();
        vlVypis.join(25); //po vypr¹ení timeoutu bude vlákno skuteènì ukonèeno - viz interrupt() ní¾e
        if (vlVypis.isAlive()) {
            System.out.println("\tVypr¹el ti èas - konèí¹! (Kap_20_Vlakno10::main())");
            vlVypis.interrupt(); //pøeru¹í jiné vlákno (zde vlVypis)
        }

        long kon = System.currentTimeMillis();
        System.out.println("èasová bilance (Kap_20_Vlakno10::main()): " + (kon - zac));
        System.out.println("Kap_20_Vlakno10::main() vlCteni.getPriority(): " + vlCteni.getPriority());
        System.out.println("Kap_20_Vlakno10::main() vlVypis.getPriority(): " + vlVypis.getPriority());
        System.out.println("Kap_20_Vlakno10::main() Thread.currentThread().getState(): " + Thread.currentThread().getState());

    }
}

/*varianty výstupù 20.6.3:
vlVypis.join(100); dostateènì vysoký timeout => vlákno main èeká na ukonèení vlákna vlVypis (toté¾ chování jako varianta "if (true) {vlVypis.join();}" v tø. Vlakno2):
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=56979:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno10
Kap_20_Vlakno10::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE
Prùbì¾né údaje - èíslo: 0, souèet: 1606528
Prùbì¾né údaje - èíslo: 5136, souèet: 13191816
Prùbì¾né údaje - èíslo: 5136, souèet: 13191816
Prùbì¾né údaje - èíslo: 5136, souèet: 13191816
Prùbì¾né údaje - èíslo: 5136, souèet: 13191816
Prùbì¾né údaje - èíslo: 5145, souèet: 13465455
...
Prùbì¾né údaje - èíslo: 100000, souèet: 5000050000
KONEÈNÉ ÚDAJE  - ÈÍSLO: 100000, SOUÈET: 5000050000
èasová bilance (Kap_20_Vlakno10::main()): 48
Kap_20_Vlakno10::main() vlCteni.getPriority(): 5
Kap_20_Vlakno10::main() vlVypis.getPriority(): 5
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0


vlVypis.join(10); nedostateènì vysoký timeout => vlákno main utne vlákno vlVypis (je¾ se nedokonèí):
----------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=57359:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno10
Kap_20_Vlakno10::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE
Prùbì¾né údaje - èíslo: 0, souèet: 2598060
Prùbì¾né údaje - èíslo: 6618, souèet: 22147840
Prùbì¾né údaje - èíslo: 6705, souèet: 22696953
Prùbì¾né údaje - èíslo: 6775, souèet: 22953700
Prùbì¾né údaje - èíslo: 6775, souèet: 22953700
Prùbì¾né údaje - èíslo: 6775, souèet: 22953700
...
Prùbì¾né údaje - èíslo: 19171, souèet: 185252376
Prùbì¾né údaje - èíslo: 19390, souèet: 189667026
Prùbì¾né údaje - èíslo: 19600, souèet: 192089800
	 Vypr¹el ti èas - konèí¹! (Kap_20_Vlakno10::main())
èasová bilance (Kap_20_Vlakno10::main()): 20
Kap_20_Vlakno10::main() vlCteni.getPriority(): 5
Kap_20_Vlakno10::main() vlVypis.getPriority(): 5
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0
*/

/*varianty výstupù 20.6.4:
Thread.sleep(2); => vlákno vlVypis svùj bìh pøíli¹ neprotahuje
vlVypis.join(100); dostateènì vysoký timeout => vlákno main èeká na ukonèení vlákna vlVypis () a k pøeru¹ení vlVypis (interrupt()) vùbec nedojde
------------------------------------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=49660:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno10
Kap_20_Vlakno10::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE
Prùbì¾né údaje - èíslo: 0, souèet: 0
Prùbì¾né údaje - èíslo: 8823, souèet: 38927076
Prùbì¾né údaje - èíslo: 14139, souèet: 99962730
Prùbì¾né údaje - èíslo: 19552, souèet: 191150128
Prùbì¾né údaje - èíslo: 27793, souèet: 386239321
Prùbì¾né údaje - èíslo: 34446, souèet: 593280681
Prùbì¾né údaje - èíslo: 40498, souèet: 820064251
Prùbì¾né údaje - èíslo: 49391, souèet: 1219760136
Prùbì¾né údaje - èíslo: 58416, souèet: 1706243736
Prùbì¾né údaje - èíslo: 70412, souèet: 2478960078
Prùbì¾né údaje - èíslo: 88164, souèet: 3886489530
KONEÈNÉ ÚDAJE  - ÈÍSLO: 100000, SOUÈET: 5000050000
èasová bilance (Kap_20_Vlakno10::main()): 43
Kap_20_Vlakno10::main() vlCteni.getPriority(): 5
Kap_20_Vlakno10::main() vlVypis.getPriority(): 5
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0


Thread.sleep(2); => dtto
vlVypis.join(25); nedostateènì vysoký timeout => vlákno main utne vlákno vlVypis, je¾ se dokonèí jen zdánlivì
   (BREAK ukonèí cyklus WHILE, tj. nedokonèí se naèítání, KONEÈNÉ ÚDAJE jsou vyti¹tìny, ov¹em s nekompletními daty)
-------------------------------------------------------------------------------------------------------------------
"C:\Program Files\Java\jdk-18.0.1.1\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\lib\idea_rt.jar=50571:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.2.5\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Doku\Know-How\Programmierung (Java, C)\tvy_java_ujj1\target\classes;C:\Users\tvy\.m2\repository\org\jetbrains\annotations\24.1.0\annotations-24.1.0.jar" org.example.Kap_20_Vlakno10
Kap_20_Vlakno10::main() Thread.currentThread(): Thread[main,5,main]
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE
Prùbì¾né údaje - èíslo: 0, souèet: 0
Prùbì¾né údaje - èíslo: 13052, souèet: 85183878
Prùbì¾né údaje - èíslo: 19185, souèet: 184041705
Prùbì¾né údaje - èíslo: 25647, souèet: 328897128
Prùbì¾né údaje - èíslo: 34451, souèet: 593452926
Prùbì¾né údaje - èíslo: 41449, souèet: 859030525
	Vypr¹el ti èas - konèí¹! (Kap_20_Vlakno10::main())
Pøedèasnì vzbuzen (Kap_20_Vlakno10::run())
KONEÈNÉ ÚDAJE  - ÈÍSLO: 45827, SOUÈET: 1050079878
èasová bilance (Kap_20_Vlakno10::main()): 28
Kap_20_Vlakno10::main() vlCteni.getPriority(): 5
Kap_20_Vlakno10::main() vlVypis.getPriority(): 5
Kap_20_Vlakno10::main() Thread.currentThread().getState(): RUNNABLE

Process finished with exit code 0
*/