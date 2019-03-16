package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.Test;

import static com.thoughtworks.collection.TestUtils.computingTime;
import static java.util.stream.Collectors.toList;

public class StreamTest {

  @Test
  public void streamPerformanceTest() {
    List<Integer> testList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      testList.add(i);
    }

    long streamTime = computingTime(() ->
        testList.stream()
            .map(String::valueOf)
            .count()
    );

    long stream1Time = computingTime(() ->
        testList.parallelStream()
            .map(String::valueOf)
            .count()
    );

    System.out.println(streamTime);
    System.out.println(stream1Time);
  }

  @Test
  public void streamOperationTest() {
    List<String> testList = new ArrayList<>();
    testList.add("eqweqw");
    testList.add("wqeqwe");
    testList.add("iopipo");
    testList.add("B");
    testList.add("A");
    testList.add("F");
    testList.add("D");
    testList.add("E");
    testList.add(null);
    testList.add("C");
    testList.add("F");
    testList.add("%%%%");
    testList.add("###");
    testList.add("&&");

    Stream<String> stream = testList.stream();
    List<Integer> list = stream
        .peek(System.out::println)
        .skip(3)
        .limit(8)
        .filter(Objects::nonNull)
        .distinct()
        .map(item -> (int) item.charAt(0))
        .sorted(Comparator.reverseOrder())
        .collect(toList());

    System.out.println(list);
  }


  @Test
  public void streamFlatMapTest() {
    Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
        .flatMap(List::stream)
        .forEach(System.out::println);
  }

  @Test
  public void streamConcatTest() {
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    List<Integer> list2 = new ArrayList<>();
    list2.add(3);
    list2.add(4);

    Stream.concat(list1.stream(), list2.stream())
        .forEach(System.out::println);
  }

  @Test
  public void reduceTest() {
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);

    Integer sum = list1.stream().reduce(0, (x, y) -> x + y);

    System.out.println(sum);
  }

  @Test
  public void infiniteStream() {
    Random random = new Random();
    List<Integer> collect = Stream.generate(random::nextInt).limit(100).collect(toList());
    System.out.println(collect);
  }

  @Test
  public void fibonacciStream() {
    Stream<Long> fibonacciSteam = Stream.generate(new FibonacciSupplier());
    List<Long> fibonacciList = fibonacciSteam.limit(50).collect(toList());
    System.out.println(fibonacciList);
  }

  @Test
  public void stepInfiniteStream() {
    List<Integer> stepList = Stream.iterate(1000, x -> x + 2)
        .limit(100)
        .collect(toList());
    System.out.println(stepList);
  }

  class FibonacciSupplier implements Supplier<Long> {

    long previous = 0;
    long current = 1;

    @Override
    public Long get() {
      long next = previous + current;
      previous = current;
      current = next;
      return previous;
    }
  }

}
