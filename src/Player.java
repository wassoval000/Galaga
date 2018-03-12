import java.awt.*;

public class Player extends Sprite{

    public Player(Color color, int x, int y, int diameter){

        super(color, x, y, diameter, diameter);

    }

    public void paint(Graphics g){

        g.setColor(color);
        g.fillOval(x, y, width, height);

    }

}
