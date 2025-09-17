package com.ericchan.interview.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RobotReturnToOriginTest {

    @Test
    void returnsTrue_whenMovesCancelOutVerticallyAndHorizontally() {
        var robot = new RobotReturnToOrigin();

        assertThat(robot.judgeCircle("UD")).isTrue();  // Up + Down cancel
        assertThat(robot.judgeCircle("LR")).isTrue();  // Left + Right cancel
        assertThat(robot.judgeCircle("UDLR")).isTrue(); // All cancel out
    }

    @Test
    void returnsFalse_whenHorizontalMovesDontCancelOut() {
        var robot = new RobotReturnToOrigin();

        assertThat(robot.judgeCircle("LL")).isFalse();    // x = -2
        assertThat(robot.judgeCircle("RRU")).isFalse();   // x = 2, y = 1
    }

    @Test
    void returnsFalse_whenVerticalMovesDontCancelOut() {
        var robot = new RobotReturnToOrigin();

        assertThat(robot.judgeCircle("UU")).isFalse();   // y = 2
        assertThat(robot.judgeCircle("UDU")).isFalse();  // net y = 1
    }

    @Test
    void emptyInput_returnsTrue() {
        var robot = new RobotReturnToOrigin();

        assertThat(robot.judgeCircle("")).isTrue();
    }

    @Test
    void mixedOrderStillReturnsTrue() {
        var robot = new RobotReturnToOrigin();

        // Moves not in canceling order but net displacement = 0
        assertThat(robot.judgeCircle("UURRDDLL")).isTrue();
    }
}
