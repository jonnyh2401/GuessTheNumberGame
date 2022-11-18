import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {

    MyLabel(int fontSize){

        this.setFont(new Font("Comic Sans",Font.BOLD,fontSize));
        this.setBounds(0,0,25,22);


    }

    MyLabel(){
        this.setText("");
        this.setBounds(0,0,25,22);
    }
}
