/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Model {

    public void setWord1(String word1) {
        this.word1 = word1;
    }

    public void setWord2(String word2) {
        this.word2 = word2;
    }

    private String word1;
    private String word2;

    /**
     * Creates phrase from 2 words
     * @return phrase
     */
    public String createPhrase(){
        return this.word1+" "+ this.word2;
    }
}
