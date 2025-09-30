package com.ericchan.interview.algo.dfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class SubtreeOfTree {
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

  /**
   *
   Break it into 2 tiny jobs
   Job A: Walk through root looking for a match start
   At every node in root, ask: “If I start here, does the whole subtree look exactly like subRoot?”
    If yes → return true.
    If no → try the left child, then the right child.
   This is just a traversal (DFS) over root.

   Job B: Check two trees are identical (structure + values)
   Given two nodes a and b, they are the same tree iff:
    both null → same
    one null, one not → different
    both non-null AND:
        a.val == b.val
        left subtrees identical
        right subtrees identical

   */
  public static boolean subtreeOfAnotherTree(Node<Integer> root, Node<Integer> subRoot) {
    // Empty tree is always a subtree
    if (subRoot == null) return true;
    // Non-empty subRoot cannot be in an empty root
    if (root == null) return false;

    // If trees match starting right here, we’re done
    if (equalTree(root, subRoot)) return true;

    // Otherwise, try starting from root’s left or right child
    return subtreeOfAnotherTree(root.left, subRoot)
      || subtreeOfAnotherTree(root.right, subRoot);
  }

  private static boolean equalTree(Node<Integer> a, Node<Integer> b) {
    if (a == null && b == null) return true;   // both empty → equal
    if (a == null || b == null) return false;  // shape differs
    if (!a.val.equals(b.val)) return false;    // values differ

    // structure+values must match on both sides
    return equalTree(a.left, b.left) && equalTree(a.right, b.right);
  }

  public static boolean isSameTree2(Node<Integer> root1, Node<Integer> root2) {
    // if both root 1 and root 2 are null, then they are the same
    if (root1 == null && root2 == null) return true;
    // if only one is null, then they are not the same
    if (root1 == null || root2 == null) return false;

    // both not null
    // tree are the same if the root valules are the same and they have the same left and right subtrees
    return root1.val == root2.val && isSameTree2(root1.left, root2.left) && isSameTree2(root1.right, root2.right);
  }

  public static boolean subtreeOfAnotherTree2(Node<Integer> root, Node<Integer> subRoot) {
    // if root is null, then a non-null subroot cannot be a subtree
    if (root == null) return false;

    // check if the two roots are same as is, or check if the left subtree is the same as subroot, or if the right subtree is the same as subroot
    return isSameTree2(root, subRoot) || subtreeOfAnotherTree2(root.left, subRoot) || subtreeOfAnotherTree2(root.right, subRoot);
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
    Node<Integer> subRoot = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
    scanner.close();
    boolean res = subtreeOfAnotherTree(root, subRoot);
    System.out.println(res);
  }
}
