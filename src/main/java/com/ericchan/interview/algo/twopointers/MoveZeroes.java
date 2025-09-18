package com.ericchan.interview.algo.twopointers;

import java.util.List;

public class MoveZeroes {

  public static List<Integer> moveZeroes(List<Integer> nums) {

    /**
     Thinking out loud:
     Fast and slow pointer
     check first element, if it is not zero, move on, move head only
     if it is zero, check if next is null
     if not null, move slow pointer up, swap, move head up
     */

    int slow = 0;

    for (int fast = 0; fast < nums.size(); fast++) {
      if (nums.get(fast) != 0) {
        int slowNum = nums.get(slow);
        nums.set(slow, nums.get(fast));
        nums.set(fast, slowNum);
        slow++;
      }
    }
    return nums;

    /**
     * Review: This was confusing to me because I kept thinking at first that the fast
     * should be looking ahead and swapping. But the right solution is that fast is just
     * like a normal int i iterator that is always going to just scan through the array.
     * We move slow pointer if the fast pointer is not zero, then we swap places and
     * move slow pointer up. Slow pointer will always be pointing to where the next
     * non-zero will be swapping to. The target position. If it fast is just zero,
     * we do nothing and just let fast iterate. This is O(n) in time and O(1) in space.
     */
  }
}
