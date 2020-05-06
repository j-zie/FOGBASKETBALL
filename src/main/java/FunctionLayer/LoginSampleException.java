package FunctionLayer;

/**
 * Formålet med loginsampleexception er at kunne kaste exception messeges fra super klassen
 * @author kasper
 */
public class LoginSampleException extends Exception {



    public LoginSampleException(String msg) {
        super(msg);
    }

}

