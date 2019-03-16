package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.junit.Test;

public class ListTest {

  @Test
  public void listSetDemo() {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.set(2, "thoughtworks");
    System.out.println(list);
  }

  @Test
  public void subListDemo() {
    List<String> originList = new ArrayList<>();
    originList.add("1");
    originList.add("2");
    originList.add("3");
    originList.add("4");
    originList.add("5");
    List<String> subList = originList.subList(2, 4);

    System.out.println(subList);

    List<String> stringList = new ArrayList<>(subList);

    subList.set(0, "1");
    System.out.println(originList);

    System.out.println(stringList);

  }

  @Test
  public void indexOfDemo() {
    List<String> originList = new ArrayList<>();
    originList.add("1");
    originList.add("2");
    originList.add("3");
    originList.add("4");
    originList.add("5");

    int index = originList.indexOf("sdaasd");
    System.out.println(index);
  }

  @Test
  public void lastIndexOfDemo() {
    List<String> originList = new ArrayList<>();
    originList.add("1");
    originList.add("2");
    originList.add("3");
    originList.add("4");
    originList.add("5");

    int index = originList.lastIndexOf("3");
    System.out.println(index);
  }

  @Test
  public void listSortDemo() {
    List<String> originList = new ArrayList<>();
    originList.add("2");
    originList.add("1");
    originList.add("4");
    originList.add("5");
    originList.add("3");

    System.out.println(originList);
    originList.sort(Comparator.comparingInt(Integer::valueOf));
    System.out.println(originList);
  }

  @Test
  public void listIteratorDemo() {
    List<String> originList = new ArrayList<>();
    originList.add("2");
    originList.add("1");
    originList.add("4");
    originList.add("5");
    originList.add("3");

    ListIterator<String> listIterator = originList.listIterator();
    while (listIterator.hasNext()) {
      int index = listIterator.nextIndex();
      String next = listIterator.next();
      System.out.println("index:" + index + ", value:" + next);
    }
  }

  @Test
  public void name() {
    List<String> testArrayList = new ArrayList<>();
    testArrayList.add("2");
    testArrayList.add("1");
    testArrayList.add("4");
    testArrayList.add("5");
    testArrayList.add("3");
    Iterator<String> iterator = testArrayList.iterator();
    while(iterator.hasNext()) {
      if(iterator.next().equals("3")) {
        iterator.remove();
      }
    }
    System.out.println(testArrayList);
  }
}
