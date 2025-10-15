package com.ericchan.interview.algo.medium;

public class MinAddParenthesis {
  public int minAddToMakeValid(String s) {

    int openBrackets = 0;
    int needToAdd = 0;

    for (char c : s.toCharArray()) {
      if (c == '(') {
        openBrackets++;
      } else {
        // if we encounter a close paren
        if (openBrackets > 0) {
          openBrackets--;
        } else {
          needToAdd++;;
        }
      }
    }
    return openBrackets + needToAdd;
  }
}
