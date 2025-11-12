package labels;

import main.TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ScoreLabel extends JLabel {
    private int[] score = {0, 0};

    public ScoreLabel() {
        this.setSize(TicTacToe.WIDTH, TicTacToe.SCORE_PANEL_HEIGHT);
        this.setFont(new Font("Futura", Font.PLAIN, 16));
        this.setText("0 : 0");
        this.setHorizontalAlignment(CENTER);
    }

    public void updateScore(int win) {
        score[win - 1]++;
        this.setText(String.format("%d : %d", score[0], score[1]));
    }
}
