import java.util.Scanner;

/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Controller {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<view.WORDS.length; i++)
        {
            model.addWord(inputValueWithScanner(sc,i));
        }
        view.printMessage(model.createPhrase());
    }

    public String inputValueWithScanner(Scanner sc, int word) {
        view.printMessage(view.INPUT_TEXT+view.WORDS[word]);
        boolean isequal=false;
        String row="";
        while(!isequal) {
            row=sc.next();
            if (row.equals(view.WORDS[word])) {
                isequal=true;
            }
            else {
                view.printMessage(view.WRONG_INPUT_INT_DATA + view.INPUT_TEXT + view.WORDS[word]);
            }
        }
        return row;
    }
}
