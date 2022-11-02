package profiling.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    public void readFile(String fileName, int bufSize) throws IOException {
        long totalBytes = 0;
        byte[] buffer = new byte[bufSize];
        try (FileInputStream in = new FileInputStream(fileName)) {
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0) {
                // do something with the buffer
                for (int i = 0; i < bytesRead; i++) {
                    totalBytes++;
//                    System.out.print((char)buffer[i]);
                }
            }
        }
        System.out.printf("Read a total of %d bytes%n", totalBytes);
    }

    /**
     *
     * @param args buffer size in KiB
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String fileName = "1GBfile";
        int bufSize = Integer.parseInt(args[0]) * 1024;
        System.out.printf("using a buffer size of %d MiB%n", bufSize / 1024 / 1024);
        long time = benchmark(fileName, bufSize);
        System.out.println("Elapsed time: " + (time / 1e9) + " s");
    }

    private static long benchmark(String fileName, int bufSize) throws IOException {
        FileReader reader = new FileReader();
        long startTime = System.nanoTime();
        for (int i = 0; i < 50; i++) {
            reader.readFile(fileName, bufSize);
        }
        return System.nanoTime() - startTime;
    }
}
