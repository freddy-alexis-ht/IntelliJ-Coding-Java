package debugging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
Copy the stacktrace below and select "Analyze Stack Trace or Thread Dump..." from the find actions dialog:

Exception in thread "main" java.lang.RuntimeException: issue in main method
	at debugging.StackTraceAnlayzers.main(StackTraceAnlayzers.java:30)
Caused by: java.lang.IllegalArgumentException: Could not get current date
	at debugging.StackTraceAnlayzers.formatDate(StackTraceAnlayzers.java:38)
	at debugging.StackTraceAnlayzers.main(StackTraceAnlayzers.java:28)
Caused by: java.lang.IllegalArgumentException: Unknown pattern letter: T
	at java.base/java.time.format.DateTimeFormatterBuilder.parsePattern(DateTimeFormatterBuilder.java:1813)
	at java.base/java.time.format.DateTimeFormatterBuilder.appendPattern(DateTimeFormatterBuilder.java:1710)
	at java.base/java.time.format.DateTimeFormatter.ofPattern(DateTimeFormatter.java:565)
	at debugging.StackTraceAnlayzers.formatDate(StackTraceAnlayzers.java:36)
	... 1 more
 */
public class StackTraceAnalyzers {

    // FIXME: Bug reported in IDE-5
    public static void main(String[] args) {
        String pattern = "Y-M-d";
        if(args.length == 1) {
            pattern = args[0];
        }
        try {
            System.out.println(formatDate(pattern));
        } catch (Exception e) {
            throw new RuntimeException("issue in main method", e);
        }
    }

    private static String formatDate(String pattern) {
        try {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not get current date", e);
        }
    }

}
