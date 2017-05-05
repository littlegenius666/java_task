/**
 * Created by Yelyzaveta_Horbachen on 03.05.17.
 */

public class Rectangle extends Point implements GLOBAL_CONSTANTS,IRectangle{

    private int height;
    private int width;

    @getValue
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws IllegalArgumentException {
        if (height==0) {
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    @getValue
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws IllegalArgumentException {
        if (width==0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
    }

    public Rectangle() {
        super();
        height=1;
        width=1;
    }

    public Rectangle(int x, int y, View view, int height, int width) throws IllegalArgumentException{
        super(x,y, view);
        setHeight(height);
        setWidth(width);

    }

    @Override
    public void transfer() {
        StringBuilder message=new StringBuilder();
        message.append(GLOBAL_CONSTANTS.START_NEW_POINT);
        if (this.getHeight()>0) {
            if (this.getWidth()>0) {
                message.append(GLOBAL_CONSTANTS.INPUT_NEW_POINT_LOW_LEFT);
            } else {
                message.append(GLOBAL_CONSTANTS.INPUT_NEW_POINT_LOW_RIGHT);
            }
        } else {
            if (this.getWidth()>0) {
                message.append(GLOBAL_CONSTANTS.INPUT_NEW_POINT_TOP_LEFT);
            } else {
                message.append(GLOBAL_CONSTANTS.INPUT_NEW_POINT_TOP_RIGHT);
            }
        }
        message.append(GLOBAL_CONSTANTS.END_NEW_POINT);
        inputCoordinates(message.toString());
    }

    @Override
    public String toString() {
        return "A"+super.toString()+"; B("+(getX()+getWidth())+","+getY()+")"
                +"; C("+(getX()+getWidth())+","+(getY()+getHeight())+")"
                +"; D("+getX()+","+(getY()+getHeight())+")";
    }

}
