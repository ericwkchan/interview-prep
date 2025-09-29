package com.ericchan.interview.algo.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {

  private List<String> serialize(InvertBinaryTree.Node<Integer> root) {
    ArrayList<String> res = new ArrayList<>();
    InvertBinaryTree.formatTree(root, res);
    return res;
  }

  @Test
  void testSimpleTree() {
    // Original tree:
    //     1
    //    / \
    //   2   3
    InvertBinaryTree.Node<Integer> root = InvertBinaryTree.buildTree(
      List.of("1", "2", "x", "x", "3", "x", "x").iterator(),
      Integer::parseInt
    );

    InvertBinaryTree.Node<Integer> inverted = InvertBinaryTree.invertBinaryTree(root);

    // Expected inverted tree:
    //     1
    //    / \
    //   3   2
    List<String> expected = List.of("1", "3", "x", "x", "2", "x", "x");
    assertEquals(expected, serialize(inverted));
  }

  @Test
  void testUnbalancedTree() {
    // Original tree:
    //     4
    //    /
    //   2
    //  /
    // 1
    InvertBinaryTree.Node<Integer> root = InvertBinaryTree.buildTree(
      List.of("4", "2", "1", "x", "x", "x", "x").iterator(),
      Integer::parseInt
    );

    InvertBinaryTree.Node<Integer> inverted = InvertBinaryTree.invertBinaryTree(root);

    // Expected inverted tree:
    //     4
    //      \
    //       2
    //        \
    //         1
    List<String> expected = List.of("4", "x", "2", "x", "1", "x", "x");
    assertEquals(expected, serialize(inverted));
  }

  @Test
  void testSingleNode() {
    InvertBinaryTree.Node<Integer> root = InvertBinaryTree.buildTree(
      List.of("5", "x", "x").iterator(),
      Integer::parseInt
    );

    InvertBinaryTree.Node<Integer> inverted = InvertBinaryTree.invertBinaryTree(root);

    // Expected: same single-node tree
    List<String> expected = List.of("5", "x", "x");
    assertEquals(expected, serialize(inverted));
  }

  @Test
  void testEmptyTree() {
    InvertBinaryTree.Node<Integer> root = null;

    InvertBinaryTree.Node<Integer> inverted = InvertBinaryTree.invertBinaryTree(root);

    // Expected: still null
    assertNull(inverted);
  }
}

