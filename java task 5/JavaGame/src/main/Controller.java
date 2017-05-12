import org.apache.log4j.Logger;
import org.mockito.internal.matchers.Null;

import java.util.Objects;
import java.util.Scanner;

/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Controller {
    Model model;
    View view;
    Reader reader;
    private static Logger log = Logger.getLogger(Controller.class.getName());

    public Controller(Model model, View view, Reader reader) {
        this.model = model;
        this.view = view;
        this.reader=reader;
    }

    public void start() {
        log.info("Game started.");
        view.printMessage(view.HELLO);
        Integer guess = null, secret;
        secret = model.generateNumber();
        log.info("Generated a random number with value "+secret);
        do {
            if (guess != null) {
                if (guess > secret) {
                    view.printMessage(view.IS_SMALLER);
                    log.info("Inputted value is greater than generated.");
                } else {
                    view.printMessage(view.IS_LARGER);
                    log.info("Inputted value is smaller than generated.");
                }
            }
            guess = inputGuess(model.getLow(), model.getHigh());
            model.guesses.add(guess);
        } while (!model.guessedRight(guess, secret));
        view.printMessage(view.CONGRATULATIONS);
        view.printStatsMessage(model.guesses);
    }

    public Integer inputGuess(Integer low, Integer high) throws NullPointerException {
        Objects.requireNonNull(low);
        Objects.requireNonNull(high);
        view.printGuessMessage(low, high);
        Integer guess = null;
        boolean isRight = false;
        while (!isRight) {
            try {
                guess=reader.setNumberInRange(low,high, view);

            if (guess < high && guess > low) {
                isRight = true;
            } else {
                    view.printMessage(view.OUT_OF_RANGE);
                    log.info("Inputted value is out of model bounds.");
                    view.printGuessMessage(low, high);
            }
            } catch (NullPointerException ex) {
                continue;
            }
        }
        return guess;
    }


}
