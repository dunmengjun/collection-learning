package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.junit.Test;

import static com.thoughtworks.collection.TestUtils.sleep;
import static com.thoughtworks.collection.TestUtils.waitForAllThreadCompleted;

public class MultipleThreadTest {

  //问题1 下面程序的最后输出会是什么样的？
  @Test
  public void arrayListTest() {
    List<String> list = new ArrayList<>();

    waitForAllThreadCompleted(1000, new ListTask(list));

    System.out.println(list.size());
  }

  //问题二 这个程序最后又会输出什么？
  @Test
  public void vectorTest() {
    Vector<String> vector = new Vector<>();

    waitForAllThreadCompleted(1000, new VectorTask(vector));

    System.out.println(vector);
  }

  class VectorTask implements Runnable {

    private Vector<String> vector;

    VectorTask(Vector<String> vector) {
      this.vector = vector;
    }

    @Override
    public void run() {
      if (!vector.contains("thoughtworks")) {
        sleep(5);
        vector.add("thoughtworks");
      }
    }
  }

  class ListTask implements Runnable {

    private List<String> data;

    ListTask(List<String> data) {
      this.data = data;
    }

    @Override
    public void run() {
      // 每个线程向List中添加100个元素
      for (int i = 0; i < 100; i++) {
        synchronized (data) {
          data.add("1");
        }
      }
    }
  }
}
