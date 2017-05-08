import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Yelyzaveta_Horbachen on 05.05.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoControllerTest {

    @Test
    public void testStart() {
        Model model=spy(Model.class);
        model.setLow(0);
        model.setHigh(100);
        when(model.generateNumber()).thenReturn(50);
        View view=spy(View.class);
        Reader reader=mock(Reader.class);
        when(reader.setNumberInRange(anyInt(),anyInt(),any(View.class))).thenReturn(-30).thenReturn(130).thenReturn(20).thenReturn(50);

        Controller controller1=new Controller(model,view,reader);
        controller1.start();
        verify(view).printMessage(view.HELLO);
        verify(model).generateNumber();
        verify(model).guessedRight(20, 50);
        verify(view).printMessage(view.IS_LARGER);
        verify(reader).setNumberInRange(model.getLow(),model.getHigh(), view);
        verify(model).guessedRight(50, 50);
        verify(view).printMessage(view.CONGRATULATIONS);
        verify(view).printStatsMessage(model.guesses);

        assertEquals(model.generateNumber(),reader.setNumberInRange(0,100,view));
    }

    @Test
    public void testInputGuess() {
        View view=spy(View.class);

        Reader reader=mock(Reader.class);
        when(reader.setNumberInRange(anyInt(),anyInt(),any(View.class))).thenReturn(-30).thenReturn(130).thenReturn(20).thenReturn(50);
        Model model=new Model(0,100);
        Controller controller1=new Controller(model,view,reader);

        Integer expected=20;
        Integer guess=controller1.inputGuess(model.getLow(),model.getHigh());
        verify(view,times(3)).printGuessMessage(0,100);
        verify(reader, times(3)).setNumberInRange(model.getLow(),model.getHigh(),view);
        verify(view, times(2)).printMessage(view.OUT_OF_RANGE);

        assertEquals(expected,guess);
    }

}
