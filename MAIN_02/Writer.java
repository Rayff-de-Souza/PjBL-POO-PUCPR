package MAIN_02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    
    private String filepath;
    private String output_filepath;
    private File file;


    public Writer(String filepath, String output_filepath) {

        this.filepath = filepath;
        this.output_filepath = output_filepath;
        this.file = new File(this.filepath);

    }


    public void writeLine(Footage footage) {

        try {
        
            FileWriter outputfile = new FileWriter(this.file);
            CSVWriter writer = new CSVWriter(outputfile);
        
        } catch (IOException error) {
            error.printStackTrace();
        }
    
    }


}
