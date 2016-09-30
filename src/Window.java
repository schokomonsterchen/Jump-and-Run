import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window  extends JFrame {

    private Objects objects;
    private JButton end;



    public Window(String title) {
        super(title);
        setFrame();
        setButtons();
    }

    private void setFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920,685);
        this.setVisible(true);
        objects = new Objects();
        this.add(objects);
    }

    private void setButtons() {
        end = new JButton("Spielende");
        end.setBounds(500,50,920,350);
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == (end)) {
                    closeWindow();
                }
            }
        });
    }

    private void closeWindow() {
        this.setVisible(false);
    }

    public Score getScore() {
        return objects.getScore();
    }

}