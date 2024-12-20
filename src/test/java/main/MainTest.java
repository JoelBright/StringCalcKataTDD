package main;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;


class MainTest {
  @Test
  void addTestForEmpty(){
    Assertions.assertEquals(0, Main.add(""));
  }

}