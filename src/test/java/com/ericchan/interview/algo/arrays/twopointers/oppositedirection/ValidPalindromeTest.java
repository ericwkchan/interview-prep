package com.ericchan.interview.algo.arrays.twopointers.oppositedirection;

import com.ericchan.interview.algo.twopointers.oppositedirection.ValidPalindrome;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

  @Test
  void testSimplePalindrome() {
    assertTrue(ValidPalindrome.isPalindrome("madam"));
  }

  @Test
  void testPalindromeWithSpacesAndCase() {
    assertTrue(ValidPalindrome.isPalindrome("Do geese see God?"));
  }

  @Test
  void testPalindromeWithMixedCaseAndPunctuation() {
    assertTrue(ValidPalindrome.isPalindrome("Was it a car or a cat I saw?"));
  }

  @Test
  void testNonPalindrome() {
    assertFalse(ValidPalindrome.isPalindrome("A brown fox jumping over"));
  }

  @Test
  void testEmptyString() {
    assertTrue(ValidPalindrome.isPalindrome(""));
  }

  @Test
  void testSingleCharacter() {
    assertTrue(ValidPalindrome.isPalindrome("x"));
  }

  @Test
  void testOnlyNonAlphanumericCharacters() {
    assertTrue(ValidPalindrome.isPalindrome("!!!")); // no letters/numbers means it's trivially a palindrome
  }

  @Test
  void testPalindromeWithNumbers() {
    assertTrue(ValidPalindrome.isPalindrome("1a2b2a1"));
  }

  @Test
  void testNotPalindromeWithNumbers() {
    assertFalse(ValidPalindrome.isPalindrome("123ab321"));
  }
}
