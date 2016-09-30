import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class BadFly extends JPanel {

    private int movement;
    private int fly;
    private boolean isFly;
    private int countCower;
    private boolean slide;
    private Image cower;

    public BadFly() {
        setFocusable(true);
        movement = 0;
        slide = false;
        fly = 0;
        isFly = false;
        countCower = 0;
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Cower/cower.png"));
        cower = imageIcon.getImage();
    }


    public void setMovement(int newMovement) {
        movement = newMovement;
    }

    public void slide() {
        slide = true;
    }


    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        if(slide) {
            countCower++;
            if(countCower == 250) {
                slide = false;
                countCower = 0;
            }
        }
        if(fly < -1650 && fly > -2100 && !slide) {
            isFly = false;
        }
        if(isFly) {
            graphics.drawImage(cower, 1723 + fly, -400, this);
            fly -= (1 - movement);
            if(fly < -7500) {
                isFly = false;
            }
        } else {
            do {
                fly = new Random().nextInt()/1000000;
                if(fly > -1) {
                    isFly = true;
                }
            } while (!isFly);
        }


    }


}