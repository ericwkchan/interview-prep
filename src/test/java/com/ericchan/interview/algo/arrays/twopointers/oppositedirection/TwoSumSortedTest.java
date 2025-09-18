package com.ericchan.interview.algo.arrays.twopointers.oppositedirection;

import com.ericchan.interview.algo.twopointers.oppositedirection.TwoSumSorted;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TwoSumSortedTest {

  @Test
  void testSampleCase() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 8, 11, 18));
    List<Integer> result = TwoSumSorted.twoSumSorted(nums, 8);
    assertEquals(Arrays.asList(1, 3), result);
  }

  @Test
  void testFirstAndLast() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 5, 10, 20));
    List<Integer> result = TwoSumSorted.twoSumSorted(nums, 21);
    assertEquals(Arrays.asList(0, 3), result);
  }

  @Test
  void testTwoElementsOnly() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(4, 6));
    List<Integer> result = TwoSumSorted.twoSumSorted(nums, 10);
    assertEquals(Arrays.asList(0, 1), result);
  }
}

