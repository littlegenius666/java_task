import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * * Record expresses a record about one user.
 *
 * @author Yelyzaveta Horbachenko
 */
public class Record {
    static String DATE_FORMAT = "dd/MM/yyyy";
    static String REG_FOR_NAME = "^[A-Z][a-z]*'?[a-z]+(-[A-Z][a-z]*'?[a-z]+)?$";
    static String REG_FOR_NICKNAME = "^[a-zA-Z][\\w]{4,19}$";
    static String REG_FOR_SKYPE = "^[a-zA-Z][\\w-\\.]{4,29}$";
    static String REG_FOR_PHONE_NUMBER = "^\\+\\d{1,3}\\d{1,4}\\d{5,8}$";
    static String REG_FOR_EMAIL = "^((?=[\\w-\\._]*[a-z])[\\w-_\\.]*){4,20}@([a-z]{2,5}\\.){1,2}[a-z]{2,5}$";
    static String REG_FOR_INDEX = "^[0-9]{4,6}$";
    static String REG_FOR_STREET = "^[A-Z][a-z]*'?[a-z]+(-[A-Z][a-z]*'?[a-z]+)?(\\s[A-Z][a-z]*'?[a-z]+(-[A-Z][a-z]*'?[a-z]+)?)?\\s(street|square|road)$";
    static String REG_FOR_HOUSE_NUMBER = "^\\d{1,3}([a-z]?|[/-]\\d{1,3})$";
    static String REG_FOR_APARTMENT_NUMBER = "^\\d{1,3}$";
    static String REG_FOR_DATE = "^(0[1-9]|[12]\\d|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$";
    static String REG_FOR_CITY = "^[A-Z][a-z]*'?[a-z]+(-[A-Z][a-z]*'?[a-z]+)?(\\s[A-Z][a-z]*'?[a-z]+(-[A-Z][a-z]*'?[a-z]+)?)?$";
    static String BUILDING = "building";
    static String COMA = ",";
    static String APP = "app.";
    static String SPACE = " ";
    static String DOT = ".";

    private String lastName;
    private String firstName;
    private String secondName;
    private String allName;

    public String getNickname() {
        return nickname;
    }

    private String nickname;
    private String comment;
    private Groups userGroup;
    private String homeTelephoneNumber;
    private String mobileTelephoneNumber;
    private String secondMobileTelephoneNumber;
    private String email;
    private String skype;
    private Address userAddress;
    private String fullAddress;
    private LocalDate inputDate;
    private LocalDate changeDate;

    /**
     * Sets all the values of the record.
     *
     * @param lastName                    expresses last name of the person.
     * @param firstName                   expresses first name of the person.
     * @param secondName                  expresses second name of the person.
     * @param nickname                    expresses nickname of the person.
     * @param comment                     a comment which user can write.
     * @param userGroup                   group which user follows.
     * @param homeTelephoneNumber         home phone number.
     * @param mobileTelephoneNumber       First mobile phone number.
     * @param secondMobileTelephoneNumber Second mobile phone number.
     * @param email                       user's Email.
     * @param skype                       user's skype.
     * @param inputDate                   Date when the last record has been written. In string form.
     * @param changeDate                  Date when the last was one of the records edited. In string form.
     * @param index                       expresses postal code.
     * @param city                        expresses city where person lives.
     * @param street                      expresses street where person lives.
     * @param houseNumber                 expresses person's house number.
     * @param apartmentNumber             expresses persons apartment number.
     */
    public void setRecordValues(String lastName, String firstName, String secondName,
                                String nickname, String comment, String userGroup,
                                String homeTelephoneNumber, String mobileTelephoneNumber,
                                String secondMobileTelephoneNumber, String email, String skype,
                                String inputDate, String changeDate, String index, String city,
                                String street, String houseNumber, String apartmentNumber) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        setAllName(firstName, secondName, lastName);
        this.nickname = nickname;
        this.comment = comment;
        this.userGroup = Groups.valueOf(userGroup);
        this.homeTelephoneNumber = homeTelephoneNumber;
        this.mobileTelephoneNumber = mobileTelephoneNumber;
        this.secondMobileTelephoneNumber = secondMobileTelephoneNumber;
        this.email = email;
        this.skype = skype;
        this.userAddress = new Address(index, city, street, houseNumber, apartmentNumber);
        setFullAddress(index, city, street, houseNumber, apartmentNumber);
        setInputDate(inputDate);
        setChangeDate(changeDate);
    }

    /**
     * Creates a full name from all three parts of the name one record, which
     * contains last name and first letters of the first and second names.
     *
     * @param firstName  First Name
     * @param secondName Second Name
     * @param lastName   Last Name
     */
    public void setAllName(String firstName, String secondName, String lastName) {
        this.allName = lastName + SPACE + firstName.substring(0, 1) + DOT
                + secondName.substring(0, 1) + DOT;
    }

    /**
     * Creates a full address from all parts of address one record, which contains
     * index, city, street, house number and apartment number.
     *
     * @param index           index.
     * @param city            city.
     * @param street          street.
     * @param houseNumber     number of house.
     * @param apartmentNumber number of apartment.
     */
    public void setFullAddress(String index, String city, String street,
                               String houseNumber, String apartmentNumber) {
        StringBuilder fullAddressStringBuilder = new StringBuilder();
        fullAddressStringBuilder.append(index);
        fullAddressStringBuilder.append(COMA);
        fullAddressStringBuilder.append(city);
        fullAddressStringBuilder.append(COMA);
        fullAddressStringBuilder.append(street);
        fullAddressStringBuilder.append(COMA);
        fullAddressStringBuilder.append(BUILDING);
        fullAddressStringBuilder.append(houseNumber);
        fullAddressStringBuilder.append(COMA);
        fullAddressStringBuilder.append(APP);
        fullAddressStringBuilder.append(apartmentNumber);
        this.fullAddress = fullAddressStringBuilder.toString();
    }

    /**
     * Set the date when the last record was added. Converts data from
     * string to LocalDate. Throws DateTimeException
     *
     * @param inputDate input date in string form.
     * @throws DateTimeException the exception to be thrown,
     *                           when data is incorrect
     */
    public void setInputDate(String inputDate) throws DateTimeException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        this.inputDate = LocalDate.parse(inputDate, formatter);

    }

    /**
     * Set the date when one of the records was last edited. Converts data from
     * string to LocalDate. Throws DateTimeException
     *
     * @param changeDate input date in string form.
     * @throws DateTimeException the exception to be thrown,
     *                           when data is incorrect
     */
    public void setChangeDate(String changeDate) throws DateTimeException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        this.changeDate = LocalDate.parse(changeDate, formatter);
    }

    public String getSecondMobileTelephoneNumber() {
        return secondMobileTelephoneNumber;
    }

    @Override
    public String toString() {
        return "Record [LastName=" + lastName + ", FirstName=" + firstName + ", SecondName=" + secondName + ", AllName="
                + allName + ", Nickname=" + nickname + ", Comment=" + comment + ", Group=" + userGroup
                + ", HomeTelephoneNumber=" + homeTelephoneNumber + ", MobileTelephoneNumber=" + mobileTelephoneNumber
                + ((getSecondMobileTelephoneNumber() != null)
                ? ", SecondMobileTelephoneNumber=" + getSecondMobileTelephoneNumber() : "")
                + ", Email=" + email + ", Skype=" + skype + ", UserAddress=" + userAddress.toString() + ", FullAddress="
                + fullAddress + ", InputDate=" + inputDate + ", ChangeDate=" + changeDate + "]";
    }

}
