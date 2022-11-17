import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JPanel topPanel;
    JPanel guessPanel;
    JPanel middlePanel;
    //JPanel bottomPanel;

    JPanel bottomPanel;



    MyFrame() {

        topPanel = new JPanel();
        guessPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();

        topPanel.setBounds(0,0,500,25);
        guessPanel.setBounds(0,25,500,45);
        middlePanel.setBounds(0,70,500,215);
        bottomPanel.setBounds(0,295,500,215);
        bottomPanel.setLayout(new BorderLayout());
        //bottomPanel.setLayout(new GridBagLayout());
        topPanel.setLayout(new BorderLayout());
        guessPanel.setLayout(new GridLayout(2, 0));
        guessPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setBackground(Color.LIGHT_GRAY);
        topPanel.setForeground(Color.WHITE);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setBounds(550,300,500,500);
        this.setVisible(true);
        this.setResizable(false);
        this.add(topPanel);
        this.add(guessPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
    }
}
