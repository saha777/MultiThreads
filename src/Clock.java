import java.awt.*;
import java.util.Date;

public class Clock extends UpdateApplet{
    public void paint(Graphics g){
        String date = new Date().toString();
        g.drawString(date, 10, 25);
    }
}
