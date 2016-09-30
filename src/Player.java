import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

/**
 * Created by Schokomonsterchen on 22.09.2016.
 */
public class Player extends JPanel {//implements Tickable {

    private Image[] walk;
    private Image jumpImage;
    private Image slideImage;
    private int distance;
    private int movement;
    private boolean jump;
    private int countJump;
    private boolean tryJump;
    private boolean dooubleJump;
    private boolean slide;
    private boolean afterSlide;
    private int countSlide;
    private int runSlow;


    public Player(){
        setFocusable(true);
        walk = new Image[60];
        loadAllImages();
        distance = 0;
        movement = 0;
        runSlow = 0;
    }


    public void setMovement(int newMovement) {
        movement = newMovement;
    }

    public void jump() {
        if(!slide || afterSlide) {
            jump = true;
        }
    }

    public void tryJump() {
        if(jump) {
            tryJump = true;
        } else {
            tryJump = false;
            dooubleJump = false;
        }
    }

    public void tryDoubleJump() {
        if(tryJump && countJump < 100){
            dooubleJump = true;
        }
    }

    public void slide() {
        if(!jump) {
            afterSlide = false;
            slide = true;
        }
    }


    public void paint(Graphics graphics) {
        super.paint(graphics);
        Image drawImage = walkImage();
        int high = 100;
        int width = 50;
        if (jump) {
            drawImage = jumpImage;
            if (dooubleJump) {
                high = drawDoubleJump();
            } else {
                high = drawJump();
            }
        } else if (slide) {
            if(countSlide < 250) {
                drawImage = slideImage;
                high = 200;
            } else {
                calculateDistance();
                afterSlide = true;
            }
            width = drawSlide();
        } else {
            calculateDistance();
        }
        graphics.drawImage(drawImage, width, high, this);
    }



    private int drawDoubleJump() {
        int high = 0;
        countJump++;
        if(countJump > 200) {
            high = countJump - 300;
        } else {
            high = 100 - countJump;
        }

        if(countJump == 400) {
            jump = false;
            tryJump = false;
            dooubleJump = false;
            countJump = 0;
        }
        return high;
    }

    private int drawJump() {
        int high = 0;
        countJump++;
        if (countJump > 100) {
            high = countJump - 100;
        } else {
            high = 100 - countJump;
        }

        if (countJump == 200) {
            jump = false;
            countJump = 0;
        }
        return high;
    }

    private int drawSlide() {
        int width = 0;
        countSlide++;
        if(countSlide < 250) {
            width = countSlide;
        } else {
            width = 500 - countSlide;
        }


        if(countSlide == 440) {
            slide = false;
            countSlide = 0;
        }
        return width;
    }

    private void calculateDistance() {
        if (runSlow == 0 && (movement == 1 || movement == -1)) {
            distance += movement;
            runSlow = 1;
        } else if (runSlow == 1) {
            runSlow = 2;
        } else if (runSlow == 2) {
            runSlow = 0;
        }
    }

    private Image walkImage() {
        int step = 0;
        if(distance > 0) {
            step = 60 - (distance % 60);
        } else if(distance < 0) {
            step = (0-distance) % 60;
        }
        for (int x = 0; x < 60; x++) {
            if(x == step) {
                return walk[x];
            }
        }
        return null;
   }



    private void loadAllImages() {
        Integer stringInteger;
        String string;
        for (int x = 0; x < 60; x++) {
            stringInteger = new Integer(x+1);
            string = stringInteger.toString();
            walk[x] = loadImage("Walk", string);
        }
        jumpImage = loadImage("Jump", "jump");
        slideImage = loadImage("Slide", "slide");
    }

    private Image loadImage(String folder, String name) {
        try {
            String path = folder + "/" + name + ".png";
            ImageIcon imageIcon = new ImageIcon("C:/Users/Schokomonsterchen/JumpAndRun/src/" + path);
//            ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
            return imageIcon.getImage();
        } catch (NullPointerException nullP) {
            ;
        }

        return null;
    }
}