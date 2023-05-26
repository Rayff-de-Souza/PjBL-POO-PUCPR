package MAIN;

public class Serie extends Footage {
    
    private int episodes;


    public Serie(String title, String description, int classification, int episodes) {

        super(title, description, classification);
        this.episodes = episodes;

    }


    public String toString(int type) {

        switch (type) {

            case 1:
            return "==========================================================" + "\nTitle:\t\t\t" + this.getTitle() + "\nDescription:\t\t" + this.getDescription() + "\nClassification:\t\t" + this.getClassification() + "\nEpisodes:\t\t" + this.episodes + "\n==========================================================";

            default:
                return "Nothing to show";

        }

    }


    

}
