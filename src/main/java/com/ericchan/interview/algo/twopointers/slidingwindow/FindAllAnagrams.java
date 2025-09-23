package com.ericchan.interview.algo.twopointers.slidingwindow;

import java.io.CharConversionException;
import java.util.*;

public class FindAllAnagrams {
  /**
   * Returns starting indices of all substrings of 'original' that are anagrams of 'check',
   * in ascending order.
   */
  public static List<Integer> findAnagrams(String original, String check) {
    List<Integer> startingIndices = new ArrayList<>();

    int sourceLength = original.length();
    int patternLength = check.length();
    if (patternLength > sourceLength) return startingIndices;

    // Frequency of characters required by 'check'
    Map<Character, Integer> requiredCharFreq = new HashMap<>();
    for (char ch : check.toCharArray()) {
      requiredCharFreq.put(ch, requiredCharFreq.getOrDefault(ch, 0) + 1);
    }

    // Frequency of characters in the current window of 'original'
    Map<Character, Integer> windowCharFreq = new HashMap<>();
    // Build the initial window [0 .. patternLength-1]
    for (int i = 0; i < patternLength; i++) {
      char ch = original.charAt(i);
      windowCharFreq.put(ch, windowCharFreq.getOrDefault(ch, 0) + 1);
    }
    if (windowCharFreq.equals(requiredCharFreq)) {
      startingIndices.add(0);
    }

    int windowStartIndex = 0; // left edge of the current window
    // Slide the window: each step brings one char in on the right, one out on the left
    for (int windowEndIndex = patternLength; windowEndIndex < sourceLength; windowEndIndex++) {
      // Incoming character at the new right edge
      char incomingChar = original.charAt(windowEndIndex);
      windowCharFreq.put(incomingChar, windowCharFreq.getOrDefault(incomingChar, 0) + 1);

      // Outgoing character from the old left edge
      /** key point here: end index is pattern length here and start index hasn't moved so
       *  temporarily, the window is larger than pattern length. think of it is as a rubber band.
       *  we then move start up and the window size is pattern length again until the next iteration
      */
      char outgoingChar = original.charAt(windowStartIndex++);
      int updatedCount = windowCharFreq.get(outgoingChar) - 1;
      if (updatedCount == 0) {
        windowCharFreq.remove(outgoingChar);
      } else {
        windowCharFreq.put(outgoingChar, updatedCount);
      }

      // If the window matches the required frequencies, record the start index
      if (windowCharFreq.equals(requiredCharFreq)) {
        startingIndices.add(windowStartIndex);
      }
    }

    return startingIndices;
  }

  public static List<Integer> otherApproach(String original, String check) {
    List<Integer> startingIndices = new ArrayList<>();
    int sourceLength = original.length();
    int patternLength = check.length();

    if (patternLength > sourceLength) return startingIndices;

    // Convert the source string to a native char array
    char[] sourceChars = original.toCharArray();

    // Frequency of characters required by "check"
    int[] requiredCounts = new int[26];
    for (char c : check.toCharArray()) {
      requiredCounts[c - 'a']++;
    }

    // Frequency of characters in the current window of "original"
    int[] windowCounts = new int[26];
    // Build the initial window [0 .. patternLength-1]
    for (int i = 0; i < patternLength; i++) {
      windowCounts[sourceChars[i] - 'a']++;
    }
    if (Arrays.equals(windowCounts, requiredCounts)) {
      startingIndices.add(0);
    }

    // Slide the window across the source string
    for (int windowEnd = patternLength; windowEnd < sourceLength; windowEnd++) {
      // Add incoming char on the right
      windowCounts[sourceChars[windowEnd] - 'a']++;

      // Remove outgoing char on the left
      char outgoing = sourceChars[windowEnd - patternLength];
      windowCounts[outgoing - 'a']--;

      // If frequencies match, record start index
      if (Arrays.equals(windowCounts, requiredCounts)) {
        startingIndices.add(windowEnd - patternLength + 1);
      }
    }

    return startingIndices;
  }

}
