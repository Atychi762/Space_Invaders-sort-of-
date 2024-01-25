import java.awt.*;
import javax.swing.*;

public class Sprite2D {

    // member data
    private double x, y;
    private double xSpeed = 0;
    private Image myImage;

    // constructor
    public Sprite2D(Image i){
        x = Math.random()*500;
        y = Math.random()*500;
        myImage = i;
    }

    // public interface
    public void moveEnemy(){
        // generating a random number and setting each of the four possible directions to a range of numbers
        int r = (int)(Math.random()*12);
        // if the number is less than 3 then the object moves down 3 pixels
        if(r < 3) {
            setPosition(x, y+3);
        }
        // if the number is between 3 and 6 then the object moves left 3 pixels
        else if(r < 6){
            setPosition(x-3, y);
        }
        // if the number is between 6 and 9 then the object moves right 3 pixels
        else if(r < 9){
            setPosition(x+3, y);
        }
        // if the number is greater than 9 then the object moves up 3 pixels
        else{
            setPosition(x, y-3);
        }
    }

    public void setPosition(double xx, double yy){
        x = xx;
        y = yy;
    }

    public void movePlayer(){
        setPosition(x + xSpeed, y);
    }

    public void setXSpeed(double dx){
        xSpeed = dx;
    }

    public void paint(Graphics g){
        // drawing the square with the stored member data as parameters
        g.drawImage(myImage, (int)x,(int)y, null);
    }

}
