package com.ericchan.interview.algo.twopointers.slidingwindow;

import java.util.List;

public class LongestSubarrayAtMostTarget {
  /**
   * Returns the length of the longest contiguous subarray whose sum <= target.
   * Assumes nums contains non-negative integers (sliding window requirement).
   */
  public static int firstAttempt(List<Integer> nums, int target) {
    /**
     * Right idea, wrong execution
     */

    if (nums.isEmpty()) {
      return 0;
    }

    int start = 0;

    int maxLength = 0;
    int currentSum = 0;
    int currentLength = 0;

    for (int end = 0; end < nums.size(); end++) {
      // ❌ Problem 1: you check overflow BEFORE adding nums[end].
      // The window you’re judging here is actually [start .. end-1],
      // but you *intend* to judge [start .. end] each iteration.

      if (currentSum > target) {
        // ❌ Problem 2 (off-by-one): you increment start first…
        start++;
        // …then subtract nums.get(start). This removes the *new* start,
        // not the element that just left the window. You meant:
        // currentSum -= nums.get(start); start++;
        currentSum = currentSum - nums.get(start);

        // This length counter can desync because of the off-by-one above.
        currentLength--;
      }

      if (currentSum <= target) {
        // ❌ Because you didn’t add nums[end] earlier, this “extend” step
        // might temporarily create an invalid window without immediate shrink.
        currentSum += nums.get(end);
        currentLength++;
      }

      if (currentSum <= target) {
        // You might update maxLength while the true window (including end)
        // should have been shrunk first.
        maxLength = Math.max(maxLength, currentLength);
      }
    }
    return maxLength;
  }
  public static int lengthOfLongestSubarrayAtMost(List<Integer> nums, int target) {
    int left = 0, sum = 0, best = 0;
    for (int right = 0; right < nums.size(); right++) {
      sum += nums.get(right);                // include end

      // goal: maixmize window length while keeping sum valid
      while (left <= right && sum > target) { // shrink until valid
        sum -= nums.get(left);
        left++;
      }

      best = Math.max(best, right - left + 1); // window is valid now
    }
    return best;
  }
}
