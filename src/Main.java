import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main extends guessTheNumberGame{


    public static void main(String[] args) {

        JLabel logoLabel = new JLabel();
        JButton button = new JButton();


        ImageIcon logoStart = new ImageIcon("guess-the-number.png");
        Image img = logoStart.getImage() ;
        Image newimg = img.getScaledInstance( 500,250,  java.awt.Image.SCALE_SMOOTH ) ;
        ImageIcon logo = new ImageIcon(newimg);

        logoLabel.setIcon(logo);


        button.setText("Start Game!");
        button.setForeground(Color.GREEN);
        button.setBackground(Color.GRAY);
        button.setBounds(100,100,100,100);
        button.setBorder(BorderFactory.createEtchedBorder());

        MyFrame mainFrame = new MyFrame();
        mainFrame.middlePanel.add(logoLabel);
        mainFrame.bottomPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                mainFrame.setVisible(false);
                GuessTheNumberGame();

            }
        });

        //GuessTheNumberGame();

    }

}