package MAIN_02.WINDOW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class ActionAddFootage implements ActionListener {

    private JTextField title;
    private JTextField description;
    private JTextField classification;
    private JTextField duration;

    public ActionAddFootage(JTextField title, JTextField description, JTextField classification, JTextField duration) {

        this.title = title;
        this.description = description;
        this.classification = classification;
        this.duration = duration;

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        

        String title = this.title.getText();
        String description = this.description.getText();
        String classification = this.classification.getText();
        String duration = this.duration.getText();


        

    }
    


}
