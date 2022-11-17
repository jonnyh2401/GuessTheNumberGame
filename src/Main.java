import javax.swing.*;
import java.awt.*;


public class Main extends guessTheNumberGame{


    public static void main(String[] args) {

        JLabel logoLabel = new JLabel();
        MyButton startGame = new MyButton("Start Game");

        ImageIcon logoStart = new ImageIcon("guess-the-number.png");
        Image img = logoStart.getImage() ;
        Image newimg = img.getScaledInstance( 500,250,  java.awt.Image.SCALE_SMOOTH ) ;
        ImageIcon logo = new ImageIcon(newimg);
        logoLabel.setIcon(logo);

        MyFrame mainFrame = new MyFrame();
        mainFrame.middlePanel.add(logoLabel);
        mainFrame.bottomPanel.add(startGame);


        //mainFrame.bottomPanel.add(startGameButton);

        startGame.addActionListener(e -> {

            mainFrame.setVisible(false);
            startGame.setVisible(false);
            GuessTheNumberGame();
        });
    }

}