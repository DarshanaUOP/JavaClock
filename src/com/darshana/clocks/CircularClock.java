package com.darshana.clocks;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by acer on 19-Dec-17.
 */
public class CircularClock extends JPanel{

    int hr,sec,min,date;
    String month;
    boolean oneTimeKey=true;
    int radius = 200;
    public Color lineColor = Color.GREEN;

    /**
     *
<<<<<<< Updated upstream
=======
     * @author Darshana
>>>>>>> Stashed changes
     * @param H Hours
     * @param M Minutes
     * @param S Seconds
     * @param DD Date
     * @param MMM Month
     */
    public void Update(int H,int M,int S,int DD,String MMM){
        hr = H;
        min = M;
        sec = S;
        date = DD;
        month = MMM;

    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2=(Graphics2D)g;

        g2.translate(this.getWidth()/2,this.getHeight()/2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.rotate(Math.toRadians(270));

        Ellipse2D bgCircle=new Ellipse2D.Float(0,0,100,100);
        bgCircle.setFrameFromCenter(new Point(0,0),new Point(radius, radius));

        Arc2D.Float arcSec = new Arc2D.Float(Arc2D.PIE);
        arcSec.setFrameFromCenter(new Point(0,0),new Point(radius,radius));

        Ellipse2D midCircle = new Ellipse2D.Float(0,0,100,100);
        midCircle.setFrameFromCenter(new Point(0,0),new Point(radius-20, radius-20));

        Arc2D.Float arcMin = new Arc2D.Float(Arc2D.PIE);
        arcMin.setFrameFromCenter(new Point(0,0),new Point(radius-20,radius-20));

        Ellipse2D endCircle = new Ellipse2D.Float(0,0,100,100);
        endCircle.setFrameFromCenter(new Point(0,0),new Point(radius-30, radius-30));

        Ellipse2D firstCircle = new Ellipse2D.Float(0,0,100,100);
        firstCircle.setFrameFromCenter(new Point(0,0),new Point(radius-10, radius-10));

        Ellipse2D outerCircle = new Ellipse2D.Float(0,0,100,100);
        outerCircle.setFrameFromCenter(new Point(0,0),new Point(radius+10, radius+10));

        Arc2D.Float arcMark = new Arc2D.Float(Arc2D.PIE);
        arcMark.setFrameFromCenter(new Point(0,0),new Point(radius+10,radius+10));

        g2.setColor(lineColor);

        for (int i=0;i<=11;i++) {
            arcMark.setAngleStart(-i * 30);
            arcMark.setAngleExtent(1);
            g2.draw(arcMark);
            g2.fill(arcMark);
        }

        arcSec.setAngleStart(0);
        arcMin.setAngleStart(0);

        arcSec.setAngleExtent(-6*sec);      //360/60 = 6;
        arcMin.setAngleExtent(-6*min);

        g2.setColor(Color.WHITE);
        g2.draw(outerCircle);
        //g2.fill(outerCircle);

        g2.setColor(Color.DARK_GRAY);
        g2.draw(bgCircle);
        g2.fill(bgCircle);

        g2.setColor(lineColor);
        g2.draw(arcSec);
        g2.fill(arcSec);

        g2.setColor(Color.black);
        g2.draw(firstCircle);
        g2.fill(firstCircle);

        g2.setColor(Color.DARK_GRAY);
        g2.draw(midCircle);
        g2.fill(midCircle);

        g2.setColor(lineColor);
        g2.draw(arcMin);
        g2.fill(arcMin);

        g2.setColor(Color.black);
        g2.draw(endCircle);
        g2.fill(endCircle);

        g2.setColor(lineColor);
        g2.rotate(Math.toRadians(90));
        g.setFont(new Font(null,Font.PLAIN,radius/2));
        FontMetrics fm = g2.getFontMetrics();
        Rectangle2D r = fm.getStringBounds(hr + "hr",g);
        int x= (0 - (int)r.getWidth())/2;
        int y= (0 - (int)r.getWidth())/2 +fm.getAscent();
        g2.drawString(hr + "hr",x,y);

        g.setFont(new Font(null,Font.PLAIN,radius/8));
        Rectangle2D r1 = fm.getStringBounds(date+"   "+month,g);
        int x1= (int) (0 - r.getWidth()/2);
        int y1= (0 - y +fm.getAscent());
        g2.drawString(date+" "+ (date == 1 || date == 21 ? "st" : (date == 2 || date == 22 ? "nd" : (date == 3 ? "rd" : "th")))+" of "+month,x1,y1);

    }

}
