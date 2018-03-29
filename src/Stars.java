import java.awt.*;

public class Stars extends Sprite {

    public Stars(Color color, int x, int y, int diameter){

        super(color, x, y, diameter, diameter);

    }

    public void paint(Graphics g){

        g.setColor(color);
        g.fillOval(x, y, width, height);
        g.setColor(Color.YELLOW);
        g.drawOval(x, y, width, height);

    }

    public void move(int boardHeight, int boardWidth){

        double angle = 2 * Math.PI*(Math.random()+1);
        int speed = 5;
        int lightx = (int)(Math.random()*10);
        int lighty = (int)(Math.random()*10);
        dx = Math.sin(angle) * speed;
        dy = Math.cos(angle) * speed;
        if(lightx<=3||lightx>=8){
            lightx*=-1;
        }
        if(lighty>=5||lighty<=7){
            lighty*=-1;
        }
        x += lightx;
        y += lighty;

        if(x < 0){
            x += 10;
        }
        else if(x > boardWidth){
            x -= 20;
        }

        if(y < 0){
            y += 10;
        }
        else if(y > boardHeight){
            y -= 20;
        }

        bounce();
    }

}
