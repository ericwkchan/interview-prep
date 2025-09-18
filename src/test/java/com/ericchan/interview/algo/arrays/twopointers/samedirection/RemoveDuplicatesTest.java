package com.ericchan.interview.algo.arrays.twopointers.samedirection;

import static org.junit.jupiter.api.Assertions.*;

import com.ericchan.interview.algo.twopointers.samedirection.RemoveDuplicates;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesTest {

  @Test
  public void testExampleCase() {
    RemoveDuplicates rd = new RemoveDuplicates();
    List<Integer> nums = new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 2, 2));

    int resultLength = rd.removeDuplicates(nums);

    assertEquals(3, resultLength);
    assertEquals(Arrays.asList(0, 1, 2), nums.subList(0, resultLength));
  }

  @Test
  public void testAllUnique() {
    RemoveDuplicates rd = new RemoveDuplicates();
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

    int resultLength = rd.removeDuplicates(nums);

    assertEquals(5, resultLength);
    assertEquals(Arrays.asList(1, 2, 3, 4, 5), nums.subList(0, resultLength));
  }

  @Test
  public void testSingleElement() {
    RemoveDuplicates rd = new RemoveDuplicates();
    List<Integer> nums = new ArrayList<>(Arrays.asList(42));

    int resultLength = rd.removeDuplicates(nums);

    assertEquals(1, resultLength);
    assertEquals(Arrays.asList(42), nums.subList(0, resultLength));
  }

  @Test
  public void testEmptyList() {
    RemoveDuplicates rd = new RemoveDuplicates();
    List<Integer> nums = new ArrayList<>();

    int resultLength = rd.removeDuplicates(nums);

    assertEquals(0, resultLength);
    assertTrue(nums.isEmpty());
  }
}
