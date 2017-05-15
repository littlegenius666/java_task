import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

/**
 * Created by Yelyzaveta_Horbachen on 15.05.17.
 */
public class MockitoTests {

    @Test
    public void testTest() {
        Model model=spy(Model.class);
        ArrayList<Record> al=mock(ArrayList.class);
        Record record=mock(Record.class);
        when (model.getRecordsList()).thenReturn(al);
        when (al.get(anyInt())).thenReturn(record);
        when (record.toString()).thenReturn("success");
        View view=new View();
        Controller controller=new Controller(model, view);
        RecordController rc=mock(RecordController.class);
        try {
            when(rc.inputDataWithScanner()).thenReturn(new Record());
        } catch (LoginIsNotUniqueException e) {
            System.err.println(e.getMessage());;
        }

        controller.processUser(rc);
        verify(model,times(2)).addRecord(any());

    }
}
