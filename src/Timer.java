import Walk.Animation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Timers implements ActionListener {

    Timer timer;
    int key;
    int movement;
    GUI gui;
    Animation animation;

    public Timers(int speed, GUI newGui, Animation newAnimation) {
        key = 0;
        movement = 0;
        gui = newGui;
        animation = newAnimation;
        timer = new Timer(speed, KeyActionListener);
        timer.start();
      }

    @Override
    public void actionPerformed(ActionEvent event) {
        gui.move(movement);
        animation.move(movement);
    }

    private class KeyActionListener extends KeyAdapter {
        public KeyActionListener() {

        }
        public void keyPressed(KeyEvent event) {
            key = event.getKeyCode();
            if (key == KeyEvent.VK_UP){
                movement = -2;
               wait(30);
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
}