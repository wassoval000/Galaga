import java.awt.*;

public class Attack extends Sprite {

    public Attack(Color color, int x, int y, int width, int height){

        super(color, x, y, width, height);

    }

    @Override
    public void paint(Graphics g){

        g.setColor(color);
        g.fillRect(x, y, width, height);

    }



}
