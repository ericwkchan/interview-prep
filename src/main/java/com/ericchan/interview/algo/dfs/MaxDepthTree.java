package com.ericchan.interview.algo.dfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class MaxDepthTree {
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

  public static int treeMaxDepth(Node<Integer> root) {
    // Base case: null subtree contributes -1 edges so a leaf ends up as 0
    if (root == null) return -1;
    int leftDepth = treeMaxDepth(root.left);
    int rightDepth = treeMaxDepth(root.right);

    // dfs = current node -> left -> right

    /**
     * The role of +1 in recursion
     * Every time you recurse down into children, you’re asking them:
     * “How deep are you?”
     * When you come back up to the parent, you have to remember:
     * “The path through me is one level deeper than my child’s.”
     * That’s what the +1 represents: the step (edge or node) from the parent to the child.
     */
    return 1 + Math.max(leftDepth, rightDepth);
  }

  /**
   Depth as edges

   Null node: there are no edges here at all. Returning -1 is the clean way to say “this doesn’t contribute an edge.”
   Leaf node: both children are null, so we calculate:
   1 + max(-1, -1) = 0
   → depth = 0 edges, which matches intuition (a leaf has no outgoing edge).
   Internal node: every step up adds +1 edge for the connection to the deeper child.

   ✅ This convention is consistent because it lets leaves naturally resolve to 0 edges.

   Depth as nodes

   Null node: there are no nodes → return 0.
   Leaf node: both children are null, so we calculate:
   1 + max(0, 0) = 1
   → depth = 1 node, which matches intuition (a leaf counts as one).
   Internal node: every step up adds +1 node (itself).

   ✅ This convention is consistent because it makes leaves naturally resolve to 1 node.

   Why -1 for edges, 0 for nodes?
   It’s all about how you want the base case to “bubble up”:
   With edges, leaves should end at 0 (so null must be -1).
   With nodes, leaves should end at 1 (so null must be 0).

   So your summary is exactly right:
   Edges → null = -1, leaf = 0.
   Nodes → null = 0, leaf = 1.
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
    Node<Integer> root = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
    scanner.close();
    int res = treeMaxDepth(root);
    System.out.println(res);
  }
}
