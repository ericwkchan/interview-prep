package com.ericchan.interview.algo.medium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShortestStringFormationTest {

  @Test
  public void testExample1() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(2, sol.shortestWay("abc", "abcbc"));
  }

  @Test
  public void testExample2() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(-1, sol.shortestWay("abc", "acdbc"));
  }

  @Test
  public void testExample3() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(3, sol.shortestWay("xyz", "xzyxz"));
  }

  @Test
  public void testSingleCharRepeated() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(5, sol.shortestWay("a", "aaaaa"));
  }

  @Test
  public void testTargetEqualsSource() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(1, sol.shortestWay("abc", "abc"));
  }

  @Test
  public void testTargetIsLongerButRepeatsSource() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(3, sol.shortestWay("abc", "abcabcabc"));
  }

  @Test
  public void testImpossibleChar() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(-1, sol.shortestWay("abc", "abd"));
  }

  @Test
  public void testEmptyTarget() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(0, sol.shortestWay("abc", ""));
  }

  @Test
  public void testSourceAndTargetSingleSameChar() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(1, sol.shortestWay("z", "z"));
  }

  @Test
  public void testSourceAndTargetDifferentChar() {
    ShortestStringFormation sol = new ShortestStringFormation();
    assertEquals(-1, sol.shortestWay("z", "y"));
  }
}
