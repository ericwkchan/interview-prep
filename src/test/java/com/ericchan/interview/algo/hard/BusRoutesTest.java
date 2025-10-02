package com.ericchan.interview.algo.hard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BusRoutesTest {

  @Test
  public void testExample1() {
    BusRoutes solver = new BusRoutes();
    int[][] routes = { {1, 2, 7}, {3, 6, 7} };
    int source = 1;
    int target = 6;

    int result = solver.numBusesToDestination(routes, source, target);

    assertEquals(2, result, "Expected 2 buses for example 1");
  }

  @Test
  public void testExample2() {
    BusRoutes solver = new BusRoutes();
    int[][] routes = {
      {7, 12},
      {4, 5, 15},
      {6},
      {15, 19},
      {9, 12, 13}
    };
    int source = 15;
    int target = 12;

    int result = solver.numBusesToDestination(routes, source, target);

    assertEquals(-1, result, "Expected -1 when no path exists for example 2");
  }

  @Test
  public void testSourceEqualsTarget() {
    BusRoutes solver = new BusRoutes();
    int[][] routes = { {1, 2, 3} };
    int source = 2;
    int target = 2;

    int result = solver.numBusesToDestination(routes, source, target);

    assertEquals(0, result, "If source == target, should need 0 buses");
  }

  @Test
  public void testDirectRoute() {
    BusRoutes solver = new BusRoutes();
    int[][] routes = { {5, 6, 7} };
    int source = 5;
    int target = 7;

    int result = solver.numBusesToDestination(routes, source, target);

    assertEquals(1, result, "If target is on the same bus as source, should need 1 bus");
  }

  @Test
  public void testTwoTransfers() {
    BusRoutes solver = new BusRoutes();
    int[][] routes = {
      {1, 2, 3},     // B0
      {3, 4, 5},     // B1
      {5, 6, 7}      // B2
    };
    int source = 1;
    int target = 7;

    int result = solver.numBusesToDestination(routes, source, target);

    assertEquals(3, result, "Expected 3 buses with two transfers");
  }
}
