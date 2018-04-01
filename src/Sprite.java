import java.awt.*;

public class Sprite implements Move, Paint{

    Color color;
    int x, y, width, height;
    double dx, dy;
    final int SPEED = 5;

    public Sprite(Color color, int x, int y, int width, int height){

        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    @Override
    public void move(int boardHeight, int boardWidth) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void paint(Graphics g) {

    }

    public void bounce(){

        dx *= -1;
        dy *= -1;

    }

    public boolean intersects (Sprite other){

        return this.getBounds().intersects(other.getBounds());

    }

    public boolean visibilityS (){

        return false;

    }

    @Override
    public void setPosition(int x, int y) {

    }
}
