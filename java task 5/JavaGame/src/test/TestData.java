/**
 * Created by Yelyzaveta_Horbachen on 11.05.17.
 */
public enum TestData {
    testStart1(-30, 220, 20, 80, 50, 130),
    testStart2(0,50),
    testStart3(-30, 220,20),
    testInputGuess1(-30, 130, 20, 50);

    Integer[] data;

    TestData(Integer... data) {
        this.data = data;
    }


}
