/**
 * Created by Yelyzaveta_Horbachen on 03.05.17.
 */
public class RectangleProxy implements IRectangle {
    private Rectangle rectangle;

    public int getHeight() {
        if(rectangle == null) {
            rectangle = new Rectangle();
        }
        return rectangle.getHeight();
    };
    public void setHeight(int height) throws UnsupportedOperationException{
        if(rectangle == null) {
            rectangle = new Rectangle();
        }
        throw new UnsupportedOperationException("You can't set values");
    };
    public int getWidth() {
        if(rectangle == null) {
            rectangle = new Rectangle();
        }
        return rectangle.getWidth();
    };

    public void setWidth(int width) throws UnsupportedOperationException{
        if(rectangle == null) {
            rectangle = new Rectangle();
        }
        throw new UnsupportedOperationException("You can't set values");
    };
}
