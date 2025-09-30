package com.ericchan.interview.algo.dfs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidBstTest {

  // alias to shorten references
  private static class N extends ValidBst.Node<Integer> {
    N(Integer v) { super(v); }
    N(Integer v, ValidBst.Node<Integer> l, ValidBst.Node<Integer> r) { super(v, l, r); }
  }

  @Test
  @DisplayName("Empty tree is valid")
  void emptyTree() {
    assertTrue(ValidBst.validBst(null));
  }

  @Test
  @DisplayName("Single node is valid")
  void singleNode() {
    ValidBst.Node<Integer> root = new N(10);
    assertTrue(ValidBst.validBst(root));
  }

  @Test
  @DisplayName("Simple valid BST:    2\n                      / \\\n                     1   3")
  void simpleValidBst() {
    ValidBst.Node<Integer> root = new N(2, new N(1), new N(3));
    assertTrue(ValidBst.validBst(root));
  }

  @Test
  @DisplayName("Invalid: left child greater than parent")
  void invalidLeftGreaterThanParent() {
    //      2
    //     / \
    //    3   4   (left child 3 > 2 => invalid)
    ValidBst.Node<Integer> root = new N(2, new N(3), new N(4));
    assertFalse(ValidBst.validBst(root));
  }

  @Test
  @DisplayName("Invalid: right subtree contains value < root (classic bound violation)")
  void invalidRightSubtreeBoundViolation() {
    //       5
    //      / \
    //     1   4
    //        / \
    //       3   6
    // 4 is < 5 so entire right subtree must be > 5; presence of 4 makes it invalid.
    ValidBst.Node<Integer> root =
      new N(5,
        new N(1),
        new N(4, new N(3), new N(6)));
    assertFalse(ValidBst.validBst(root));
  }

  @Test
  @DisplayName("Duplicates are invalid under strict inequality rules")
  void duplicatesInvalid() {
    //   2
    //    \
    //     2   (equal to parent -> invalid because code uses strict > and <)
    ValidBst.Node<Integer> root = new N(2, null, new N(2));
    assertFalse(ValidBst.validBst(root));
  }

  @Test
  @DisplayName("Valid using buildTree helper (preorder with 'x' nulls): 5 1 x x 7 x x")
  void buildTreeValid() {
    List<String> tokens = ValidBst.splitWords("5 1 x x 7 x x");
    Iterator<String> it = tokens.iterator();
    ValidBst.Node<Integer> root = ValidBst.buildTree(it, Integer::parseInt);
    assertTrue(ValidBst.validBst(root));
  }

  @Test
  @DisplayName("Invalid using buildTree helper: 5 1 x x 4 3 x x 6 x x")
  void buildTreeInvalid() {
    // Preorder encoding:
    //       5
    //      / \
    //     1   4
    //        / \
    //       3   6
    List<String> tokens = ValidBst.splitWords("5 1 x x 4 3 x x 6 x x");
    Iterator<String> it = tokens.iterator();
    ValidBst.Node<Integer> root = ValidBst.buildTree(it, Integer::parseInt);
    assertFalse(ValidBst.validBst(root));
  }

  @Test
  @DisplayName("Larger valid BST")
  void largerValid() {
    //         8
    //       /   \
    //      4     10
    //     / \      \
    //    2   6      20
    ValidBst.Node<Integer> root =
      new N(8,
        new N(4, new N(2), new N(6)),
        new N(10, null, new N(20)));
    assertTrue(ValidBst.validBst(root));
  }

  @Test
  @DisplayName("Invalid deep bound violation")
  void invalidDeepBound() {
    //         8
    //       /   \
    //      4     10
    //     / \      \
    //    2   12     20   (12 in left subtree of 8 violates global max bound)
    ValidBst.Node<Integer> root =
      new N(8,
        new N(4, new N(2), new N(12)),
        new N(10, null, new N(20)));
    assertFalse(ValidBst.validBst(root));
  }
}
