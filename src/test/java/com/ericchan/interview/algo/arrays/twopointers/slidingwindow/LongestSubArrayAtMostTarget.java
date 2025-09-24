package com.ericchan.interview.algo.arrays.twopointers.slidingwindow;

import com.ericchan.interview.algo.twopointers.slidingwindow.LongestSubarrayAtMostTarget;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubarrayAtMostTargetTest {

  @Test
  void exampleCase() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 6, 3, 1, 2, 4, 5));
    int target = 10;
    int res = LongestSubarrayAtMostTarget.lengthOfLongestSubarrayAtMost(nums, target);
    assertEquals(4, res); // [3,1,2,4]
  }

  @Test
  void allWithinTarget_takeWholeArray() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 1));
    int target = 10;
    int res = LongestSubarrayAtMostTarget.lengthOfLongestSubarrayAtMost(nums, target);
    assertEquals(3, res); // entire array fits
  }

  @Test
  void exactMatchWindow() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 5));
    int target = 10;
    int res = LongestSubarrayAtMostTarget.lengthOfLongestSubarrayAtMost(nums, target);
    assertEquals(3, res); // [2,3,5] sums to 10
  }

  @Test
  void noElementFits_returnsZero() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(11, 12, 13));
    int target = 10;
    int res = LongestSubarrayAtMostTarget.lengthOfLongestSubarrayAtMost(nums, target);
    assertEquals(0, res); // no subarray sum <= 10
  }

  @Test
  void singleElementEqualTarget_countsOne() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(10));
    int target = 10;
    int res = LongestSubarrayAtMostTarget.lengthOfLongestSubarrayAtMost(nums, target);
    assertEquals(1, res);
  }

  @Test
  void zerosHelpExtendLength() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 0, 5, 0, 0));
    int target = 5;
    int res = LongestSubarrayAtMostTarget.lengthOfLongestSubarrayAtMost(nums, target);
    assertEquals(5, res); // entire array fits due to zeros
  }

  @Test
  void increasingSequence_shrinksWhenNeeded() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    int target = 7;
    int res = LongestSubarrayAtMostTarget.lengthOfLongestSubarrayAtMost(nums, target);
    assertEquals(3, res); // [1,2,3] or [3,4] (length 3 vs 2)
  }

  @Test
  void emptyList_returnsZero() {
    List<Integer> nums = new ArrayList<>();
    int target = 10;
    int res = LongestSubarrayAtMostTarget.lengthOfLongestSubarrayAtMost(nums, target);
    assertEquals(0, res);
  }
}
