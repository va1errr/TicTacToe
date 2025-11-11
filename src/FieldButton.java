import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldButton extends JButton implements ActionListener {
    boolean isOccupied = false;

    public int state = 0;

    public FieldButton() {
        Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
//        this.setBorder(border);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isOccupied) {
            if (TicTacToe.currentTurn == 1) this.setText("Cross");
            else this.setText("Nought");

            this.state = TicTacToe.currentTurn;
            TicTacToe.currentTurn = TicTacToe.currentTurn % 2 + 1;
            isOccupied = true;

            int win = TicTacToe.handleTurn();
            if (win != 0){
                System.out.println(win + " wins!");
                TicTacToe.handleVictory();
            }
        }
    }
}
