package com.ericchan.interview.algo.twopointers.slidingwindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
  /**
   * Returns the length of the longest substring without repeating characters.
   */
  public static int lengthOfLongestSubstring(String s) {

    if (s.length() <= 1) {
      return s.length();
    }

    HashSet<Character> uniqueChecker = new HashSet<>();

    int start = 0;
    int longestLength = 0;
    for (int end = 0; end < s.length(); end++) {
      // reminder: don't add the char into the hashset first
      char c = s.charAt(end);
      // inherently, we don't need start <= end in the condition here
      // shrink until we don't have any dupes or shrink while incoming char
      // causes a dupe
      while (uniqueChecker.contains(c)) {
        uniqueChecker.remove(s.charAt(start));
        start++;
      }

      // safe to add now so we aren't checking for something we added if we
      // did this in the beginning
      uniqueChecker.add(c);
      longestLength = Math.max(longestLength, end - start + 1);
    }

    return longestLength;
  }
}
