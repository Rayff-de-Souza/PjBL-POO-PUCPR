package MAIN_02.WINDOW;

import java.awt.GridLayout;

import javax.swing.*;

public class Window extends JPanel {

    private static final int TITLE_BAR_HEIGHT = 20;
    private JFrame frame;


    public Window(String name) {

        this.frame = new JFrame(name);
        this.frame.add(this);
        this.frame.setLocation(300, 200);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.frame.setVisible(true);
    
    }


    public void add_panel(JPanel panel) {
        this.frame.getContentPane().add(panel);
        this.frame.pack();
    }


    public JFrame getFrame() { return this.frame; }

}