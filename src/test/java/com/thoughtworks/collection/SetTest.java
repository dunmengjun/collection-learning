package com.thoughtworks.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;

public class SetTest {

  //hash set的无序性是指取出和存入的顺序不一致,运行多次可能顺序不一致
  @Test
  public void hashSetIsNotSorted() {
    Set hashSet = new HashSet();
    hashSet.add("B");
    hashSet.add("A");
    hashSet.add("D");
    hashSet.add("E");
    hashSet.add("C");
    hashSet.add("F");
    System.out.println(hashSet);
  }

  //取出和存入的顺序一致, 不管运行几次，顺序也都是固定的
  @Test
  public void linkedHashSetIsSorted() {
    Set linkedHashSet = new LinkedHashSet();
    linkedHashSet.add("B");
    linkedHashSet.add("A");
    linkedHashSet.add("D");
    linkedHashSet.add("E");
    linkedHashSet.add("C");
    linkedHashSet.add("F");
    System.out.println(linkedHashSet);
  }

  //取出和存入的顺序不一致，但是是可排序的,加入其中的类必须实现Comparable接口, 不管运行几次，顺序都是固定的
  @Test
  public void treeSetIsSorted() {
    Set treeSet = new TreeSet();
    treeSet.add("B");
    treeSet.add("B");
    treeSet.add("A");
    treeSet.add("D");
    treeSet.add("E");
    treeSet.add("C");
    treeSet.add("F");
    System.out.println(treeSet);
  }

  @Test
  public void treeSetWillThrowExceptionWhenItemIsNotImplementComparableInterface() {
    Set treeSet = new TreeSet();
    treeSet.add(new Item());
    System.out.println(treeSet);
  }

  class Item {

  }
}
