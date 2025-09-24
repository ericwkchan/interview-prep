package com.ericchan.interview.algo.arrays.twopointers.slidingwindow;

import com.ericchan.interview.algo.twopointers.slidingwindow.ShortestSubarrayAtLeastTarget;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ShortestSubarrayAtLeastTargetTest {

  @Test
  void exampleCase() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 4, 1, 7, 3, 0, 2, 5));
    int target = 10;
    int res = ShortestSubarrayAtLeastTarget.lengthOfShortestSubarrayAtLeast(nums, target);
    assertEquals(2, res); // [7,3]
  }

  @Test
  void singleElementEqualsTarget() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(10));
    int target = 10;
    int res = ShortestSubarrayAtLeastTarget.lengthOfShortestSubarrayAtLeast(nums, target);
    assertEquals(1, res);
  }

  @Test
  void entireArrayNeeded() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 1, 1));
    int target = 3;
    int res = ShortestSubarrayAtLeastTarget.lengthOfShortestSubarrayAtLeast(nums, target);
    assertEquals(3, res);
  }

  @Test
  void classicLeetStyleCase() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 1, 2, 4, 3));
    int target = 7;
    int res = ShortestSubarrayAtLeastTarget.lengthOfShortestSubarrayAtLeast(nums, target);
    assertEquals(2, res); // [4,3]
  }

  @Test
  void zerosPresentStillAllowLengthOne() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 0, 10, 0));
    int target = 10;
    int res = ShortestSubarrayAtLeastTarget.lengthOfShortestSubarrayAtLeast(nums, target);
    assertEquals(1, res); // [10]
  }

  @Test
  void multipleWindowsChooseShortest() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(5, 1, 5, 1, 5));
    int target = 6;
    int res = ShortestSubarrayAtLeastTarget.lengthOfShortestSubarrayAtLeast(nums, target);
    assertEquals(2, res); // [5,1] or [1,5]
  }

  @Test
  void targetEqualsTotalSum() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(5, 5));
    int target = 10;
    int res = ShortestSubarrayAtLeastTarget.lengthOfShortestSubarrayAtLeast(nums, target);
    assertEquals(2, res);
  }

  @Test
  void increasingSequence() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    int target = 11;
    int res = ShortestSubarrayAtLeastTarget.lengthOfShortestSubarrayAtLeast(nums, target);
    assertEquals(3, res); // [3,4,5] -> 12
  }
}
