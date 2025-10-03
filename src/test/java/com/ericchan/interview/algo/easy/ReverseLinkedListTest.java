package com.ericchan.interview.algo.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

  // ---------- Helpers for building/inspecting lists ----------
  private static ReverseLinkedList.Node<Integer> build(int... vals) {
    ReverseLinkedList.Node<Integer> dummy = new ReverseLinkedList.Node<>(0);
    ReverseLinkedList.Node<Integer> tail = dummy;
    for (int v : vals) {
      tail.next = new ReverseLinkedList.Node<>(v);
      tail = tail.next;
    }
    return dummy.next;
  }

  private static int[] toArray(ReverseLinkedList.Node<Integer> head) {
    int len = 0;
    for (ReverseLinkedList.Node<Integer> p = head; p != null; p = p.next) len++;
    int[] out = new int[len];
    int i = 0;
    for (ReverseLinkedList.Node<Integer> p = head; p != null; p = p.next) out[i++] = p.val;
    return out;
  }

  // ---------- Tests ----------
  @Test
  @DisplayName("Empty list → null")
  void reverse_empty() {
    ReverseLinkedList.Node<Integer> head = null;
    ReverseLinkedList.Node<Integer> rev = ReverseLinkedList.reverseLinkedList(head);
    assertNull(rev);
  }

  @Test
  @DisplayName("Single node stays the same node")
  void reverse_single() {
    ReverseLinkedList.Node<Integer> head = build(7);
    ReverseLinkedList.Node<Integer> rev = ReverseLinkedList.reverseLinkedList(head);
    assertArrayEquals(new int[]{7}, toArray(rev));
    assertSame(head, rev);
    assertNull(rev.next);
  }

  @Test
  @DisplayName("Multiple nodes reverse correctly")
  void reverse_multiple() {
    ReverseLinkedList.Node<Integer> head = build(1, 2, 3, 4, 5);
    ReverseLinkedList.Node<Integer> rev = ReverseLinkedList.reverseLinkedList(head);
    assertArrayEquals(new int[]{5, 4, 3, 2, 1}, toArray(rev));
  }

  @Test
  @DisplayName("Handles negatives and duplicates")
  void reverse_negativesDuplicates() {
    ReverseLinkedList.Node<Integer> head = build(-1, -1, 0, 2, 2);
    ReverseLinkedList.Node<Integer> rev = ReverseLinkedList.reverseLinkedList(head);
    assertArrayEquals(new int[]{2, 2, 0, -1, -1}, toArray(rev));
  }

  @Test
  @DisplayName("In-place reversal reuses the same node objects (identity check)")
  void reverse_inPlaceIdentity() {
    ReverseLinkedList.Node<Integer> n1 = new ReverseLinkedList.Node<>(10);
    ReverseLinkedList.Node<Integer> n2 = new ReverseLinkedList.Node<>(20);
    ReverseLinkedList.Node<Integer> n3 = new ReverseLinkedList.Node<>(30);
    n1.next = n2; n2.next = n3;

    ReverseLinkedList.Node<Integer> rev = ReverseLinkedList.reverseLinkedList(n1);

    assertSame(n3, rev);
    assertSame(n2, rev.next);
    assertSame(n1, rev.next.next);
    assertNull(rev.next.next.next);
  }

  @Test
  @DisplayName("Double reverse returns the original sequence")
  void reverse_twice() {
    int[] data = {5, 6, 7, 8};
    ReverseLinkedList.Node<Integer> head = build(data);
    ReverseLinkedList.Node<Integer> once = ReverseLinkedList.reverseLinkedList(head);
    ReverseLinkedList.Node<Integer> twice = ReverseLinkedList.reverseLinkedList(once);
    assertArrayEquals(data, toArray(twice));
  }
}
