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

    public boolean loginIsUnique(String element) {
        for (Record record: recordsList
             ) {
            if (element.equals(record.getNickname())) {
                return false;
            }
        }
        return true;

    }

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
