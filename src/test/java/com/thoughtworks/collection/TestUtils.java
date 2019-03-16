package com.thoughtworks.collection;

import java.util.concurrent.CountDownLatch;

public class TestUtils {

  public static long computingTime(Runnable runnable) {
    long startTime = System.currentTimeMillis();
    runnable.run();
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void waitForAllThreadCompleted(int threadNumber, Runnable runnable) {
    CountDownLatch countDownLatch = new CountDownLatch(threadNumber);
    for (int i = 0; i < threadNumber; i++) {
      Thread thread = new Thread(new WaitForAllTask(countDownLatch, runnable));
      thread.start();
    }
    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static class WaitForAllTask implements Runnable {

    private CountDownLatch countDownLatch;

    private Runnable runnable;

    public WaitForAllTask(CountDownLatch countDownLatch, Runnable runnable) {
      this.countDownLatch = countDownLatch;
      this.runnable = runnable;
    }

    @Override
    public void run() {
      runnable.run();
      countDownLatch.countDown();
    }
  }
}
