import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {
    public static void main(String[] args)
    {
        try
        {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new HelloWorld("Simple Slick Game"));
            appgc.setDisplayMode(1280, 720, false);
            appgc.start();
        }
        catch (SlickException ex)
        {
        }
    }
}