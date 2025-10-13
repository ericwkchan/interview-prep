package com.ericchan.interview.algo.medium;

import java.util.*;

public class TopKFrequentElements {

  // naive solution that is O(nlogn)
  public int[] topKFrequentWithSorting(int[] nums, int k) {
    // Step 1: Count frequencies
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    // Step 2: Convert to list of [num, freq] pairs
    List<int[]> items = new ArrayList<>(freq.size());
    for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
      items.add(new int[]{e.getKey(), e.getValue()});
    }

    // Step 3: Sort by frequency descending
    items.sort((a, b) -> Integer.compare(b[1], a[1]));

    // Step 4: Take top k
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = items.get(i)[0];
    }
    return result;
  }

  // O(n log k)
  public int[] topKFrequentWithMinHeap(int[] nums, int k) {
    // Step 1: Count frequencies
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    // Step 2: Create a min-heap (smallest frequency on top)
    PriorityQueue<int[]> heap = new PriorityQueue<>(
      (a, b) -> Integer.compare(a[1], b[1])
    );

    // Step 3: Add (num, freq) pairs and maintain heap size ≤ k
    for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
      heap.offer(new int[]{entry.getKey(), entry.getValue()});
      if (heap.size() > k) {
        heap.poll(); // remove smallest freq
      }
    }

    // Step 4: Extract results
    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      result[i] = heap.poll()[0];
    }
    return result;
  }

  // O(n)
  public int[] topKFrequent(int[] nums, int k) {
    // Step 1: Count frequencies
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      freq.put(num, freq.getOrDefault(num, 0) + 1);
    }

    // Step 2: Initialize buckets (index = frequency)
    List<Integer>[] buckets = new ArrayList[nums.length + 1];
    for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
      int f = e.getValue();
      if (buckets[f] == null) buckets[f] = new ArrayList<>();
      buckets[f].add(e.getKey());
    }

    // Step 3: Collect top k elements from highest freq down
    int[] result = new int[k];
    int idx = 0;
    for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
      if (buckets[i] != null) {
        for (int num : buckets[i]) {
          result[idx++] = num;
          if (idx == k) break;
        }
      }
    }
    return result;
  }
}
