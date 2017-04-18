import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Model {

    private Integer low;
    private Integer high;
    List<Integer> guesses = new ArrayList<Integer>();

    public Integer getLow() {
        return low;
    }

    public Integer getHigh() {
        return high;
    }

    public Model() {
        this.low = 0;
        this.high = Integer.MAX_VALUE;
    }

    public Model(Integer low, Integer high) {
        Objects.requireNonNull(low);
        Objects.requireNonNull(high);
        if (low <= high) {
            this.low = low;
            this.high = high;
        } else {
            this.low = high;
            this.high = low;
        }
    }

    public Integer generateNumber() {
        Random r = new Random();
        Integer randomNumber = null;
        if (high.equals(low)) {
            randomNumber = high;
        } else {
            randomNumber = r.nextInt(high - low - 1) + low + 1;
        }
        return randomNumber;
    }

    public boolean guessedRight(Integer guess, Integer secret) {
        Objects.requireNonNull(guess);
        Objects.requireNonNull(secret);
        if (guess.equals(secret)) {
            return true;
        } else {
            if (guess > secret) {
                high = guess - 1;
            } else {
                low = guess + 1;
            }
            return false;
        }
    }
}
