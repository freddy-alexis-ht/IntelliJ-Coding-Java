package profiling.memory;

import java.io.IOException;
import java.util.Random;

/**
 * run with JVM options -Xmx300m -XX:ActiveProcessorCount=2
 * use jps to find PID and jstat -gcutil pid for gc info
 */
public class GarbageProducer {

    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    private final byte[][] bytes = new byte[2100][102400];

    public void produceGarbage() {
        int index = new Random().nextInt(bytes.length);
        bytes[index] = new byte[102400];
    }

    public static void main(String[] args) throws IOException {
        GarbageProducer garbageProducer = new GarbageProducer();
        while(!Thread.currentThread().isInterrupted()) {
            garbageProducer.produceGarbage();
        }
    }

}
