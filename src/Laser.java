import java.awt.*;

public class Laser extends Sprite {

    boolean hitEdge;
    Game game;

    public Laser(Color color, int x, int y, int width, int height){

        super(color, x, y, width, height);

    }

    public void paint(Graphics g){

        g.setColor(color);
        g.fillRect(x, y, width, height);

    }

    public boolean isHitEdge(){

        return hitEdge;

    }

    public void move(int boardWidth, int boardHeight){

        if(game.isSpacePressed()){

            if(y < 0){
                hitEdge = true;
            }
            if(y > boardHeight){
                hitEdge = false;
            }

        }

    }

}
