import java.awt.*;

public class Attack extends Sprite {

    static long time = System.currentTimeMillis();
    static int LRSPEED = 5;

    public Attack(Color color, int x, int y, int width, int height){

        super(color, x, y, width, height);

    }

    @Override
    public void paint(Graphics g){

        g.setColor(color);
        g.fillRect(x, y, width, height);

    }

    public void move(int boardHeight, int boardWidth){

        while(time < 5000){
            if(x>boardWidth){
                LRSPEED *= -1;
            }
            if(x<0){
                LRSPEED *= -1;
            }

        }

    }



}
