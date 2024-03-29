import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InvadersApplication extends JFrame implements Runnable, KeyListener {

    // member data
    private static final Dimension WindowSize = new Dimension(600, 600);
    private static final int NumAliens = 30;
    private Sprite2D[] AliensArray = new Sprite2D[NumAliens];
    private Sprite2D PlayerShip;

    // Getting the images for the alien and player ships
    private ImageIcon icon1 = new ImageIcon("C:\\Java_Projects\\images\\alien_ship_1.png");
    private ImageIcon icon2 = new ImageIcon("C:\\Java_Projects\\images\\player_ship.png");
    private Image alienShip = icon1.getImage();
    private Image playerImage = icon2.getImage();

    // constructor
    public InvadersApplication(){
        // filling the game object array with new game objects
        for(int i = 0; i < NumAliens; i++){
            AliensArray[i] = new Sprite2D(alienShip);
        }

        // instantiating the player ship
        PlayerShip = new Sprite2D(playerImage);

        // Creating the window for the application
        this.setTitle("Space Invaders!...(Kind of)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Dimension Screen_Size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = Screen_Size.width/2 - WindowSize.width/2;
        int y = Screen_Size.height/2 - WindowSize.height/2;
        setBounds(x, y, WindowSize.width, WindowSize.height);
        setVisible(true);

        // setting the players starting position
        PlayerShip.setPosition(280, 560);

        // Creating a thread for the application
        Thread t = new Thread(this);
        t.start();

    }

    // Thread entry point
    public void run(){
        // Creating the "game" loop
        while(true){
            // iterating through all the game objects and calling their move() methods
            for(int i = 0; i < NumAliens; i++){
                AliensArray[i].moveEnemy();
            }
            // calling the players  move() method
            PlayerShip.movePlayer();
            // calling repaint each iteration to redraw the objects
            repaint();
            // trying to get the thread to sleep for 20 milliseconds and catching the interrupted exception
            try{
                Thread.sleep(20);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    // 3 keyboard event handler functions
    public void keyTyped(KeyEvent e) {
        // adding the player control using the arrow Keys
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            // if the right arrow is pressed set the player speed to 5
            PlayerShip.setXSpeed(5);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            //if the left arrow is pressed set the player speed to -5
            PlayerShip.setXSpeed(-5);
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // adding the player control using the arrow Keys
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            // if the right arrow is pressed set the player speed to 5
            PlayerShip.setXSpeed(5);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            //if the left arrow is pressed set the player speed to -5
            PlayerShip.setXSpeed(-5);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // if the 
        PlayerShip.setXSpeed(0);
    }

    // applications paint method
    public void paint(Graphics g){
        // drawing a white rectangle the size of the screen to allow for window resizing without error
        Dimension Screen_Size = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Screen_Size.width, Screen_Size.height);

        // looping through all the game objects calling their paint() methods
        for(int i = 0; i < NumAliens; i++){
            AliensArray[i].paint(g);
        }
        PlayerShip.paint(g);
    }

    // application entry point
    public static void main(String[] args){
        System.out.println("Hello world!");
        InvadersApplication ia = new InvadersApplication();
        ia.addKeyListener(ia);

    }
}


