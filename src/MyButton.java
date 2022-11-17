import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    MyButton(String text){

        super.setText(text);
        this.setForeground(Color.GREEN);
        this.setBackground(Color.GRAY);
        this.setBounds(0,100,100,100);
        this.setBorder(BorderFactory.createEtchedBorder());

    }
}
