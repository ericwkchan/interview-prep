package com.ericchan.interview.algo.twopointers.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class RangeSumQueryImmutable {

  public static int rangeSumQueryImmutable(List<Integer> nums, int left, int right) {

    ArrayList<Integer> prefixSums = new ArrayList<>();
    prefixSums.add(0);

    /**
     * nums = [1, 2, 3, 4], sumRange(1, 3). Output: 9.
     * prefixSum = [0, 1, 3, 6, 10]
     */

    int sum = 0;
    for (int i : nums) {
      sum += i;
      prefixSums.add(sum);
    }

    return prefixSums.get(right + 1) - prefixSums.get(left);
  }
}
