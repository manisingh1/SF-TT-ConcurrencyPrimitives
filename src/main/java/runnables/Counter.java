package runnables;

public class Counter {
  private static /*volatile*/ int count = 0;

  public static void main(String[] args) throws Throwable {
    Object rendezvous = new Object();
    Runnable r = () -> {
      for (int i = 0; i < 100_000_000; i++) {
        synchronized (rendezvous) {
          count++;
        }
      }
    };
    Thread t1 = new Thread(r);
    t1.start();
    Thread t2 = new Thread(r);
    t2.start();
//    Thread.sleep(1_000);
    t1.join();
    t2.join();
    System.out.println("value of count is " + count);

  }
}
