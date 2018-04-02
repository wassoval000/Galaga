import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    static Timer timer;
    static List<Sprite> sprites = new ArrayList<Sprite>();
    static int attackCount = 15;
    private long current, last;
    static int [] xArray = new int[15];
    static int [] yArray = new int[15];
    static int lives = 3;
    static String livesCount = "";
    static final int EDGE = 45;

    public static void setup(){

        while(sprites.size()!=0){
            sprites.remove(0);
        }

        for(int i = 0; i < xArray.length; i++){
            xArray[i] = (int)(Math.random()*700);
        }

        for(int i = 0; i < yArray.length; i++){
            yArray[i] = (int)(Math.random()*300);
        }

        sprites.add(0, new Player (Color.lightGray, 400, 600, 60));

        for(int i = 0; i < attackCount; i++) {
            sprites.add(new Attack(Color.RED, xArray[i], yArray[i], 30, 30));
        }

    }

    public void checkCollisions() {

        for (int i = 0; i < sprites.size(); i++) {
            for (int j = 0; j < sprites.size(); j++) {
                if (i != j) {
                    if (sprites.get(i).getBounds().intersects(sprites.get(j).getBounds())) {
                        if (sprites.get(i) instanceof Laser && sprites.get(j) instanceof Attack) {
                            sprites.remove(i);
                            sprites.remove(j);
                            attackCount -= 1;
                            if (attackCount == 0) {
                                Screens.end();
                            }
                            break;
                        } else if (sprites.get(i) instanceof Player && sprites.get(j) instanceof Attack) {
                            sprites.remove(j);
                            lives -= 1;
                            attackCount -= 1;
                            if (lives == 0) {
                                Screens.lose();
                                lives = 3;
                            }
                            break;
                        }
                    }
                }
            }
        }

    }

    public void setPlayerPos(int x, int y){

        sprites.get(0).setPosition(x,y);

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        setBackground(Color.BLACK);

        if(Screens.isGame()){
            super.paintComponent(g);
            for(int i = 0; i < sprites.size(); i++){
                sprites.get(i).paint(g);
            }
            toString(lives);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Serif", Font.PLAIN, 30));
            printString(livesCount, (getWidth()*2)-(EDGE*5),0,getHeight()-EDGE,g);
        }

        if(Screens.isEnd()){
            for(int i = 0; i < sprites.size(); i++){
                sprites.remove(i);
            }
            g.setColor(Color.cyan);
            g.setFont(new Font("Serif",Font.BOLD,46));
            printString("YOU WON :)", getWidth(), 0, (int)getHeight()/3, g);
            g.setFont(new Font("Serif",Font.BOLD,40));
            g.setColor(Color.cyan);
            printString("PRESS ENTER TO PLAY AGAIN <3",getWidth(),0,(int)(getHeight()/3)*2,g);
            g.setColor(Color.pink);
            printString("PRESS ENTER TO PLAY AGAIN <3",getWidth()+4,0,(int)((getHeight()/3)*2)+4,g);
        }

        if(Screens.isLose()){
            for(int i = 0; i < sprites.size(); i++){
                sprites.remove(i);
            }
            g.setColor(Color.RED);
            g.setFont(new Font("Serif",Font.BOLD,46));
            printString("YOU LOSE :(", getWidth(), 0, (int)getHeight()/3, g);
            g.setFont(new Font("Serif",Font.BOLD,40));
            g.setColor(Color.lightGray);
            printString("PRESS ENTER TO PLAY AGAIN",getWidth(),0,(int)(getHeight()/3)*2,g);
            g.setColor(Color.red);
            printString("PRESS ENTER TO PLAY AGAIN",getWidth()+4,0,(int)((getHeight()/3)*2)+4,g);
        }

        if(Screens.isStart()){
            g.setColor(Color.CYAN);
            g.setFont(new Font("Serif",Font.BOLD,46));
            printString("GALAGA", getWidth(), 0, (int)getHeight()/3, g);
            g.setColor(Color.MAGENTA);
            g.setFont(new Font("Serif",Font.BOLD,36));
            printString("PRESS 1 to Play Easy", getWidth(), 0, 450, g);
            printString("2 for Medium", getWidth(), 0, 550, g);
            printString("3 for Hard", getWidth(), 0, 650, g);
        }

    }

    private void printString(String s, int width, int x, int y, Graphics g){

        int length = (int)g.getFontMetrics().getStringBounds(s,g).getWidth();
        int start = width/2-length/2;
        g.drawString(s,start+x,y);

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

    public static String toString(int lives){

        if(lives==3){
            livesCount = "Lives Left: 3";
        }
        else if(lives==2){
            livesCount = "Lives Left: 2";
        }
        else if(lives==1){
            livesCount = "Lives Left: 1";
        }

        return livesCount;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        checkCollisions();

        for(int i = 0; i < sprites.size(); i++){

            sprites.get(i).move(getHeight(),getWidth());

        }
        repaint();

    }


}
