package com.ericchan.interview.algo.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class InsertIntoBST {
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

  public static Node<Integer> insertBst(Node<Integer> root, int val) {
    if (root == null) return new Node<>(val);     // found leaf spot
    if (val < root.val) {
      root.left = insertBst(root.left, val);
    } else if (val > root.val) {
      root.right = insertBst(root.right, val);
    }
    // if equal, do nothing (no duplicates)
    return root;
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

  public static <T> void formatTree(Node<T> node, List<String> out) {
    if (node == null) {
      out.add("x");
      return;
    }
    out.add(node.val.toString());
    formatTree(node.left, out);
    formatTree(node.right, out);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Node<Integer> bst = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
    int val = Integer.parseInt(scanner.nextLine());
    scanner.close();
    Node<Integer> res = insertBst(bst, val);
    ArrayList<String> resArr = new ArrayList<>();
    formatTree(res, resArr);
    System.out.println(String.join(" ", resArr));
  }
}
