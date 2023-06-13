package MAIN_02.EXCEPTIONS;

public class ExceptionInvalidClassification extends Exception {
    
    private String classification;

    public ExceptionInvalidClassification(String classification) {

        super();
        this.classification = classification;

    }


    public String toString() {
        return "A classificação \"" + this.classification + "\" é inválida.";
    }

}
