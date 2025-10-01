package com.ericchan.interview.algo.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class BinaryTreeLevelOrder {
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
  // algorithm: add node to queue to start
  // loop over queue size, pop it, add popped nodes children left and right to queue

  public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
    queue.add(root); // at least one element in the queue to kick start bfs
    while (queue.size() > 0) { // as long as there is element in the queue
      int n = queue.size();
      List<Integer> newLevel = new ArrayList<>();
      // dequeue each node in the current level
      for (int i = 0; i < n; i++) {
        Node<Integer> node = queue.pop();
        newLevel.add(node.val);
        // enqueue non-null children
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      res.add(newLevel);
    }

    return res;
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
    List<List<Integer>> res = levelOrderTraversal(root);
    for (List<Integer> row : res) {
      System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
  }
}
