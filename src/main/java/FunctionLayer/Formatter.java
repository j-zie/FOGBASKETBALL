package FunctionLayer;
/**
 *  Streng formatterings værktøj
 */
public class Formatter {
    /**
     * Bliver brugt til at fixerere katalog paragraf
     */
    public static String fixedStrLength(String aStr) {
        if (aStr.length() > 30) {
            return aStr.substring(0,30) + " ...";
        } else {
            String spaces = "";
            for (int i = 0; i < ((30 + 4) - aStr.length()); i++) {
                spaces += " ";
            }
            return aStr + spaces;
        }
    }
}
