import java.util.Scanner;

/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        view.printMessage(view.HELLO);
        Integer guess = null, secret;
        secret = model.generateNumber();
        do {
            if (guess != null) {
                if (guess > secret) {
                    view.printMessage(view.IS_SMALLER);
                } else {
                    view.printMessage(view.IS_LARGER);
                }
            }
            guess = inputGuess(model.getLow(), model.getHigh());
        } while (!model.guessedRight(guess, secret));
        view.printMessage(view.CONGRATULATIONS);
    }

    public Integer inputGuess(Integer low, Integer high) {
        view.printGuessMessage(low, high);
        Integer guess = null;
        boolean isRight = false;
        while (!isRight) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                guess = sc.nextInt();
                if (guess > high || guess < low) {
                    view.printMessage(view.OUT_OF_RANGE);
                    view.printGuessMessage(low, high);
                } else {
                    isRight = true;
                }
            } else {
                view.printMessage(view.WRONG_INPUT);
                view.printGuessMessage(low, high);
            }

        }
        return guess;
    }


}
