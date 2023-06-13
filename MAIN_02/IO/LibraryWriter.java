package MAIN_02.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import MAIN_02.Library;
import MAIN_02.WINDOW.Alert;

public class LibraryWriter {
    
    
    private String output_file; 
    private FileOutputStream file_out;
    private ObjectOutputStream object_out;
    private Alert alert;


    public LibraryWriter (String output_file) {
        this.output_file = output_file;
        this.alert = new Alert();

        try { 
            this.file_out = new FileOutputStream(this.output_file); 
            this.object_out = new ObjectOutputStream(this.file_out);
        } 
        catch (FileNotFoundException error) { alert.notification("Não foi possível localizar o arquivo de filmes."); }
        catch (IOException error) { alert.notification("Erro ao tentar serializar arquivo de filmes."); }

    }


    public void write(Library library) {

        try { this.object_out.writeObject(library); }
        catch (IOException error) { alert.notification("Não foi possível gravar o filme no banco de dados."); error.printStackTrace(); }

    }


    public void close_writer() {
        try { this.object_out.close(); }
        catch (IOException error) { alert.notification("Não foi possível fechar o serializador de filmes."); }

        try { this.file_out.close(); }
        catch (IOException error) { alert.notification("Não foi possível fechar o arquivo de filmes."); }
    }

}
