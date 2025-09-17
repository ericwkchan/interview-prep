package com.ericchan.interview.algo.arrays;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class TwoSumTest {
    @Test
    void example() {
        var sol = new TwoSum();
        assertThat(sol.solve(new int[]{2,7,11,15}, 9)).containsExactly(0,1);
    }

    @Test
    void noSolution() {
        var sol = new TwoSum();
        assertThat(sol.solve(new int[]{1,2,3}, 100)).containsExactly(-1,-1);
    }

    @Test
    void duplicatesHandled() {
        var sol = new TwoSum();
        assertThat(sol.solve(new int[]{3,3}, 6)).containsExactly(0,1);
    }
}
