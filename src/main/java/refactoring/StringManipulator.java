package refactoring;

import java.util.HashMap;
import java.util.Map;

public class StringManipulator {

    public static final String DEFAULT_GREETING = "Hello ";
    private final Map<String, String> replacements;

    public StringManipulator() {
        replacements = new HashMap<>();
        replacements.put(" 1 ", " one ");
        replacements.put(" 2 ", " two ");
        replacements.put(" 3 ", " three ");
    }

    /**
     * Returns a greeting message for the supplied personToGreet.
     *
     * @param personToGreet personToGreet to greet
     * @return greeting string
     */
    public String greet(String personToGreet) {
        return DEFAULT_GREETING + personToGreet;
    }

    public String applyReplacements(String value) {
        // TODO: move replacements to a field and allow adding custom replacements
        for (Map.Entry<String, String> replacement : replacements.entrySet()) {
            value = value.replace(replacement.getKey(), replacement.getValue());
        }
        return value;
    }

    public void addReplacement(String original, String replacement) {
        this.replacements.put(original, replacement);
    }
}
