package frames;

import main.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VictoryFrame extends JFrame {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;

    public VictoryFrame() {
        this.setTitle("Victory!");
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setBackground(new Color(0, 0, 255));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(2, 1));

        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(new Color(200, 200, 200));

        JLabel victoryMessage = new JLabel();

        int won = TicTacToe.currentTurn % 2 + 1;
        if (won == 1) victoryMessage.setText("<html> <p style=\"text-align: center;\"> Crosses won!<br><br> " +
                "Would like to play again?</p></html>");
        else if (won == 2) victoryMessage.setText("<html> <p style=\"text-align: center;\"> Noughts won!<br><br> " +
                "Would like to play again?</p></html>");

        Font font = new Font("Futura", Font.PLAIN, 16);
        victoryMessage.setFont(font);

        font = new Font("Futura", Font.PLAIN, 13);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(200, 200, 200));
        buttonsPanel.setLayout(null);

        JButton playButton = new JButton("Again");
        playButton.setFont(font);
        playButton.setForeground(Color.green);
        playButton.setSize(WIDTH / 4, HEIGHT / 6);
        playButton.setLocation(WIDTH / 8, 0);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                TicTacToe.playAgain();
                TicTacToe.resetTimer();
                TicTacToe.getTimer().restart();
            }
        });
        buttonsPanel.add(playButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(font);
        exitButton.setForeground(Color.red);
        exitButton.setSize(WIDTH / 4, HEIGHT / 6);
        exitButton.setLocation( 5 * WIDTH / 8, 0);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonsPanel.add(exitButton);

        messagePanel.add(victoryMessage);

        mainPanel.add(messagePanel);
        mainPanel.add(buttonsPanel);

        this.add(mainPanel);
    }
}
