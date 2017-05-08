import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by Yelyzaveta_Horbachen on 03.05.17.
 */
public class RectangleProxyTest {
    IRectangle rectangle;

    @Test (expected = UnsupportedOperationException.class)
    public void testSetWidth() {
        rectangle=new RectangleProxy();
        rectangle.setWidth(10);
        fail();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testSetHeight() {
        rectangle=new RectangleProxy();
        rectangle.setHeight(10);
        fail();
    }

    @Ignore("Not sure how getWidth test must be implemented")
    @Test
    public void testGetWidth() {
        rectangle=new RectangleProxy();

    }

    @Ignore("Not sure how getHeight test must be implemented")
    @Test
    public void testGetHeight() {
        rectangle=new RectangleProxy();
    }


}
