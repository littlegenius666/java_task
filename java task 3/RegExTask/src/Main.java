/**
 * Main class. It runs the program.
 *
 * @author Yelyzaveta Horbachenko
 */
public class Main {
    public static void main(String[] args) {
        //Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        RecordController recordController=new RecordController(model, view);
        //Run
        controller.processUser(recordController);
    }
}
