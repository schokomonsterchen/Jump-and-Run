import javax.swing.*;

public class InfoBox {



    public InfoBox(Score score) {
        Object[] object = { "Ok"};
        JOptionPane.showMessageDialog(null, this.createString(score), "Paulheit", JOptionPane.INFORMATION_MESSAGE);
    }


    public String createString(Score score)
    {

        return "Zeit:  " + toString(score.getTime())
            + "\nLevel:  " + toString(score.getLevel())
            + "\nDistanz:  " + toString(score.getDistance())
            + "\nLiebesgrüße: " + toString(score.getMessage())
            + "\nNicht gelesen Liebesgrüße: " + toString(score.getNoMessage())
            + "\nPunkte:  " + toString(score.getPoints());
    }


    private String toString(int i)  {
        Integer stringInteger = new Integer(i);
        return stringInteger.toString();
    }

}