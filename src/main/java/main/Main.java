package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    String numbers = "//[xo*xo]\n1xo*xo2xo*xo3";
    int answer = add(numbers);
    System.out.println(answer);
  }

  static int add(String numbers) throws NoNegativesException{
    AtomicInteger sum = new AtomicInteger();
    String delimiterRegex = "[,\n]";
    int beginIndex = 0;
    List<Integer> negatives = new ArrayList<>();

    if(numbers.contains("//")){
      beginIndex = numbers.indexOf('\n') + 1;
      if(numbers.contains("[")){
        int delimiterStart = numbers.indexOf('[');
        int delimiterEnd = numbers.lastIndexOf(']');
        String delims = numbers.substring(delimiterStart+1, delimiterEnd).replace("][", "|");
        delimiterRegex = delims.replace("[", "").replace("]", "");
      }else {
        delimiterRegex = numbers.substring(2, beginIndex-1);
      }
    }
    if(numbers.isEmpty() || numbers.substring(beginIndex).isEmpty()) {
      return 0;
    } else if(numbers.contains(delimiterRegex) || numbers.contains(",") || numbers.contains("\n")) {
      List<Integer> nums =
          Arrays.stream(numbers.substring(beginIndex).split(delimiterRegex)).map(s -> Integer.parseInt(s.trim())).toList();
      nums.stream().filter(i -> i <= 1000).forEach(i -> {
        if(i < 0) {
          negatives.add(i);
        } else {
          sum.getAndAdd(i);
        }
      });
    } else {
      int i = Integer.parseInt(numbers.substring(beginIndex));
      if (i < 0) {
        negatives.add(i);
      } else {
        sum.getAndAdd(i);
      }
    }

    if (negatives.isEmpty()) {
      return sum.get();
    } else {
      String exceptionMessage = String.format("Numbers not allowed, numbers:%s",
          negatives.stream().map(Object::toString).collect(Collectors.joining(", ")));
      throw new NoNegativesException(exceptionMessage);
    }
  }
}