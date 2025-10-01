package com.ericchan.interview.algo.medium;

import java.util.HashSet;
import java.util.Set;
// Leetcode #1055
public class ShortestStringFormation {
  public int shortestWay(String source, String target) {
    // Pre-check: every target char must exist in source
    Set<Character> sourceChars = new HashSet<>();
    for (char c : source.toCharArray()) {
      sourceChars.add(c);
    }
    for (char c : target.toCharArray()) {
      if (!sourceChars.contains(c)) return -1;
    }

    int count = 0;  // number of subsequences used
    int i = 0;      // pointer into target

    while (i < target.length()) {
      // One scan through source = one subsequence
      for (int j = 0; j < source.length() && i < target.length(); j++) {
        // this is the greedy approach of taking as many characters that match
        // in every pass through the string
        if (source.charAt(j) == target.charAt(i)) {
          i++;  // consume a target char
        }
      }
      count++;
    }

    return count;
  }
}
