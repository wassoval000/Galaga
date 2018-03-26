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
