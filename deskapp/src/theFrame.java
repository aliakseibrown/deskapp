import org.apache.pdfbox.pdmodel.PDDocument;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class theFrame implements ActionListener {

    Integer x = 100;
    Integer z = 300;
    Integer y = 100;
    Integer numBook = 1;
    String nameBook = "src/book"+numBook+"Page.java";

    JFrame frame = new JFrame();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();

    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();

    ImageIcon image1 = new ImageIcon(new ImageIcon("book.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon image2 = new ImageIcon(new ImageIcon("lib-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon image3 = new ImageIcon(new ImageIcon("subtitles-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon image4 = new ImageIcon(new ImageIcon("plus.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

    //Border border = BorderFactory.create
    //theLabel label = new theLabel();

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JPanel panelCont = new JPanel();
    JPanel firstGrandPanel = new JPanel();
    JPanel secondGrandPanel = new JPanel();
    JPanel thirdGrandPanel = new JPanel();
    CardLayout cl = new CardLayout();

    PDDocument document = new PDDocument();





    theFrame(){


        panelCont.setLayout(cl);

        firstGrandPanel.setBackground(Color.GRAY);
        secondGrandPanel.setBackground(Color.YELLOW);
        thirdGrandPanel.setBackground(Color.GREEN);

        //firstGrandPanel.add(panel4);
        //frame.add(firstGrandPanel);
        panelCont.add(firstGrandPanel, "1");
        panelCont.add(secondGrandPanel, "2");
        panelCont.add(thirdGrandPanel, "3");
        cl.show(panelCont, "1");

        label1.setText("Reading Now");
        label1.setBounds(20,0,200,70);
        label1.setFont(new Font("TimesRoman", Font.BOLD, 30));

        label2.setText("Reading");
        label2.setBounds(20,0,200,70);
        label2.setFont(new Font("TimesRoman", Font.PLAIN, 15));

        /*label3.setText("Reading Now");
        label3.setBounds(20,0,200,70);
        label3.setFont(new Font("Monospaced", Font.PLAIN, 15));
        label3.setIcon(image1);
        label3.setHorizontalAlignment(JLabel.LEFT);
         */

        panel1.setBackground(Color.GREEN);
        panel2.setBackground(Color.YELLOW);
        panel3.setBackground(Color.RED);
        panel4.setBackground(Color.BLUE);
        panel5.setBackground(Color.CYAN);

        panel1.setPreferredSize(new Dimension(100,450));
        panel2.setPreferredSize(new Dimension(20,50));
        panel3.setPreferredSize(new Dimension(20,100));
        panel4.setPreferredSize(new Dimension(100,70));
        panel5.setPreferredSize(new Dimension(100,370));

        panel1.add(label1);
        //panel4.add(label3);
        panel5.add(label2);

        panel4.add(button6);
        panel4.add(button2);
        panel4.add(button3);
        panel4.add(button4);
        panel4.add(button5);

        panel4.setLayout(new GridLayout());

        panel1.setLayout(new BorderLayout()); // give a label to know where to stay, connect to the panel
        panel1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.darkGray));
        panel5.setBorder(BorderFactory.createMatteBorder(1 , 0, 0, 0, Color.darkGray));
        panel4.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.darkGray));
        panel1.add(panel5, BorderLayout.SOUTH);

        firstGrandPanel.add(button1);
        firstGrandPanel.setLayout(null);
        button1.setIcon(image4);
        button1.setBounds(100,100,200,270);
        button1.setFocusable(false);
        button1.addActionListener(this);

        //button2.setBounds(0,0,200,200);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setIcon(image1);
        button2.setText("Reading Now");
        button2.setFont(new Font("Monospaced", Font.PLAIN, 15));

        //button2.setOpaque(false);
        //button2.setContentAreaFilled(false);
        //button2.setBorderPainted(false);

        //button3.setBounds(0,0,200,200);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setIcon(image2);
        button3.setText("Library");
        button3.setFont(new Font("Monospaced", Font.PLAIN, 15));


        //button4.setBounds(0,0,200,200);
        button4.setFocusable(false);
        button4.addActionListener(this);
        button4.setIcon(image3);
        button4.setText("Dictionary");
        button4.setFont(new Font("Monospaced", Font.PLAIN, 15));


        //frame.add(button1);
        frame.setTitle("LingContext: Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setResizable(false); // prevent from changing the size of the app

        frame.add(panelCont);
        firstGrandPanel.setLayout(new BorderLayout());
        //firstGrandPanel.add(panel4,BorderLayout.SOUTH);
        firstGrandPanel.add(panel1,BorderLayout.NORTH);
        firstGrandPanel.add(panel2,BorderLayout.WEST);
        firstGrandPanel.add(panel3,BorderLayout.EAST);


        //secondGrandPanel.setLayout(new BorderLayout());
        //secondGrandPanel.add(panel5,BorderLayout.SOUTH);

        //thirdGrandPanel.setLayout(new BorderLayout());
        //thirdGrandPanel.add(panel4,BorderLayout.SOUTH);


        //frame.add(panel1,BorderLayout.NORTH);
        //frame.add(panel2,BorderLayout.WEST);
        //frame.add(panel3,BorderLayout.EAST);
        frame.add(panel4,BorderLayout.SOUTH);
        //frame.add(panel5,BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //frame.getContentPane().setBackground(Color.DARK_GRAY); //change the color of background


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "1");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "2");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "3");
            }
        });

    }

    public static void switching(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LaunchPage();
            }
        });
    }

    //PDDocument document = PDDocument.load(new File("test.pdf"));

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button1){

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {

                    /*
                    System.out.println(file);
                    PDDocument document = Loader.loadPDF(file);
                    PDFTextStripper stripper = new PDFTextStripper();
                    String text = stripper.getText(document);
                    System.out.println("Text:" + text);
                    */
                    //String nameBook = "book1Page.java";
                    File newBook = new File(nameBook);
                    if (newBook.createNewFile()) {
                        System.out.println("File created: " + newBook.getName());
                    } else {
                        System.out.println("File already exists.");
                    }
                    numBook = numBook + 1;
                    nameBook = "src/book"+numBook+"Page.java";
                    System.out.println("The rewritten string is " + nameBook);
                    FileWriter launchPagejava = new FileWriter("LaunchPage.java");
                    launchPagejava.write(" JButton button7 = new JButton();\n" +
                            "                    button7.setBounds(100,100,200,270);\n" +
                            "                    button1.setBounds(z + 100,100,200,270);\n" +
                            "                    button7.setFocusable(false);\n" +
                            "                    button7.addActionListener(this);\n" +
                            "                    frame.add(button7);");

                    JButton button7 = new JButton();
                    button7.setBounds(100,100,200,270);
                    button1.setBounds(z + 100,100,200,270);
                    button7.setFocusable(false);
                    button7.addActionListener(this);
                    frame.add(button7);
                    z = z + z;
                    TextPage Window = new TextPage();

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
            //frame.dispose(); // close the LaucnhPage
            //TextPage Window = new TextPage();
        }
        if(e.getSource()== button2){ // Library
            image1 = new ImageIcon(new ImageIcon("book.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button2.setIcon(image1);
            image2 = new ImageIcon(new ImageIcon("lib-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button3.setIcon(image2);
            image3 = new ImageIcon(new ImageIcon("subtitles-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button4.setIcon(image3);
        }
        if(e.getSource()== button3){ // Library
            image1 = new ImageIcon(new ImageIcon("book-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button2.setIcon(image1);
            image2 = new ImageIcon(new ImageIcon("lib.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button3.setIcon(image2);
            image3 = new ImageIcon(new ImageIcon("subtitles-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button4.setIcon(image3);
        }
        if(e.getSource()== button4){ // Library
            image1 = new ImageIcon(new ImageIcon("book-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button2.setIcon(image1);
            image2 = new ImageIcon(new ImageIcon("lib-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button3.setIcon(image2);
            image3 = new ImageIcon(new ImageIcon("subtitles.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button4.setIcon(image3);
        }

        /*if(e.getSource()== button3){ // Library
            cl.show(panelCont, "2");
            //frame.dispose(); // close the LaucnhPage
            //LibraryPage Window = new LibraryPage();
        }*/
    }

}




/*public class theFrame implements ActionListener {

    Integer x = 100;
    Integer z = 100;
    Integer y = 100;
    Integer numBook = 1;
    String filewayBook = "src/book"+numBook+"Page.java";
    String classPage = "book"+numBook+"Page";

    //JButton buttonPage = new JButton(classPage);



    JFrame frame = new JFrame();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();

    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();

    ImageIcon image1 = new ImageIcon(new ImageIcon("book.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon image2 = new ImageIcon(new ImageIcon("lib-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon image3 = new ImageIcon(new ImageIcon("subtitles-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon image4 = new ImageIcon(new ImageIcon("plus.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

    //Border border = BorderFactory.create
    //theLabel label = new theLabel();

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JPanel panelCont = new JPanel();
    JPanel firstGrandPanel = new JPanel();
    JPanel secondGrandPanel = new JPanel();
    JPanel thirdGrandPanel = new JPanel();
    CardLayout cl = new CardLayout();

    PDDocument document = new PDDocument();

    JButton buttonPage = new JButton(classPage);

    theFrame(){
        File directory = new File("src/");
        int fileCount=directory.list().length;

        while (fileCount != 0) {
            try {
                File tempFile = new File(filewayBook);
                //boolean exists = tempFile.exists();
                if (tempFile.exists()) {
                    //Class.forName(classPage);
                    //String buttonPage = "button"+classPage;


                    JButton buttonPage = new JButton(classPage);
                    System.out.println("Class exists: " + classPage);

                    buttonPage.setBounds(z,100,200,270);
                    //button1.setBounds(z + 100, 100, 200, 270);
                    buttonPage.setFocusable(false);
                    buttonPage.addActionListener(this);
                    firstGrandPanel.add(buttonPage);


                    buttonPage.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            /*Class<?> clazz = null;
                            try {
                                System.out.println("lallala ..... "+classPage);
                                clazz = Class.forName("book1Page");
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                            try {
                                Object date = clazz.newInstance();
                            } catch (InstantiationException | IllegalAccessException e) {
                                e.printStackTrace();
                            } */
/*
                            try {
                                Class.forName(classPage).newInstance();
                            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            //new LaunchPage();
                            //frame.dispose();

                            //if(classPage == "book2Page"){
                            //  new book2Page();
                            //}
                            //if(classPage == "book3Page"){
                            //    new book3Page();
                            //}
                        }
                    });
                    numBook = numBook + 1;
                    classPage = "book"+numBook+"Page";
                    filewayBook = "src/book"+numBook+"Page.java";

                    z = z + 300;
                    fileCount = fileCount -1;
                } else {
                    System.out.println("no: " + classPage);

                    break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        panelCont.setLayout(cl);

        firstGrandPanel.setBackground(Color.GRAY);
        secondGrandPanel.setBackground(Color.YELLOW);
        thirdGrandPanel.setBackground(Color.GREEN);

        //firstGrandPanel.add(panel4);
        //frame.add(firstGrandPanel);
        panelCont.add(firstGrandPanel, "1");
        panelCont.add(secondGrandPanel, "2");
        panelCont.add(thirdGrandPanel, "3");
        cl.show(panelCont, "1");

        label1.setText("Reading Now");
        label1.setBounds(20,0,200,70);
        label1.setFont(new Font("TimesRoman", Font.BOLD, 30));

        label2.setText("Reading");
        label2.setBounds(20,0,200,70);
        label2.setFont(new Font("TimesRoman", Font.PLAIN, 15));

        /*label3.setText("Reading Now");
        label3.setBounds(20,0,200,70);
        label3.setFont(new Font("Monospaced", Font.PLAIN, 15));
        label3.setIcon(image1);
        label3.setHorizontalAlignment(JLabel.LEFT);
         */
/*
        panel1.setBackground(Color.GREEN);
        panel2.setBackground(Color.YELLOW);
        panel3.setBackground(Color.RED);
        panel4.setBackground(Color.BLUE);
        panel5.setBackground(Color.CYAN);

        //panel1.setPreferredSize(new Dimension(100,450));
        panel1.setBounds(0, 0, 1280, 450);
        panel2.setPreferredSize(new Dimension(20,50));
        panel3.setPreferredSize(new Dimension(20,100));
        panel4.setPreferredSize(new Dimension(100,70));
        panel5.setPreferredSize(new Dimension(100,370));

        panel1.add(label1);
        //panel4.add(label3);
        panel5.add(label2);

        panel4.add(button6);
        panel4.add(button2);
        panel4.add(button3);
        panel4.add(button4);
        panel4.add(button5);

        panel4.setLayout(new GridLayout());

        panel1.setLayout(new BorderLayout()); // give a label to know where to stay, connect to the panel
        panel1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.darkGray));
        panel5.setBorder(BorderFactory.createMatteBorder(1 , 0, 0, 0, Color.darkGray));
        panel4.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.darkGray));
        panel1.add(panel5, BorderLayout.SOUTH);

        firstGrandPanel.setLayout(null);
        firstGrandPanel.add(button1);

        button1.setIcon(image4);
        button1.setBounds(z,100,200,270);
        button1.setFocusable(false);
        button1.addActionListener(this);

        //button2.setBounds(0,0,200,200);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setIcon(image1);
        button2.setText("Reading Now");
        button2.setFont(new Font("Monospaced", Font.PLAIN, 15));

        //button2.setOpaque(false);
        //button2.setContentAreaFilled(false);
        //button2.setBorderPainted(false);

        //button3.setBounds(0,0,200,200);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setIcon(image2);
        button3.setText("Library");
        button3.setFont(new Font("Monospaced", Font.PLAIN, 15));


        //button4.setBounds(0,0,200,200);
        button4.setFocusable(false);
        button4.addActionListener(this);
        button4.setIcon(image3);
        button4.setText("Dictionary");
        button4.setFont(new Font("Monospaced", Font.PLAIN, 15));

        //frame.add(button1);
        frame.setTitle("LingContext: Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setResizable(false); // prevent from changing the size of the app

        frame.add(panelCont);
        firstGrandPanel.setLayout(null);
        firstGrandPanel.add(panel1);
        //firstGrandPanel.setLayout(new BorderLayout());
        //firstGrandPanel.add(panel4, BorderLayout.SOUTH);
        //firstGrandPanel.add(panel1,BorderLayout.NORTH);
        //firstGrandPanel.add(panel2,BorderLayout.WEST);
        //firstGrandPanel.add(panel3,BorderLayout.EAST);


        //secondGrandPanel.setLayout(new BorderLayout());
        //secondGrandPanel.add(panel5,BorderLayout.SOUTH);

        //thirdGrandPanel.setLayout(new BorderLayout());
        //thirdGrandPanel.add(panel4,BorderLayout.SOUTH);


        //frame.add(panel1,BorderLayout.NORTH);
        //frame.add(panel2,BorderLayout.WEST);
        //frame.add(panel3,BorderLayout.EAST);
        frame.add(panel4,BorderLayout.SOUTH);
        //frame.add(panel5,BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //frame.getContentPane().setBackground(Color.DARK_GRAY); //change the color of background
        System.out.println("Class exists: " + classPage);

        System.out.println("File Count:"+fileCount);

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "1");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "2");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "3");
            }
        });

    }

    public static void switching(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LaunchPage();
            }
        });
    }

    //PDDocument document = PDDocument.load(new File("test.pdf"));

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== buttonPage){
            book1Page Window = new book1Page();
        }

        if(e.getSource()== button1){

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    JButton buttonPage = new JButton(classPage);
                    /*
                    System.out.println(file);
                    PDDocument document = Loader.loadPDF(file);
                    PDFTextStripper stripper = new PDFTextStripper();
                    String text = stripper.getText(document);
                    System.out.println("Text:" + text);
                    */
                    //String nameBook = "book1Page.java";

                    /*File newBook = new File(filewayBook);
                    if (newBook.createNewFile()) {
                        System.out.println("File created: " + newBook.getName());
                    } else {
                        System.out.println("File already exists.");
                    }*/
/*
                    FileWriter launchPagejava = new FileWriter("src/book"+numBook+"Page.java");
                    launchPagejava.write("import javax.swing.*;\n" +
                            "import java.awt.*;\n" +
                            "\n" +
                            "public class book"+numBook+"Page {\n" +
                            "    JFrame frame = new JFrame();\n" +
                            "    JLabel label = new JLabel(\"This page is for: book"+numBook+"Page\");\n" +
                            "    JPanel panelText = new JPanel();\n" +
                            "\n" +
                            "    book"+numBook+"Page(){\n" +
                            "\n" +
                            "        label.setBounds(0,0,200,50);\n" +
                            "\n" +
                            "        panelText.setBackground(Color.GRAY);\n" +
                            "        panelText.setBounds(50,50,500,500);\n" +
                            "        panelText.add(label);\n" +
                            "\n" +
                            "        frame.add(panelText);\n" +
                            "        frame.setTitle(\"LingContext: Reading\");\n" +
                            "        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n" +
                            "        frame.setSize(1280,720);\n" +
                            "        //frame.add(label);\n" +
                            "        frame.setLayout(null);\n" +
                            "        frame.setVisible(true);\n" +
                            "    }\n" +
                            "}");
                    launchPagejava.close();

                    System.out.println("Class has been created by +: " + classPage);

                    buttonPage.setBounds(z,100,200,270);
                    buttonPage.setFocusable(false);
                    buttonPage.addActionListener(this);
                    //firstGrandPanel.setLayout(new FlowLayout());
                    firstGrandPanel.add(buttonPage);

                    z = z +300;
                    button1.setBounds(z,100,200,270);

                    numBook = numBook + 1;
                    filewayBook = "src/book"+numBook+"Page.java";
                    classPage = "book"+numBook+"Page";
                    System.out.println("The rewritten string is " + filewayBook);

                    //TextPage Window = new TextPage();

                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
            //frame.dispose(); // close the LaucnhPage
            //TextPage Window = new TextPage();
        }
        if(e.getSource()== button2){ // Library
            image1 = new ImageIcon(new ImageIcon("book.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button2.setIcon(image1);
            image2 = new ImageIcon(new ImageIcon("lib-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button3.setIcon(image2);
            image3 = new ImageIcon(new ImageIcon("subtitles-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button4.setIcon(image3);
        }
        if(e.getSource()== button3){ // Library
            image1 = new ImageIcon(new ImageIcon("book-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button2.setIcon(image1);
            image2 = new ImageIcon(new ImageIcon("lib.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button3.setIcon(image2);
            image3 = new ImageIcon(new ImageIcon("subtitles-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button4.setIcon(image3);
        }
        if(e.getSource()== button4){ // Library
            image1 = new ImageIcon(new ImageIcon("book-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button2.setIcon(image1);
            image2 = new ImageIcon(new ImageIcon("lib-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button3.setIcon(image2);
            image3 = new ImageIcon(new ImageIcon("subtitles.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            button4.setIcon(image3);
        }

        /*if(e.getSource()== button3){ // Library
            cl.show(panelCont, "2");
            //frame.dispose(); // close the LaucnhPage
            //LibraryPage Window = new LibraryPage();
        }*/
/*    }

}
 */

