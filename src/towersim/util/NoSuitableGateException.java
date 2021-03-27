package towersim.util;

public class NoSuitableGateException extends Exception {
    public NoSuitableGateException(){
        super();
    }

    public NoSuitableGateException(String errorMessage){
        super(errorMessage);
    }

}
