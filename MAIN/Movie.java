package MAIN;


public class Movie extends Footage {

    private int duration;

    public Movie(String title, String description, int classification, int duration) {
        
        super(title, description, classification);
        this.duration = duration;

    }


    public String toString(int type) {

        switch (type) {

            case 1:
                return "==========================================================" + "\nTitle:\t\t\t" + this.getTitle() + "\nDescription:\t\t" + this.getDescription() + "\nClassification:\t\t" + this.getClassification() + "\nDuration:\t\t" + this.duration + "\n==========================================================";

            default:
                return "Nothing to show";

        }

    }

}
