package MAIN_02;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {
    
    private String library_name;
    private ArrayList<Footage> footages = new ArrayList<Footage>();


    public Library(String library_name) {
        this.library_name = library_name;
    }


    public void addFootage(Footage footage) {
        this.footages.add(footage);
    }


    public void toString(int type) {

        switch (type) {

            // SHOW ALL SERIES AND MOVIES
            case 1:
                System.out.println("- LIBRARY: " + this.library_name);
                for (int i = 0; i < this.footages.size(); i++) {

                    System.out.println(this.footages.get(i).toString(1));

                }
                break;

        }

    }


    public Object[][] return_footages() {
        
        Object[][] result = new Object[this.footages.size()][4];

        for (int i = 0; i < this.footages.size(); i++) {
            
            result[i][0] = this.footages.get(i).getTitle();
            result[i][1] = this.footages.get(i).getDescription();
            result[i][2] = this.footages.get(i).getClassification();

            if (this.footages.get(i) instanceof Movie) { result[i][3] = this.footages.get(i).getDuration() + " minutes"; }
            else if (this.footages.get(i) instanceof Serie) { result[i][3] = this.footages.get(i).getDuration() + " episodes"; }
            
        }

        return result;

    }



}
