package com.ericchan.interview.algo.dfs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class LowestCommonAncestor {
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

  public static int lcaOnBst(Node<Integer> bst, int p, int q) {
    if (bst.val > p && bst.val > q) {
      return lcaOnBst(bst.left, p, q);
    } else if (bst.val < p && bst.val < q) {
      return lcaOnBst(bst.right, p, q);
    } else {
      return bst.val;
    }
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
    Node<Integer> bst = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
    int p = Integer.parseInt(scanner.nextLine());
    int q = Integer.parseInt(scanner.nextLine());
    scanner.close();
    int res = lcaOnBst(bst, p, q);
    System.out.println(res);
  }
}
