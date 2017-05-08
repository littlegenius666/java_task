import java.util.Objects;
import java.util.Scanner;

/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Controller {
    Model model;
    View view;
    Reader reader;

    public Controller(Model model, View view, Reader reader) {
        this.model = model;
        this.view = view;
        this.reader=reader;
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
            model.guesses.add(guess);
        } while (!model.guessedRight(guess, secret));
        view.printMessage(view.CONGRATULATIONS);
        view.printStatsMessage(model.guesses);
    }

    public Integer inputGuess(Integer low, Integer high) {
        Objects.requireNonNull(low);
        Objects.requireNonNull(high);
        view.printGuessMessage(low, high);
        Integer guess = null;
        boolean isRight = false;
        while (!isRight) {
            guess=reader.setNumberInRange(low,high, view);
            if (guess < high && guess > low) {
                isRight = true;
            } else {
                    view.printMessage(view.OUT_OF_RANGE);
                    view.printGuessMessage(low, high);
            }
        }
        return guess;
    }


}
