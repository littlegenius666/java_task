import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;

/**
 * Created by Yelyzaveta_Horbachen on 05.05.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoControllerTest {

    List<Integer> testData;
    @Test
    public void testStart() {
        testData = Arrays.asList(TestData.testStart1.data);
        Model model = spy(Model.class);
        model.setLow(0);
        model.setHigh(100);
        Integer expected = 50;
        when(model.generateNumber()).thenReturn(expected);
        View view = spy(View.class);
        Reader reader = mock(Reader.class);
        OngoingStubbing stubbing = when(reader.setNumberInRange(anyInt(), anyInt(), any(View.class)));
        Integer lastIndex = testData.indexOf(expected);
        if (lastIndex != -1) {
            int outOfRange = 0, inRangeGreater = 0, inRangeSmaller = 0;
            for (int i = 0; i <= lastIndex; i++) {
                int elem = testData.get(i);
                stubbing = stubbing.thenReturn(elem);
                if (elem > model.getLow() && elem < expected) {
                    inRangeSmaller++;
                }
                if (elem < model.getHigh() && elem > expected)
                    inRangeGreater++;
                }


            Controller controller1 = new Controller(model, view, reader);
            controller1.start();
            verify(view, times(1)).printMessage(view.HELLO);
            verify(model, times(1)).generateNumber();
            verify(model, times(inRangeGreater + inRangeSmaller)).guessedRight(not(eq(expected)), eq(expected));
            verify(view, times(inRangeSmaller)).printMessage(view.IS_LARGER);
            verify(view, times(inRangeGreater)).printMessage(view.IS_SMALLER);
            verify(reader, times(lastIndex + 1)).setNumberInRange(anyInt(), anyInt(), any(View.class));
            verify(model, times(1)).guessedRight(expected, expected);
            verify(view, times(1)).printMessage(view.CONGRATULATIONS);
            verify(view, times(1)).printStatsMessage(model.guesses);

            assertEquals(expected, reader.setNumberInRange(model.getLow(), model.getHigh(), view));
        } else {
            System.err.println("Test data doesn't have expected value. Please, check it again.");
            fail();
        }
    }



    @Test
    public void testInputGuess() {
        testData= Arrays.asList(TestData.testInputGuess1.data);
        View view=spy(View.class);
        Model model=new Model();
        model.setLow(0);
        model.setHigh(100);
        Reader reader=mock(Reader.class);
        OngoingStubbing stubbing = when(reader.setNumberInRange(anyInt(), anyInt(), any(View.class)));
        Integer elementInRange=null;
        for (Integer elem:testData
             ) {
            if (elem>model.getLow() && elem<model.getHigh()) {
                elementInRange=elem;
                break;
            }
        }
        if (elementInRange!=null) {
            int outOfRange = 0;
            Integer lastIndex=testData.indexOf(elementInRange);
            for (int i=0; i<=lastIndex; i++) {
                stubbing = stubbing.thenReturn(testData.get(i));
            }
            Controller controller1=new Controller(model,view,reader);
            Integer guess=controller1.inputGuess(model.getLow(),model.getHigh());
            verify(view,times(lastIndex+1)).printGuessMessage(model.getLow(),model.getHigh());
            verify(reader, times(lastIndex+1)).setNumberInRange(anyInt(),anyInt(),any(View.class));
            verify(view, times(lastIndex)).printMessage(view.OUT_OF_RANGE);

        } else {
            System.err.println("Test data doesn't have value in range ("+model.getLow()+","+model.getHigh()+"). Please, check it again.");
            fail();
        }


    }

}
