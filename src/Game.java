import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame {

    Board board;

    public Game(){

        setVisible(true);
        setResizable(false);
        setTitle("GALAGA");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        board = new Board();
        add(board);
        pack();
        setLocationRelativeTo(null);
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }
        });

    }

    public static void main(String[] args){

        Game game = new Game();
        game.board.setup();

   }

}
