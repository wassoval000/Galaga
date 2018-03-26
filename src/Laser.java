import java.awt.*;

public class Laser extends Sprite {

    boolean hitEdge;

    public Laser(Color color, int x, int y, int diameter){

        super(color, x, y, diameter, diameter);

    }

    public void paint(Graphics g){

        g.setColor(color);
        g.fillOval(x, y, width, height);

    }

    public boolean isHitEdge(){

        return hitEdge;

    }

    public void move(int boardWidth, int boardHeight){

        if(y < 0){
            hitEdge = true;
        }
        if(y > boardHeight){
            hitEdge = false;
        }

    }

}
