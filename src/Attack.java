import java.awt.*;

public class Attack extends Sprite {

    static long time = System.currentTimeMillis();
    static boolean moving = true;
    static int LRSPEED = 8;
    static int UDSPEED = 8;

    public Attack(Color color, int x, int y, int width, int height) {

        super(color, x, y, width, height);

    }

    @Override
    public void paint(Graphics g) {

        g.setColor(color);
        g.fillRect(x, y, width, height);

    }

    public void move(int boardHeight, int boardWidth) {

        long changeTime = System.currentTimeMillis() - time;
        if (changeTime > 5000) {
            moving = !moving;
            time = System.currentTimeMillis();
        }

        if(moving){
            x += LRSPEED;
            if (x > boardWidth) {
                x -= 20;
                LRSPEED *= -1;
            }
            if (x < 0) {
                x += 10;
                LRSPEED *= -1;
            }
        }
        else{
            y += UDSPEED;
            if (y > 600) {
                y -= 10;
                UDSPEED *= -1;
            }
            if (y < 0) {
                y += 10;
                UDSPEED *= -1;
            }
        }
    }
}
