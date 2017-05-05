/**
 * Controller class. It expresses controller in MVC pattern.
 *
 * @author Yelyzaveta Horbachenko
 */
public class Controller {
    Model model = new Model();
    View view = new View();

    // constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

    }

    /**
     * The main method, which creates recordController, then creates a record and
     * prints it
     */
    public void processUser() {
        RecordController recordController = new RecordController(model, view);
        try {
            model.addRecord(recordController.inputDataWithScanner());
            model.addRecord(recordController.inputDataWithScanner());
        }
        catch (LoginIsNotUniqueException e) {
            view.print(e.getMessage());
        }
        for (int i = 0; i < model.getRecordsList().size(); i++) {
            view.print(model.getRecordsList().get(i).toString());
        }
    }

}

