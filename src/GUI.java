import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JPanel {

   int fixPicture;
    int picture;
    int x;
    private Image background1;
    private Image background2;



    public GUI() {
        fixPicture = 0;
        x = 0;
        setFocusable(true);
        loadAllImages();
    }

    public void move(int run) {
        if(run == 1 || run == -1) {
            picture += run;
        }
        repaint();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
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

        //graphics.drawImage(walkImage(), 50, 100, this);
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