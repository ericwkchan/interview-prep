package com.ericchan.interview.algo.arrays.twopointers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.ericchan.interview.algo.twopointers.MoveZeroes;

public class MoveZeroesTest {

  @Test
  void testExampleCase() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 0, 2, 0, 0, 7));
    MoveZeroes.moveZeroes(nums);
    assertEquals(Arrays.asList(1, 2, 7, 0, 0, 0), nums);
  }

  @Test
  void testNoZeroes() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(4, 5, 6));
    MoveZeroes.moveZeroes(nums);
    assertEquals(Arrays.asList(4, 5, 6), nums);
  }

  @Test
  void testAllZeroes() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
    MoveZeroes.moveZeroes(nums);
    assertEquals(Arrays.asList(0, 0, 0, 0), nums);
  }

  @Test
  void testZerosAtFront() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 0, 1, 2, 3));
    MoveZeroes.moveZeroes(nums);
    assertEquals(Arrays.asList(1, 2, 3, 0, 0), nums);
  }

  @Test
  void testSingleElement() {
    List<Integer> nums = new ArrayList<>(Arrays.asList(0));
    MoveZeroes.moveZeroes(nums);
    assertEquals(Arrays.asList(0), nums);
  }

  @Test
  void testEmptyList() {
    List<Integer> nums = new ArrayList<>();
    MoveZeroes.moveZeroes(nums);
    assertTrue(nums.isEmpty());
  }
}

