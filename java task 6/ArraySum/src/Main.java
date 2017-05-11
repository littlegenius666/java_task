import java.util.Random;

/**
 * Created by Yelyzaveta_Horbachen on 11.05.17.
 */
public class Main {
    public static int size = 1000;
    public static int threadCount = 2;
    public static void main(String [] args ) throws InterruptedException{

        Random random = new Random();
        int[] array=new int[size];

        for(int i =0; i<size; i++){
            array[i]=random.nextInt();
        }
        SumThread vector[] = new SumThread[threadCount];
        long start = System.nanoTime();
        for(int i = 0; i < threadCount; i++){
            vector[i] = new SumThread(array,size*i/threadCount,size*(i + 1)/threadCount);
            vector[i].start();
        }
        for(int i = 0; i < threadCount; i++){
            vector[i].join();
        }
        double threadSum = 0;
        for(int i = 0; i < threadCount; i++){
            threadSum += vector[i].getResult();
        }
        long end = System.nanoTime();
        long traceTime = end-start;
        System.out.println("Сума при паралельному розрахунку = "+threadSum);
        System.out.println("Час паралельного розрахунку = "+traceTime+" нс");
    }
}
