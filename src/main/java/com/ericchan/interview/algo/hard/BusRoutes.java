package com.ericchan.interview.algo.hard;

import java.util.*;

/**
 * LeetCode 815: Bus Routes
 * BFS over STOPS (each BFS level == one more bus taken).
 */
class BusRoutes {

  public int numBusesToDestination(int[][] routes, int source, int target) {
    // If we already are at the target stop, no buses are needed.
    if (source == target) {
      return 0;
    }

    // --------------------------------------------------------------------
    // 1) Build an index: stop -> list of buses that pass through that stop
    // --------------------------------------------------------------------
    Map<Integer, List<Integer>> stopToBuses = new HashMap<>();

    for (int busIndex = 0; busIndex < routes.length; busIndex++) {
      int[] route = routes[busIndex];

      for (int stop : route) {
        // If this stop hasn't been seen before, create a new list for it.
        if (!stopToBuses.containsKey(stop)) {
          stopToBuses.put(stop, new ArrayList<>());
        }
        // Add this bus to the list of buses that serve 'stop'.
        List<Integer> busesAtStop = stopToBuses.get(stop);
        busesAtStop.add(busIndex);
      }
    }

    // Quick impossibility check: if either endpoint isn't served by any bus, abort.
    if (!stopToBuses.containsKey(source) || !stopToBuses.containsKey(target)) {
      return -1;
    }

    // --------------------------------------------------------------------
    // 2) Prepare BFS state
    //    - Queue holds STOPS we can stand at after the current # of buses.
    //    - visitedStops prevents adding the same stop multiple times.
    //    - visitedBuses ensures each bus is "expanded" only once.
    //    - busesTaken counts BFS layers (each layer == boarding one more bus).
    // --------------------------------------------------------------------
    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(source);

    Set<Integer> visitedStops = new HashSet<>();
    visitedStops.add(source);

    Set<Integer> visitedBuses = new HashSet<>();

    int busesTaken = 0;

    // --------------------------------------------------------------------
    // 3) BFS: expand in WAVES. Each outer loop iteration = take ONE MORE bus.
    // --------------------------------------------------------------------
    while (!queue.isEmpty()) {
      // We are about to consider boarding one more bus for this entire layer.
      busesTaken++;

      // Process exactly the stops currently reachable before taking the next bus.
      int currentLayerSize = queue.size();

      for (int i = 0; i < currentLayerSize; i++) {
        // Take the next stop from the frontier.
        int stop = queue.poll();

        // From this stop, look at ALL buses we could board here.
        List<Integer> busesHere = stopToBuses.get(stop);
        if (busesHere == null) {
          // No buses from this stop (shouldn't happen if map built correctly).
          continue;
        }

        for (int bus : busesHere) {
          // If we've already expanded this bus before, skip it.
          if (visitedBuses.contains(bus)) {
            continue;
          }

          // Mark this bus as visited: we will fan out all its stops now.
          visitedBuses.add(bus);

          // Riding this bus gives access to EVERY stop on its route.
          int[] route = routes[bus];
          for (int nextStop : route) {
            // If we see the target while expanding this bus, we are done.
            if (nextStop == target) {
              return busesTaken;
            }

            // Otherwise, queue up new stops we haven't stood at yet.
            if (!visitedStops.contains(nextStop)) {
              visitedStops.add(nextStop);
              queue.offer(nextStop);
            }
          }
        }
      }
    }

    // If we exhaust the queue, there is no way to reach the target.
    return -1;
  }
}
