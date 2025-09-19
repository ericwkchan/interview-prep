package com.ericchan.interview.algo.twopointers.oppositedirection;

import java.util.List;

public class WaterContainer {

  public static int maxArea(java.util.List<Integer> h) {
    int left = 0, right = h.size() - 1;
    int best = 0;

    while (left < right) {
      int height = Math.min(h.get(left), h.get(right));
      int width  = right - left;
      best = Math.max(best, height * width);

      if (h.get(left) < h.get(right)) {
        left++;     // try to raise the height cap from the left
      } else {
        right--;    // try to raise the height cap from the right
      }
    }
    return best;
    /**
     * Review: The shorter height is the limiting factor and we don't move the pointer
     * with the larger height and see if theres anything that can match it. 
     */
  }

  public static int wrongMaxArea(List<Integer> heights) {

    int left = 0;
    int right = heights.size() - 1;

    int maxArea = 0;
    int leftStayArea = 0;
    int rightStayArea= 0;

    if (heights.size() <= 1) {
      return 0;
    }

    while (left != right) {
      int shorterHeight;
      if (heights.get(right) > heights.get(left)) {
        shorterHeight = heights.get(left);
      } else {
        shorterHeight = heights.get(right);
      }

      int length = (heights.size() - left - 1);
      int area = shorterHeight * length;

      if (area > rightStayArea) {
        rightStayArea = area;
      }
      left++;
    }
    left = 0;
    right = heights.size() - 1;
    while (right != left) {
      int shorterHeight;
      if (heights.get(right) > heights.get(left)) {
        shorterHeight = heights.get(left);
      } else {
        shorterHeight = heights.get(right);
      }

      int length = right;
      int area = shorterHeight * length;

      if (area > leftStayArea) {
        leftStayArea = area;
      }
      right--;
    }
    return Math.max(leftStayArea, rightStayArea);
  }
}
