package com.ericchan.interview.algo.twopointers;

import java.util.Iterator;
import java.util.function.Function;

public class LinkedListMiddle {
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

  public static int middleOfLinkedList(Node<Integer> head) {
    Node<Integer> slow = head;
    Node<Integer> fast = head;
    int listLength = 0;

    if (head == null) {
      return 0;
    }

    if (head.next == null) {
      return head.val;
    }

    while(fast.next != null) {
      listLength++;
      fast = fast.next;
    }

    int count = 0;
    int middle = listLength / 2;
    if (listLength % 2 != 0 ) {
      middle = (listLength / 2) +  1;
    }
    while (count < middle) {
      count++;
      slow = slow.next;
      if (count == middle) {
        return slow.val;
      }
    }
    return 0;
  }

  public static int betterMiddleOfLinkedList(Node<Integer> head) {
    Node<Integer> slow = head;
    Node<Integer> fast = head;

    if (head == null) {
      return 0;
    }

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow.val;

    /**
     * Review: So my solution kind of sucked because I passed through two times and also made myself prone to
     * off by one errors. Even though in theory it could work because I'm counting the length of the list and
     * then traversing again but halving it to find the middle, it's not elegant. The better solution is to
     * use two pointers, a slow and fast. Slow moves 1 space and fast moves 2 space every check. This means
     * for k iterations
     * slow_index = k
     * fast_index = 2k
     * We check if current fast is not null and also check if the next one is not null. Then we move and reassign
     * 2 spaces for fast. Then move and reassign one space for slow.
     *
     */
  }
  
  public static <T> Node<T> buildList(Iterator<String> iter, Function<String, T> f) {
    if (!iter.hasNext()) return null;
    String val = iter.next();
    Node<T> next = buildList(iter, f);
    return new Node<T>(f.apply(val), next);
  }
}
