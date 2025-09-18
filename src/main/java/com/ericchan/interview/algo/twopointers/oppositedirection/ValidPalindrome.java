package com.ericchan.interview.algo.twopointers.oppositedirection;

import java.util.ArrayList;

public class ValidPalindrome {

  public static boolean isPalindrome(String s) {
    /**
     * My first intuition is to use left and right pointers and check if left and right
     * is always equal to each other. We'll need to take the string and move chars into
     * a ArrayList and since we are ignoring alphanumeric, it means we don't care about spaces
     */
    if (s.length() <= 1) {
      return true;
    }

    // s.toCharArray(); Wow didn't know we had this. It's a char[] and not List

    ArrayList<Character> chars = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {
      if (Character.isLetterOrDigit(s.charAt(i))) {
        chars.add(Character.toLowerCase(s.charAt(i)));
      }
    }

    if (chars.size() == 0) {
      return true;
    }

    int left = 0;
    int right = chars.size() - 1;

    while (left != right) {
      if (chars.get(left) != chars.get(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;

    /**
     * So I got this right but a few edge cases I needed to think about.
     * An empty string and a string with just 1 char is a palindrome.
     * It's important to remember how to get the chars from string
     * and the alphanumeric detection in the Characters class.
     * Also, if its just symbols, we're going to get an empty char
     * array and that is considered a palindrome! You can also
     * not create more structures and have a check for alphanumeric
     * but I don't like that as much.
     */
  }
}
