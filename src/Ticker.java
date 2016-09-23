//import Walk.Animation;

import sun.org.mozilla.javascript.internal.Synchronizer;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Ticker {

    List<Tickable> tickables;
    ReentrantLock reentrantLock;
//    Animation animation;

    public Ticker() {//int speed, GUI newGui, Animation newAnimation) {
        tickables = new LinkedList<Tickable>();
        this.start();
        /*key = 0;
        movement = 0;
        gui = newGui;
        animation = newAnimation;

        timer = new Timer(speed, KeyActionListener);
        timer.start();
      */}

    public void add(Tickable tickable) {
        synchronized(tickables) {
            tickables.add(tickable);
        }
    }

    private void start() {
        Thread thread = new Thread(new Runnable() {
             @Override
             public void run() {
                 loop();
             }
         });
        thread.start();
    }

    private void loop() {
        while(true) {
            synchronized (tickables) {
                for (Tickable tickable : tickables) {
                    tickable.tick();
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

/*    @Override
    public void actionPerformed(ActionEvent event) {
        gui.tick(movement);
        animation.tick(movement);
    }



*/}