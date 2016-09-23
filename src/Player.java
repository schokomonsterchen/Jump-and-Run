import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

/**
 * Created by Schokomonsterchen on 22.09.2016.
 */
public class Player extends JPanel {//implements Tickable {


    // todo: Use arrays (or Vectors or Lists)
    private Image walk1;
    private Image walk2;
    private Image walk3;
    private Image walk4;
    private Image walk5;
    private Image walk6;
    private Image walk7;
    private Image walk8;
    private Image walk9;
    private Image walk10;
    private Image walk11;
    private Image walk12;
    private Image walk13;
    private Image walk14;
    private Image walk15;
    private Image walk16;
    private Image walk17;
    private Image walk18;
    private Image walk19;
    private Image walk20;
    private Image walk21;
    private Image walk22;
    private Image walk23;
    private Image walk24;
    private Image walk25;
    private Image walk26;
    private Image walk27;
    private Image walk28;
    private Image walk29;
    private Image walk30;
    private Image walk31;
    private Image walk32;
    private Image walk33;
    private Image walk34;
    private Image walk35;
    private Image walk36;
    private Image walk37;
    private Image walk38;
    private Image walk39;
    private Image walk40;
    private Image walk41;
    private Image walk42;
    private Image walk43;
    private Image walk44;
    private Image walk45;
    private Image walk46;
    private Image walk47;
    private Image walk48;
    private Image walk49;
    private Image walk50;
    private Image walk51;
    private Image walk52;
    private Image walk53;
    private Image walk54;
    private Image walk55;
    private Image walk56;
    private Image walk57;
    private Image walk58;
    private Image walk59;
    private Image walk60;
    private Image jumpImage;
    int distance;
    int movement;
    boolean jump;
    int countJump;
    boolean slide;
    Timer timer;


    public Player(){
        setFocusable(true);
        loadAllImages();
        distance = 0;
        movement = 0;
    /*    jump = false;
        countJump = 0;
        slide = false;
   */}


    /*    public void tick() {
            if(run == 1 || run == -1) {
                distance += run;
            } else {
                if(run == 2){
                    slide = true;
                } else if(run == -2) {
                    jump = true;
                }
            }
          repaint();
    }
    */

    public void setMovement(int newMovement) {
        movement = newMovement;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        if(movement == 1 || movement == -1) {
            distance += movement;
        }
       /* if (jump) {
            if(countJump == 0) {
                countJump = 50;
                graphics.drawImage(jumpImage, countJump, 100, this);
                countJump = 60;
            } else if(countJump > 50) {
                //if(countJump < )
            }
        } else if (slide){

        } else {
         */

            graphics.drawImage(walkImage(), 50, 100, this);
        //}
    }

    private Image walkImage() {
        int step = 0;
        if(distance > 0) {
            step = 60 - (distance % 60);
        } else if(distance < 0) {
            step = (0-distance) % 60;
        }
        if(step == 1) {
            return walk1;
        } else if (step == 2) {
            return walk2;
        } else if (step == 3) {
            return walk3;
        } else if (step == 4) {
            return walk4;
        } else if (step == 5) {
            return walk5;
        } else if (step == 6) {
            return walk6;
        } else if (step == 7) {
            return walk7;
        } else if (step == 8) {
            return walk8;
        } else if (step == 9) {
            return walk9;
        } else if (step == 10) {
            return walk10;
        } else if (step == 11) {
            return walk11;
        } else if (step == 12) {
            return walk12;
        } else if (step == 13) {
            return walk13;
        } else if (step == 14) {
            return walk14;
        } else if (step == 15) {
            return walk15;
        } else if (step == 16) {
            return walk16;
        } else if (step == 17) {
            return walk17;
        } else if (step == 18) {
            return walk18;
        } else if (step == 19) {
            return walk19;
        } else if (step == 20) {
            return walk20;
        } else if (step == 21) {
            return walk21;
        } else if (step == 22) {
            return walk22;
        } else if (step == 23) {
            return walk23;
        } else if (step == 24) {
            return walk24;
        } else if (step == 25) {
            return walk25;
        } else if (step == 26) {
            return walk26;
        } else if (step == 27) {
            return walk27;
        } else if (step == 28) {
            return walk28;
        } else if (step == 29) {
            return walk29;
        } else if (step == 30) {
            return walk30;
        } else if (step == 31) {
            return walk31;
        } else if (step == 32) {
            return walk32;
        } else if (step == 33) {
            return walk33;
        } else if (step == 34) {
            return walk34;
        } else if (step == 35) {
            return walk35;
        } else if (step == 36) {
            return walk36;
        } else if (step == 37) {
            return walk37;
        } else if (step == 38) {
            return walk38;
        } else if (step == 39) {
            return walk39;
        } else if (step == 40) {
            return walk40;
        } else if (step == 41) {
            return walk41;
        } else if (step == 42) {
            return walk42;
        } else if (step == 43) {
            return walk43;
        } else if (step == 44) {
            return walk44;
        } else if (step == 45) {
            return walk45;
        } else if (step == 46) {
            return walk46;
        } else if (step == 47) {
            return walk47;
        } else if (step == 48) {
            return walk48;
        } else if (step == 49) {
            return walk49;
        } else if (step == 50) {
            return walk50;
        } else if (step == 51) {
            return walk51;
        } else if (step == 52) {
            return walk52;
        } else if (step == 53) {
            return walk53;
        } else if (step == 54) {
            return walk54;
        } else if (step == 55) {
            return walk55;
        } else if (step == 56) {
            return walk56;
        } else if (step == 57) {
            return walk57;
        } else if (step == 58) {
            return walk58;
        } else if (step == 59) {
            return walk59;
        } else if (step == 0) {
            return walk60;
        } else {
            return null;
        }

    }

    private void loadAllImages() {
        walk1 = loadImage("Walk", "1");
        walk2 = loadImage("Walk", "2");
        walk3 = loadImage("Walk", "3");
        walk4 = loadImage("Walk", "4");
        walk5 = loadImage("Walk", "5");
        walk6 = loadImage("Walk", "6");
        walk7 = loadImage("Walk", "7");
        walk8 = loadImage("Walk", "8");
        walk9 = loadImage("Walk", "9");
        walk10 = loadImage("Walk", "10");
        walk11 = loadImage("Walk", "11");
        walk12 = loadImage("Walk", "12");
        walk13 = loadImage("Walk", "13");
        walk14 = loadImage("Walk", "14");
        walk15 = loadImage("Walk", "15");
        walk16 = loadImage("Walk", "16");
        walk17 = loadImage("Walk", "17");
        walk18 = loadImage("Walk", "18");
        walk19 = loadImage("Walk", "19");
        walk20 = loadImage("Walk", "20");
        walk21 = loadImage("Walk", "21");
        walk22 = loadImage("Walk", "22");
        walk23 = loadImage("Walk", "23");
        walk24 = loadImage("Walk", "24");
        walk25 = loadImage("Walk", "25");
        walk26 = loadImage("Walk", "26");
        walk27 = loadImage("Walk", "27");
        walk28 = loadImage("Walk", "28");
        walk29 = loadImage("Walk", "29");
        walk30 = loadImage("Walk", "30");
        walk31 = loadImage("Walk", "31");
        walk32 = loadImage("Walk", "32");
        walk33 = loadImage("Walk", "33");
        walk34 = loadImage("Walk", "34");
        walk35 = loadImage("Walk", "35");
        walk36 = loadImage("Walk", "36");
        walk37 = loadImage("Walk", "37");
        walk38 = loadImage("Walk", "38");
        walk39 = loadImage("Walk", "39");
        walk40 = loadImage("Walk", "40");
        walk41 = loadImage("Walk", "41");
        walk42 = loadImage("Walk", "42");
        walk43 = loadImage("Walk", "43");
        walk44 = loadImage("Walk", "44");
        walk45 = loadImage("Walk", "45");
        walk46 = loadImage("Walk", "46");
        walk47 = loadImage("Walk", "47");
        walk48 = loadImage("Walk", "48");
        walk49 = loadImage("Walk", "49");
        walk50 = loadImage("Walk", "50");
        walk51 = loadImage("Walk", "51");
        walk52 = loadImage("Walk", "52");
        walk53 = loadImage("Walk", "53");
        walk54 = loadImage("Walk", "54");
        walk55 = loadImage("Walk", "55");
        walk56 = loadImage("Walk", "56");
        walk57 = loadImage("Walk", "57");
        walk58 = loadImage("Walk", "58");
        walk59 = loadImage("Walk", "59");
        walk60 = loadImage("Walk", "60");
        //jumpImage = loadImage("Jump", "jump");
    }

    private Image loadImage(String folder, String name) {
        try {
            String path = folder + "/" + name + ".png";
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
            return imageIcon.getImage();
        } catch (NullPointerException nullP) {
            ;
        }

        return null;
    }
}