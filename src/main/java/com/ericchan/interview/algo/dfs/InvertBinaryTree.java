package com.ericchan.interview.algo.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class InvertBinaryTree {
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

  public static Node<Integer> invertBinaryTree(Node<Integer> tree) {
    if (tree == null) {
      return null;
    }
    return new Node<>(tree.val, invertBinaryTree(tree.right), invertBinaryTree(tree.left));
  }

  public static Node<Integer> invertBinaryTreeAlt(Node<Integer> tree) {
    if (tree == null) {
      return null; // base case
    }

    // swap left and right children
    Node<Integer> temp = tree.left;
    tree.left = tree.right;
    tree.right = temp;

    // invert the subtrees
    invertBinaryTree(tree.left);
    invertBinaryTree(tree.right);

    return tree; // return the root of the inverted subtree
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
    Node<Integer> tree = buildTree(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
    scanner.close();
    Node<Integer> res = invertBinaryTree(tree);
    ArrayList<String> resArr = new ArrayList<>();
    formatTree(res, resArr);
    System.out.println(String.join(" ", resArr));
  }
}
