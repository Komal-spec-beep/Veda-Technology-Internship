package day27.threadsafecounter;
import java.util.concurrent.atomic.AtomicInteger;

class UnsafeCounter {

    int count = 0;

    void increment() {
        count++;
    }
}

class SynchronizedCounter {

    int count = 0;

    synchronized void increment() {
        count++;
    }
}

class AtomicCounter {
    AtomicInteger count = new AtomicInteger(0);

    void increment() {
        count.incrementAndGet();
    }
}

public class ThreadSafeCounter {

    public static void main(String[] args) throws InterruptedException {

        AtomicCounter counter = new AtomicCounter();
        SynchronizedCounter syncCounter = new SynchronizedCounter();
        UnsafeCounter unsafeCounter = new UnsafeCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });
        
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                syncCounter.increment();
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                syncCounter.increment();
            }
        });
        
        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                unsafeCounter.increment();
            }
        });

        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                unsafeCounter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        
        t3.start();
        t4.start();

        t3.join();
        t4.join();
        
        t5.start();
        t6.start();

        t5.join();
        t6.join();

        System.out.println("Expected Count: 200000");
        System.out.println("Synchronized Count: " + syncCounter.count);
        System.out.println("AtomicInteger Count: " + counter.count.get());
        System.out.println("Unsafe Counter: " + unsafeCounter.count);
    }
}