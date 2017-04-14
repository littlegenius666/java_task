import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Model {

    private List<String> words=new ArrayList<String>();
    public void addWord(String word)
    {
        words.add(word);
    }

    /**
     * Creates phrase from 2 words
     * @return phrase
     */
    public String createPhrase(){
        String phrase="";
        for (int i=0; i<words.size(); i++)
        {
            phrase+=words.get(i)+" ";
        }
        return phrase;
    }
}
