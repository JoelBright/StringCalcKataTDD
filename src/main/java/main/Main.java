package main;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void main(String[] args) {
    String numbers = "";
    int answer = add(numbers);
    System.out.println(answer);
  }

  static int add(String numbers) {
    if(numbers.isEmpty())
      return 0;
    else {
      return 1;
    }
  }
}