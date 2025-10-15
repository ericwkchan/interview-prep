package com.ericchan.interview.realproblems.rokt;

// rokt had variation where its just 1-9 and no leading 0s

public class ValidAbbreviation {
  public static boolean validWordAbbreviation(String word, String abbr) {
    int i = 0, j = 0;

    while (i < word.length() && j < abbr.length()) {
      char c = abbr.charAt(j);

      // Case 1: abbreviation has a number
      if (Character.isDigit(c)) {
        if (c == '0') return false; // leading zero check

        int num = 0;
        while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
          num = num * 10 + (abbr.charAt(j) - '0');
          j++;
        }
        i += num; // skip 'num' letters in word
      }
      // Case 2: abbreviation has a letter
      else {
        if (i >= word.length() || word.charAt(i) != c)
          return false;
        i++;
        j++;
      }
    }

    // Both must be fully consumed
    return i == word.length() && j == abbr.length();
  }
}
