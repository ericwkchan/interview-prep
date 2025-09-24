package com.ericchan.interview.algo.arrays.twopointers.slidingwindow;

import com.ericchan.interview.algo.twopointers.slidingwindow.LongestSubstringWithoutRepeating;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingTest {

  @Test
  void example1() {
    String s = "abccabcabcc";
    int res = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
    assertEquals(3, res); // "abc" or "cab"
  }

  @Test
  void example2() {
    String s = "aaaabaaa";
    int res = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
    assertEquals(2, res); // "ab"
  }

  @Test
  void allUnique() {
    String s = "abcdef";
    int res = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
    assertEquals(6, res); // whole string
  }

  @Test
  void allSameChar() {
    String s = "aaaaaa";
    int res = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
    assertEquals(1, res);
  }

  @Test
  void emptyString() {
    String s = "";
    int res = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
    assertEquals(0, res);
  }

  @Test
  void singleChar() {
    String s = "x";
    int res = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
    assertEquals(1, res);
  }

  @Test
  void mixedRepeats() {
    String s = "pwwkew";
    int res = LongestSubstringWithoutRepeating.lengthOfLongestSubstring(s);
    assertEquals(3, res); // "wke"
  }
}
