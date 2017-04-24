import java.util.ArrayList;

/**
 * Model class. It expresses model in MVC pattern and has all the logic.
 *
 * @author Yelyzaveta Horbachenko
 */

public class Model {
    /**
     * recordsList contains records.
     */
    private ArrayList<Record> recordsList = new ArrayList<Record>();

    /**
     * Adds a record to recordsList
     *
     * @param record A record to be added.
     */
    public void addRecord(Record record) {
        recordsList.add(record);
    }

    public ArrayList<Record> getRecordsList() {
        return recordsList;
    }
}
