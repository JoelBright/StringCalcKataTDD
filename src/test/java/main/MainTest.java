package main;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {
  @Test
  void addForEmptyTest(){
    Assertions.assertEquals(0, Main.add(""));
  }
  @Test
  void addSingleNumberTest(){
    Assertions.assertEquals(1, Main.add("1"));
    Assertions.assertEquals(5, Main.add("5"));
    Assertions.assertEquals(17, Main.add("17"));
  }
  @Test
  void addSeriesOfNumbersTest(){
    Assertions.assertEquals(55, Main.add("1, 2, 3, 4, 5, 6, 7, 8, 9, 10"));
    Assertions.assertEquals(75, Main.add("5, 10, 15, 20, 25"));
    Assertions.assertEquals(183, Main.add("17, 19, 23, 27, 29, 31, 37"));
    Assertions.assertEquals(1899, Main.add("183, 159, 263, 237, 289, 391, 377"));
  }
  @Test
  void addSeriesOfNumbersUsingNewlineAlsoTest(){
    Assertions.assertEquals(55, Main.add("1\n2, 3\n4, 5, 6, 7, 8\n9, 10"));
    Assertions.assertEquals(75, Main.add("5\n10\n15\n20\n25"));
    Assertions.assertEquals(183, Main.add("17, 19, 23, 27, 29, 31, 37"));
    Assertions.assertEquals(1899, Main.add("183, 159, 263, 237, 289, 391, 377"));
  }
  @Test
  void addSeriesOfNumbersAllowDelimiterChangeTest(){
    Assertions.assertEquals(0, Main.add("//;\n"));
    Assertions.assertEquals(17, Main.add("//;\n17"));
    Assertions.assertEquals(55, Main.add("//;\n1;2;3;4;5;6;7;8;9;10"));
    Assertions.assertEquals(75, Main.add("//:\n5:10:15:20:25"));
    Assertions.assertEquals(1899, Main.add("//!\n183!159!263!237!289!391!377"));
  }
  @Test
  void addNegativesNotAllowedTest(){
    NoNegativesException e1 = assertThrows(NoNegativesException.class,
        () -> Main.add("-5"));
    assertEquals("Numbers not allowed, numbers:-5", e1.getMessage());

    NoNegativesException e2 = assertThrows(NoNegativesException.class,
        () -> Main.add("-5,6, 8, -7, 15,74, 6"), "Numbers not allowed, numbers:-5, -7");
    assertEquals("Numbers not allowed, numbers:-5, -7", e2.getMessage());

    NoNegativesException e3 = assertThrows(NoNegativesException.class,
        () -> Main.add("-25, -7, 41, -541, -98"));
    assertEquals("Numbers not allowed, numbers:-25, -7, -541, -98", e3.getMessage());
  }
  @Test
  void addIgnoreNumbersGreaterThanThousandTest(){
    Assertions.assertEquals(41, Main.add("1, 2000, 3, 4000, 5, 6, 7, 8000, 9, 10"));
    Assertions.assertEquals(1050, Main.add("5, 1000, 1500, 20, 25"));
    Assertions.assertEquals(100, Main.add("17, 19, 2003, 27, 2009, 3001, 37"));
    Assertions.assertEquals(1610, Main.add("183, 159, 263, 237, 2809, 391, 377"));
  }
  @Test
  void addDelimiterDefinedInSquareBracketsTest(){
    Assertions.assertEquals(0, Main.add("//[;]\n"));
    Assertions.assertEquals(17, Main.add("//[::]\n17"));
    Assertions.assertEquals(55, Main.add("//[--]\n1--2--3--4--5--6--7--8--9--10"));
    Assertions.assertEquals(75, Main.add("//[;:]\n5;:10;:15;:20;:25"));
    Assertions.assertEquals(6, Main.add("//[xoxo]\n1xoxo2xoxo3"));
  }
}