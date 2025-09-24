package com.ericchan.interview.algo.arrays.twopointers.slidingwindow;

import com.ericchan.interview.algo.twopointers.slidingwindow.MinCardsToMatchPair;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MinCardsToMatchPairTest {

  @Test
  void exampleCase() {
    List<Integer> cards = new ArrayList<>(Arrays.asList(3, 4, 2, 3, 4, 7));
    int res = MinCardsToMatchPair.minPickupLength(cards);
    assertEquals(4, res); // [3,4,2,3] or [4,2,3,4]
  }

  @Test
  void immediatePairAtStart() {
    List<Integer> cards = new ArrayList<>(Arrays.asList(5, 5, 1, 2));
    int res = MinCardsToMatchPair.minPickupLength(cards);
    assertEquals(2, res); // [5,5]
  }

  @Test
  void pairSeparatedByOne() {
    List<Integer> cards = new ArrayList<>(Arrays.asList(1, 2, 1));
    int res = MinCardsToMatchPair.minPickupLength(cards);
    assertEquals(3, res); // [1,2,1]
  }

  @Test
  void pairAtEnd() {
    List<Integer> cards = new ArrayList<>(Arrays.asList(9, 8, 7, 6, 7));
    int res = MinCardsToMatchPair.minPickupLength(cards);
    assertEquals(3, res); // [7,6,7] (indices 2..4 need 3, but also [8,7,6,7] = 4 -> min is 3)
  }

  @Test
  void multiplePairsChooseShortestWindow() {
    List<Integer> cards = new ArrayList<>(Arrays.asList(1, 2, 3, 1, 2, 1));
    int res = MinCardsToMatchPair.minPickupLength(cards);
    assertEquals(2, res); // last two [1,1]
  }

  @Test
  void noPairs() {
    List<Integer> cards = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    int res = MinCardsToMatchPair.minPickupLength(cards);
    assertEquals(-1, res);
  }

  @Test
  void singleCard() {
    List<Integer> cards = new ArrayList<>(Arrays.asList(42));
    int res = MinCardsToMatchPair.minPickupLength(cards);
    assertEquals(-1, res);
  }

  @Test
  void largeValuesStillWork() {
    List<Integer> cards = new ArrayList<>(Arrays.asList(1_000_000, 2, 3, 1_000_000));
    int res = MinCardsToMatchPair.minPickupLength(cards);
    assertEquals(4, res);
  }

  @Test
  void adjacentPairInMiddle() {
    List<Integer> cards = new ArrayList<>(Arrays.asList(7, 3, 3, 5));
    int res = MinCardsToMatchPair.minPickupLength(cards);
    assertEquals(2, res); // [3,3]
  }
}
