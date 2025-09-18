package com.ericchan.interview.algo.arrays.twopointers;

import com.ericchan.interview.algo.twopointers.LinkedListMiddle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class LinkedListMiddleTest {

  @Test
  void testOddLengthList() {
    LinkedListMiddle.Node<Integer> head =
      LinkedListMiddle.buildList(List.of("0", "1", "2", "3", "4").iterator(), Integer::parseInt);

    int result = LinkedListMiddle.middleOfLinkedList(head);

    assertEquals(2, result, "Middle of [0, 1, 2, 3, 4] should be 2");
  }

  @Test
  void testEvenLengthList() {
    LinkedListMiddle.Node<Integer> head =
      LinkedListMiddle.buildList(List.of("0", "1", "2", "3", "4", "5").iterator(), Integer::parseInt);

    int result = LinkedListMiddle.middleOfLinkedList(head);

    assertEquals(3, result, "Middle of [0, 1, 2, 3, 4, 5] should be 3 (second middle node)");
  }

  @Test
  void testSingleElementList() {
    LinkedListMiddle.Node<Integer> head =
      LinkedListMiddle.buildList(List.of("42").iterator(), Integer::parseInt);

    int result = LinkedListMiddle.middleOfLinkedList(head);

    assertEquals(42, result, "Middle of [42] should be 42");
  }

  @Test
  void testTwoElementList() {
    LinkedListMiddle.Node<Integer> head =
      LinkedListMiddle.buildList(List.of("10", "20").iterator(), Integer::parseInt);

    int result = LinkedListMiddle.middleOfLinkedList(head);

    assertEquals(20, result, "Middle of [10, 20] should be 20 (second middle node)");
  }

  @Test
  void testEmptyList() {
    LinkedListMiddle.Node<Integer> head = null;

    int result = LinkedListMiddle.middleOfLinkedList(head);

    assertEquals(0, result, "Empty list should return 0 or handle gracefully");
  }

  @Test
  void testSingleElementList2() {
    LinkedListMiddle.Node<Integer> head =
      LinkedListMiddle.buildList(List.of("42").iterator(), Integer::parseInt);

    int result = LinkedListMiddle.betterMiddleOfLinkedList(head);

    assertEquals(42, result, "Middle of [42] should be 42");
  }

  @Test
  void testTwoElementList2() {
    LinkedListMiddle.Node<Integer> head =
      LinkedListMiddle.buildList(List.of("10", "20").iterator(), Integer::parseInt);

    int result = LinkedListMiddle.betterMiddleOfLinkedList(head);

    assertEquals(20, result, "Middle of [10, 20] should be 20 (second middle node)");
  }

  @Test
  void testEmptyList2() {
    LinkedListMiddle.Node<Integer> head = null;

    int result = LinkedListMiddle.betterMiddleOfLinkedList(head);

    assertEquals(0, result, "Empty list should return 0 or handle gracefully");
  }
}

