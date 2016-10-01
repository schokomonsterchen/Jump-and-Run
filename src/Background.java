import javax.swing.*;
import java.awt.*;

public class Background extends JPanel {


    int movement;
    int picture;
    int fixPicture;
    int x;
    private Image background1;
    private Image background2;


    public Background(Score newScore) {
        setFocusable(true);
        movement = 0;
        picture = 0;
        fixPicture = 0;
        x = 0;
        loadAllImages();
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        if(movement != 0) {
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

    }

    public void setMovement(int newMovement) {
        movement = newMovement;
    }

    public int getPicture() {
        return picture;
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

    public int getMovement() {
        return movement;
    }
}