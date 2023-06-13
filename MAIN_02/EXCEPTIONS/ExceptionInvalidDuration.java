package MAIN_02.EXCEPTIONS;

public class ExceptionInvalidDuration extends Exception {
    
    private String duration;

    public ExceptionInvalidDuration(String duration) {

        super();
        this.duration = duration;

    }


    public String toString() {
        return "A duração \"" + this.duration + "\" é inválida.";
    }


}
