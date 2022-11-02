package profiling.concurrency;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Example taken from https://github.com/apangin/java-profiling-presentation/blob/master/src/demo6/DatagramTest.java
 * licensed under Apache License 2.0
 */
public class LockingDatagram {

    private static final AtomicLong totalPackets = new AtomicLong();
    private static DatagramChannel ch;

    public static void sendLoop() {
        final ByteBuffer buf = ByteBuffer.allocateDirect(1000);
        final InetSocketAddress remoteAddr = new InetSocketAddress("127.0.0.1", 5556);
        try {
            while (!Thread.interrupted()) {
                buf.clear();
                ch.send(buf, remoteAddr);
                totalPackets.incrementAndGet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ch = DatagramChannel.open();
        ch.bind(new InetSocketAddress(5555));
        ch.configureBlocking(false);

        Executor pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            pool.execute(LockingDatagram::sendLoop);
        }

        System.out.println("Warming up...");
        Thread.sleep(3000);
        totalPackets.set(0);

        System.out.println("Benchmarking...");
        Thread.sleep(5000);
        System.out.println(totalPackets.get() / 5);

        System.exit(0);
    }
}
