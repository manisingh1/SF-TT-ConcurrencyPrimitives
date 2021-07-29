package runnables;

public class Ex1 {
  public static void main(String[] args) {
    Runnable myjob = new Runnable() {
      int i = 0;
      @Override
      public void run() {
        System.out.println(Thread.currentThread().getName() + " worker starting...");
        for (; i < 100; i++) {
          System.out.println(Thread.currentThread().getName() + " i is " + i);
        }
        System.out.println(Thread.currentThread().getName() + " worker ending...");
      }
    };

    System.out.println(Thread.currentThread().getName() + " about to trigger worker");
//    myjob.run();
    Thread t = new Thread(myjob);
    Thread t2 = new Thread(myjob);
//    t.setDaemon(true);
    t.start();
    t2.start();
    System.out.println(Thread.currentThread().getName() + " worker returned");
  }
}
