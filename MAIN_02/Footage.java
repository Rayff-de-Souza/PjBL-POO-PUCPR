package MAIN_02;

import java.io.Serializable;


abstract public class Footage implements Serializable {
    
    private String title;
    private String description;
    private int classification;


    public Footage(String title, String description, int classification) {

        this.title = title;
        this.description = description;
        this.classification = classification;

    }


    abstract public String toString(int type);


    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getClassification() {
        return this.classification;
    }

    abstract int getDuration();

}
