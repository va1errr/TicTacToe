package main;

import buttons.FieldButton;
import frames.DrawFrame;
import labels.ScoreLabel;
import labels.TimerLabel;
import frames.VictoryFrame;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    public static final int WIDTH = 450;
    public static final int HEIGHT = 475;
    public static final int SCORE_PANEL_HEIGHT = HEIGHT - WIDTH;
    public static final int GAME_PANEL_HEIGHT = HEIGHT - 2 * SCORE_PANEL_HEIGHT;

    public static int currentTurn = 1;

    private static final FieldButton[] buttons = {
            new FieldButton(), new FieldButton(), new FieldButton(),
            new FieldButton(), new FieldButton(), new FieldButton(),
            new FieldButton(), new FieldButton(), new FieldButton()
    };
    private static final TimerLabel timerLabel = new TimerLabel();
    public static final ScoreLabel scoreLabel = new ScoreLabel();

    public TicTacToe () {
        this.setTitle("main.TicTacToe");
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setBackground(new Color(0, 0, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JPanel scorePanel = new JPanel();
        scorePanel.setBackground(new Color(200, 200, 200));
        scorePanel.setSize(WIDTH, SCORE_PANEL_HEIGHT);
        scorePanel.setLayout(null);
        scorePanel.add(timerLabel);
        scorePanel.add(scoreLabel);

        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 3));
        gamePanel.setBackground(new Color(210, 210, 210));
        gamePanel.setSize(WIDTH, GAME_PANEL_HEIGHT);
        gamePanel.setLocation(0, SCORE_PANEL_HEIGHT);

        for (FieldButton button : buttons) gamePanel.add(button);

        mainPanel.add(scorePanel);
        mainPanel.add(gamePanel);

        this.add(mainPanel);
    }

    public static int handleTurn() {
        int win = 0;
        if (buttons[0].state != 0 && buttons[0].state == buttons[1].state && buttons[0].state == buttons[2].state) win = buttons[0].state;
        if (buttons[3].state != 0 && buttons[3].state == buttons[4].state && buttons[3].state == buttons[5].state) win = buttons[3].state;
        if (buttons[6].state != 0 && buttons[6].state == buttons[7].state && buttons[6].state == buttons[8].state) win = buttons[6].state;
        if (buttons[0].state != 0 && buttons[0].state == buttons[3].state && buttons[0].state == buttons[6].state) win = buttons[0].state;
        if (buttons[1].state != 0 && buttons[1].state == buttons[4].state && buttons[1].state == buttons[7].state) win = buttons[1].state;
        if (buttons[2].state != 0 && buttons[2].state == buttons[5].state && buttons[2].state == buttons[8].state) win = buttons[2].state;
        if (buttons[0].state != 0 && buttons[0].state == buttons[4].state && buttons[0].state == buttons[8].state) win = buttons[0].state;
        if (buttons[2].state != 0 && buttons[2].state == buttons[4].state && buttons[2].state == buttons[6].state) win = buttons[2].state;

        boolean draw = true;
        for (FieldButton button : buttons)
            if (button.state == 0) {
                draw = false;
                break;
            }
        if (draw && win == 0) return -1;

        return win;
    }

    public static void handleVictory() {
        for (FieldButton button : buttons) button.setEnabled(false);

        VictoryFrame victoryFrame = new VictoryFrame();

        victoryFrame.setVisible(true);
        victoryFrame.setAlwaysOnTop(true);
    }

    public static void handleDraw() {
        for (FieldButton button : buttons) button.setEnabled(false);

        DrawFrame drawFrame = new DrawFrame();

        drawFrame.setVisible(true);
        drawFrame.setAlwaysOnTop(true);
    }

    public static void playAgain() {
        for (FieldButton button : buttons) {
            button.setEnabled(true);
            button.setIcon(null);
            button.state = 0;
            button.isOccupied = false;
        }
    }

    public static void resetTimer() {
        timerLabel.reset();

        String seconds = String.format("%03d", 0);
        timerLabel.setText(seconds);
    }

    public static Timer getTimer() {
        return timerLabel.getTimer();
    }

    public void main(String[] args) {
        this.setVisible(true);
    }
}
