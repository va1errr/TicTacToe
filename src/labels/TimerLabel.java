package labels;

import main.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerLabel extends JLabel {
    private int time = 0;

    private final Timer timer = new Timer(1000, new ActionListener() {
        String seconds;

        @Override
        public void actionPerformed(ActionEvent e) {
            time++;
            seconds = String.format("%03d", time);
            setText(seconds);
        }
    });

    public TimerLabel() {
        this.setSize(50, TicTacToe.SCORE_PANEL_HEIGHT);
        this.setFont(new Font("Futura", Font.PLAIN, 16));
        this.setLocation(10, 0);

        this.reset();

        timer.start();
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void reset() {
        String seconds = String.format("%03d", time);
        this.setText(seconds);
        this.time = 0;
    }
}
