
import jdk.nashorn.internal.ir.EmptyNode;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * RecordController controls the process of record filling.
 *
 * @author Yelyzaveta Horbachenko
 */
public class RecordController implements GlobalConstants {
    Model model;
    View view;

    // constructor
    public RecordController(Model model, View view) {
        this.model=model;
        this.view = view;
    }

    /**
     * Method asks to input correct data.
     * Writes a rule every time user makes a mistake.
     * By using checkInput checks if the input is correct.
     *
     * @param sc      scanner
     * @param regex   regular expression
     * @param message message with a rule.
     * @return correct value
     */
    public String inputData(Scanner sc, String regex, String message) throws LoginIsNotUniqueException  {
        view.print(message);
        String input = sc.nextLine();
        if (message.contains("nickname") && !model.loginIsUnique(input)) {
            throw new LoginIsNotUniqueException();
        }
        while (!checkInput(regex, input)) {

            view.print(WRONG_INPUT + message);
            input = sc.nextLine();
        }
        return input;
    }

    /**
     * Asks user to write yes or no. Made specially to ask
     * if user wants to write down his second mobile number
     *
     * @param sc scanner
     * @return return true if user input yes, and false if no.
     */
    public boolean userCheckInput(Scanner sc)  throws LoginIsNotUniqueException {
        return inputData(sc, REG_FOR_YES_OR_NO, INPUT_YES_OR_NO).equals("yes");
    }

    /**
     * Check the value with regular expression.
     *
     * @param regex regular expression
     * @param input message which user inputs
     * @return true if value is correct, and false if it is not
     */
    public boolean checkInput(String regex, String input) {
        return input.matches(regex);
    }

    /**
     * Controls input of all data.
     *
     * @return record object.
     */
    public Record inputDataWithScanner()  throws LoginIsNotUniqueException {
        Record record = new Record();
        String secondMobilePhoneNumber;
        Scanner sc = new Scanner(System.in);
        String lastName = inputData(sc, Record.REG_FOR_NAME, INPUT_LAST_NAME);
        String firstName = inputData(sc, Record.REG_FOR_NAME, INPUT_FIRST_NAME);
        String secondName = inputData(sc, Record.REG_FOR_NAME, INPUT_MIDDLE_NAME);
        boolean loginIsUnique=false;
        StringBuilder nickname=new StringBuilder(0);
        while (!loginIsUnique) {
            try {
                nickname.append(inputData(sc, Record.REG_FOR_NICKNAME, INPUT_NICKNAME));
            }
            catch (LoginIsNotUniqueException e){
                view.print(e.getMessage());
                continue;
            }
            loginIsUnique=true;
        }

        view.print(INPUT_COMMENT);
        String comment = sc.nextLine();
        String group = inputData(sc, generateRegForGroups(), generateMessageForGroups());
        String homePhoneNumber = inputData(sc, Record.REG_FOR_PHONE_NUMBER,
                INPUT_HOME_PHONE_NUMBER);
        String mobilePhoneNumber = inputData(sc, Record.REG_FOR_PHONE_NUMBER, INPUT_MOBILE_PHONE_NUMBER);
        if (userCheckInput(sc)) {
            secondMobilePhoneNumber = inputData(sc, Record.REG_FOR_PHONE_NUMBER, INPUT_SECOND_MOBILE_PHONE_NUMBER);
        } else {
            secondMobilePhoneNumber = null;
        }
        String email = inputData(sc, Record.REG_FOR_EMAIL, INPUT_EMAIL);
        String skype = inputData(sc, Record.REG_FOR_SKYPE, INPUT_SKYPE);
        String index = inputData(sc, Record.REG_FOR_INDEX, INPUT_INDEX);
        String city = inputData(sc, Record.REG_FOR_CITY, INPUT_CITY);
        String street = inputData(sc, Record.REG_FOR_STREET, INPUT_STREET);
        String houseNumber = inputData(sc, Record.REG_FOR_HOUSE_NUMBER, INPUT_HOUSE_NUMBER);
        String apartmentNumber = inputData(sc, Record.REG_FOR_APARTMENT_NUMBER, INPUT_APARTMENT_NUMBER);
        String inputDate = inputData(sc, Record.REG_FOR_DATE, INPUT_DATE_OF_LAST_RECORD);
        String changeDate = inputData(sc, Record.REG_FOR_DATE, INPUT_DATE_OF_CHANGE);
        record.setRecordValues(lastName, firstName, secondName, nickname.toString(), comment, group, homePhoneNumber,
                mobilePhoneNumber, secondMobilePhoneNumber, email, skype, inputDate, changeDate, index, city, street,
                houseNumber, apartmentNumber);
        view.print(END_OF_RECORD);
        return record;

    }

    /**
     * Generates regular expression for groups.
     *
     * @return string regular expression
     */
    public String generateRegForGroups() {
        StringBuilder result = new StringBuilder();
        result.append("(");
        for (Groups Group : Groups.values()) {
            result.append(Group + "|");
        }
        result.deleteCharAt(result.length() - 1);
        result.append(")");
        return result.toString();
    }

    /**
     * Generates input message with a rule for groups
     *
     * @return input message.
     */
    public String generateMessageForGroups() {
        StringBuilder result = new StringBuilder();
        result.append(INPUT_GROUP);
        for (Groups Group : Groups.values()) {
            result.append(Group + ", ");
        }
        result.deleteCharAt(result.length() - 1);
        result.deleteCharAt(result.length() - 1);
        result.append(".");
        return result.toString();
    }
}

