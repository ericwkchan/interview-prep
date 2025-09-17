package com.ericchan.interview.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Classic FizzBuzz problem:
 *
 * <ul>
 *   <li>Return "FizzBuzz" if i is divisible by both 3 and 5
 *   <li>Return "Fizz" if i is divisible by 3 only
 *   <li>Return "Buzz" if i is divisible by 5 only
 *   <li>Otherwise, return the number itself as a string
 * </ul>
 */
public class FizzBuzz {

  /**
   * Generate FizzBuzz sequence from 1 to n (inclusive).
   *
   * @param n the length of the sequence
   * @return list of strings containing Fizz/Buzz/FizzBuzz or numbers
   */
  public List<String> solve(int n) {
    // TODO: Implement FizzBuzz logic here
    // Steps to consider:
    // 1) Create a List<String> result
    // 2) Loop i from 1 to n (inclusive)
    // 3) For each i, check:
    //      - if divisible by 15 -> add "FizzBuzz"
    //      - else if divisible by 3 -> add "Fizz"
    //      - else if divisible by 5 -> add "Buzz"
    //      - else add String.valueOf(i)
    // 4) Return result
    // Important to use else ifs bc using multiple ifs can lead to multiples

    ArrayList<String> result = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      if (i % 15 == 0) {
        result.add("FizzBuzz");
      } else if (i % 3 == 0) {
        result.add("Fizz");
      } else if (i % 5 == 0) {
        result.add("Buzz");
      } else {
        result.add(String.valueOf(i));
      }
    }
    return result;
  }
}
