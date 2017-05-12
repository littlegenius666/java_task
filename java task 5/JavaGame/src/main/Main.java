import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Yelyzaveta_Horbachen on 13.04.17.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Logger log = Logger.getLogger(Main.class.getName());
        PropertyConfigurator.configure("log4j.properties");

        Integer low = 0;
        Integer high = 100;
        Model model = new Model(low, high);
        View view = new View();
        Scanner sc=new Scanner(System.in);
        Reader reader=new Reader();
        Controller game = new Controller(model, view,reader);
        game.start();
        log.info("Game finished.");
    }
}
