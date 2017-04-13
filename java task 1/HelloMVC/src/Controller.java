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
        model.setWord1(inputValueWithScanner(sc, 1));
        model.setWord2(inputValueWithScanner(sc, 2));
        view.printMessage(model.createPhrase());
    }

    public String inputValueWithScanner(Scanner sc, int word) {
        view.printMessage(view.INPUT_TEXT+view.WORDS[word-1]);
        boolean isequal=false;
        String row="";
        while(!isequal) {
            row=sc.next();
            if (row.equals(view.WORDS[word-1])) {
                isequal=true;
            }
            else {
                view.printMessage(view.WRONG_INPUT_INT_DATA + view.INPUT_TEXT + view.WORDS[word - 1]);
            }
        }
        return row;
    }
}
