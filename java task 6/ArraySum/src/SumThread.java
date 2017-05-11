/**
 * Created by Yelyzaveta_Horbachen on 11.05.17.
 */
public class SumThread extends Thread{
    int[] array;
    int startIndex;
    int endIndex;
    double result;
    public SumThread(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    public double getResult() {
        return result;
    }

    @Override
    public void run(){
        for(int i = startIndex; i<endIndex; i++ ){
            result+=array[i];
        }
    }
}
