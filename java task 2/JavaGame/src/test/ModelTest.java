import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import javax.swing.*;

/**
 * Created by Yelyzaveta_Horbachen on 18.04.17.
 */
public class ModelTest {

    @Test
    public void testModelHighSmallerThanLow() {
        Model model=new Model(15,5);
        Integer expectedHigherBound=15;
        assertEquals(expectedHigherBound,model.getHigh());
    }

    @Test (expected = NullPointerException.class)
    public void testModelNull() {
        Model model=new Model(0,null);
        fail();
    }

    @Test
    public void testGenerateNumberFrom5To15() {
        Model model=new Model(5,15);
        Integer randomNumber=model.generateNumber();
        assertTrue("Сгенерировано число вне диапазона",(randomNumber>=model.getLow()||randomNumber<=model.getHigh()));
    }

    @Test
    public void testGenerateNumberFrom0ToMaxValue() {
        Model model=new Model();
        Integer randomNumber=model.generateNumber();
        assertTrue("Сгенерировано число вне диапазона",(randomNumber>=model.getLow()||randomNumber<=model.getHigh()));

    }

    /*@Test
    public void testGenerateNumberFrom0ToMaxPlus100Value() {
        Model model=new Model(0, Integer.MAX_VALUE+100);
        Integer randomNumber=model.generateNumber();
        System.out.println(randomNumber);
        assertTrue("Сгенерировано число вне диапазона",(randomNumber>=model.getLow()||randomNumber<=model.getHigh()));

    }*/

    @Test
    public void testGenerateNumberFrom0To0() {
        Model model=new Model(0,0);
        Integer randomNumber=model.generateNumber();
        assertTrue("Сгенерировано число вне диапазона",(randomNumber>=model.getLow()||randomNumber<=model.getHigh()));
    }


    @Test
    public void testRandomRange(){
        Model model=new Model(0,100);
        int iterationCount=100000;
        for (int i=0; i<iterationCount; i++) {
            Integer randomNumber=model.generateNumber();
            assertFalse("Сгенерировано число вне диапазона",(randomNumber<model.getLow()||randomNumber>model.getHigh()));
        }

    }

    @Test
    public void testRandomEquability() {
        Model model=new Model(0,100);
        int iterationCount=1000;
        int[] numbers=new int[(model.getHigh()+1)-model.getLow()];
        for (int i=0; i<numbers.length; i++) {
            numbers[i]=model.getLow()+i;
        }

        for (int i=0; i<iterationCount; i++) {
            Integer randomNumber=model.generateNumber();
            for (int j=0; j<numbers.length; j++) {
                if (randomNumber==numbers[j]) {
                    numbers[j]=-1;
                }
            }
        }

        for (int i=0; i<numbers.length; i++) {

            if (numbers[i]!=-1) {
                fail();
            }
        }
    }

    @Test
    public void testRightGuess() {
        Model model=new Model(0,100);
        Integer secret=50;
        Integer guess=50;
        boolean guessed=model.guessedRight(guess,secret);
        assertEquals(true,guessed);
    }

    @Test
    public void testWrongGuess() {
        Model model=new Model(0,100);
        Integer secret=50;
        Integer guess=-5;
        boolean guessed=model.guessedRight(guess,secret);
        assertEquals(false,guessed);
    }

    @Test (expected = NullPointerException.class)
    public void testNullGuess() {
        Model model=new Model(0,100);
        Integer secret=50;
        Integer guess=null;
        boolean guessed=model.guessedRight(guess,secret);
        fail();
    }

    @Test
    public void testHigherBound() {
        Model model=new Model(0,100);
        //guess must be greater than secret
        Integer secret=50;
        Integer guess=80;
        boolean guessed=model.guessedRight(guess,secret);
        guess--;
        assertEquals(guess,model.getHigh());
    }

    @Test
    public void testLowerBound() {
        Model model=new Model(0,100);
        //guess must be smaller than secret
        Integer secret=50;
        Integer guess=20;
        boolean guessed=model.guessedRight(guess,secret);
        guess++;
        assertEquals(guess,model.getLow());
    }

}
