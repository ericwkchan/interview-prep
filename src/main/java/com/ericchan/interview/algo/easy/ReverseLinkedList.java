package com.ericchan.interview.algo.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ReverseLinkedList {
  public static class Node<T> {
    public T val;
    public Node<T> next;

    public Node(T val) {
      this(val, null);
    }

    public Node(T val, Node<T> next) {
      this.val = val;
      this.next = next;
    }
  }

  public static Node<Integer> reverseLinkedList(Node<Integer> head) {
    Node<Integer> previous = null;
    Node<Integer> current = head;

    while (current != null) {
      Node<Integer> nextNode = current.next; // step 1: store current's next
      current.next = previous; // step 2: reverse link
      previous = current; // step 3: move prev forward
      current = nextNode; // step 4: move curr forward

    }
    return previous; // previous is the head
  }

  public static <T> Node<T> buildList(Iterator<String> iter, Function<String, T> f) {
    if (!iter.hasNext()) return null;
    String val = iter.next();
    Node<T> next = buildList(iter, f);
    return new Node<T>(f.apply(val), next);
  }

  public static List<String> splitWords(String s) {
    return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
  }

  public static <T> void formatList(Node<T> node, List<String> out) {
    if (node == null) return;
    out.add(node.val.toString());
    formatList(node.next, out);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Node<Integer> head = buildList(splitWords(scanner.nextLine()).iterator(), Integer::parseInt);
    scanner.close();
    Node<Integer> res = reverseLinkedList(head);
    ArrayList<String> resArr = new ArrayList<>();
    formatList(res, resArr);
    System.out.println(String.join(" ", resArr));
  }
}
