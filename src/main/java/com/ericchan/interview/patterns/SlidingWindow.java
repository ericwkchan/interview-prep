package com.ericchan.interview.patterns;

public class SlidingWindow {
    /**
     * Example skeleton: longest substring with at most k distinct ASCII chars.
     */
    public static int longestWithKDistinct(char[] s, int k) {
        int[] freq = new int[128];
        int distinct = 0, best = 0;
        for (int L = 0, R = 0; R < s.length; R++) {
            if (freq[s[R]]++ == 0) distinct++;
            while (distinct > k) {
                if (--freq[s[L++]] == 0) distinct--;
            }
            best = Math.max(best, R - L + 1);
        }
        return best;
    }
}
