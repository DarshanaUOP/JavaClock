import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by acer on 18-Dec-17.
 */
public class Clock {
    public static void main(String[] args) {
        /*
        while(true){
            //System.out.println(new SimpleDateFormat("hh:mm:ss , dd,MMMMMM,yyyy").format(new Date()));
            System.out.println(new SimpleDateFormat("ss").format(new Date()));

            try{Thread.sleep(500);}catch (Exception e){}
        }
        */

        //System.out.println(new SimpleDateFormat("hh:mm:ss a, dd,MMMMMM,yyyy").format(new Date()));

        clockGUI clock = new clockGUI();
        clock.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        clock.setTitle("Clock");
        clock.setEnabled(true);
        clock.setSize(1700,1000);
        clock.setVisible(true);
    }
}
