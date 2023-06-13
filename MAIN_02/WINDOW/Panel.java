package MAIN_02.WINDOW;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import MAIN_02.Library;
import MAIN_02.Movie;
import MAIN_02.EXCEPTIONS.ExceptionInvalidClassification;
import MAIN_02.EXCEPTIONS.ExceptionInvalidDescription;
import MAIN_02.EXCEPTIONS.ExceptionInvalidDuration;
import MAIN_02.EXCEPTIONS.ExceptionInvalidTitle;
import MAIN_02.IO.LibraryReader;
import MAIN_02.IO.LibraryWriter;


public class Panel {
    
    private JPanel panel;
    private Library library;
    Object[][] footages_array;
    String[] name_columns;


    public Panel(Object[][] footages_array, String[] name_columns, Library library) {
        
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.footages_array = footages_array;
        this.name_columns = name_columns;
        this.library = library;


        this.add_main_interface();
    }


    public void add_main_interface() {


        // TABELA
        DefaultTableModel table_model = new DefaultTableModel(this.footages_array, this.name_columns);
        JTable table = new JTable(table_model);

        // PAINEL DE ROLAGEM DA TABELA
        JScrollPane scrollPane = new JScrollPane(table);
        this.panel.add(scrollPane);


        // BOTÃO DE REMOVER CURTA METRAGEM
        JButton btn_remove = new JButton("Remove Footage");


        
        JTextField tf_title = new JTextField(1);
        JTextField tf_description = new JTextField(1);
        JTextField tf_classification = new JTextField(1);
        JTextField tf_duration = new JTextField(1);
        JTextField tf_remove_footage = new JTextField(1);


        JLabel lb_title = new JLabel("Title");
        JLabel lb_description = new JLabel("Description");
        JLabel lb_classification = new JLabel("Classification");
        JLabel lb_duration = new JLabel("Duration");
        JLabel lb_remove_footage = new JLabel("Footage Index");
        

        // BOTÃO DE ADICIOONAR CURTA METRAGEM
        ActionListener act_btn_add_movie = new ActionAddFootage(tf_title, tf_description, tf_classification, tf_duration);
        JButton btn_add = new JButton("Add Footage");

        btn_add.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {


                try {

                    // FAZENDO AS VALIDAÇÕES DOS CAMPOS
                    if (tf_title.getText().length() < 2) { throw new ExceptionInvalidTitle(lb_title.getText()); }
                    else if (tf_description.getText().length() < 2) { throw new ExceptionInvalidDescription(tf_description.getText()); }
                    else if (tf_classification.getText().length() == 0) { throw new ExceptionInvalidClassification(tf_classification.getText()); }
                    else if (tf_duration.getText().length() == 0) { throw new ExceptionInvalidDuration(tf_duration.getText()); }


                    // ADICIONANDO VALORES NA LIVRARIA
                    Movie new_movie = new Movie(
                        lb_title.getText(), 
                        lb_description.getText(), 
                        1, 
                        1
                    );

                    library.addFootage(new_movie);
                    Object[][] footages_array = library.return_footages();

                    
                    // CRIANDO A NOVA LIVRARIA
                    Library new_library = new Library("Biblioteca Principal");
                    
                    for (int i = 0; i < footages_array.length; i++) {
                        Movie movie = new Movie("1", "", 1, 1);
                        new_library.addFootage(movie);
                    }


                    // SALVANDO A NOVA CURTA METRAGEM NO ARQUIVO
                    LibraryWriter library_writer = new LibraryWriter("./PjBL-POO-PUCPR/MAIN_02/_OBJECTS_SERIALIZED/library.ser");

                    library_writer.write(new_library);
                    library_writer.close_writer();


                    // ATUALIZANDO VALORES NA TABELA
                    table_model.setRowCount(0);

                    for (Object[] footage : footages_array) {
                        table_model.addRow(footage);
                    }

                } 
                catch (ExceptionInvalidTitle error) { JOptionPane.showMessageDialog(null, error.toString()); }
                catch (ExceptionInvalidDescription error) { JOptionPane.showMessageDialog(null, error.toString()); }
                catch (ExceptionInvalidClassification error) { JOptionPane.showMessageDialog(null, error.toString()); }
                catch (ExceptionInvalidDuration error) { JOptionPane.showMessageDialog(null, error.toString()); }

            }

        });


        // ADICIONANDO OBJETOS NO LAYOUT
        this.panel.add(lb_title);
        this.panel.add(tf_title);
        
        this.panel.add(lb_description);
        this.panel.add(tf_description);

        this.panel.add(lb_classification);
        this.panel.add(tf_classification);

        this.panel.add(lb_duration);
        this.panel.add(tf_duration);

        this.panel.add(btn_add);

        this.panel.add(lb_remove_footage);
        this.panel.add(tf_remove_footage);
        this.panel.add(btn_remove);
        


    }


    public JPanel get_panel() {
        return this.panel;
    }


}
