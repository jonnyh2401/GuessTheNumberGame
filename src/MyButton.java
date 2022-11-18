import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    MyButton(String text){

        super.setText(text);
        this.setForeground(Color.GREEN);
        this.setFont(new Font("Comic Sans", Font.BOLD, 18));
        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(0,0,100,70);
        this.setContentAreaFilled(false);

    }
}
