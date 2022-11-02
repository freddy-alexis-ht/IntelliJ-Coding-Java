package livetemplates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArgumentPrinter {

    private static final Logger LOGGER = Logger.getLogger(ArgumentPrinter.class.getName());

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    private static void printFileContent(Path path) {
        if (path.toFile().exists()) {
            try {
                LOGGER.log(Level.FINE, Files.readString(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException("file does not exist.");
        }
    }
}


