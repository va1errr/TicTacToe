import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FieldButton extends JButton implements ActionListener{
    boolean isOccupied = false;

    public int state = 0;

    private ImageIcon cross_icon;
    private ImageIcon nought_icon;

    private static final int WIDTH = 18 * TicTacToe.WIDTH / 60;
    private static final int HEIGHT = 18 * TicTacToe.GAME_PANEL_HEIGHT / 60;

    public FieldButton() {
//        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
//        this.setBorder(border);
        try {
            cross_icon = new ImageIcon(ImageIO.read(new File("./src/images/cross.png")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));
        }
        catch (IOException _) {
            System.out.println("No cross icon found!");
        }
        try {
            nought_icon = new ImageIcon(ImageIO.read(new File("./src/images/nought.png")).getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH));
        }
        catch (IOException _) {
            System.out.println("No nought icon found!");
        }

        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isOccupied) {
            if (TicTacToe.currentTurn == 1) this.setIcon(cross_icon);
            else this.setIcon(nought_icon);

            this.state = TicTacToe.currentTurn;
            TicTacToe.currentTurn = TicTacToe.currentTurn % 2 + 1;
            isOccupied = true;

            int win = TicTacToe.handleTurn();
            if (win > 0) {
                TicTacToe.handleVictory();
                TicTacToe.scoreLabel.updateScore(win);
            }
            else if (win == -1) TicTacToe.handleDraw();

            if (win != 0) {
                Timer timer = TicTacToe.getTimer();
                timer.stop();
                TicTacToe.currentTurn = 1;
            }
        }
    }
}
