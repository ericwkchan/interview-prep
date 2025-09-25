package com.ericchan.interview.algo.twopointers.prefixsum;

import java.util.*;

public class SubarraySumTarget {
  /**
   * Finds a subarray that sums to target and returns [start, endExclusive].
   * If none exists, returns [-1, -1].
   */
  public static int[] findSubarraySumIndices(List<Integer> arr, int target) {
    // TODO: Implement using prefix sum + hashmap

    List<Integer> prefixSums = new ArrayList<>();
    prefixSums.add(0);

    int sum = 0;

    for (int i : arr) {
      sum += i;
      prefixSums.add(sum);
    }

    HashMap<Integer, Integer> lastSeenMap = new HashMap<>();

    lastSeenMap.put(0,0);

    // prefix[right] - prefix[left] = target
    // prefix[right] = target + prefix [left]
    // prefix[right] - target = prefix [left] (need)
    // we know these ^             ^ check if we have seen this

    for (int right = 1; right <= arr.size(); right++) {
      // This is equation to get our complement based on our right pointer and target
      int need = prefixSums.get(right) - target;
      if (lastSeenMap.containsKey(need)) {
        return new int[]{lastSeenMap.get(need), right};
      }
      // this will put the earliest occurence only which matters
      // overwriting this with a regular put means you could miss
      // a valid shorter subarray
      lastSeenMap.putIfAbsent(prefixSums.get(right), right);
    }

    return new int[]{-1, -1};
  }

  public static List<Integer> thisCouldWorkToo(List<Integer> arr, int target) {
    HashMap<Integer, Integer> prefixSums = new HashMap<>();
    // prefix_sum 0 happens when we have an empty array
    prefixSums.put(0, 0);
    int curSum = 0;
    for (int i = 0; i < arr.size(); i++) {
      curSum += arr.get(i);
      int complement = curSum - target;
      if (prefixSums.containsKey(complement)) {
        return List.of(prefixSums.get(complement), i + 1);
      }
      prefixSums.put(curSum, i + 1);
    }
    return null;
  }

  public static int totalSubarraysSumTarget(List<Integer> arr, int target) {
    HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();
    // There is one way to have a prefix sum of 0 before we've started (i.e., the empty subarray).
    prefixSumFrequency.put(0,1);
    int currentSum = 0;
    int validSubarrays = 0;

    /**
     * Carry a running sum, and at each step ask: “Have I seen a sum that was exactly target smaller?”
     * If yes, each time I saw it, that’s a valid subarray. Then log today’s sum for the future.
     */

    /**
     * Tiny example
     * arr = [1, 2, 3], target = 3
     * Start: map {0:1} (before we start, sum=0 once).
     * See 1 → curSum=1, need -2 (not in map). Add {1:1}.
     * See 2 → curSum=3, need 0 (map[0]=1) → found 1 subarray ([1,2]). Add {3:1}.
     * See 3 → curSum=6, need 3 (map[3]=1) → found 1 subarray ([3]). Add {6:1}.
     *
     * Answer = 2 subarrays.
     */

    for (int i : arr) {
      currentSum += i;
      validSubarrays += prefixSumFrequency.getOrDefault(currentSum - target, 0);
      prefixSumFrequency.put(currentSum, prefixSumFrequency.getOrDefault(currentSum, 0) + 1);
    }

    return validSubarrays;
  }
}
