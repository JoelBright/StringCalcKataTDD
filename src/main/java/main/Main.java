package main;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    String numbers = "";
    int answer = add(numbers);
    System.out.println(answer);
  }

  static int add(String numbers) {
    AtomicInteger sum = new AtomicInteger();
    if(numbers.contains(",")) {
      List<Integer> nums =
          Arrays.stream(numbers.split(",")).map(s -> Integer.parseInt(s.trim())).toList();
      nums.forEach(sum::addAndGet);
    }

    return sum.get();
  }
}