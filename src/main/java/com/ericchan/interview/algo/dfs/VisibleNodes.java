package com.ericchan.interview.algo.dfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class VisibleNodes {
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

  public static int visibleTreeNode(Node<Integer> root) {
    return dfsVisible(root, Integer.MIN_VALUE);
  }

  public static int dfsVisible(Node<Integer> node, int maxSoFar) {
    //base case
    if (node == null) {
      return 0;
    }
    int visibleNodes = 0;

    // this is essentially preorder traversal. check current node, and then left and then right

    if (node.val >= maxSoFar) {
      visibleNodes++;
    }

    int nextMax = Math.max(maxSoFar, node.val);

    visibleNodes += dfsVisible(node.left, nextMax);
    visibleNodes += dfsVisible(node.right, nextMax);
    return visibleNodes;
  }

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
    Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
    scanner.close();
    int res = visibleTreeNode(root);
    System.out.println(res);
  }

  /*
  🔑 1. Always identify what state needs to be carried down the recursion
In this problem, visibility isn’t just about the current node — it depends on the maximum value seen on the path from root to this node.
That means you must pass maxSoFar down into recursive calls.
General tip: If a condition depends on the path, you usually need to pass extra state (like max, min, or sum) along the recursion.

🔑 2. Base cases should return neutral values

Here, null means no node, so return 0 visible nodes.
General tip: Always ask yourself “what’s the neutral/empty contribution at the base case?”

For sums, return 0.
For products, return 1.
For max, return -∞.

🔑 3. Count this node + recurse into children

Typical recursive pattern looks like:

int count = condition ? 1 : 0;
count += recurse(left);
count += recurse(right);
return count;


That’s the bread and butter of tree DFS problems.

🔑 4. Update your state before passing it down

You must compute nextMax = Math.max(maxSoFar, node.val) and use it when recursing.
Forgetting this is a common bug: you’re effectively freezing the state instead of updating it.

🔑 5. Time and space complexity

Time: O(n) because each node is visited once.
Space: O(h) where h is the tree height (recursion stack).

Worst case: skewed tree → O(n).

Balanced tree: O(log n).

🧠 Mental template

When you see “nodes are visible / valid / countable if … based on path/root”, think:
DFS with extra state parameter.
Update state at each node.
Count current node if condition is met.
Sum over children.

⚡ Quick tips for interviews

Clarify whether “visible” depends on strict > or >=.
Clarify if negative values are allowed (so you can start maxSoFar = -∞ properly).
Start with a brute force mental model:
"Path to each node = list → check max."
Then realize you can just pass the max instead of recalculating.
Small examples (increasing path, decreasing path) are great to test logic.

  */

  /**
   * Ramblings: So I know that a visible node is classified as such when root to that specific node has no values
   * that are greater than that node. basically that node has to the largest in the path from root. If i were to
   * define a base case, then if the node is null, then we should return 0. aka - 0 visible nodes returned. we need
   * to traverse the tree and determine for each node whether or not the node is visible. so we need to keep passing
   * down a max value. and update that max value. if the current node's value is greater or equal to that passed down
   * max value, we're going to determine that this current node is a visible node and increment by 1. then naturally
   * we will have to update the new max along this path and check who is greater between the path current max or the
   * current node's max. this will be passed to the next check in recursion. in order to get the visible nodes
   * along a tree, we need to check if the current node is a visible node or not and then check its left and right nodes.
   * we are returning the number of visible nodes call and each call will be incrementing the return value of the number of nodes.
   */
}
