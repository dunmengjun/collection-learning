package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollectionMethodTest {

  @Test
  public void sizeExample() {
    List<String> testList = new ArrayList<>();
    testList.add("one");
    testList.add("two");

    assertEquals(2, testList.size());
  }

  @Test
  public void isEmptyExample() {
    List<String> testList = new ArrayList<>();
    testList.add("one");

    assertFalse(testList.isEmpty());
  }

  @Test
  public void containsExample() {
    Collection<String> collection = new ArrayList<>();
    collection.add("one");

    assertTrue(collection.contains("one"));
  }

  @Test
  public void iteratorExample() {
    List<String> testList = new ArrayList<>();
    testList.add("one");
    testList.add("two");

    Iterator<String> iterator = testList.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  @Test
  public void toArrayWithoutTypeExample() {
    List<String> testList = new ArrayList<>();
    testList.add("one");
    testList.add("two");

    Object[] actual = testList.toArray();

    assertArrayEquals(new Object[]{"one", "two"}, actual);
  }

  @Test
  public void toArrayWithTypeExample() {
    List<String> testList = new ArrayList<>();
    testList.add("one");
    testList.add("two");

    String[] actual = testList.toArray(new String[0]);

    assertArrayEquals(new String[]{"one", "two"}, actual);
  }

  @Test
  public void removeExample() {
    List<String> testList = new ArrayList<>();
    testList.add("one");
    testList.add("two");

    boolean actual = testList.remove("one");

    assertTrue(actual);
    assertArrayEquals(new Object[]{"two"}, testList.toArray());
  }

  @Test
  public void containsAllExample() {
    List<String> originList = new ArrayList<>();
    originList.add("one");
    originList.add("two");
    originList.add("three");
    List<String> containedList = new ArrayList<>();
    containedList.add("one");
    containedList.add("two");

    boolean actual = originList.containsAll(containedList);

    assertTrue(actual);
  }

  @Test
  public void addAllExample() {
    List<String> list = new ArrayList<>();
    list.add("one");
    List<String> otherList = new ArrayList<>();
    otherList.add("two");
    otherList.add("three");

    boolean actual = list.addAll(otherList);

    assertTrue(actual);
    assertArrayEquals(new Object[]{"one", "two", "three"}, list.toArray());
  }

  @Test
  public void removeAllExample() {
    List<String> list = new ArrayList<>();
    list.add("one");
    list.add("two");
    list.add("three");
    List<String> needDeletedList = new ArrayList<>();
    needDeletedList.add("two");
    needDeletedList.add("three");

    boolean actual = list.removeAll(needDeletedList);

    assertTrue(actual);
    assertArrayEquals(new Object[]{"one"}, list.toArray());
  }

  @Test
  public void retainAllExample() {
    List<String> list = new ArrayList<>();
    list.add("one");
    list.add("two");
    list.add("three");
    List<String> needRetainList = new ArrayList<>();
    needRetainList.add("two");
    needRetainList.add("three");

    boolean actual = list.retainAll(needRetainList);

    assertTrue(actual);
    assertArrayEquals(new Object[]{"two", "three"}, list.toArray());
  }

  @Test
  public void removeIfExample() {
    List<String> list = new ArrayList<>();
    list.add("one");
    list.add("two");
    list.add("ww");
    list.add("three");

    boolean actual = list.removeIf(item -> item.contains("w"));

    assertTrue(actual);
    assertArrayEquals(new Object[]{"one", "three"}, list.toArray());
  }

  @Test
  public void clearExample() {
    List<String> list = new ArrayList<>();
    list.add("one");
    list.add("two");
    list.add("three");

    list.clear();

    assertEquals(0, list.size());
  }
}
