import org.newdawn.slick.*;

import java.util.logging.Logger;

/**
 * Created by Maik on 01.10.2016.
 */
public class HelloWorld extends BasicGame {

    public HelloWorld(String gamename)
    {
        super("");
    }

    @Override
    public void init(GameContainer gc) throws SlickException {}

    @Override
    public void update(GameContainer gc, int i) throws SlickException {}

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        g.drawString("Howdy!", 100, 100);
    }


}
