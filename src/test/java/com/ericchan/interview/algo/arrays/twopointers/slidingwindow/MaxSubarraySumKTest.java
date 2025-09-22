package com.ericchan.interview.algo.arrays.twopointers.slidingwindow;

import com.ericchan.interview.algo.twopointers.slidingwindow.MaxSubarraySumK;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MaxSubarraySumKTest {

  @Test
  void testExampleCase() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 7, 4, 1));
    int k = 3;
    int result = MaxSubarraySumK.maxSubarraySum(nums, k);
    assertEquals(14, result); // [3, 7, 4] -> 14
  }

  @Test
  void testWindowSizeOne() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(5, 1, 2, 10, 3));
    int result = MaxSubarraySumK.maxSubarraySum(nums, 1);
    assertEquals(10, result); // just the largest single element
  }

  @Test
  void testWindowEqualsArrayLength() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(2, 2, 2, 2));
    int result = MaxSubarraySumK.maxSubarraySum(nums, 4);
    assertEquals(8, result); // entire array
  }

  @Test
  void testArrayWithZeros() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 0, 5, 0, 0));
    int result = MaxSubarraySumK.maxSubarraySum(nums, 2);
    assertEquals(5, result); // [5, 0]
  }

  @Test
  void testArrayIncreasing() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    int result = MaxSubarraySumK.maxSubarraySum(nums, 2);
    assertEquals(9, result); // [4, 5]
  }

  @Test
  void testArrayDecreasing() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5));
    int result = MaxSubarraySumK.maxSubarraySum(nums, 3);
    assertEquals(24, result); // [9, 8, 7]
  }

  @Test
  void testWindowSizeEqualOneAndArrayOfOnes() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 1, 1));
    int result = MaxSubarraySumK.maxSubarraySum(nums, 1);
    assertEquals(1, result); // any single element
  }
}
