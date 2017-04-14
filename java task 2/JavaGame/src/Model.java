import java.util.Random;

/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Model {

    private Integer low;
    private Integer high;

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Model(Integer low, Integer high) {
        this.low = low;
        this.high = high;
    }

    public Integer generateNumber() {
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    public boolean guessedRight(Integer guess, Integer secret) {
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
