import javax.swing.*;
import java.awt.*;

public class TextPage {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("This page is for text");
    JPanel panelText = new JPanel();

    TextPage(){

        label.setBounds(0,0,200,50);

        panelText.setBackground(Color.GRAY);
        panelText.setBounds(50,50,500,500);
        panelText.add(label);

        frame.add(panelText);
        frame.setTitle("LingContext: Reading");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        //frame.add(label);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}