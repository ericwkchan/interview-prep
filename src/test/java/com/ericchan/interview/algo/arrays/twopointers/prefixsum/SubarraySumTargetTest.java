package com.ericchan.interview.algo.arrays.twopointers.prefixsum;

import com.ericchan.interview.algo.twopointers.prefixsum.SubarraySumTarget;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SubarraySumTargetTest {

  @Test
  void exampleCase() {
    List<Integer> arr = Arrays.asList(1, -20, -3, 30, 5, 4);
    int[] res = SubarraySumTarget.findSubarraySumIndices(arr, 7);
    assertArrayEquals(new int[]{1, 4}, res); // [-20,-3,30]
  }

  @Test
  void subarrayAtStart() {
    List<Integer> arr = Arrays.asList(2, 3, -1, 4);
    int[] res = SubarraySumTarget.findSubarraySumIndices(arr, 4);
    assertArrayEquals(new int[]{0, 3}, res); // [2,3,-1]
  }

  @Test
  void singleElementMatch() {
    List<Integer> arr = Arrays.asList(5, 1, 2);
    int[] res = SubarraySumTarget.findSubarraySumIndices(arr, 1);
    assertArrayEquals(new int[]{1, 2}, res); // [1]
  }

  @Test
  void entireArrayMatch() {
    List<Integer> arr = Arrays.asList(1, 2, 3, 4);
    int[] res = SubarraySumTarget.findSubarraySumIndices(arr, 10);
    assertArrayEquals(new int[]{0, 4}, res); // whole array
  }

  @Test
  void noMatchReturnsMinusOne() {
    List<Integer> arr = Arrays.asList(1, 2, 3);
    int[] res = SubarraySumTarget.findSubarraySumIndices(arr, 100);
    assertArrayEquals(new int[]{-1, -1}, res);
  }

  @Test
  void negativeNumbersInside() {
    List<Integer> arr = Arrays.asList(4, -2, -2, 5);
    int[] res = SubarraySumTarget.findSubarraySumIndices(arr, 0);
    assertArrayEquals(new int[]{0, 3}, res); // [4,-2,-2]
  }
}
