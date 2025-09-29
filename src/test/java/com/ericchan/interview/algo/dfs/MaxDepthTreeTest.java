package com.ericchan.interview.algo.dfs;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class MaxDepthTreeTest {

  /** Convenience: build a tree from a single-line serialized string. */
  private static MaxDepthTree.Node<Integer> build(String ser) {
    return MaxDepthTree.buildTree(
      MaxDepthTree.splitWords(ser).iterator(),
      Integer::parseInt
    );
  }

  @Test
  void singleNode_depthZeroEdges() {
    // Tree: 1
    // Encoding: 1 x x
    MaxDepthTree.Node<Integer> root = build("1 x x");
    assertEquals(0, MaxDepthTree.treeMaxDepth(root));
  }

  @Test
  void twoLevels_depthOneEdge() {
    //    1
    //   / \
    //  2   3
    // Encoding: 1 2 x x 3 x x
    MaxDepthTree.Node<Integer> root = build("1 2 x x 3 x x");
    assertEquals(1, MaxDepthTree.treeMaxDepth(root));
  }

  @Test
  void mixedTree_depthTwoEdges() {
    //        1
    //       / \
    //      2   3
    //         /
    //        4
    // Longest path: 1-3-4 (2 edges)
    // Encoding: 1 2 x x 3 4 x x x
    MaxDepthTree.Node<Integer> root = build("1 2 x x 3 4 x x x");
    assertEquals(2, MaxDepthTree.treeMaxDepth(root));
  }

  @Test
  void leftSkewed_depthThreeEdges() {
    // 1-2-3-4 (chain left)
    // Encoding: 1 2 3 4 x x x x x
    MaxDepthTree.Node<Integer> root = build("1 2 3 4 x x x x x");
    assertEquals(3, MaxDepthTree.treeMaxDepth(root));
  }

  @Test
  void rightSkewed_depthThreeEdges() {
    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    // Encoding: 1 x 2 x 3 x 4 x x
    MaxDepthTree.Node<Integer> root = build("1 x 2 x 3 x 4 x x");
    assertEquals(3, MaxDepthTree.treeMaxDepth(root));
  }

  @Test
  void unbalanced_depthThreeEdges() {
    //        10
    //       /  \
    //      5    20
    //     /       \
    //    1         30
    //                \
    //                 40
    // Longest path: 10-20-30-40 (3 edges)
    // Encoding: 10 5 1 x x x 20 x 30 x 40 x x
    MaxDepthTree.Node<Integer> root = build("10 5 1 x x x 20 x 30 x 40 x x");
    assertEquals(3, MaxDepthTree.treeMaxDepth(root));
  }

  // Note: If you decide an empty tree should return -1 (edges definition),
  // you can add this test after implementing accordingly:
  // @Test
  // void emptyTree_edgesConventionMinusOne() {
  //     assertEquals(-1, Solution.treeMaxDepth(null));
  // }
}

