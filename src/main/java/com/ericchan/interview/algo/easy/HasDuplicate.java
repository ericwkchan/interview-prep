package com.ericchan.interview.algo.easy;

import java.util.HashSet;

public class HasDuplicate {
  public boolean hasDuplicate(int[] nums) {
    HashSet<Integer> dupeCheck = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!dupeCheck.contains(nums[i])) {
        dupeCheck.add(nums[i]);
      } else {
        return true;
      }
    }
    return false;
  }
}
