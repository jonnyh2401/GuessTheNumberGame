import javax.swing.*;
import java.awt.*;

public class MyGridPanel extends JPanel {

    MyButton startButton = new MyButton("Start Game");
    GridBagConstraints gbc = new GridBagConstraints();

    MyGridPanel(){

        setLayout(new GridBagLayout());
        setBounds(0,295,500,215);



    }
}
