/**
 * GlobalConstants is an interface that contains all global constants.
 *
 * @author Yelyzaveta Horbachenko
 */
public interface GlobalConstants {
    String INPUT_FIRST_NAME = "Write your first name. You can use only letters, the first one must be upper case. ";
    String INPUT_LAST_NAME = "Write your last name. You can use only letters, the first one must be upper case. ";
    String INPUT_MIDDLE_NAME = "Write your middle name.  You can use only letters, the first one must be upper case. ";
    String INPUT_NICKNAME = "Write your nickname. It must start with a letter, then you can use, letters, digits and \"_\". It must be from 5 to 20 symbols. ";
    String INPUT_COMMENT = "Write your comment.";
    String INPUT_GROUP = "Write your group. Choose from these: ";
    String INPUT_HOME_PHONE_NUMBER = "Write your home telephone number. It must look like \"+380445555555\" ";
    String INPUT_MOBILE_PHONE_NUMBER = "Write your mobile telephone number. It must look like \"+380505555555\" ";
    String INPUT_SECOND_MOBILE_PHONE_NUMBER = "Write your second mobile telephone number. It must look like \"+380505555555\" ";
    String INPUT_EMAIL = "Write your E-mail. You can use digits, lower case letters, \"_\", \".\" and \"-\". Then you must type \"@\" and then a domain name, which can contain 2 or 3 parts, separated by dot. For example \"bla-bla1_bla@epam.com\"";
    String INPUT_SKYPE = "Write your Skype. It must start with a letter, then you can use digits, letters,\"-\", \".\", \"_\". It must be from 6 to 30 symbols.";
    String INPUT_INDEX = "Write your index. It must contain from 4 to 6 digits.";
    String INPUT_CITY = "Write name of your city. ";
    String INPUT_STREET = "Write name of your street. Street name must begin with upper case letter. And after street name you must write street, square or road";
    String INPUT_HOUSE_NUMBER = "Write number of your house. It can look like \"999\",\"999b\" or \"999/999\". It can have a value from 0 to 999";
    String INPUT_APARTMENT_NUMBER = "Write number of you apartment. It can be from 0 to 999";
    String INPUT_DATE_OF_CHANGE = "Write date when the record book was changed at last. It must look like DD/MM/YYYY";
    String INPUT_DATE_OF_LAST_RECORD = "Write date when the last record in the record book was added. It must look like DD/MM/YYYY";
    String INPUT_YES_OR_NO = "Write \'yes\' if you want to write your second mobile phone number, and \'no\' if not. ";
    String REG_FOR_YES_OR_NO = "^(yes|no)$";
    String WRONG_INPUT = "Wrong input! ";
    String END_OF_RECORD="Record was added in Notebook.";
}
