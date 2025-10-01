package com.ericchan.interview.algo.bfs;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeLevelOrderTest {

  @Test
  void testBalancedTree() {
    // Tree:
    //       3
    //     /   \
    //    9    20
    //        /  \
    //       15   7
    BinaryTreeLevelOrder.Node<Integer> root =
      new BinaryTreeLevelOrder.Node<>(3,
        new BinaryTreeLevelOrder.Node<>(9),
        new BinaryTreeLevelOrder.Node<>(20,
          new BinaryTreeLevelOrder.Node<>(15),
          new BinaryTreeLevelOrder.Node<>(7)));

    List<List<Integer>> expected = Arrays.asList(
      Arrays.asList(3),
      Arrays.asList(9, 20),
      Arrays.asList(15, 7)
    );

    assertEquals(expected, BinaryTreeLevelOrder.levelOrderTraversal(root));
  }

  @Test
  void testLeftSkewedTree() {
    // Tree:
    //    1
    //   /
    //  2
    // /
    //3
    BinaryTreeLevelOrder.Node<Integer> root =
      new BinaryTreeLevelOrder.Node<>(1,
        new BinaryTreeLevelOrder.Node<>(2,
          new BinaryTreeLevelOrder.Node<>(3),
          null),
        null);

    List<List<Integer>> expected = Arrays.asList(
      Collections.singletonList(1),
      Collections.singletonList(2),
      Collections.singletonList(3)
    );

    assertEquals(expected, BinaryTreeLevelOrder.levelOrderTraversal(root));
  }

  @Test
  void testRightSkewedTree() {
    // Tree:
    // 1
    //  \
    //   2
    //    \
    //     3
    BinaryTreeLevelOrder.Node<Integer> root =
      new BinaryTreeLevelOrder.Node<>(1,
        null,
        new BinaryTreeLevelOrder.Node<>(2,
          null,
          new BinaryTreeLevelOrder.Node<>(3)));

    List<List<Integer>> expected = Arrays.asList(
      Collections.singletonList(1),
      Collections.singletonList(2),
      Collections.singletonList(3)
    );

    assertEquals(expected, BinaryTreeLevelOrder.levelOrderTraversal(root));
  }

  @Test
  void testSingleNodeTree() {
    BinaryTreeLevelOrder.Node<Integer> root = new BinaryTreeLevelOrder.Node<>(42);

    List<List<Integer>> expected = Collections.singletonList(
      Collections.singletonList(42)
    );

    assertEquals(expected, BinaryTreeLevelOrder.levelOrderTraversal(root));
  }

  @Test
  void testEmptyTree() {
    assertEquals(Collections.emptyList(), BinaryTreeLevelOrder.levelOrderTraversal(null));
  }
}
