import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    Timer timer;
    List<Sprite> sprites = new ArrayList<Sprite>();

    public void setup(){

        sprites.add(0, new Player (Color.lightGray, getWidth()/2, getHeight()/2, 12));

    }

    public void setPlayerPos(int x, int y){

        sprites.get(0).setPosition(x,y);

    }

    public void paintComponent(Graphics g){

        super.paintComponent(Graphics g){



        }

    }

    public Board(){

        setPreferredSize(new Dimension(800,800));
        setBackground(Color.BLACK);
        timer = new Timer(1000/60,this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


}
