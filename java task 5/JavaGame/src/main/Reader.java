import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * Created by Yelyzaveta_Horbachen on 08.05.17.
 */
public class Reader {
    private static Logger log = Logger.getLogger(Reader.class.getName());
    public Integer setNumberInRange(Integer low, Integer high, View view) {
        Scanner sc=new Scanner(System.in);
        Integer guess=null;
        if (sc.hasNextInt()) {
            guess = sc.nextInt();
            log.info("User inputted a number with value "+guess);
        } else {
            log.warn("User tried to input a non-numeric value "+sc.next());
            view.printMessage(view.WRONG_INPUT);
            view.printGuessMessage(low, high);
        }
        return guess;
    }
}
