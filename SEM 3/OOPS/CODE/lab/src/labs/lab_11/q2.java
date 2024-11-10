package labs.lab_11;

class Example implements Runnable {

    private final String message;  // Message to print ("Hi" or "AI")
    private final Object lock;     // Shared lock object

    // Constructor to initialize the message and the lock
    Example(String message, Object lock) {
        this.message = message;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
              // Infinite loop to keep printing alternately
                synchronized (lock) {
                    // Print the message
                    System.out.println(message);

                    Thread.sleep(3000);
                    // Notify the other thread to wake up
                    lock.notify();

                    // Wait for the other thread to print
                    lock.wait();
                }

                // Sleep for 3 seconds (outside the synchronized block)


        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

public class q2 {
    public static void main(String[] args) {
        // Shared lock object for synchronization
        Object lock = new Object();

        // Create two Runnable instances with the same lock object
        Runnable obj1 = new Example("Hi", lock);
        Runnable obj2 = new Example("AI", lock);

        // Create and start the two threads
        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);

        thread1.start();
        thread2.start();

        // Ensure the main thread waits for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
    }
}
