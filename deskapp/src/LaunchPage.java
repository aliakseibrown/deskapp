import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class LaunchPage implements ActionListener {

    Integer x = 100;
    Integer z = 100;
    Integer y = 100;
    Integer numBook = 1;
    String filewayBook = "src/book"+numBook+"Page.java";
    String classPage = "book"+numBook+"Page";

    JFrame frame = new JFrame();
    JButton buttonDictionary = new JButton();
    JButton buttonReading = new JButton();
    JButton buttonLibrary = new JButton();
    JButton buttonCreate = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JLabel labelImage = new JLabel();
    JPanel secondGrandPanel = new JPanel();
    JPanel firstGrandPanel = new JPanel();
    JPanel thirdGrandPanel = new JPanel();
    JPanel panelCont = new JPanel();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    CardLayout cl = new CardLayout();
    PDDocument document = new PDDocument();
    JButton buttonPage = new JButton(classPage);

    ImageIcon imageUser = new ImageIcon(new ImageIcon("user.png").getImage().getScaledInstance(30, 31, Image.SCALE_DEFAULT));
    ImageIcon imageReading = new ImageIcon(new ImageIcon("book.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon imageLibrary = new ImageIcon(new ImageIcon("lib-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon imageDictionary = new ImageIcon(new ImageIcon("subtitles-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon imageCreate = new ImageIcon(new ImageIcon("plus.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

    LaunchPage(){
        File directory = new File("src/");
        int fileCount = directory.list().length;
        JButton[] buttonPage = new JButton[10];

        while (fileCount != 0) {
            try {
                File tempFile = new File(filewayBook);
                if (tempFile.exists()) {
                    buttonPage[numBook] = new JButton(classPage);
                    buttonPage[numBook].setBounds(z,100,200,270);
                    buttonPage[numBook].setFocusable(false);
                    firstGrandPanel.add(buttonPage[numBook]);

                     class ButtonHandler implements ActionListener{
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                Class.forName(((JButton)e.getSource()).getText()).newInstance();
                                frame.dispose();
                            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }

                    ButtonHandler handler = new ButtonHandler();
                    buttonPage[numBook].addActionListener(handler);
                    ImageIcon imagePage = new ImageIcon(new ImageIcon("coverBook"+numBook+".png").getImage().getScaledInstance(210, 270, Image.SCALE_DEFAULT));
                    buttonPage[numBook].setIcon(imagePage);
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




        label1.setText("Reading Now");
        label1.setBounds(40,0,200,70);
        label1.setFont(new Font("TimesRoman", Font.BOLD, 30));

        labelImage.setIcon(imageUser);
        labelImage.setBounds(1200, 15, 50, 50);

        //firstGrandPanel.add(panel4);
        //frame.add(firstGrandPanel);

        firstGrandPanel.setBackground(new Color(255,255,255,255));
        secondGrandPanel.setBackground(Color.YELLOW);
        thirdGrandPanel.setBackground(Color.GREEN);

        panelCont.setLayout(cl);
        panelCont.add(firstGrandPanel, "1");
        panelCont.add(secondGrandPanel, "2");
        panelCont.add(thirdGrandPanel, "3");
        cl.show(panelCont, "1");



        /*label3.setText("Reading Now");
        label3.setBounds(20,0,200,70);
        label3.setFont(new Font("Monospaced", Font.PLAIN, 15));
        label3.setIcon(image1);
        label3.setHorizontalAlignment(JLabel.LEFT);
         */

        panel2.setBackground(Color.YELLOW);
        panel3.setBackground(Color.RED);
        panel4.setBackground(Color.white);

        panel5 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(255,255,255,255);
                Color color2 = new Color(240,240,240,255);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        //panel5.setBackground(Color.CYAN);

        //panel1.setPreferredSize(new Dimension(100,450));

        panel2.setPreferredSize(new Dimension(20,50));
        panel3.setPreferredSize(new Dimension(20,100));
        panel4.setPreferredSize(new Dimension(100,70));
        panel5.setPreferredSize(new Dimension(100,370));


        //panel4.add(label3);

        panel4.add(button6);
        panel4.add(buttonReading);
        panel4.add(buttonLibrary);
        panel4.add(buttonDictionary);
        panel4.add(button5);
        panel4.setBackground(new Color(246,247,247,255));
        panel4.setLayout(new GridLayout());
        panel4.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.lightGray));

        panel5.setBorder(BorderFactory.createMatteBorder(1 , 0, 0, 0, Color.lightGray));
        panel5.add(label2);

        panel1.add(labelImage);
        panel1.add(label1);
        panel1.setLayout(new BorderLayout()); // give a label to know where to stay, connect to the panel
        panel1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.lightGray));
        panel1.add(panel5, BorderLayout.SOUTH);
        panel1.setBounds(0, 0, 1280, 450);
        panel1.setBackground(Color.white);


        firstGrandPanel.setLayout(null);
        firstGrandPanel.add(buttonCreate);

        buttonCreate.setBounds(z,100,200,270);
        buttonCreate.addActionListener(this);
        buttonCreate.setFocusable(false);
        buttonCreate.setIcon(imageCreate);
        buttonCreate.setFocusPainted(false);

        //button2.setBounds(0,0,200,200);
        buttonReading.addActionListener(this);
        buttonReading.setIcon(imageReading);
        buttonReading.setText("Reading Now");
        buttonReading.setFont(new Font("Monospaced", Font.PLAIN, 15));
        buttonReading.setBorderPainted(false);
        buttonReading.setFocusPainted(false);
        buttonReading.setFocusable(false);
        buttonReading.setBackground(new Color(246,247,247,255));

        button5.setBorderPainted(false);
        button5.setFocusPainted(false);
        button6.setBorderPainted(false);
        button6.setFocusPainted(false);

        //button2.setOpaque(false);
        //button2.setContentAreaFilled(false);
        //button2.setBorderPainted(false);

        //button3.setBounds(0,0,200,200);
        buttonLibrary.setFocusable(false);
        buttonLibrary.addActionListener(this);
        buttonLibrary.setIcon(imageLibrary);
        buttonLibrary.setText("Library");
        buttonLibrary.setFont(new Font("Monospaced", Font.PLAIN, 15));
        buttonLibrary.setBorderPainted(false);
        buttonLibrary.setFocusPainted(false);


        //button4.setBounds(0,0,200,200);
        buttonDictionary.setFocusable(false);
        buttonDictionary.addActionListener(this);
        buttonDictionary.setIcon(imageDictionary);
        buttonDictionary.setText("Dictionary");
        buttonDictionary.setFont(new Font("Monospaced", Font.PLAIN, 15));
        buttonDictionary.setBorderPainted(false);


        //frame.add(button1);
        frame.setTitle("LingContext: Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setResizable(false); // prevent from changing the size of the app

        frame.add(panelCont);
        firstGrandPanel.setLayout(null);
        firstGrandPanel.add(panel1,BorderLayout.NORTH);
        //firstGrandPanel.add(panel1);

        //firstGrandPanel.setLayout(new BorderLayout());
        //firstGrandPanel.add(panel4, BorderLayout.SOUTH);
        firstGrandPanel.add(panel1,BorderLayout.NORTH);
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


        buttonReading.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "1");
            }
        });

        buttonLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                cl.show(panelCont, "2");
            }
        });

        buttonDictionary.addActionListener(new ActionListener() {
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
        JButton[] buttonPage = new JButton[10];

        if(e.getSource()== buttonCreate){

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    buttonPage[numBook] = new JButton(classPage);

                    PDDocument document = Loader.loadPDF(file);
                    PDFRenderer pdfRenderer = new PDFRenderer(document);
                    BufferedImage img = pdfRenderer.renderImage(0);
                    ImageIO.write(img, "JPEG",
                            new File("coverBook"+numBook+".png"));
                    document.close();

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

                    FileWriter launchPagejava = new FileWriter("src/book"+numBook+"Page.java");
                    launchPagejava.write("import javax.swing.*;\n" +
                            "import java.awt.*;\n" +
                            "\n" +
                            "public class book"+numBook+"Page {\n" +
                            "    JFrame frame = new JFrame();\n" +
                            "    JLabel label = new JLabel(\"This page is for text\");\n" +
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
                            "}"); //text write in file
                    launchPagejava.close();

                    ImageIcon imagePage = new ImageIcon(new ImageIcon("coverBook"+numBook+".png").getImage().getScaledInstance(210, 270, Image.SCALE_DEFAULT));
                    buttonPage[numBook].setIcon(imagePage);
                    buttonPage[numBook].setBounds(z,100,200,270);
                    buttonPage[numBook].setFocusable(false);
                    buttonPage[numBook].addActionListener(this);
                    //firstGrandPanel.setLayout(new FlowLayout());
                    firstGrandPanel.add( buttonPage[numBook]);
                    System.out.println(numBook);

                    class ButtonHandler implements ActionListener{
                        ClassLoader classLoader = ButtonHandler.class.getClassLoader();
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                System.out.println(numBook);
                                numBook = numBook - 1;
                                //Class aClass = classLoader.loadClass("book" + numBook + "Page");

                                //File file = new File("src/book"+numBook+"Page.java");
                                //URLClassLoader clazzLoader = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()});
                                Class.forName(((JButton)e.getSource()).getText()).newInstance();
                            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                        }}
                    }
                    ButtonHandler handler = new ButtonHandler();
                    buttonPage[numBook].addActionListener(handler);

                    z = z +300;
                    buttonCreate.setBounds(z,100,200,270);

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
            //LaunchPage Window = new LaunchPage();
            //frame.dispose(); // close the LaucnhPage
            //TextPage Window = new TextPage();
        }
        if(e.getSource()== buttonReading){ // Library
            imageReading = new ImageIcon(new ImageIcon("book.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            buttonReading.setIcon(imageReading);
            imageLibrary = new ImageIcon(new ImageIcon("lib-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            buttonLibrary.setIcon(imageLibrary);
            imageDictionary = new ImageIcon(new ImageIcon("subtitles-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            buttonDictionary.setIcon(imageDictionary);
        }
        if(e.getSource()== buttonLibrary){ // Library
            imageReading = new ImageIcon(new ImageIcon("book-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            buttonReading.setIcon(imageReading);
            imageLibrary = new ImageIcon(new ImageIcon("lib.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            buttonLibrary.setIcon(imageLibrary);
            imageDictionary = new ImageIcon(new ImageIcon("subtitles-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            buttonDictionary.setIcon(imageDictionary);
        }
        if(e.getSource()== buttonDictionary){ // Library
            imageReading = new ImageIcon(new ImageIcon("book-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            buttonReading.setIcon(imageReading);
            imageLibrary = new ImageIcon(new ImageIcon("lib-2.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            buttonLibrary.setIcon(imageLibrary);
            imageDictionary = new ImageIcon(new ImageIcon("subtitles.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
            buttonDictionary.setIcon(imageDictionary);
        }


        /*if(e.getSource()== button3){ // Library
            cl.show(panelCont, "2");
            //frame.dispose(); // close the LaucnhPage
            //LibraryPage Window = new LibraryPage();
        }*/
    }

}
