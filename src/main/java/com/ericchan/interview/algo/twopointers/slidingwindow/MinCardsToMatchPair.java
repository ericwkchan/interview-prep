package com.ericchan.interview.algo.twopointers.slidingwindow;

import java.util.HashMap;
import java.util.List;

public class MinCardsToMatchPair {

  /**
   * Returns the minimum number of consecutive cards needed to include
   * a matching pair (same value). If no pair exists, return -1.
   */
  public static int minPickupLength(List<Integer> cards) {
    // remember: when dealing with finding duplicates, hashmaps are best

    if (cards.size() <= 1) {
      return -1;
    }

    int left = 0;
    int leastLength = cards.size() + 1;
    HashMap<Integer, Integer> windowCardFreq = new HashMap<>();
    for (int right = 0; right < cards.size(); right++) {
      windowCardFreq.put(cards.get(right), windowCardFreq.getOrDefault(cards.get(right), 0) + 1);
      // while the condition is true, shrink window and update
      while (windowCardFreq.get(cards.get(right)) == 2) {
        leastLength = Math.min(leastLength, right - left + 1);
        windowCardFreq.put(cards.get(left), windowCardFreq.get(cards.get(left)) - 1);
        left++;
      }
    }

    if (leastLength != cards.size() + 1) {
      return leastLength;
    } else {
      return -1;
    }
  }

  /**
   lastSeen remembers the most recent index where we saw a given card value.
   best starts “impossibly large” (sentinel). Any real window will be smaller.

   As we iterate through cards:
   If we’ve seen val before at index j, then the subarray [j .. i] contains two copies of val.
   Its length is i - j + 1.
   Update best if this window is shorter than what we had before.

   Then update lastSeen[val] = i so future matches use the latest occurrence.
   */

  public static int lastSeenApproach(List<Integer> cards) {
    HashMap<Integer, Integer> lastSeen = new HashMap<>();
    int best = cards.size() + 1;

    for (int i = 0; i < cards.size(); i++) {
      int val = cards.get(i);
      if (lastSeen.containsKey(val)) {
        int j = lastSeen.get(val);
        best = Math.min(best, i - j + 1);
      }
      lastSeen.put(val, i);
    }

    return best == cards.size() + 1 ? -1 : best;
  }
}
