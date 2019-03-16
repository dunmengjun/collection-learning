package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import static com.thoughtworks.collection.TestUtils.computingTime;

public class ArrayListAndLinkedListTest {

  private List<Integer> testArrayList = new ArrayList<>();

  private List<Integer> testLinkedList = new LinkedList<>();

  @Before
  public void setup() {
    for (int i = 0; i < 1000000; i++) {
      testArrayList.add(i);
    }

    for (int i = 0; i < 1000000; i++) {
      testLinkedList.add(i);
    }
  }

  @Test
  public void setTest(){
    long arrayListGetValueTime = computingTime(() -> {
      for (int i = 0; i < 10000; i++) {
        testArrayList.add(4000,7969879);
      }
    });

    long linkedListGetValueTime = computingTime(() -> {
      for (int i = 0; i < 10000; i++) {
        testLinkedList.add(4000,7969879);
      }
    });

    System.out.println(arrayListGetValueTime);
    System.out.println(linkedListGetValueTime);
  }

  @Test
  public void arrayListGetValueDemo() {
    long arrayListGetValueTime = computingTime(() -> {
      for (int i = 0; i < 1000000; i++) {
        testArrayList.get(999999);
      }
    });

    long linkedListGetValueTime = computingTime(() -> {
      for (int i = 0; i < 1000000; i++) {
        testLinkedList.get(999999);
      }
    });

    System.out.println(arrayListGetValueTime);
    System.out.println(linkedListGetValueTime);
  }

  @Test
  public void inLoopCanNotAllowedRemoveItemFromList() {
    for (Integer item : testArrayList) {
      if (item == 4) {
        testArrayList.remove(item);
      }
    }
  }
}
