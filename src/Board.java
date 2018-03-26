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
    private long current, last;
    int [] xArray = new int[15];
    int [] yArray = new int[15];

    public void setup(){

        for(int i = 0; i < xArray.length; i++){
            xArray[i] = (int)(Math.random()*700);
        }

        for(int i = 0; i < yArray.length; i++){
            yArray[i] = (int)(Math.random()*300);
        }

        sprites.add(0, new Player (Color.lightGray, getWidth()/2, 600, 60));

        for(int i = 0; i < attackCount; i++){
            sprites.add(new Attack(Color.RED, xArray[i], yArray[i], 30, 30));
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

        current  = System.currentTimeMillis();
        if((current - last) > 350){
            sprites.add(new Laser(Color.GREEN, sprites.get(0).x, sprites.get(0).y, 8, 20));
            last = System.currentTimeMillis();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < sprites.size(); i++){

            sprites.get(i).move(getHeight(),getWidth());

        }
        repaint();

    }


}
