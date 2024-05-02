package multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    AtomicInteger count;
    public int threadsNum;

    private final List<Thread> threads;

    public AtomicCounter (int threadsNum) {
        this.threadsNum = threadsNum;
        count = new AtomicInteger(0);
        threads = new ArrayList<>();
    }

    public int incrementWith (int steps) {
        for (int i = 0; i < threadsNum; i++) {
            var thread = new Thread(() -> {
                for (int j = 0; j < steps / threadsNum; j++) {
                    count.incrementAndGet();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return count.get();
    }
}
