package com.ericchan.interview.algo.arrays.twopointers.prefixsum;

import com.ericchan.interview.algo.twopointers.prefixsum.RangeSumQueryImmutable;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class RangeSumQueryImmutableTest {

  @Test
  public void testExampleCase() {
    assertEquals(9,
      RangeSumQueryImmutable.rangeSumQueryImmutable(Arrays.asList(1, 2, 3, 4), 1, 3));
  }

  @Test
  public void testSingleElement() {
    assertEquals(10,
      RangeSumQueryImmutable.rangeSumQueryImmutable(Arrays.asList(5, 10, 15), 1, 1));
  }

  @Test
  public void testFullRange() {
    assertEquals(20,
      RangeSumQueryImmutable.rangeSumQueryImmutable(Arrays.asList(2, 4, 6, 8), 0, 3));
  }

  @Test
  public void testDifferentRange() {
    assertEquals(11,
      RangeSumQueryImmutable.rangeSumQueryImmutable(Arrays.asList(3, -1, 7, 5), 1, 3));
  }
}
