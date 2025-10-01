package com.ericchan.interview.algo.dfs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertIntoBSTTest {

  private List<String> formatTree(InsertIntoBST.Node<Integer> root) {
    List<String> result = new ArrayList<>();
    InsertIntoBST.formatTree(root, result);
    return result;
  }

  @Test
  void testInsertIntoEmptyTree() {
    InsertIntoBST.Node<Integer> root = null;
    root = InsertIntoBST.insertBst(root, 10);

    List<String> output = formatTree(root);
    assertEquals(List.of("10", "x", "x"), output);
  }

  @Test
  void testInsertSmallerValueGoesLeft() {
    InsertIntoBST.Node<Integer> root = new InsertIntoBST.Node<>(10);
    InsertIntoBST.insertBst(root, 5);

    List<String> output = formatTree(root);
    assertEquals(List.of("10", "5", "x", "x", "x"), output);
  }

  @Test
  void testInsertLargerValueGoesRight() {
    InsertIntoBST.Node<Integer> root = new InsertIntoBST.Node<>(10);
    InsertIntoBST.insertBst(root, 15);

    List<String> output = formatTree(root);
    assertEquals(List.of("10", "x", "15", "x", "x"), output);
  }

  @Test
  void testInsertMultipleValues() {
    InsertIntoBST.Node<Integer> root = new InsertIntoBST.Node<>(10);
    InsertIntoBST.insertBst(root, 5);
    InsertIntoBST.insertBst(root, 15);
    InsertIntoBST.insertBst(root, 3);
    InsertIntoBST.insertBst(root, 7);
    InsertIntoBST.insertBst(root, 12);

    List<String> output = formatTree(root);

    // Expected preorder serialization
    assertEquals(
      List.of("10", "5", "3", "x", "x", "7", "x", "x", "15", "12", "x", "x", "x"),
      output
    );
  }

  @Test
  void testDuplicateValueNotInserted() {
    InsertIntoBST.Node<Integer> root = new InsertIntoBST.Node<>(10);
    InsertIntoBST.insertBst(root, 10); // duplicate

    List<String> output = formatTree(root);
    assertEquals(List.of("10", "x", "x"), output);
  }
}
