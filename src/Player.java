import java.awt.*;

public class Player extends Sprite{

    public Player(Color color, int x, int y, int diameter){

        super(color, x, y, diameter, diameter);

    }

    public void paint(Graphics g){

        g.setColor(color);
        g.fillOval(x, y, width, height);
        g.setColor(Color.MAGENTA);
        g.drawOval(x,y,width,height);

    }

    @Override
    public void move(int boardHeight,int boardWidth){

        if(x < boardWidth || x > 0){
            if(Game.isLeftPressed()){
                x -= 5;
            }
            if(Game.isRightPressed()){
                x += 5;
            }
        }
        if(x > boardWidth || x < 0){
            if(x > boardWidth){
                x -= 10;
            }
            if(x < 0){
                x += 10;
            }
        }

    }

}
