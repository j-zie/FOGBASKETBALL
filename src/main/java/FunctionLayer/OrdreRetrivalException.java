package FunctionLayer;

/**
 * Når en exception bliver kasted kommer den med en messege der kommer fra exception klassen.
 */

public class OrdreRetrivalException extends Exception {

    public OrdreRetrivalException(String msg) {
        super(msg);
    }


}
