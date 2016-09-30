import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GoodFly extends JPanel {

    private int movement;
    private boolean[] isHigh;
    private int[] flyHigh;
    private boolean[] isLow;
    private int[] flyLow;
    private int countCatch;
    private boolean jump;
    private boolean tryJump;
    private boolean dooubleJump;
    private int messages;
    private int noMessages;
    private Image catchMe;

    public GoodFly() {
        setFocusable(true);
        movement = 0;
        isHigh = new boolean[0];
        flyHigh = new int[0];
        isLow = new boolean[1];
        flyLow = new int[1];
        isLow[0] = false;
        countCatch = 0;
        jump = false;
        tryJump = false;
        dooubleJump = false;
        messages = 0;
        noMessages = 0;
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("Catch/catch.png"));
        catchMe = imageIcon.getImage();
    }

    public void setLevel(int level) {
        int x = level % 2;
        if(x == 1) {
            isLow = setBooleanListUp(isLow);
            flyLow = setIntegerListUp(flyLow);
        } else if(x == 0) {
            isHigh = setBooleanListUp(isHigh);
            flyHigh = setIntegerListUp(flyHigh);
        }
    }

    public void setMovement(int newMovement) {
        movement = newMovement;
    }

    public void jump() {
        jump = true;
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
        if(tryJump && countCatch < 100){
            dooubleJump = true;
        }
    }



    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        messages = 0;
        if(jump) {
            countCatch++;
            if(countCatch > 350 && dooubleJump) {
                jump = false;
                countCatch = 0;
            } else if(countCatch > 200 && !dooubleJump) {
                jump = false;
                countCatch = 0;
            }
        }
        for(int x = 0; x < isLow.length; x++) {
            if(isLow[x]) {
                graphics.drawImage(catchMe,1723 + flyLow[x], 100, this);
                if (flyLow[x] < -1997) {
                    isLow[x] = false;
                    noMessages++;
                } else if((flyLow[x] == -1750 || flyLow[x] == -1751) && countCatch > 50
                        && (countCatch < 150 || (countCatch < 350 && dooubleJump))) {
                    isLow[x] = false;
                    messages++;
                } else {
                    flyLow[x] -= (1 - movement);
                }
            } else {
                do {
                    flyLow[x] = new Random().nextInt()/1000000;
                    if(flyLow[x] > -1) {
                        isLow[x] = true;
                    }
                } while (!isLow[x]);

            }
        }
        for(int x = 0; x < isHigh.length; x++) {
            if(isHigh[x]) {
                graphics.drawImage(catchMe,1723 + flyHigh[x], 10, this);
                if (flyHigh[x] < -1997) {
                    isHigh[x] = false;
                    noMessages++;
                } else if((flyHigh[x] == -1750 || flyHigh[x] == -1751) && dooubleJump && countCatch > 150 && countCatch < 250) {
                    isHigh[x] = false;
                    messages++;
                } else {
                    flyHigh[x] -= (1 - movement);
                }
            } else {
                do {
                    flyHigh[x] = new Random().nextInt()/1000000;
                    if(flyHigh[x] > -1) {
                        isHigh[x] = true;
                    }
                } while (!isHigh[x]);

            }
        }


    }

    private boolean[] setBooleanListUp(boolean[] list) {
        boolean[] newList = new boolean[list.length + 1];
        for(int y = 0; y < list.length; y++) {
            newList[y] = list[y];
        }
        newList[list.length] = false;
        return newList;
    }

    private int[] setIntegerListUp(int[] list) {
        int[] newList = new int[list.length + 1];
        for(int y = 0; y < list.length; y++) {
            newList[y] = list[y];
        }
        newList[list.length] = 0;
        return newList;
    }

    public int getMessages() {
        return messages;
    }

    public int getNoMessages() {
        return noMessages;
    }
}
