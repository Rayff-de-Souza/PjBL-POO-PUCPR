package MAIN_02;

import java.util.ArrayList;

import javax.naming.LinkRef;

import MAIN_02.IO.LibraryReader;
import MAIN_02.IO.LibraryWriter;
import MAIN_02.WINDOW.Window;
import MAIN_02.WINDOW.Panel;


class Main {

    
    public static void main(String[] args) {

        System.out.println("Hello world");

        // Movies Writer / Reader
        LibraryWriter library_writer = new LibraryWriter("./PjBL-POO-PUCPR/MAIN_02/_OBJECTS_SERIALIZED/library.ser");
        LibraryReader library_reader = new LibraryReader("./PjBL-POO-PUCPR/MAIN_02/_OBJECTS_SERIALIZED/library.ser");
        
        
        Movie movie_01 = new Movie("A Culpa é das Estrelas", "Um filme aleatório", 16, 120);
        Movie movie_02 = new Movie("A Culpa é das Estrelas", "Um filme aleatório", 16, 120);
        Serie serie_01 = new Serie("Peaky Blinders", "Sangue e Navalhas", 18, 20);
        Serie serie_02 = new Serie("Peaky Blinders", "Sangue e Navalhas", 18, 20);        

        
        Library library_01 = new Library("Biblioteca Principal");
        library_01.addFootage(movie_01);
        library_01.addFootage(movie_02);
        library_01.addFootage(serie_01);
        library_01.addFootage(serie_02);

        library_writer.write(library_01);
        library_writer.close_writer();
        

        Library library_02 = library_reader.read();


        library_reader.close_reader();

        Object[][] footages_array = library_02.return_footages();
        String[] name_columns = {"Title", "Description", "Classification", "Duration"};

        // WINDOW AND PANEL
        Window window = new Window("Library");
        Panel panel = new Panel(footages_array, name_columns, library_02);
        window.add_panel(panel.get_panel());

    }

}