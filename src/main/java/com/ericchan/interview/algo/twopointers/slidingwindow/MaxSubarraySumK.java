package com.ericchan.interview.algo.twopointers.slidingwindow;

import java.util.List;

public class MaxSubarraySumK {
  public static int maxSubarraySum(List<Integer> nums, int k) {
    int start = 0;
    int end = k;
    int windowSum = 0;

    for (int i = 0; i < k; i++) {
      windowSum += nums.get(i);
    }
    int maxSum = windowSum;
    while (start < nums.size() - k) {
      windowSum -= nums.get(start);
      windowSum += nums.get(end);
      maxSum = Math.max(maxSum, windowSum);
      start++;
      end++;
    }

/*    while (start <= nums.size() - k) {
      int sum = 0;
      for (int i = start; i < end; i++) {
        sum = sum + nums.get(i);
      }
      maxSum = Math.max(sum, maxSum);
      start++;
      end++;
    }*/

    /**
     * Review: Be careful about the indexes when moving the window and when to stop. The initial
     * approach I had works but its an unnecessary loop to try and sum the subarray. We can take
     * advantage of the sliding window and add/subtract the two pointers for better efficiency.
     * Also, subarray != subset. Subarray refers to contiguous parts of the array.
     */

    return maxSum;
  }
}
