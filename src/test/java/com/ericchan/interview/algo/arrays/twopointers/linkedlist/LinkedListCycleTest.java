package com.ericchan.interview.algo.arrays.twopointers.linkedlist;

import com.ericchan.interview.algo.twopointers.linkedlist.LinkedListCycle;
import org.junit.jupiter.api.Test;
import com.ericchan.interview.algo.twopointers.linkedlist.LinkedListCycle.Node;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {

  // Helper: build a linear list from ints and return head
  private Node<Integer> build(int... vals) {
    if (vals.length == 0) return null;
    Node<Integer> head = new Node<>(vals[0]);
    Node<Integer> curr = head;
    for (int i = 1; i < vals.length; i++) {
      curr.next = new Node<>(vals[i]);
      curr = curr.next;
    }
    return head;
  }

  // Helper: get node at index (0-based)
  private <T> Node<T> at(Node<T> head, int idx) {
    Node<T> cur = head;
    while (idx-- > 0 && cur != null) cur = cur.next;
    return cur;
  }

  @Test
  void noCycle_simpleList_returnsFalse() {
    Node<Integer> head = build(1, 2, 3, 4);
    assertFalse(LinkedListCycle.hasCycle(head));
  }

  @Test
  void cycle_middleToEarlier_returnsTrue() {
    Node<Integer> head = build(3, 1, 4, 1, 5);
    // create cycle: tail -> node at index 1 (value 1)
    Node<Integer> tail = at(head, 4);
    tail.next = at(head, 1);
    assertTrue(LinkedListCycle.hasCycle(head));
  }

  @Test
  void singleNode_noCycle_returnsFalse() {
    Node<Integer> head = new Node<>(42);
    assertFalse(LinkedListCycle.hasCycle(head));
  }

  @Test
  void singleNode_selfCycle_returnsTrue() {
    Node<Integer> head = new Node<>(7);
    head.next = head; // self-loop
    assertTrue(LinkedListCycle.hasCycle(head));
  }

  @Test
  void twoNodes_cycle_returnsTrue() {
    Node<Integer> a = new Node<>(1);
    Node<Integer> b = new Node<>(2);
    a.next = b;
    b.next = a; // 2-node cycle
    assertTrue(LinkedListCycle.hasCycle(a));
  }

  @Test
  void emptyList_returnsFalse() {
    assertFalse(LinkedListCycle.hasCycle(null));
  }
}
