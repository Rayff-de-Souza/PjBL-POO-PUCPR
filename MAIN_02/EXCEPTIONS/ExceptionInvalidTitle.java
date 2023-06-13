package MAIN_02.EXCEPTIONS;

public class ExceptionInvalidTitle extends Exception {
    
    private String title;

    public ExceptionInvalidTitle(String title) {

        super();
        this.title = title;

    }


    public String toString() {
        return "O título \"" + this.title + "\" é inválido.";
    }

}
