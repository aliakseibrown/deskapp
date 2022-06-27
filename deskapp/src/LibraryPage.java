import javax.swing.*;

public class LibraryPage {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("This page is for text");

    LibraryPage(){

        label.setBounds(0,0,200,50);

        frame.setTitle("LingContext: Reading");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.add(label);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
