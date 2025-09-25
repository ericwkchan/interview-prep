package com.ericchan.interview.algo.twopointers.prefixsum;


import java.util.ArrayList;
import java.util.List;

public class ProductArrayExceptSelf {
  /**
   * Returns a list where ans[i] = product of all nums except nums[i].
   * Do it in O(n) time and without using division.
   */
  public static List<Integer> productExceptSelf(List<Integer> nums) {

    int n = nums.size();
    List<Integer> answer = new ArrayList<>(n);

    // initialize with 1s
    for (int i = 0; i < n; i++) {
      answer.add(1);
    }

    // build prefix products
    int prefix = 1;
    for (int i = 0; i < n; i++) {
      answer.set(i, prefix);
      prefix *= nums.get(i);
    }

    // multiply with suffix products
    int suffix = 1;
    for (int i = n - 1; i >= 0; i--) {
      answer.set(i, answer.get(i) * suffix);
      suffix *= nums.get(i);
    }

    /**
     * Algorithm Recap
     *
     * Build an array of prefix products:
     * prefix[i] = product of nums[0..i-1] (everything to the left of i).
     *
     * Build an array of suffix products:
     * suffix[i] = product of nums[i+1..end] (everything to the right of i).
     *
     * Combine them:
     * answer[i] = prefix[i] * suffix[i].
     *
     * Both prefix and suffix start with 1, since 1 is the neutral element for multiplication.
     *
     * Example
     *
     * nums = [1, 2, 3, 4]
     * prefix = [1, 1, 2, 6]
     * suffix = [24, 12, 4, 1]
     * answer = [24, 12, 8, 6]
     *
     * Why it works
     * First loop fills answer[i] with the product of everything to the left of i.
     * Second loop multiplies in the product of everything to the right of i.
     * Result: answer[i] = leftProduct * rightProduct.
     */

    return answer;
  }
}
