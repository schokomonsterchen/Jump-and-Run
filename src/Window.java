import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Window  extends JFrame {


    public Window(String title) {
        super(title);
        setFrame();
    }

    private void setFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920,685);
        this.setVisible(true);
        this.add(new GUI());

    }
}