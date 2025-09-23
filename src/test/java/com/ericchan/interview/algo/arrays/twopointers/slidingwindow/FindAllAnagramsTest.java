package com.ericchan.interview.algo.arrays.twopointers.slidingwindow;

import com.ericchan.interview.algo.twopointers.slidingwindow.FindAllAnagrams;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FindAllAnagramsTest {

  @Test
  void example1() {
    List<Integer> res = FindAllAnagrams.findAnagrams("cbaebabacd", "abc");
    assertEquals(Arrays.asList(0, 6), res);
  }

  @Test
  void example2() {
    List<Integer> res = FindAllAnagrams.findAnagrams("abab", "ab");
    assertEquals(Arrays.asList(0, 1, 2), res);
  }

  @Test
  void noMatches() {
    List<Integer> res = FindAllAnagrams.findAnagrams("abcdefg", "zzz");
    assertTrue(res.isEmpty());
  }

  @Test
  void identicalStrings() {
    List<Integer> res = FindAllAnagrams.findAnagrams("anagram", "anagram");
    assertEquals(Arrays.asList(0), res);
  }

  @Test
  void repeatedChars() {
    List<Integer> res = FindAllAnagrams.findAnagrams("aaaaa", "aa");
    assertEquals(Arrays.asList(0, 1, 2, 3), res);
  }

  @Test
  void checkLongerThanOriginal() {
    List<Integer> res = FindAllAnagrams.findAnagrams("ab", "abcd");
    assertTrue(res.isEmpty());
  }

  @Test
  void singleChar() {
    List<Integer> res = FindAllAnagrams.findAnagrams("aaaa", "a");
    assertEquals(Arrays.asList(0, 1, 2, 3), res);
  }
}
