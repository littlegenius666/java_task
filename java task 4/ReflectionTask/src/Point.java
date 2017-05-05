import java.util.Scanner;

/**
 * Created by Yelyzaveta_Horbachen on 03.05.17.
 */
public class Point {
    private int x;
    private int y;
    protected View view;

    @getValue
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @getValue
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point() {
        x=0;
        y=0;
        view=new View();
    }

    public Point (int x, int y, View view) {
        this.x=x;
        this.y=y;
        this.view=view;
    }

    public void transfer() {
        StringBuilder message=new StringBuilder();
        message.append(GLOBAL_CONSTANTS.START_NEW_POINT);
        message.append(GLOBAL_CONSTANTS.END_NEW_POINT);
        inputCoordinates(message.toString());
    }

    public void inputCoordinates(String message) {
        view.print(message.toString());
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        String[] coordinates=input.split(",");
        while ((coordinates.length!=2) || (!Methods.isInteger(coordinates[0])) || (!Methods.isInteger(coordinates[1]))) {
            view.print(GLOBAL_CONSTANTS.WRONG_INPUT+message.toString());
            input=sc.next();
            coordinates=input.split(",");
        }
        setX(Integer.parseInt(coordinates[0]));
        setY(Integer.parseInt(coordinates[1]));
    }

    @Override
    public String toString() {
        return "("+getX()+","+getY()+")";
    }
}
