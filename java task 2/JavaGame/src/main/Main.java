/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Main {
    public static void main(String[] args) {
        Integer low = 0;
        Integer high = 100;
        Model model = new Model(low, high);
        View view = new View();
        Controller game = new Controller(model, view);
        game.start();
    }
}
