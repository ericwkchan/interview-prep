package com.ericchan.interview.algo.twopointers.linkedlist;


public class LinkedListCycle {
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

  /**
   * Returns true if the linked list starting at head contains a cycle.
   * Bonus: implement with O(1) extra space (Floyd's tortoise & hare).
   */
  public static <T> boolean hasCycle(Node<T> head) {
    if (head == null) return false;

    Node<T> left = head; //slow
    Node<T> right = head; //fast

    while (right != null && right.next != null) {
      left = left.next;
      right = right.next.next;
      if (right == left) {
        return true;
      }
    }

    /**
     * Initially, I wanted to have two pointers and move right one at a time and check against the
     * slow pointer. Which is good for checking if there's a cylce against the first node but not
     * a cycle in the middle. What we need to do is have a faster pointer for the floyd tortoise
     * and hare algorithm. Essentially, we just keep moving ahead faster with the fast pointer and
     * a cycle will mean that we will never hit null. Because a cycle means that somewhere along the
     * linked list we will point back to an older node. If there are no cycle, we will eventually hit
     * null. It's also possible to meet and detect the cycle inside the cycle and thats okay. Still O(N)
     */
    return false;
  }
}
