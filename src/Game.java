import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {

    Board board;
    static boolean leftPressed, rightPressed, spacePressed;

    public Game(){

        setVisible(true);
        setResizable(false);
        setTitle("GALAGA");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board = new Board();
        add(board);
        pack();
        setLocationRelativeTo(null);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    leftPressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    rightPressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    spacePressed = true;
                    board.laser();
                }
                if(e.getKeyCode()==KeyEvent.VK_1){
                    if(Screens.isStart()){
                        Screens.game();
                        Board.setup();
                        Attack.LRSPEED = 6;
                        Attack.UDSPEED = 6;
                        Board.lives = 3;
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_2){
                    if(Screens.isStart()){
                        Screens.game();
                        Board.setup();
                        Attack.LRSPEED = 8;
                        Attack.UDSPEED = 8;
                        Board.lives = 2;
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_3){
                    if(Screens.isStart()){
                        Screens.game();
                        Board.setup();
                        Attack.LRSPEED = 10;
                        Attack.UDSPEED = 10;
                        Board.lives = 1;
                    }
                }
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    if(Screens.isEnd()){
                        Screens.start();
                    }
                    else if(Screens.isLose()){
                        Screens.start();
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    leftPressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    rightPressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    spacePressed = false;
                }
            }
        });

    }

    public static void main(String[] args){

            Game game = new Game();
            Screens.start();
            game.board.setup();

   }

   public static boolean isLeftPressed(){
        return leftPressed;
   }

   public static boolean isRightPressed(){
        return rightPressed;
   }

   public static boolean isSpacePressed(){
        return spacePressed;
   }

}
