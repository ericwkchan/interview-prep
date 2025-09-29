package com.ericchan.interview.algo.dfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VisibleNodesTest {

  /** Helper: build tree from a serialized string. */
  private static VisibleNodes.Node<Integer> build(String ser) {
    return VisibleNodes.buildTree(VisibleNodes.splitWords(ser).iterator(), Integer::parseInt);
  }

  @Test
  void singleNode_visible() {
    // Tree: 5
    // Encoding: 5 x x
    VisibleNodes.Node<Integer> root = build("5 x x");
    assertEquals(1, VisibleNodes.visibleTreeNode(root));
  }

  @Test
  void increasingChain_allVisible() {
    // Tree:
    //   1
    //    \
    //     2
    //      \
    //       3
    // Encoding: 1 x 2 x 3 x x
    VisibleNodes.Node<Integer> root = build("1 x 2 x 3 x x");
    assertEquals(3, VisibleNodes.visibleTreeNode(root));
  }

  @Test
  void decreasingChain_onlyRootVisible() {
    // Tree:
    //   5
    //    \
    //     4
    //      \
    //       2
    // Encoding: 5 x 4 x 2 x x
    VisibleNodes.Node<Integer> root = build("5 x 4 x 2 x x");
    assertEquals(1, VisibleNodes.visibleTreeNode(root));
  }

  @Test
  void mixedTree_someVisible() {
    // Tree:
    //       5
    //      / \
    //     3   10
    //    /   /  \
    //   4   7    15
    //
    // Visible: 5 (root), 10 (greater than 5), 15 (greater than 10)
    //          3 is NOT visible (blocked by 5), 4 is NOT visible (blocked by 5)
    //          7 is NOT visible (blocked by 10)
    //
    // Encoding: 5 3 4 x x x 10 7 x x 15 x x
    VisibleNodes.Node<Integer> root = build("5 3 4 x x x 10 7 x x 15 x x");
    assertEquals(3, VisibleNodes.visibleTreeNode(root));
  }

  @Test
  void balancedTree_leftVisibleRightVisible() {
    // Tree:
    //       4
    //      / \
    //     2   6
    //    /   / \
    //   1   5   7
    //
    // Visible: 4, 6, 7
    // 2 is NOT (blocked by 4), 1 is NOT (blocked by 4),
    // 5 is NOT (blocked by 6).
    //
    // Encoding: 4 2 1 x x x 6 5 x x 7 x x
    VisibleNodes.Node<Integer> root = build("4 2 1 x x x 6 5 x x 7 x x");
    assertEquals(3, VisibleNodes.visibleTreeNode(root));
  }

  @Test
  void nullTree_zeroVisible() {
    VisibleNodes.Node<Integer> root = null;
    assertEquals(0, VisibleNodes.visibleTreeNode(root));
  }
}
