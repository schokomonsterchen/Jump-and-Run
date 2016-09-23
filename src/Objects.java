import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Objects extends JPanel implements ActionListener {// implements Tickable {

    Background background;
    Player player;



    int key;
    private Image background1;
    private Image background2;

    Timer timer;


    public Objects() {
        setFocusable(true);
        background = new Background();
        player = new Player();
        key = 0;
        loadAllImages();
        this.addKeyListener(new KeyActionListener());
        timer = new Timer(5, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    /*    public void tick() {
            repaint();
        }

        public void setMovement(int newMovement) {
            movement = newMovement;
        }
      */
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        background.paint(graphics);
        player.paint(graphics);
        /*int movement = 0;
        if(movement == 1 || movement == -1) {
            picture += movement;
        }
        if (picture == fixPicture + 3500) {
            fixPicture = picture;
            x = x-2;
        } else if (picture == fixPicture - 3500) {
            fixPicture = picture;
            x = x+2;
        }
        for(int y = 0; y < 3; y++) {
            graphics.drawImage(background1, picture + (1750*(x-2+(2*y))) , 0, this);
            graphics.drawImage(background2, picture + (1750*(x-1+(y*2))), 0, this);
        }
          */
    }


    private class KeyActionListener extends KeyAdapter {
        public KeyActionListener() {
            System.out.println("KeyActionListener");
        }
        public void keyPressed(KeyEvent event) {
            key = event.getKeyCode();
            if (key == KeyEvent.VK_UP){
                background.setMovement(-2);
                player.setMovement(-2);
            } else if (key == KeyEvent.VK_DOWN){
                background.setMovement(2);
                player.setMovement(2);
            } else if(key == KeyEvent.VK_LEFT){
                background.setMovement(1);
                player.setMovement(1);
            } else if(key == KeyEvent.VK_RIGHT){
                background.setMovement(-1);
                player.setMovement(-1);
            }

        }
        public void keyReleased(KeyEvent event) {
            key = event.getKeyCode();
            if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
                background.setMovement(0);
                player.setMovement(0);
            }
        }
    }



    private void loadAllImages() {
        background1 = loadImage("Background", "image001");
        background2 = loadImage("Background", "image002");
    }

    private Image loadImage(String folder, String name) {
        String path = folder + "/" + name + ".png";
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        return imageIcon.getImage();
    }
}