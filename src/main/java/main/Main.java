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
    String delimiterRegex = "[,\n]";
    int beginIndex = 0;
    if(numbers.contains("//")){
      delimiterRegex = numbers.charAt(2)+"";
      beginIndex = 4;
    }
    if(numbers.isEmpty() || beginIndex >= numbers.length()) {
      return 0;
    } else if(numbers.contains(delimiterRegex) || numbers.contains(",") || numbers.contains("\n")) {
      List<Integer> nums =
          Arrays.stream(numbers.substring(beginIndex).split(delimiterRegex)).map(s -> Integer.parseInt(s.trim())).toList();
      nums.forEach(sum::addAndGet);
    } else {
      sum.getAndAdd(Integer.parseInt(numbers.substring(beginIndex)));
    }

    return sum.get();
  }
}