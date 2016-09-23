import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window  extends JFrame {//implements ActionListener{

    int key;
    int movement;
    Objects objects;
    Timer timer;


    public Window(String title) {
        super(title);
        setFrame();
    }

    private void setFrame() {
        key = 0;
        movement = 0;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920,685);
        this.setVisible(true);
       // Ticker ticker = new Ticker();
        //background = new Background();
      //  ticker.add(background);
        Player player = new Player();
        //ticker.add(player);
        objects = new Objects();
        this.add(objects);
//        this.add(player);
/*        this.addKeyListener(new KeyActionListener());
        timer = new Timer(5, this);
        timer.start();
  */  }

/*    @Override
    public void actionPerformed(ActionEvent e) {
        background.setMovement(movement);
        background.repaint();
    }

    private class KeyActionListener extends KeyAdapter {
        public KeyActionListener() {
            System.out.println("KeyActionListener");
        }
        public void keyPressed(KeyEvent event) {
            key = event.getKeyCode();
            if (key == KeyEvent.VK_UP){
                movement = -2;
            } else if (key == KeyEvent.VK_DOWN){
                movement = 2;
            } else if(key == KeyEvent.VK_LEFT){
                movement = 1;
            } else if(key == KeyEvent.VK_RIGHT){
                movement = -1;
            }
        }
        public void keyReleased(KeyEvent event) {
            key = event.getKeyCode();
            if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
                movement = 0;
            }
        }
    }
*/}