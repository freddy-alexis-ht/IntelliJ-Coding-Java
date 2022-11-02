package debugging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ConcurrencyIssue {

    static final List<String> scannedFiles = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        scanFiles();
        System.out.println(scannedFiles);
        if (scannedFiles.size() > 1) {
            throw new RuntimeException("file scanned twice");
        }
    }

    static void scanFiles() throws InterruptedException {
        Thread t1 = new Thread(() -> scanFile("/tmp/foo.txt"), "T1");
        t1.start();
        scanFile("/tmp/foo.txt");
        t1.join();
    }

    static void scanFile(String fileName) {
        synchronized (scannedFiles) {
            if (!scannedFiles.contains(fileName)) {
                simulateScan();
                scannedFiles.add(fileName);
            }
        }
    }

    static void simulateScan() {
        try {
            Thread.sleep(new Random().nextInt(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
