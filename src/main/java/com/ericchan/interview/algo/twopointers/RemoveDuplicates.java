package com.ericchan.interview.algo.twopointers;

import java.util.List;

public class RemoveDuplicates {
  public int removeDuplicates(List<Integer> nums) {
    if (nums.isEmpty()) {
      return 0;
    }

    int slow = 0;

    for (int fast = 0; fast < nums.size(); fast++) {
      if (!nums.get(fast).equals(nums.get(slow))) {
        slow++;
        nums.set(slow, nums.get(fast));
      }
    }

    return slow + 1;
    /**
     * Review: So we have to assume this is sorted otherwise we can just use a hash set while
     * iterating. And also, we can't use extra memory. So the way we do this is we have two
     * pointers, one moving faster and one lagging behind. The one that always iterates, checks if
     * the value is the same as the lagging pointer. If it changed at all, update the position of
     * slow pointer to value of faster pointer and iterate the slow pointer. Keep going until end of
     * the array and if you take the slow pointer + 1, that's the number of duplicates. we're not
     * really removing duplicates which is silly to the name of this problem.
     */
  }
}
