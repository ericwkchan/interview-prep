package com.ericchan.interview.algo.dfs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class BalancedBinaryTreeTest {

  /** Helper: build a tree from serialized preorder string using the provided utilities. */
  private static BalancedBinaryTree.Node<Integer> build(String ser) {
    return BalancedBinaryTree.buildTree(BalancedBinaryTree.splitWords(ser).iterator(), Integer::parseInt);
  }

  @Test
  void emptyTree_isBalanced() {
    assertTrue(BalancedBinaryTree.isBalanced(null));
  }

  @Test
  void singleNode_isBalanced() {
    BalancedBinaryTree.Node<Integer> root = build("1 x x");
    assertTrue(BalancedBinaryTree.isBalanced(root));
  }

  @Test
  void perfectBalanced_isBalanced() {
    //      1
    //     / \
    //    2   3
    //   / \ / \
    //  4  5 6  7
    // Encoding: 1 2 4 x x 5 x x 3 6 x x 7 x x
    BalancedBinaryTree.Node<Integer> root = build("1 2 4 x x 5 x x 3 6 x x 7 x x");
    assertTrue(BalancedBinaryTree.isBalanced(root));
  }

  @Test
  void completeBalanced_isBalanced() {
    //      10
    //     /  \
    //    5    15
    //   / \     \
    //  2   7     20
    // Heights differ by at most 1 at every node.
    // Encoding: 10 5 2 x x 7 x x 15 x 20 x x
    BalancedBinaryTree.Node<Integer> root = build("10 5 2 x x 7 x x 15 x 20 x x");
    assertTrue(BalancedBinaryTree.isBalanced(root));
  }

  @Test
  void leftHeavy_unbalanced() {
    // Skewed left:
    // 1
    // |
    // 2
    // |
    // 3
    // |
    // 4
    // Any node along the chain has left-right height diff > 1.
    // Encoding: 1 2 3 4 x x x x x
    BalancedBinaryTree.Node<Integer> root = build("1 2 3 4 x x x x x");
    assertFalse(BalancedBinaryTree.isBalanced(root));
  }

  @Test
  void rightHeavy_unbalanced() {
    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    // Encoding: 1 x 2 x 3 x 4 x x
    BalancedBinaryTree.Node<Integer> root = build("1 x 2 x 3 x 4 x x");
    assertFalse(BalancedBinaryTree.isBalanced(root));
  }

  @Test
  void subtleUnbalanced_deepInside() {
    //        8
    //       / \
    //      4   12
    //     / \
    //    2   6
    //   /
    //  1
    // /
    //0
    // Node 4 has left height 3 (4-2-1-0) and right height 1 (4-6), diff = 2 -> unbalanced.
    // Encoding: 8 4 2 1 0 x x x x 6 x x 12 x x
    BalancedBinaryTree.Node<Integer> root = build("8 4 2 1 0 x x x x 6 x x 12 x x");
    assertFalse(BalancedBinaryTree.isBalanced(root));
  }

  @Test
  void boundaryBalanced_diffExactlyOne_ok() {
    //        5
    //       / \
    //      3   9
    //     /
    //    2
    //   /
    //  1
    // Left subtree height (edges) = 2 (3-2-1), right subtree height = 0 (just 9).
    // Root diff = 2? Wait: careful — heights measured from each node:
    //   - At node 3: left=2 (3-2-1), right=-1 (null), diff=3 -> that would be unbalanced.
    // Let's adjust to be exactly balanced at every node:
    //
    //        5
    //       / \
    //      3   9
    //     /   /
    //    2   8
    //   /
    //  1
    //
    // Now:
    //  - At 3: left=2 (3-2-1), right=-1 => diff=3 -> still too big. Let's tweak:
    //
    // Final balanced example with diffs ≤ 1 everywhere:
    //        5
    //       / \
    //      3   9
    //     /   / \
    //    2   8  10
    //   /
    //  1
    //
    // Heights:
    // - Node 2: left=1 (2-1), right=-1 -> diff=2? That's too big.
    // One more tweak to keep all diffs ≤ 1:
    //
    //        5
    //       / \
    //      3   9
    //     / \   \
    //    2   4   10
    //   /
    //  1
    //
    // Now:
    //  - Node 2: left=1 (2-1), right=-1 -> diff=2 (still too big). Let's give 2 a right child to balance:
    //
    //        5
    //       / \
    //      3   9
    //     / \   \
    //    2   4   10
    //   / \
    //  1   2
    //
    // To keep integers simple, let's choose a clean known-balanced tree instead:
    //
    //        4
    //       / \
    //      2   6
    //     / \   \
    //    1   3   7
    //
    // Heights at every node differ by ≤ 1.
    // Encoding: 4 2 1 x x 3 x x 6 x 7 x x
    BalancedBinaryTree.Node<Integer> root = build("4 2 1 x x 3 x x 6 x 7 x x");
    assertTrue(BalancedBinaryTree.isBalanced(root));
  }
}
