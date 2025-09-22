package com.ericchan.interview.algo.arrays.twopointers.oppositedirection;

import com.ericchan.interview.algo.twopointers.oppositedirection.WaterContainer;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

  @Test
  void testSampleCase() {
    List<Integer> heights = new ArrayList<>(Arrays.asList(1, 8, 6, 2, 5, 4, 8, 3, 7));
    int result = WaterContainer.maxArea(heights);
    assertEquals(49, result);
  }

  @Test
  void testSimpleTwoLines() {
    List<Integer> heights = new ArrayList<>(Arrays.asList(1, 1));
    int result = WaterContainer.maxArea(heights);
    assertEquals(1, result); // width=1, height=1 → area=1
  }

  @Test
  void testIncreasingHeights() {
    List<Integer> heights = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    int result = WaterContainer.maxArea(heights);
    assertEquals(6, result); // best is lines at indices 1 & 4: min(2,5)*3=6
  }

  @Test
  void testDecreasingHeights() {
    List<Integer> heights = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
    int result = WaterContainer.maxArea(heights);
    assertEquals(6, result); // best is lines at indices 0 & 3: min(5,2)*3=6
  }

  @Test
  void testAllSameHeights() {
    List<Integer> heights = new ArrayList<>(Arrays.asList(4, 4, 4, 4));
    int result = WaterContainer.maxArea(heights);
    assertEquals(12, result); // best is first & last: 4 * width(3) = 12
  }

  @Test
  void testSingleElement() {
    List<Integer> heights = new ArrayList<>(Arrays.asList(5));
    int result = WaterContainer.maxArea(heights);
    assertEquals(0, result); // can't form container with one line
  }

  @Test
  void testEmptyList() {
    List<Integer> heights = new ArrayList<>();
    int result = WaterContainer.maxArea(heights);
    assertEquals(0, result);
  }
}
