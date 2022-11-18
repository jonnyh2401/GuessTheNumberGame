import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    //JPanel topPanel;
    JPanel guessPanel;
    JPanel middlePanel;
    JPanel bottomPanel;
    JPanel leftPanel;
    JPanel rightPanel;


    MyFrame() {

        //topPanel = new JPanel();
        guessPanel = new JPanel();
        middlePanel = new JPanel();
        bottomPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();

        //topPanel.setBounds(0,0,500,25);
        guessPanel.setBounds(100,0,500,70);
        middlePanel.setBounds(100,70,500,215);
        bottomPanel.setBounds(100,295,500,215);
        leftPanel.setBounds(0,0,100,500);
        rightPanel.setBounds(600,0,100,500);
        bottomPanel.setLayout(new BorderLayout());
        //bottomPanel.setLayout(new GridBagLayout());
        //topPanel.setLayout(new BorderLayout());
        guessPanel.setLayout(new BorderLayout());
        leftPanel.setLayout(new GridLayout(2,1));
        rightPanel.setLayout(new GridLayout(2,1));
        guessPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.setBackground(Color.LIGHT_GRAY);
        //topPanel.setBackground(Color.LIGHT_GRAY);
        //topPanel.setForeground(Color.WHITE);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(725,500);
        this.setBounds(550,300,725,500);
        this.setVisible(true);
        this.setResizable(false);
        //this.add(topPanel);
        this.add(guessPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
        this.add(leftPanel);
        this.add(rightPanel);
    }
}
