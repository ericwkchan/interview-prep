package com.ericchan.interview.algo.twopointers.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class PrefixSumConcept {

  public static List<Integer> prefixSum(List<Integer> nums) {
    int sum = 0;
    List<Integer> prefixSums = new ArrayList<>();
    for (int i = 0; i < nums.size(); i++) {
      sum += nums.get(i);
      prefixSums.add(sum);
    }
    return prefixSums;
  }

  public static List<Integer> prefixSumAlternate(List<Integer> nums) {
    List<Integer> prefix = new ArrayList<>();
    prefix.add(0); // base case

    int sum = 0;
    for (int x : nums) {
      sum += x;
      prefix.add(sum);
    }
    return prefix;
  }
}
