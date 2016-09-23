import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private JButton open;
    private JButton adjustments;
    private JButton info;
    private JButton end;

    public Frame(String title) {
        super(title);
        setFrame();
        setButtons();


    }

    private void setFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920,685);//1500,400);
        this.setLayout(null);

        this.setVisible(true);
    }

    private void setButtons() {
        open = new JButton("komm mit mir ins Paultierland");
        open.setBounds(500,50,920,350);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == (open)) {
                    Window window = new Window("Paultierland");
                }
            }
        });
        add(open);

        adjustments = new JButton("deine Paulheit");
        adjustments.setBounds(448,450,350,60);
        adjustments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource().equals(adjustments)) {
                    Adjustments adjustmentBox = new Adjustments();
                }
            }
        });
        add(adjustments);

        info = new JButton("wie paul bist du");
        info.setBounds(800,450,350,60);
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource().equals(info)) {
                    InfoBox infoBox = new InfoBox();
                }
            }
        });
        add(info);

        end = new JButton("bis zum nächsten Paulenzertag");
        end.setBounds(1152,450,350,60);
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource().equals(end)) {
                    System.exit(0);
                }
            }
        });
        add(end);
    }


}