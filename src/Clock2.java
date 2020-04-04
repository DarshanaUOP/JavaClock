import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by acer on 20-Dec-17.
 */
public class Clock2 extends JPanel {
    int  hr,sec,min;
    boolean oneTimeKey=true;
    int radius = 200 , thickness = 15 ;
    Color lineColor = Color.GREEN;
    Color fontColor = Color.cyan;

    public void Update(int H,int M,int S){
        hr = H;
        min = M;
        sec = S;
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.translate(this.getWidth() / 2, this.getHeight() / 2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.rotate(Math.toRadians(270));

        Ellipse2D outerCircle = new Ellipse2D.Float(0,0,100,100);
        outerCircle.setFrameFromCenter(new Point(0,0),new Point(radius+thickness, radius+thickness));

        g2.draw(outerCircle);


        Arc2D.Float arcMark = new Arc2D.Float(Arc2D.PIE);
        arcMark.setFrameFromCenter(new Point(0,0),new Point(radius+10,radius+10));

        g2.setColor(lineColor);

        for (int i=0;i<=11;i++) {
            arcMark.setAngleStart(-i * 30);
            arcMark.setAngleExtent(1);
            g2.draw(arcMark);
            g2.fill(arcMark);

        }

//START TO DRAWING SECONDS;
        Ellipse2D Circle1 = new Ellipse2D.Float(0,0,100,100);
        Circle1.setFrameFromCenter(new Point(0,0),new Point(radius, radius));

        g2.setColor(Color.DARK_GRAY);
        g2.draw(Circle1);
        g2.fill(Circle1);

        Arc2D.Float arcSec = new Arc2D.Float(Arc2D.PIE);
        arcSec.setFrameFromCenter(new Point(0,0),new Point(radius,radius));

        arcSec.setAngleExtent(-6*sec);
        g2.setColor(lineColor);
        g2.draw(arcSec);
        g2.fill(arcSec);

        Arc2D.Float arcSecSeparator = new Arc2D.Float(Arc2D.PIE);
        arcSecSeparator.setFrameFromCenter(new Point(0,0),new Point(radius,radius));

        g2.setColor(Color.BLACK);
/*
        for(int i=0;i<=60;i++) {
            arcSecSeparator.setAngleStart(-6*i);
            arcSecSeparator.setAngleExtent(1);
            g2.draw(arcSecSeparator);
            g2.fill(arcSecSeparator);
        }
*/
        Ellipse2D circlex = new Ellipse2D.Float(0,0,100,100);
        circlex.setFrameFromCenter(new Point(0,0),new Point(radius-thickness, radius-thickness));
        g2.draw(circlex);
        g2.fill(circlex);

//START TO DRAWING MINUTES;
        Ellipse2D Circle2 = new Ellipse2D.Float(0,0,100,100);
        Circle2.setFrameFromCenter(new Point(0,0),new Point(radius-2*thickness, radius-2*thickness));

        g2.setColor(Color.DARK_GRAY);
        g2.draw(Circle2);
        g2.fill(Circle2);

        Arc2D.Float arcMin = new Arc2D.Float(Arc2D.PIE);
        arcMin.setFrameFromCenter(new Point(0,0),new Point(radius-2*thickness,radius-2*thickness));

        arcMin.setAngleExtent(-6*min);
        g2.setColor(lineColor);
        g2.draw(arcMin);
        g2.fill(arcMin);

        Arc2D.Float arcMinSeparator = new Arc2D.Float(Arc2D.PIE);
        arcMinSeparator.setFrameFromCenter(new Point(0,0),new Point(radius-2*thickness,radius-2*thickness));

        g2.setColor(Color.BLACK);

        for(int i=0;i<=60;i++) {
            arcSecSeparator.setAngleStart(-6*i);
            arcSecSeparator.setAngleExtent(1);
            g2.draw(arcSecSeparator);
            g2.fill(arcSecSeparator);
        }


//START TO DRAWING TEXT;
        Ellipse2D CircleMiddle = new Ellipse2D.Float(0,0,100,100);
        CircleMiddle.setFrameFromCenter(new Point(0,0),new Point(radius-3*thickness, radius-3*thickness));

        g2.setColor(Color.black);
        g2.draw(CircleMiddle);
        g2.fill(CircleMiddle);

        g2.setColor(fontColor);
        g2.rotate(Math.toRadians(90));
        g.setFont(new Font(null,Font.PLAIN,radius/2));
        FontMetrics fm = g2.getFontMetrics();

        Rectangle2D r = fm.getStringBounds(hr + "hr",g);
        int x= (0 - (int)r.getWidth())/2;
        int y= (0 - (int)r.getWidth())/2 +fm.getAscent();
        g2.drawString(hr + "hr",x,y);

        g.setFont(new Font(null,Font.PLAIN,radius/5));
        Rectangle2D r1 = fm.getStringBounds(min + ":" +sec,g);
        int x1= (0 - (int)r1.getWidth())/2 ;
        int y1= (0 -y +fm.getAscent());
        g2.drawString(min + " min " +sec+" sec",x1,y1);

    }
    
}
