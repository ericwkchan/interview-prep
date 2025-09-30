package com.ericchan.interview.algo.dfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ValidBst {
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

  public static boolean dfs(Node<Integer> node, int min, int max) {
    // empty tree is always a valid BST
    if (node == null) return true;
    // check if node value is in between min and max bounds
    // if not, then its not a valid BST
    if (!(node.val > min && node.val < max)) {
      return false;
    }
    // run DFS on both left and right. For left, the next max is node value. For right, the next min is node value.
    return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
  }

  public static boolean validBst(Node<Integer> root) {
    // do DFS with root and sentinel min max values
    return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
    boolean res = validBst(root);
    System.out.println(res);
  }
}
