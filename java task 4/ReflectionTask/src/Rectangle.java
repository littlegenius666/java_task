/**
 * Created by uzer on 02.05.2017.
 */
public class Rectangle extends Point{
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws IllegalArgumentException{
        if (height<0) {
            throw new IllegalArgumentException("Height must be greater than zero!");
        }
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws IllegalArgumentException {
        if (width < 0) {
            throw new IllegalArgumentException("Width must be greater than zero!");
        }
        this.width = width;
    }

    public Rectangle(int height, int width) throws IllegalArgumentException{
        setHeight(height);
        setWidth(width);
    }

    

}
