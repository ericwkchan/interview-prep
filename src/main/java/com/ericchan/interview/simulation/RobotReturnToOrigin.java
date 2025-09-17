package com.ericchan.interview.simulation;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Determines if a robot returns to the origin (0, 0) after executing a sequence of moves.
 *
 * <p>Moves consist of: - 'U' (up) - 'D' (down) - 'L' (left) - 'R' (right)
 */
public class RobotReturnToOrigin {

  /**
   * Check if the robot returns to the origin after all moves.
   *
   * @param moves string of moves (each char is 'U','D','L','R')
   * @return true if the robot ends at (0,0), false otherwisSe
   */
  public boolean judgeCircle(String moves) {
    ArrayList<String> moveList = new ArrayList<>(Arrays.asList(moves.split("")));
    int[] robotPosition = {0, 0};

    for (String move : moveList) {
      if (move.equals("U")) {
        robotPosition[1]++;
      } else if (move.equals("D")) {
        robotPosition[1]--;
      } else if (move.equals("L")) {
        robotPosition[0]--;
      } else if (move.equals("R")) {
        robotPosition[0]++;
      }
    }

    return robotPosition[0] == 0 && robotPosition[1] == 0;
    /**
     * Review: I could have used a switch case and I also didn't have to use too many data
     * structures here. I could have just calculated x and y coordinates. Also, I could have added
     * some edge case handling: If empty string = true because robot hasn't moved. and If single
     * character = false because you can't go back
     */
  }
}
