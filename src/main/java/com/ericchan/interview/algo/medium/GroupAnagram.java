package com.ericchan.interview.algo.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagram {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, ArrayList<String>> anagramMap = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      int[] charFreq = new int[26];
      for (char c : strs[i].toCharArray()) {
        charFreq[c - 'a']++;
      }
      String charFreqString = Arrays.toString(charFreq);
      if (anagramMap.containsKey(charFreqString)) {
        ArrayList<String> anagramStrings = anagramMap.get(charFreqString);
        anagramStrings.add(strs[i]);
        anagramMap.put(charFreqString, anagramStrings);
      } else {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add(strs[i]);
        anagramMap.putIfAbsent(charFreqString, stringList);
      }
    }
    return new ArrayList<>(anagramMap.values());
  }
}
