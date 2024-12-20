package main;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;


class MainTest {
  @Test
  void addTestForEmpty(){
    Assertions.assertEquals(0, Main.add(""));
  }
  @Test
  void addTestSingleNumber(){
    Assertions.assertEquals(1, Main.add("1"));
    Assertions.assertEquals(5, Main.add("5"));
    Assertions.assertEquals(17, Main.add("17"));
  }
  @Test
  void addTestSeriesOfNumbers(){
    Assertions.assertEquals(55, Main.add("1, 2, 3, 4, 5, 6, 7, 8, 9, 10"));
    Assertions.assertEquals(75, Main.add("5, 10, 15, 20, 25"));
    Assertions.assertEquals(183, Main.add("17, 19, 23, 27, 29, 31, 37"));
    Assertions.assertEquals(1899, Main.add("183, 159, 263, 237, 289, 391, 377"));
  }
}