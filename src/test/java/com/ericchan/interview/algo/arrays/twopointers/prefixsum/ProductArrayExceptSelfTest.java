package com.ericchan.interview.algo.arrays.twopointers.prefixsum;

import com.ericchan.interview.algo.twopointers.prefixsum.ProductArrayExceptSelf;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProductArrayExceptSelfTest {

  @Test
  void exampleCase() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    List<Integer> res = ProductArrayExceptSelf.productExceptSelf(nums);
    assertEquals(Arrays.asList(24, 12, 8, 6), res);
  }

  @Test
  void containsSingleZero() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 0, 4));
    List<Integer> res = ProductArrayExceptSelf.productExceptSelf(nums);
    // only index 2 gets product of non-zero elements, others are 0
    assertEquals(Arrays.asList(0, 0, 8, 0), res);
  }

  @Test
  void containsMultipleZeros() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 2, 0, 4));
    List<Integer> res = ProductArrayExceptSelf.productExceptSelf(nums);
    // two or more zeros -> all products are 0
    assertEquals(Arrays.asList(0, 0, 0, 0), res);
  }

  @Test
  void includesNegatives() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(-1, 1, -1, 1));
    List<Integer> res = ProductArrayExceptSelf.productExceptSelf(nums);
    // products: [1 * -1 * 1, -1 * -1 * 1, -1 * 1 * 1, -1 * 1 * -1] = [-1, 1, -1, 1]
    assertEquals(Arrays.asList(-1, 1, -1, 1), res);
  }

  @Test
  void mixedNumbers() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(2, 3, 5, 7));
    List<Integer> res = ProductArrayExceptSelf.productExceptSelf(nums);
    assertEquals(Arrays.asList(105, 70, 42, 30), res);
  }

  @Test
  void twoElements() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(9, 4));
    List<Integer> res = ProductArrayExceptSelf.productExceptSelf(nums);
    assertEquals(Arrays.asList(4, 9), res);
  }

  @Test
  void largeValues_noOverflowCheckHereButShouldWorkForJavaIntRange() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1000, 100, 10));
    List<Integer> res = ProductArrayExceptSelf.productExceptSelf(nums);
    assertEquals(Arrays.asList(1000, 10000, 100000), res);
  }
}
