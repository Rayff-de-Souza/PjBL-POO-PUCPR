package MAIN_02.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import MAIN_02.WINDOW.Alert;
import MAIN_02.Library;

public class LibraryReader {
 
    private String filepath;
    private FileInputStream file_input;
    private ObjectInputStream object_input;
    private Alert alert;


    public LibraryReader(String filepath) {
        this.filepath = filepath;
        this.alert = new Alert();

        try {
            this.file_input = new FileInputStream(filepath);
            this.object_input = new ObjectInputStream(file_input);
        } 
        catch (FileNotFoundException error) { alert.notification("Não foi possível localizar o arquivo de filmes."); }
        catch (IOException error) { alert.notification("Erro ao tentar ler arquivo serializado de filmes."); }

    }


    public Library read() {
        try {
            Library library = (Library) this.object_input.readObject();
            return library;
        }
        catch (IOException error) { alert.notification("Erro ao tentar ler objeto filme."); return null; }
        catch (ClassNotFoundException error) { alert.notification("Erro ao tentar converter objeto de filme"); return null; }
    }


    public void close_reader() {

        try { this.file_input.close(); }
        catch (IOException error) { alert.notification("Não foi possível fechar o leitor de filmes."); }

        try { this.object_input.close(); }
        catch (IOException error) { alert.notification("Não foi possível fechar o leitor de filmes serializados."); }

    }

}
