package main;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// to ensure that user can close the window
        window.setResizable(false);
        window.setTitle(" SQUID GAME ");
        window.setLocationRelativeTo(null);
        GamePanel gamePanel= new GamePanel();
        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamePanel.startGameThread();


    }
}
