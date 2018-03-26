import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    Timer timer;
    List<Sprite> sprites = new ArrayList<Sprite>();
    final int attackCount = 15;

    public void setup(){

        sprites.add(0, new Player (Color.lightGray, getWidth()/2, getHeight()/2, 18));

        for(int i = 0; i < attackCount; i++){
            sprites.add(new Attack(Color.CYAN, getWidth()/2, getHeight()/2, 10, 10));
        }

    }

    public void setPlayerPos(int x, int y){

        sprites.get(0).setPosition(x,y);

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        for(int i = 0; i < sprites.size(); i++){
            sprites.get(i).paint(g);
        }

    }

    public Board(){

        setPreferredSize(new Dimension(800,800));
        setBackground(Color.BLACK);
        timer = new Timer(1000/60,this);
        timer.start();

    }

    public void laser(){

        sprites.add(new Laser(Color.GREEN, sprites.get(0).x, sprites.get(0).y, 5, 7));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < sprites.size(); i++){

            sprites.get(i).move(getHeight(),getWidth());

        }
        repaint();

    }


}
