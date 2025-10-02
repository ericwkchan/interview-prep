package com.ericchan.interview.algo.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis {
  public static boolean validParentheses(String s) {
    ArrayDeque<Character> dq = new ArrayDeque<>();
    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');

    for (char c : s.toCharArray()) {
      // if opener, push
      if (c == '(' || c == '[' || c == '{') {
        dq.push(c);
      }
      // if closer, check
      else if (c == ')' || c == ']' || c == '}') {
        if (dq.isEmpty()) return false;  // no opener to match
        char top = dq.pop();             // last seen opener
        if (top != map.get(c)) return false; // mismatch
      }
    }

    // stack must be empty at the end
    return dq.isEmpty();
  }

  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(') stack.push(')');
      else if (c == '{') stack.push('}');
      else if (c == '[') stack.push(']');
      else if (stack.isEmpty() || stack.pop() != c) return false;
    }
    return stack.isEmpty();
  }
}
