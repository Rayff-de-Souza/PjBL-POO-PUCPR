package MAIN_02;

import java.util.ArrayList;

public class Library {
    
    private String library_name;
    private ArrayList<Footage> footages = new ArrayList<Footage>();


    public Library(String library_name, ArrayList<Footage> footages) {
        
        this.library_name = library_name;
        this.footages = footages;

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



}
