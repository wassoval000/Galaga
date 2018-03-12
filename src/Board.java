import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    Timer timer;
    List<Sprite> sprites = new ArrayList<~>();

    public Board(){

        setPreferredSize(new Dimension(800,800));
        setBackground(Color.BLACK);
        timer = new Timer(1000/60,this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
