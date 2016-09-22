import javax.swing.*;

public class InfoBox {

    public InfoBox() {
        Object[] object = { "Ok"};
        JOptionPane.showMessageDialog(null, this.createString(), "Paulheit", JOptionPane.INFORMATION_MESSAGE);
    }


    public String createString() {
        return "No Information";
    }
}