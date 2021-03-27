package towersim.util;

public class NoSpaceException extends Exception {
    public NoSpaceException(){
        super();
    }

    public NoSpaceException(String errorMessage){
        super(errorMessage);
    }
}
