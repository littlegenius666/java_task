import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

/**
 * Created by Yelyzaveta_Horbachen on 05.05.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoControllerTest {

    /*@Mock
    private Model model;

    @Mock
    private View view;*/

    @Test
    public void testStart() {
        Model model=mock(Model.class);
        View view=mock(View.class);

        Controller controller=new Controller(model,view);
        controller.start();
    }
}
