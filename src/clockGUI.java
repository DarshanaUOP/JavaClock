import javax.swing.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.util.Date;

import com.darshana.clocks.*;
/**
 * Created by acer on 18-Dec-17.
 */
public class clockGUI extends JFrame {

    GridBagConstraints con = new GridBagConstraints();

    private JPanel panBack,panTime,panDate;
    private JLabel lHr,lMin,lSec,lAP,lDay,lMonth,lTimeZone,lDot1,lDot2,lNamePlate;

    public clockGUI(){

        Color foreGround = Color.CYAN;
        Color backgroundColor = Color.BLACK;
        Font hourAndMinFont = new Font(null,Font.PLAIN,200);
        Font dayFont = new Font(null,Font.PLAIN,60);
        Font apFont = new Font(null,Font.PLAIN,40);

        panBack = new JPanel(new GridBagLayout());
        panBack.setVisible(true);
        panBack.setBackground(Color.black);
        add(panBack);

        panTime = new JPanel(new GridBagLayout());
        panTime.setVisible(true);
        panTime.setBackground(backgroundColor);
        con.gridx=0;
        con.gridy=0;
        con.weightx=2;
        con.fill = GridBagConstraints.VERTICAL;
        panBack.add(panTime,con);

        panDate = new JPanel(new GridBagLayout());
        panDate.setBackground(backgroundColor);
        panDate.setVisible(true);
        con.gridx=0;
        con.gridy=1;
        con.weightx=2;
        con.fill = GridBagConstraints.VERTICAL;
        panBack.add(panDate,con);

        lHr = new JLabel();
        lHr.setForeground(foreGround);
        lHr.setBackground(backgroundColor);
        lHr.setFont(hourAndMinFont);
        con.gridx=0;
        con.gridy=0;
        con.fill = GridBagConstraints.BOTH;
        panTime.add(lHr,con);

        lDot1 = new JLabel(":");
        lDot1.setForeground(foreGround);
        lDot1.setBackground(backgroundColor);
        lDot1.setFont(hourAndMinFont);
        con.gridx=1;
        con.gridy=0;
        con.fill = GridBagConstraints.BOTH;
        panTime.add(lDot1,con);

        lMin = new JLabel();
        lMin.setForeground(foreGround);
        lMin.setBackground(backgroundColor);
        lMin.setFont(hourAndMinFont);
        con.gridx=2;
        con.gridy=0;
        con.fill = GridBagConstraints.BOTH;
        panTime.add(lMin,con);

        lDot2 = new JLabel(":");
        lDot2.setForeground(foreGround);
        lDot2.setBackground(backgroundColor);
        lDot2.setFont(hourAndMinFont);
        con.gridx=3;
        con.gridy=0;
        con.fill = GridBagConstraints.BOTH;
        panTime.add(lDot2,con);

        lSec = new JLabel();
        lSec.setForeground(foreGround);
        lSec.setBackground(backgroundColor);
        lSec.setFont(hourAndMinFont);
        con.gridx=4;
        con.gridy=0;
        con.fill = GridBagConstraints.BOTH;
        panTime.add(lSec,con);

        lAP = new JLabel();
        lAP.setForeground(foreGround);
        lAP.setBackground(backgroundColor);
        lAP.setFont(apFont);
        con.gridx=5;
        con.gridy=0;
        con.fill = GridBagConstraints.BOTH;
        panTime.add(lAP,con);

        lDay = new JLabel();
        lDay.setForeground(foreGround);
        lDay.setBackground(backgroundColor);
        lDay.setFont(dayFont);
        con.gridx=0;
        con.gridy=0;
        con.fill = GridBagConstraints.BOTH;
        panDate.add(lDay,con);

        lMonth = new JLabel();
        lMonth.setForeground(foreGround);
        lMonth.setBackground(backgroundColor);
        lMonth.setFont(dayFont);
        con.gridx=1;
        con.gridy=0;
        con.fill = GridBagConstraints.BOTH;
        panDate.add(lMonth,con);
/**
        lTimeZone = new JLabel();
        lTimeZone.setForeground(foreGround);
        lTimeZone.setBackground(backgroundColor);
        lTimeZone.setFont(new Font(null,Font.PLAIN,10));
        con.gridx=0;
        con.gridy=3;
        con.fill = GridBagConstraints.BOTH;
        panDate.add(lTimeZone,con);
*/


        lNamePlate = new JLabel("Created by Darshana Ariyarathna");
        lNamePlate.setFont(new Font(null,Font.PLAIN,16));
        lNamePlate.setBackground(Color.green);
        lNamePlate.setEnabled(true);
        con.gridx=0;
        con.gridy=4;
        con.gridwidth=2;
        con.gridheight=1;
        con.weightx=4;
        con.weighty=0;
        con.fill = GridBagConstraints.BOTH;
        panBack.add(lNamePlate,con);


        CircularClock circularClock= new CircularClock();
        circularClock.setVisible(true);
        circularClock.setBackground(backgroundColor);
        circularClock.lineColor = foreGround;
        con.gridx=0;
        con.gridy=3;
        con.gridwidth=1;
        con.gridheight=1;
        con.weightx=1;
        con.weighty=1;
        con.fill = GridBagConstraints.BOTH;
        panBack.add(circularClock,con);

        CristalClock clock2= new CristalClock();
        clock2.setVisible(true);
        clock2.setBackground(backgroundColor);
        clock2.lineColor = Color.CYAN;
        clock2.fontColor = Color.cyan;
        con.gridx=1;
        con.gridy=3;
        con.gridwidth=1;
        con.gridheight=1;
        con.weightx=2;
        con.weighty=1;
        con.fill = GridBagConstraints.BOTH;
        panBack.add(clock2,con);
        //lTimeZone.setText(new SimpleDateFormat("z").format(new Date()));

        Thread thread = new Thread(){
            @Override public void run() {
                while (true) {
                    String h=new SimpleDateFormat("H").format(new Date());
                    String m = new SimpleDateFormat("mm").format(new Date());
                    String s = new SimpleDateFormat("ss").format(new Date());

                    int hour =Integer.valueOf(h);
                    int minutes = Integer.valueOf(m);
                    int seconds = Integer.valueOf(s);
                    int date =Integer.valueOf(new SimpleDateFormat("dd").format(new Date()) );
                    String month =new SimpleDateFormat("MMM").format(new Date());

                    lHr.setText(h);
                    lMin.setText(m);
                    lSec.setText(s);

                    circularClock.Update(hour,minutes,seconds,date,month);
                    circularClock.repaint();

                    clock2.Update(hour,minutes,seconds);
                    clock2.repaint();

                    //lAP.setText(" " + new SimpleDateFormat("a").format(new Date()));
                    lDay.setText(date  + (date == 1 || date == 21 || date == 31 ? "st" : (date == 2 || date == 22 ? "nd" : (date == 3 ? "rd" : "th")))+" of ");
                    lMonth.setText(new SimpleDateFormat("MMMM").format(new Date())+" "+ new SimpleDateFormat("yyyy").format(new Date()));
                    //lYear.setText(new SimpleDateFormat("Y").format(new Date()));

                    //lTimeZone.setText(new SimpleDateFormat("z").format(new Date()));

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                }
            }
        };thread.start();


    }
}
