/*import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(final String[] args) throws Exception {
        ThreadSafe1 runnable = new ThreadSafe1();
        new Thread(runnable).start();

        TimeUnit.MICROSECONDS.sleep(10000);
        runnable.cancel();

        System.out.println("in the main method done = " + runnable.getDone());
        System.out.println("Main thread says goodbye!");
    }

    public static class ThreadSafe1 implements Runnable {
        private volatile boolean done; // sometimes changes are not visible

        @Override
        public void run() {
            System.out.println("in the ThreadSafe done = " + done);
            long count = 0;
            while (!done) {
                count++;
            }
            System.out.println("Job's done! Count = " + count);
        }

        public void cancel() {
            done = true;
        }

        public boolean getDone(){
            return done;
        }
    }
}
*/
import java.util.concurrent.atomic.AtomicInteger;

class CounterThread extends Thread {
    private AtomicInteger count = new AtomicInteger();  // Atomic variable

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(i * 50);  // Simulate work with sleep
                count.incrementAndGet();  // Atomic increment operation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getCount() {
        return count.get();    // Get current value of count
    }
}

public class Main {
    public static void main(String[] args)
            throws InterruptedException {
        CounterThread t1 = new CounterThread();
        CounterThread t2 = new CounterThread();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // Expected output is 10 because
        // each thread increments 5 times.
        System.out.println("Count: " + (t1.getCount() + t2.getCount()));
    }
}