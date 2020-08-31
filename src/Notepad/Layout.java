package Notepad;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.event.*;
import java.io.*;

public class Layout extends JFrame implements ActionListener {

    //MENU BAR
    JMenuBar menu;

    //separator
    JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);

    //MENU
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu adresy = new JMenu("Adresy");
    JMenu options = new JMenu("Options");
    JMenu foreground = new JMenu("Foreground");
    JMenu background = new JMenu("Background");
    JMenu fontsize = new JMenu("Font size");

    //MENU FILE
    JMenuItem open = new JMenuItem("Open");
    JMenuItem save = new JMenuItem("Save");
    JMenuItem saveas = new JMenuItem("Save as ...");
    JMenuItem exit = new JMenuItem("Exit");

    //MENU EDIT
    JMenuItem praca = new JMenuItem("Praca");
    JMenuItem szkola = new JMenuItem("Szkoła");
    JMenuItem dom = new JMenuItem("Dom");

    //MENU OPTIONS
    JMenuItem blue = new JMenuItem("Blue");
    JMenuItem yellow = new JMenuItem("Yellow");
    JMenuItem orange = new JMenuItem("Orange");
    JMenuItem red = new JMenuItem("Red");
    JMenuItem white = new JMenuItem("White");
    JMenuItem black = new JMenuItem("Black");
    JMenuItem green = new JMenuItem("Green");

    JMenuItem blue2 = new JMenuItem("Blue");
    JMenuItem yellow2 = new JMenuItem("Yellow");
    JMenuItem orange2 = new JMenuItem("Orange");
    JMenuItem red2 = new JMenuItem("Red");
    JMenuItem white2 = new JMenuItem("White");
    JMenuItem black2 = new JMenuItem("Black");
    JMenuItem green2 = new JMenuItem("Green");

    JMenuItem size8 = new JMenuItem("8");
    JMenuItem size10 = new JMenuItem("10");
    JMenuItem size12 = new JMenuItem("12");
    JMenuItem size14 = new JMenuItem("14");
    JMenuItem size16 = new JMenuItem("16");
    JMenuItem size18 = new JMenuItem("18");
    JMenuItem size20 = new JMenuItem("20");
    JMenuItem size22 = new JMenuItem("22");
    JMenuItem size24 = new JMenuItem("24");



    JPanel mainpanel;
    JScrollPane scroll;
    JEditorPane text;

    //ICONS Creation
    private Icon iconBlue = new IconA(Color.blue);
    private Icon iconYellow = new IconA (Color.yellow);
    private Icon iconOrange = new IconA (Color.orange);
    private Icon iconRed = new IconA (Color.red);
    private Icon iconWhite = new IconA(Color.white);
    private Icon iconBlack= new IconA(Color.black);
    private Icon iconGreen = new IconA(Color.green);


    Font f;

    String command = " ";

    String str1 = " ", str2 = " ", str3 = " ";
    String str4 = " ";

    String str5 = " ";
    String str6 = " ", str7 = " ", str8 = " ";

    String str9 = " ";

    int len, len1, len2;

    int i = 0;
    int pos1;

    FileInputStream fobj;

    FileOutputStream fboj2;

    FileOutputStream fboj22;

    public Layout(String str) {

        super(str);

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        this.setSize(width/4, height/3);
        int frameWidth = this.getSize().width;
        int frameHeight = this.getSize().height;
        this.setLocation((width-frameWidth)/2, (height-frameHeight)/2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        // Panel
        mainpanel = new JPanel();
        mainpanel = (JPanel) getContentPane();
        mainpanel.setLayout(new BorderLayout());


        // Menu bar
        menu = new JMenuBar();
        setJMenuBar(menu);


        file.add(open);
        file.add(save);
        file.add(saveas);
        file.add(sep);
        file.add(exit);


        menu.add(file);
        menu.add(edit);
        menu.add(options);

        //Mnemoniki
        //File Menu
        open.setMnemonic('o');
        save.setMnemonic('s');
        saveas.setMnemonic('a');
        exit.setMnemonic('x');
        //Adresy Menu
        praca.setMnemonic('p');
        szkola.setMnemonic('s');
        dom.setMnemonic('d');

        //Accelerators File
        KeyStroke keyStrokeOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        open.setAccelerator(keyStrokeOpen);
        KeyStroke keyStrokeSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        save.setAccelerator(keyStrokeSave);
        KeyStroke keyStrokeSaveAs = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        saveas.setAccelerator(keyStrokeSaveAs);
        KeyStroke keyStrokeExit = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        exit.setAccelerator(keyStrokeExit);

        //Accelerators Adresy
        KeyStroke keyStrokePraca = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
        praca.setAccelerator(keyStrokePraca);
        KeyStroke keyStrokeSzkola = KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK);
        szkola.setAccelerator(keyStrokeSzkola);
        KeyStroke keyStrokeDom = KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
        dom.setAccelerator(keyStrokeDom);


        // Edit menu
        edit.add(adresy);
        adresy.add(praca);
        adresy.add(szkola);
        adresy.add(dom);

        //MENU Options
        options.add(foreground);
        options.add(background);
        options.add(fontsize);

        //SUBMENU background
        background.add(blue2);
        background.add(yellow2);
        background.add(orange2);
        background.add(red2);
        background.add(black2);
        background.add(white2);
        background.add(green2);

        //SUBMENU foreground
        foreground.add(blue);
        foreground.add(yellow);
        foreground.add(orange);
        foreground.add(red);
        foreground.add(black);
        foreground.add(white);
        foreground.add(green);

        //SUBMENU Font size
        fontsize.add(size8);
        fontsize.add(size10);
        fontsize.add(size12);
        fontsize.add(size14);
        fontsize.add(size16);
        fontsize.add(size18);
        fontsize.add(size20);
        fontsize.add(size22);
        fontsize.add(size24);

        //Ikony
        //foreground
        blue.setIcon(iconBlue);
        yellow.setIcon(iconYellow);
        orange.setIcon(iconOrange);
        red.setIcon(iconRed);
        white.setIcon(iconWhite);
        black.setIcon(iconBlack);
        green.setIcon(iconGreen);
        //background
        blue2.setIcon(iconBlue);
        yellow2.setIcon(iconYellow);
        orange2.setIcon(iconOrange);
        red2.setIcon(iconRed);
        white2.setIcon(iconWhite);
        black2.setIcon(iconBlack);
        green2.setIcon(iconGreen);


        // Action Listener
        open.addActionListener(this);
        save.addActionListener(this);
        saveas.addActionListener(this);
        exit.addActionListener(this);
        praca.addActionListener(this);
        szkola.addActionListener(this);
        dom.addActionListener(this);
        blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.BLUE);
            }
        });

        yellow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.YELLOW);
            }
        });

        orange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.ORANGE);
            }
        });

        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.RED);
            }
        });

        white.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.WHITE);
            }
        });

        black.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.BLACK);
            }
        });

        green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setForeground(Color.GREEN);
            }
        });

        blue2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setBackground(Color.BLUE);
            }
        });
        yellow2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setBackground(Color.YELLOW);
            }
        });
        orange2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setBackground(Color.ORANGE);
            }
        });

        red2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setBackground(Color.RED);
            }
        });
        white2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setBackground(Color.WHITE);
            }
        });

        black2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setBackground(Color.BLACK);
            }
        });

        green2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                text.setBackground(Color.GREEN);
            }
        });
        size8.addActionListener(this);
        size10.addActionListener(this);
        size12.addActionListener(this);
        size14.addActionListener(this);
        size16.addActionListener(this);
        size18.addActionListener(this);
        size20.addActionListener(this);
        size22.addActionListener(this);
        size24.addActionListener(this);

        // Text panel
        text = new JEditorPane();
        scroll = new JScrollPane(text);
        mainpanel.add(scroll, BorderLayout.CENTER);

        // Default font
        f = new Font("Arial", Font.PLAIN, 18);
        text.setFont(f);

    }

    public void actionPerformed(ActionEvent ae) {

        // commands
        command = (String) ae.getActionCommand();


        try {

            if (command.equals("Open")) {

                str4 = " ";
                FileDialog dialog = new FileDialog(this, "Open");
                dialog.setVisible(true);

                str1 = dialog.getDirectory();
                str2 = dialog.getFile();
                str3 = str1 + str2;
                File f = new File(str3);
                fobj = new FileInputStream(f);
                len = (int) f.length();
                for (int j = 0; j < len; j++) {
                    char str5 = (char) fobj.read();
                    str4 = str4 + str5;

                }
                text.setText(str4);
            }
            this.setTitle("Prosty Edytor - "  + str2);

        } catch (IOException e) {}

        // Save from "Open"
        try {

            if (command.equals("Save")) {

                str9 = text.getText();
                len2 = str9.length();
                byte buff[] = str9.getBytes();

                File f2 = new File(str3);
                FileOutputStream fboj2 = new FileOutputStream(f2);
                for (int i = 0; i < len2; i++) {
                    fboj2.write(buff[i]);
                }
                fboj2.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Save from "Save as.."
        try {

            if (command.equals("Save")) {

                str9 = text.getText();
                len2 = str9.length();
                byte buff[] = str9.getBytes();

                File f2 = new File(str8);
                FileOutputStream fboj2 = new FileOutputStream(f2);
                for (int i = 0; i < len2; i++) {
                    fboj2.write(buff[i]);
                }
                fboj2.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

            try {

                if (command.equals("Save as ...")) {
                    FileDialog dialog1 = new FileDialog(this, "Save As", FileDialog.SAVE);
                    dialog1.setVisible(true);

                    str6 = dialog1.getDirectory();
                    str7 = dialog1.getFile();
                    str8 = str6 + str7;

                    str5 = text.getText();
                    len1 = str5.length();
                    byte buf[] = str5.getBytes();

                    File f1 = new File(str8);
                    FileOutputStream fobj1 = new FileOutputStream(f1);
                    for (int k = 0; k < len1; k++) {
                        fobj1.write(buf[k]);
                    }
                    fobj1.close();
                    this.setTitle("Prosty Edytor - " + str7);
                }



            } catch (IOException e) {}



        if (command.equals("Exit")) {
            System.exit(0);
        }


        Document doc = text.getDocument();
        int cursor = text.getCaretPosition();
        try {

            if (command.equals("Praca")) {
                String work = "Adres Służbowy:";
                doc.insertString(cursor, work, null);
            }
            if (command.equals("Szkoła")) {
                String school = "Adres Szkoły:";
                doc.insertString(cursor, school, null);
            }
            if (command.equals("Dom")) {
                String home = "Adres Domowy:";
                doc.insertString(cursor, home, null);
            }


        } catch (Exception e) {}



        if (command.equals("8")) {
            String fontName = f.getName();
            int fontStyle = f.getStyle();

            f = new Font(fontName, fontStyle, 8);
            text.setFont(f);
        }

        if (command.equals("10")) {
            String fontName = f.getName();
            int fontStyle = f.getStyle();

            f = new Font(fontName, fontStyle, 10);
            text.setFont(f);
        }

        if (command.equals("12")) {
            String fontName = f.getName();
            int fontStyle = f.getStyle();
            f = new Font(fontName, fontStyle, 12);
            text.setFont(f);
        }

        if (command.equals("14")) {
            String fontName = f.getName();
            int fontStyle = f.getStyle();

            f = new Font(fontName, fontStyle, 14);
            text.setFont(f);
        }
        if (command.equals("16")) {
            String fontName = f.getName();
            int fontStyle = f.getStyle();

            f = new Font(fontName, fontStyle, 16);
            text.setFont(f);
        }

        if (command.equals("18")) {
            String fontName = f.getName();
            int fontStyle = f.getStyle();

            f = new Font(fontName, fontStyle, 18);
            text.setFont(f);
        }

        if (command.equals("20")) {
            String fontName = f.getName();
            int fontStyle = f.getStyle();

            f = new Font(fontName, fontStyle, 20);
            text.setFont(f);
        }

        if (command.equals("22")) {
            String fontName = f.getName();
            int fontStyle = f.getStyle();

            f = new Font(fontName, fontStyle, 22);
            text.setFont(f);
        }

        if (command.equals("24")) {
            String fontName = f.getName();
            int fontStyle = f.getStyle();

            f = new Font(fontName, fontStyle, 24);
            text.setFont(f);
        }

    }

}