import java.awt.*;

public class Player extends Sprite{

    Game game;

    public Player(Color color, int x, int y, int diameter){

        super(color, x, y, diameter, diameter);

    }

    public void paint(Graphics g){

        g.setColor(color);
        g.fillOval(x, y, width, height);
        g.setColor(Color.MAGENTA);
        g.drawOval(x,y,width,height);

    }

    public void move(int boardHeight,int boardWidth){

        if(game.isLeftPressed()){
            x -= 5;
        }
        if(game.isRightPressed()){
            x += 5;
        }

    }

}
