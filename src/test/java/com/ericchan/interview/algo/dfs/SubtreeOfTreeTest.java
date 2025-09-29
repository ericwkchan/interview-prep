package com.ericchan.interview.algo.dfs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubtreeOfTreeTest {

  @Test
  void testSubtreeExists() {
    // root:    3
    //        /   \
    //       4     5
    //      / \
    //     1   2
    //
    // subRoot:  4
    //          / \
    //         1   2

    SubtreeOfTree.Node<Integer> root = SubtreeOfTree.buildTree(
      List.of("3", "4", "1", "x", "x", "2", "x", "x", "5", "x", "x").iterator(),
      Integer::parseInt
    );
    SubtreeOfTree.Node<Integer> subRoot = SubtreeOfTree.buildTree(
      List.of("4", "1", "x", "x", "2", "x", "x").iterator(),
      Integer::parseInt
    );

    assertTrue(SubtreeOfTree.subtreeOfAnotherTree(root, subRoot));
  }

  @Test
  void testSubtreeNotExists() {
    // root:    3
    //        /   \
    //       4     5
    //      / \
    //     1   2
    //
    // subRoot:  4
    //          / \
    //         1   3   (different structure/values)

    SubtreeOfTree.Node<Integer> root = SubtreeOfTree.buildTree(
      List.of("3", "4", "1", "x", "x", "2", "x", "x", "5", "x", "x").iterator(),
      Integer::parseInt
    );
    SubtreeOfTree.Node<Integer> subRoot = SubtreeOfTree.buildTree(
      List.of("4", "1", "x", "x", "3", "x", "x").iterator(),
      Integer::parseInt
    );

    assertFalse(SubtreeOfTree.subtreeOfAnotherTree(root, subRoot));
  }

  @Test
  void testSubtreeSameAsRoot() {
    // root and subRoot are identical single-node tree: [1]

    SubtreeOfTree.Node<Integer> root = SubtreeOfTree.buildTree(
      List.of("1", "x", "x").iterator(),
      Integer::parseInt
    );
    SubtreeOfTree.Node<Integer> subRoot = SubtreeOfTree.buildTree(
      List.of("1", "x", "x").iterator(),
      Integer::parseInt
    );

    assertTrue(SubtreeOfTree.subtreeOfAnotherTree(root, subRoot));
  }

  @Test
  void testEmptySubtree() {
    // root: [1], subRoot: null
    SubtreeOfTree.Node<Integer> root = SubtreeOfTree.buildTree(
      List.of("1", "x", "x").iterator(),
      Integer::parseInt
    );

    assertTrue(SubtreeOfTree.subtreeOfAnotherTree(root, null)); // empty tree is always a subtree
  }

  @Test
  void testEmptyRoot() {
    // root: null, subRoot: [1]
    SubtreeOfTree.Node<Integer> subRoot = SubtreeOfTree.buildTree(
      List.of("1", "x", "x").iterator(),
      Integer::parseInt
    );

    assertFalse(SubtreeOfTree.subtreeOfAnotherTree(null, subRoot));
  }
}
