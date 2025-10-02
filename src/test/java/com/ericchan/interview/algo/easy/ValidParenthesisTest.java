package com.ericchan.interview.algo.easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisTest {

  @Test
  void testEmptyString() {
    assertTrue(ValidParenthesis.validParentheses(""),
      "Empty string should be valid");
  }

  @Test
  void testSinglePair() {
    assertTrue(ValidParenthesis.validParentheses("()"));
    assertTrue(ValidParenthesis.validParentheses("[]"));
    assertTrue(ValidParenthesis.validParentheses("{}"));
  }

  @Test
  void testNestedPairs() {
    assertTrue(ValidParenthesis.validParentheses("({[]})"),
      "Nested brackets should be valid");
    assertTrue(ValidParenthesis.validParentheses("{[()]}"));
  }

  @Test
  void testSequentialPairs() {
    assertTrue(ValidParenthesis.validParentheses("()[]{}"),
      "Multiple sequential valid pairs should be valid");
  }

  @Test
  void testInvalidClosingFirst() {
    assertFalse(ValidParenthesis.validParentheses(")"),
      "Closing without opening should be invalid");
    assertFalse(ValidParenthesis.validParentheses(")("),
      "Closing before opening should be invalid");
  }

  @Test
  void testMismatchedPairs() {
    assertFalse(ValidParenthesis.validParentheses("(]"),
      "Different type brackets should be invalid");
    assertFalse(ValidParenthesis.validParentheses("([)]"),
      "Incorrect nesting should be invalid");
  }

  @Test
  void testUnclosedOpeners() {
    assertFalse(ValidParenthesis.validParentheses("("),
      "Unclosed opener should be invalid");
    assertFalse(ValidParenthesis.validParentheses("{[("),
      "Multiple unclosed openers should be invalid");
  }
}
