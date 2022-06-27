import javax.swing.*;
import java.awt.Font;
import java.awt.Color;

public class theLabel extends JLabel {

     theLabel(){
          this.setText("Text");
          this.setBounds(100,100,100,75);
          //this.setVerticalTextPosition(JLabel.TOP);
          //this.setHorizontalTextPosition(JLabel.CENTER);
          this.setForeground(new Color(151, 41, 41)); //set font color of text
          this.setFont(new Font("Arial", Font.BOLD, 20));
     }

}
