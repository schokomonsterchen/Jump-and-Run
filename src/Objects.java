import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Objects extends JPanel implements ActionListener {// implements Tickable {

    private Background background;
    private GoodFly goodFly;
    private BadFly badFly;
    private Player player;
    private int key;
    private Score score;
    private int speed;
    private Timer timer;


    public Objects() {
        setFocusable(true);
        background = new Background(score);
        goodFly = new GoodFly();
        badFly = new BadFly();
        player = new Player();
        key = 0;
        this.addKeyListener(new KeyActionListener());
        score = new Score();
        speed = 5;
        timer = new Timer(speed, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        score.setTimeUp();
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        background.paint(graphics);
        score.setDistance(background.getMovement());
        goodFly.paint(graphics);
        for(int x = 0; x < goodFly.getMessages(); x++) {
            score.setMessageUp();
        }
        for(int x = 0; x < goodFly.getNoMessages(); x++) {
            score.setNoMessageUp();
        }
        badFly.paint(graphics);
        player.paint(graphics);
        if (score.getMessage() > 20 * score.getLevel()) {
            timer.stop();
            speed--;
            timer = new Timer(speed, this);
            timer.start();
        }
        if(score.getMessage() > (5 * score.getLevel())) {
            score.setLevelUp();
            goodFly.setLevel(score.getLevel());
        }

    }


    private class KeyActionListener extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            key = event.getKeyCode();
            if (key == KeyEvent.VK_UP){
                player.jump();
                player.tryDoubleJump();
                goodFly.jump();
                goodFly.tryDoubleJump();
            } else if (key == KeyEvent.VK_DOWN){
                player.slide();
                badFly.slide();
            } else if(key == KeyEvent.VK_LEFT){
                background.setMovement(1);
                player.setMovement(1);
                goodFly.setMovement(1);
                badFly.setMovement(1);
            } else if(key == KeyEvent.VK_RIGHT){
                background.setMovement(-1);
                player.setMovement(-1);
                goodFly.setMovement(-1);
                badFly.setMovement(-1);
            }

        }
        public void keyReleased(KeyEvent event) {
            key = event.getKeyCode();
            if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
                background.setMovement(0);
                player.setMovement(0);
                goodFly.setMovement(0);
                badFly.setMovement(0);
            } else if(key == KeyEvent.VK_UP) {
                player.tryJump();
                goodFly.tryJump();
            }
        }
    }

    public Score getScore() {
        return score;
    }

}