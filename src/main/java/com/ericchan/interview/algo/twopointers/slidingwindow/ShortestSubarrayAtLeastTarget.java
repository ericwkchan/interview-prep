package com.ericchan.interview.algo.twopointers.slidingwindow;

import java.util.List;

public class ShortestSubarrayAtLeastTarget {

  public static int lengthOfShortestSubarrayAtLeast(List<Integer> nums, int target) {

    if (nums.get(0) >= target) {
      return 1;
    }

    int left = 0;
    int shortestLength = nums.size() + 1;
    int windowSum = 0;
    for (int right = 0; right < nums.size(); right++) {
      windowSum += nums.get(right);

      // goal: minimize window length while window sum is valid

      while (windowSum >= target) {
        // shrink while valid and constantly check if we have a shorter length
        shortestLength = Math.min(shortestLength, right - left + 1);
        windowSum -= nums.get(left);
        left++;
      }
    }
    return shortestLength;
  }
}
