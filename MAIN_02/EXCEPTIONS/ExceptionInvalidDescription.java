package MAIN_02.EXCEPTIONS;

public class ExceptionInvalidDescription extends Exception {
    
    private String description;

    public ExceptionInvalidDescription(String description) {

        super();
        this.description = description;

    }


    public String toString() {
        return "A descrição \"" + this.description + "\" é inválido.";
    }

}
