package com.ericchan.interview.algo.twopointers.oppositedirection;

import java.util.ArrayList;
import java.util.List;

public class TwoSumSorted {
  public static List<Integer> twoSumSorted(List<Integer> nums, int target) {
    /**
     * My first intuition is to iterate until the index is > the target
     * But that doesn't work if we have negative numbers
     * What if we can go from the last index and the first index
     * If the sum of the left and right are greater than target, decrement right
     * If the sum of the left and right are smaller than target, decrement left
     * If right and left are equal then we didnt find a solution.
     */

    int left = 0;
    int right = nums.size() - 1;

    ArrayList<Integer> result = new ArrayList<>();

    while (left != right) {
      if (nums.get(left) + nums.get(right) == target) {
        result.add(left);
        result.add(right);
        return result;
      }
      if (nums.get(left) + nums.get(right) > target) {
        right--;
      }
      if (nums.get(left) +  nums.get(right) < target) {
        left ++;
      }
    }
    return result;
  }
}
