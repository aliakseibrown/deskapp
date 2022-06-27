import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class book1Page {
    ImageIcon imageStart = new ImageIcon(new ImageIcon("start.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
    ImageIcon imageMenu = new ImageIcon(new ImageIcon("menu.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
    ImageIcon imageNext = new ImageIcon(new ImageIcon("next.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon imageExit = new ImageIcon(new ImageIcon("exit.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
    ImageIcon imageD = new ImageIcon(new ImageIcon("d.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));

    PDFTextStripper stripper = new PDFTextStripper();
    JTextField textField = new JTextField();
    JTextPane textPane = new JTextPane();
    JFrame frame = new JFrame();
    StyledDocument doc = textPane.getStyledDocument();
    JDialog frameTranslation = new JDialog();
    JDialog frameWriting = new JDialog();
    JButton buttonStart = new JButton();
    JButton buttonMenu = new JButton();
    JButton buttonMiddle = new JButton();
    JButton buttonNext = new JButton();
    JButton buttonExit = new JButton();
    JLabel boxTranslation = new JLabel("", SwingConstants.CENTER);
    JLabel labelText1 = new JLabel();
    JLabel labelText2 = new JLabel();
    JLabel boxInput = new JLabel();
    JPanel panelMouseTranslation = new MotionPanel(frameTranslation);
    JPanel panelMouseWriting = new MotionPanel(frameWriting);
    JPanel panelText = new JPanel();
    File fileWords = new File("correctBook1.txt");
    File fileNumber = new File("orderBook1.txt");
    StringBuffer firstPartBuffer = new StringBuffer();
    StringBuffer secondPartBuffer = new StringBuffer();
    String[] dividedCorrectWords;
    String[] dividedOrderWords;
    String[] dividedSentence;
    String writtenWord;
    String randomWord;
    String secondPart;
    String firstPart;
    Integer numberSentenceOrder;
    Integer numberRandom;
    Integer numberMax;
    book1Page() throws IOException {
        fileWords.createNewFile();
        fileNumber.createNewFile();
        Scanner sc = new Scanner(new FileInputStream(fileWords));

        numberSentenceOrder = 0;

        //labelText1.setBounds(0, 0, 540, 600);

        labelText1.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        labelText1.setSize(100, 100);
        labelText1.setBackground(Color.white);
        labelText1.setOpaque(true);

        //labelText2.setBounds(640, 0, 540, 600);
        labelText2.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        labelText2.setBackground(Color.white);
        labelText2.setSize(100, 100);
        labelText2.setOpaque(true);

        buttonMiddle.setBounds(325, 150, 50, 40);
        buttonMiddle.setBorderPainted(false);
        buttonMiddle.setFocusPainted(false);
        buttonMiddle.setFocusable(false);
        buttonMiddle.setIcon(imageD);

        buttonMenu.setBounds(35, 10, 60, 35);
        buttonMenu.setBorderPainted(false);
        buttonMenu.setFocusPainted(false);
        buttonMenu.setFocusable(false);
        buttonMenu.setIcon(imageMenu);

        buttonStart.setBounds(1185, 10, 60, 35);
        buttonStart.setBorderPainted(false);
        buttonStart.setFocusPainted(false);
        buttonStart.setFocusable(false);
        buttonStart.setIcon(imageStart);

        buttonExit.setBounds(250, 150, 50, 40);
        buttonExit.setBorderPainted(false);
        buttonExit.setFocusPainted(false);
        buttonExit.setFocusable(false);
        buttonExit.setIcon(imageExit);

        buttonNext.setBounds(400, 150, 50, 40);
        buttonNext.setEnabled(false);
        buttonNext.setBorderPainted(false);
        buttonNext.setFocusPainted(false);
        buttonNext.setFocusable(false);
        buttonNext.setIcon(imageNext);



        panelText.setBounds(50, 50, 1180, 600);
        panelText.setBackground(Color.white);
        panelText.setLayout(null);

        boxInput.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        boxInput.setBounds(20, 20, 660, 120);
        boxInput.setLayout(new FlowLayout());
        boxInput.setBackground(Color.white);
        boxInput.setOpaque(true);
        boxInput.add(labelText1);
        boxInput.add(textField);
        boxInput.add(labelText2);

        panelMouseWriting.setBounds(0, 0, 700, 200);
        panelMouseWriting.setBackground(Color.white);
        panelMouseWriting.setOpaque(false);
        panelMouseWriting.setLayout(null);

        frameWriting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameWriting.setBackground(Color.white);
        frameWriting.setSize(700, 200);
        frameWriting.setLocationRelativeTo(null);
        frameWriting.setUndecorated(true);
        frameWriting.setVisible(false);
        frameWriting.setLayout(null);
        frameWriting.setTitle("the Sentence");
        frameWriting.add(buttonMiddle);
        frameWriting.add(buttonExit);
        frameWriting.add(buttonNext);
        frameWriting.add(boxInput);
        frameWriting.add(panelMouseWriting);
        frameWriting.getContentPane().setBackground(Color.white);


        frameTranslation.setSize(200, 70);
        frameTranslation.setLocation(740, 200); // if its possible to change to dynamic location
        frameTranslation.setUndecorated(true);
        frameTranslation.setVisible(false);
        frameTranslation.setLayout(null);
        frameTranslation.setTitle("Translation");
        frameTranslation.add(boxTranslation);
        frameTranslation.add(panelMouseTranslation);
        frameTranslation.getContentPane().setBackground(Color.white);        //frameTranslation.setAlwaysOnTop(true);

        panelMouseTranslation.setBounds(0, 0, 200, 70);
        panelMouseTranslation.setBackground(Color.white);
        panelMouseTranslation.setOpaque(false);
        panelMouseTranslation.setLayout(null);


        boxTranslation.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        boxTranslation.setLayout(new GridBagLayout());
        boxTranslation.setSize(200,70);
        //boxTranlation.setLayout(new FlowLayout());
        //boxTranlation.setBounds(80,10,160,50);

        //textField.setBorder(BorderFactory.createLineBorder(Color.white));
        //textField.setBorder(null);
        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        textField.setFont(new Font("Sans Serif", Font.PLAIN, 16));
        textField.setPreferredSize(new Dimension(120, 30));

        textPane.setFont(new Font("Sans Serif", Font.PLAIN, 18));
        textPane.setEditable(false);
        textPane.setBackground(Color.white);

        Container container = frame.getContentPane();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setTitle("LingContext: Reading");
        frame.add(buttonStart);
        frame.add(buttonMenu);



        //frame.add(panelText);
        //frame.add(label);

        File file = new File("/Users/alexeybrown/Documents/Anxious People - Fredrik Backman.pdf");
        PDDocument document = Loader.loadPDF(file);

        String text = stripper.getText(document);
        String[] split = text.split("[?.!]");
        System.out.println(split[numberSentenceOrder] + ".");

        int count=0;
        while(sc.hasNext()){
            sc.next();
            count++;
        }
        String correctWords = Files.readString(Paths.get(String.valueOf(fileWords)));
        String orderWords = Files.readString(Paths.get(String.valueOf(fileNumber)));

        //devidedCorrectWords = new String(Files.readAllBytes(Paths.get("file.txt")));

        //Container con = frame.getContentPane();

        String editedText = String.join(". ", split);
        //textPane.setText(editedText);


        numberSentenceOrder = count;
        dividedSentence = split[numberSentenceOrder].split("\\s+");
        dividedCorrectWords = correctWords.split("[\\n]");
        dividedOrderWords = orderWords.split("[\\n]");
        numberRandom = ThreadLocalRandom.current().nextInt(1, dividedSentence.length);
        numberMax = dividedSentence.length;
        randomWord = dividedSentence[numberRandom];

        /*System.out.println("correctWords: " + correctWords);
        System.out.println("Number of words(count): " + count);
        System.out.println("dividedCorrectWords: " + dividedCorrectWords[0] + " " + dividedCorrectWords.length);
        System.out.println("dividedOrderWords: " + Integer.parseInt(dividedOrderWords[0]));*/

        for(int i = 1; i < numberRandom; i++) {
            firstPartBuffer.append(dividedSentence[i]);
            firstPartBuffer.append(" ");
        }
        for(int i = (numberRandom + 1); i < numberMax; i++) {
            secondPartBuffer.append(dividedSentence[i]);
            if( i == numberMax - 1) {
                secondPartBuffer.append(".");
            }else{
                secondPartBuffer.append(" ");
            }
        }
        firstPart = firstPartBuffer.toString();
        secondPart = secondPartBuffer.toString();


        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frameTranslation.setVisible(true);
                frameWriting.setVisible(true);
                buttonNext.setEnabled(false);
                System.out.println(firstPart+ "!"+ randomWord + "! " + secondPart);
                System.out.println(dividedSentence[0]);
            }
        });


        try { // showing text on the main panel
            /*System.out.println("Random: " + numberRandom + " from: " + numberMax);
            for(int i = 0; i < dividedSentence.length; i++ ){
                System.out.println(i + ": " + dividedSentence[i]);
            }
                System.out.println("randomWord: " + randomWord);*/
            //System.out.println(Integer.parseInt(dividedOrderWords[0]) + 1);
            for (int i = 0; i < 30; i++) {

                String firstPart;
                String randomWord;
                String secondPart;
                String[] dividedSentence;
                StringBuffer firstPartBuffer = new StringBuffer();
                StringBuffer secondPartBuffer = new StringBuffer();

                firstPartBuffer.setLength(0);
                secondPartBuffer.setLength(0);
                if( fileWords.length() != 0){
                if( i < dividedCorrectWords.length){
                    dividedSentence = split[i].split("\\s+");
                    numberMax = dividedSentence.length;
                    randomWord = dividedCorrectWords[i];

                   for(int n = 1; n < Integer.parseInt(dividedOrderWords[i]); n++) {
                        firstPartBuffer.append(dividedSentence[n]);
                        firstPartBuffer.append(" ");
                    }
                    for(int n = (Integer.parseInt(dividedOrderWords[i]) + 1); n < numberMax; n++) {
                        secondPartBuffer.append(dividedSentence[n]);
                        if (n == numberMax - 1) {
                            secondPartBuffer.append(". ");
                        } else {
                            secondPartBuffer.append(" ");
                        }
                    }
                        firstPart = firstPartBuffer.toString();
                        secondPart = secondPartBuffer.toString();

                        Style style = textPane.addStyle("Red", null);
                        StyleConstants.setForeground(style, Color.red);
                        doc.insertString(doc.getLength(), firstPart, null);
                        doc.insertString(doc.getLength(), randomWord + " ", style);
                        doc.insertString(doc.getLength(), secondPart, null);
                        firstPartBuffer.setLength(0);
                        secondPartBuffer.setLength(0);
                }else{
                    doc.insertString(doc.getLength(), split[i], null);
                    doc.insertString(doc.getLength(), ". ", null);
                }
            }else{
                    doc.insertString(doc.getLength(), split[i], null);
                    doc.insertString(doc.getLength(), ". ", null);
                }
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }


        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                writtenWord = textField.getText();
                System.out.println("dividedSentence: " + dividedSentence[numberRandom]);
                if(writtenWord.equals(dividedSentence[numberRandom])){
                    System.out.println("WOW");
                    textField.setBorder(null);
                    textField.setEditable(false);
                    textField.setCaretColor(Color.white);
                    buttonNext.setEnabled(true);
                    System.out.println(numberSentenceOrder);

                    //File fileWords = new File(String.valueOf(fileWords)));
                    //File fileNumber = new File(String.valueOf(fileNumber)));
                    FileWriter fr = null;
                    FileWriter fran= null;

                    try {
                        Scanner sc = new Scanner(new FileInputStream(fileWords));
                        int count=0;
                        while(sc.hasNext()){
                            sc.next();
                            count++;
                        }
                        if( count == numberSentenceOrder){
                            fr = new FileWriter(fileWords, true);
                            fran = new FileWriter(fileNumber, true);
                            BufferedWriter br = new BufferedWriter(fr);
                            br.write(randomWord+"\n");
                            br.close();
                            fr.close();
                            BufferedWriter bran = new BufferedWriter(fran);
                            bran.write(numberRandom+"\n");
                            bran.close();
                            fr.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //numberSentenceOrder = numberSentenceOrder + 1;
                }else{
                    System.out.println("try again");
                    //writtenWord = textField.getText();
                }
                System.out.println("firstPart: " + firstPart);
            }
        });


        //frame.getRootPane().setDefaultButton(buttonNext);
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                textField.setText("");
                firstPartBuffer.setLength(0);
                secondPartBuffer.setLength(0);
                numberSentenceOrder = numberSentenceOrder + 1;
                dividedSentence = split[numberSentenceOrder].split("\\s+");
                numberRandom = ThreadLocalRandom.current().nextInt(1, dividedSentence.length);
                numberMax = dividedSentence.length;
                randomWord = dividedSentence[numberRandom];
                //LibraryPage Window = new LibraryPage();
                for(int i = 1; i < numberRandom; i++) {
                    firstPartBuffer.append(dividedSentence[i]);
                    firstPartBuffer.append(" ");
                }
                for(int i = (numberRandom + 1); i < numberMax; i++) {
                    secondPartBuffer.append(dividedSentence[i]);
                    if( i == numberMax - 1) {
                        secondPartBuffer.append(".");
                    }else{
                        secondPartBuffer.append(" ");
                    }
                }

                writtenWord = textField.getText();
                //textField.addActionListener((ActionListener) buttonNext);
                textField.setBorder(BorderFactory.createMatteBorder(
                        0, 0, 1, 0, Color.black));
                textField.setEditable(true);
                textField.setCaretColor(Color.black);
                firstPart = firstPartBuffer.toString();
                secondPart = secondPartBuffer.toString();

                buttonNext.setEnabled(false);

                labelText1.setText(firstPart);
                labelText2.setText(secondPart);
                boxTranslation.setText(randomWord);
                System.out.println(firstPart+ "!"+ randomWord + "! " + secondPart);

            }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frameTranslation.setVisible(false);
                frameWriting.setVisible(false);
                buttonNext.setEnabled(true);
            }
        });

        buttonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                LaunchPage launch = new LaunchPage();
            }
        });

        //firstpart[0]
        // firstpart[1]
        //split[0] = split[0].replace("this", "This");


        
        /*int i = 0;
        textPane.setText(split[i]+".\n"+
                split[i+1]+".\n"+
                split[i+2]+".\n"+
                split[i+3]+".\n");*/

        //StyleConstants.setForeground(keyWord, Color.GRAY);
        //StyleConstants.setBackground(keyWord, Color.cyan);
        //StyleConstants.setBold(keyWord,true);

        //doc.insertString(0, "Start of text:\n", null);
        //doc.insertString(doc.getLength(), "\nEnd of text.", keyWord);
        JScrollPane scrollPane = new JScrollPane(textPane);
        container.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBounds(50, 50, 1180, 600);
        scrollPane.setViewportBorder(null);
        //scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_NEVER );


        scrollPane.setBorder(null);

        labelText1.setText(firstPart);
        labelText2.setText(secondPart);
        boxTranslation.setText(randomWord);

        frame.setSize(1280, 720);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


    private void addStylesToDocument(StyledDocument doc) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == textField) {
            /*labelText1.setText("");
            labelText2.setText("");
            boxTranlation.setText("");*/
        }
    }
}

