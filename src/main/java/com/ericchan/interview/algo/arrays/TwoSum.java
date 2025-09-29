package com.ericchan.interview.algo.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  /**
   * Return indices of two numbers that add up to target, or {-1,-1} if none. Time: O(n), Space:
   * O(n)
   */
  public int[] solve(int[] nums, int target) {
    Map<Integer, Integer> idx = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int want = target - nums[i];
      if (idx.containsKey(want)) return new int[] {idx.get(want), i};
      idx.put(nums[i], i);
    }
    return new int[] {-1, -1};
  }

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> indexLookup = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      indexLookup.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (indexLookup.containsKey(complement) && indexLookup.get(complement) != i) {
        return new int[] {i, indexLookup.get(complement)};
      }
    }
    return new int[] {};
  }
}
