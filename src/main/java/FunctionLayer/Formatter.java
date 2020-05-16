package FunctionLayer;
/**
 *  Streng formatterings værktøj
 */
public class Formatter {
    /**
     * Bliver brugt til at fixerere katalog paragraf
     */
    public static String fixedStrLength(String aStr) {
        int lineLength = 22;
        if (aStr.length() > lineLength) {
            return aStr.substring(0, 19) + " ...";
        }
        else {
            return aStr; // empty line
        }
    }
}
