import java.util.Scanner;

/**
 * Created by Yelyzaveta_Horbachen on 08.05.17.
 */
public class Reader {
    public Integer setNumberInRange(Integer low, Integer high, View view) {
        Scanner sc=new Scanner(System.in);
        Integer guess=null;
        if (sc.hasNextInt()) {
            guess = sc.nextInt();

        } else {
            view.printMessage(view.WRONG_INPUT);
            view.printGuessMessage(low, high);
        }
        return guess;
    }
}
