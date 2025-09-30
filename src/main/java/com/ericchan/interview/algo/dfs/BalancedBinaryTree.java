package com.ericchan.interview.algo.dfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class BalancedBinaryTree {
  public static class Node<T> {
    public T val;
    public Node<T> left;
    public Node<T> right;

    public Node(T val) {
      this(val, null, null);
    }

    public Node(T val, Node<T> left, Node<T> right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static boolean isBalanced(Node<Integer> root) {
    return heightOrUnbalanced(root) != -1;
  }

  public static int heightOrUnbalanced(Node<Integer> node) {

    if (node == null) return 0; // height = nodes from root to leaf -> empty subtree = 0

    int leftHeight = heightOrUnbalanced(node.left);
    if (leftHeight == -1) return -1;

    int rightHeight = heightOrUnbalanced(node.right);
    if (rightHeight == -1) return -1;

    if (Math.abs(leftHeight - rightHeight) > 1) return -1;

    // My height is 1 + the higher height of my two subtrees
    return 1 + Math.max(leftHeight, rightHeight);
  }

  public static boolean roundTwo(Node<Integer> root) {
    return dfsHeight(root) != -1;
  }

  public static int dfsHeight(Node<Integer> node) {
    //base case
    if (node == null) {
      return 0;
    }

    int leftHeight = dfsHeight(node.left);
    // checking for -1 for left and right height is basically saying
    // if we are imbalanced at any point in the left or right subtree
    // deem the whole tree unbalanced
    if (leftHeight == -1) {
      return -1;
    }

    int rightHeight = dfsHeight(node.right);
    if (rightHeight == -1) {
      return -1;
    }

    // imbalanced check
    // if the height between the two trees is more than 1 -> imbalanced
    if (Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    }

    // we are returning the max height of each tree and adding 1 to find the height of the current node passed
    return 1 + Math.max(leftHeight, rightHeight);
  }

  /**
   🧠 Recursive Function Checklist

   1. Clarify the return value
   Ask: “What do I want this function to return for any given node?”
   Example: In the height problem → return the height of the subtree rooted at this node.

  2. Define the base case(s)
   What happens for the simplest input? (e.g., null, empty array, leaf)
   Example: If node == null, return 0 (if height in nodes).

   3. Write recursive calls
   Assume the recursive function already works for children.
   Don’t overthink how it gets computed; trust recursion.
   Example: int left = height(node.left); int right = height(node.right);

   4. Combine child results
   How do child answers build the parent’s answer?
   This is where Math.max(...) + 1 comes in for height.
   Or sum(left,right), min(left,right), boolean and/or, etc.

   5. Handle extra logic (constraints/early exits)
   Balance check, cycle detection, pruning, etc.
   Example: If difference > 1, return sentinel -1.

   6. Return the final result
   Return exactly what you defined in step 1.
   */

  // this function builds a tree from input; you don't have to modify it
  // learn more about how trees are encoded in https://algo.monster/problems/serializing_tree
  public static <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
    String val = iter.next();
    if (val.equals("x")) return null;
    Node<T> left = buildTree(iter, f);
    Node<T> right = buildTree(iter, f);
    return new Node<T>(f.apply(val), left, right);
  }

  public static List<String> splitWords(String s) {
    return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Node<Integer> tree = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
    scanner.close();
    boolean res = isBalanced(tree);
    System.out.println(res);
  }
}
