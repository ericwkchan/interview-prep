package com.ericchan.interview.realproblems.pinterest;

import java.util.*;

public class DeleteNodeInForest {

  /**
   * Problem: Delete a Node and Its Subtree from a Forest
   * You are given an integer array parent of length n representing a forest of trees (possibly multiple roots).
   * Each node is labeled from 0 to n − 1.
   * For each node i:
   * parent[i] is the index of its parent.
   * A node i is a root if parent[i] == i.
   * The invariant parent[i] ≤ i always holds (a node’s parent appears before it in the array).
   * The forest may contain multiple disjoint trees.
   * You are also given an integer target, representing a node you must delete, along with all of its descendants.
   * When a node is deleted, set its corresponding value in parent[] to -1.
   * Perform the deletion in place (mutate the input array directly) and return the resulting parent array.
   *
   * Example 1
   *
   * Input:
   * parent = [0, 0, 1, 1, 3, 5], target = 1
   *
   * Output:
   * [0, -1, -1, -1, -1, 5]
   *
   * Explanation:
   * The forest has two roots (0 and 5).
   * Deleting node 1 removes nodes 1, 2, 3, 4, which belong to its subtree.
   *
   * Example 2
   *
   * Input:
   * parent = [0, 0, 1, 1, 3], target = 0
   *
   * Output:
   * [-1, -1, -1, -1, -1]
   *
   * Explanation:
   * Deleting root 0 removes the entire tree.
   */


  /**
   * In-place delete of target and all descendants in a parent-array forest.
   * Representation:
   *   - nodes: 0..n-1
   *   - parent[i] <= i
   *   - root: parent[i] == i
   *   - deleted: parent[i] == -1
   *
   * Time:  O(n)
   * Space: O(1) extra
   */
  public static void deleteSubtreeInPlace(int[] parent, int target) {
    int n = parent.length;

    // 1) delete the target itself (works even if target is a root)
    parent[target] = -1;

    // 2) propagate deletion forward in one pass
    for (int i = target + 1; i < n; i++) {
      int p = parent[i];

      // Skip already-deleted and roots (roots have parent[i] == i)
      if (p == -1 || p == i) continue;

      // If my parent is deleted (parent[p] == -1), I am deleted too.
      if (parent[p] == -1) {
        parent[i] = -1;
      }
    }
  }

  // quick demo
  public static void main(String[] args) {
    int[] a = {0, 0, 1, 1, 3, 5};   // roots: 0 and 5
    deleteSubtreeInPlace(a, 1);     // delete node 1 and its subtree
    System.out.println(Arrays.toString(a)); // [0, -1, -1, -1, -1, 5]

    int[] b = {0, 0, 1, 1, 3};
    deleteSubtreeInPlace(b, 0);     // delete root 0 and its subtree
    System.out.println(Arrays.toString(b)); // [-1, -1, -1, -1, -1]
  }
}
