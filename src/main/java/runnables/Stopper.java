package runnables;

public class Stopper {
  private static boolean stop = false;

  public static void main(String[] args) throws Throwable {
    new Thread(() -> {
      System.out.println("worker thread started...");
      while (! stop)
        ;
      System.out.println("worker thread ended...");
    }).start();
    System.out.println("main has launched the worker...");
    Thread.sleep(1000);
    System.out.println("main about to change stop...");
    stop = true;
    System.out.println("main... value of stop is " + stop);
  }
}
