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
}