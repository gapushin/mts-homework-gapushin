package multiThreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    public AtomicInteger count;

    public AtomicCounter () {
        count = new AtomicInteger(0);
    }

    public void increment () {
        count.incrementAndGet();
    }

    public int getResult () {
        return count.get();
    }
}
