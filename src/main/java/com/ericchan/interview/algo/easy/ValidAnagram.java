package com.ericchan.interview.algo.easy;

import java.util.HashMap;

public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    char[] sChar = s.toCharArray();
    char[] tChar = t.toCharArray();

    HashMap<Character, Integer> answerKey = new HashMap<>();
    HashMap<Character, Integer> inputKey = new HashMap<>();
    for (char c : sChar) {
      answerKey.put(c, answerKey.getOrDefault(c, 0) + 1);
    }
    for (char c : tChar) {
      inputKey.put(c, inputKey.getOrDefault(c, 0) + 1);
    }
    return inputKey.equals(answerKey);
  }
}
