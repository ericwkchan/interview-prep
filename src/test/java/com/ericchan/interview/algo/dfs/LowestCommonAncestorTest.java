package com.ericchan.interview.algo.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorTest {

  private LowestCommonAncestor.Node<Integer> buildSampleBst() {
        /*
                6
              /   \
             2     8
            / \   / \
           0   4 7   9
              / \
             3   5
         */
    LowestCommonAncestor.Node<Integer> n3 = new LowestCommonAncestor.Node<>(3);
    LowestCommonAncestor.Node<Integer> n5 = new LowestCommonAncestor.Node<>(5);
    LowestCommonAncestor.Node<Integer> n4 = new LowestCommonAncestor.Node<>(4, n3, n5);
    LowestCommonAncestor.Node<Integer> n0 = new LowestCommonAncestor.Node<>(0);
    LowestCommonAncestor.Node<Integer> n2 = new LowestCommonAncestor.Node<>(2, n0, n4);
    LowestCommonAncestor.Node<Integer> n7 = new LowestCommonAncestor.Node<>(7);
    LowestCommonAncestor.Node<Integer> n9 = new LowestCommonAncestor.Node<>(9);
    LowestCommonAncestor.Node<Integer> n8 = new LowestCommonAncestor.Node<>(8, n7, n9);
    return new LowestCommonAncestor.Node<>(6, n2, n8);
  }

  @Test
  void testLcaRootIsAnswer() {
    var root = buildSampleBst();
    int lca = LowestCommonAncestor.lcaOnBst(root, 2, 8);
    assertEquals(6, lca, "LCA of 2 and 8 should be 6");
  }

  @Test
  void testLcaInLeftSubtree() {
    var root = buildSampleBst();
    int lca = LowestCommonAncestor.lcaOnBst(root, 2, 4);
    assertEquals(2, lca, "LCA of 2 and 4 should be 2");
  }

  @Test
  void testLcaInRightSubtree() {
    var root = buildSampleBst();
    int lca = LowestCommonAncestor.lcaOnBst(root, 7, 9);
    assertEquals(8, lca, "LCA of 7 and 9 should be 8");
  }

  @Test
  void testLcaWhereOneNodeIsAncestor() {
    var root = buildSampleBst();
    int lca = LowestCommonAncestor.lcaOnBst(root, 2, 5);
    assertEquals(2, lca, "LCA of 2 and 5 should be 2 (ancestor case)");
  }

  @Test
  void testLcaSameNode() {
    var root = buildSampleBst();
    int lca = LowestCommonAncestor.lcaOnBst(root, 4, 4);
    assertEquals(4, lca, "LCA of same node should be the node itself");
  }
}
