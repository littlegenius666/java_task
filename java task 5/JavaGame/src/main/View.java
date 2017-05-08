import java.util.List;

/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class View {
    static String HELLO = "Добро пожаловать в 'Угадай число'!";
    static String WRONG_INPUT = "Нужно ввести число, а не символ ¬_¬";
    static String OUT_OF_RANGE = "Введённое число выходит за указанный диапазон.";
    static String IS_LARGER = "Загаданное число больше. ";
    static String IS_SMALLER = "Загаданное число меньше. ";
    static String CONGRATULATIONS = "Поздравляем! Вы выиграли! :)";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGuessMessage(Integer low, Integer high) {
        System.out.println("Введите число в диапазоне (" + low + "," + high + "):");
    }

    public void printStatsMessage(List<Integer> guesses) {
        System.out.println("Вы угадали число с " + guesses.size() + " попыток.\nВаши попытки:");
        for (int i = 0; i < guesses.size(); i++) {
            System.out.println((i + 1) + " попытка: " + guesses.get(i));
        }
    }
}
