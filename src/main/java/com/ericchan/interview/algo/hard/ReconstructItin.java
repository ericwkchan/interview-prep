package com.ericchan.interview.algo.hard;

import java.util.*;

public class ReconstructItin {
  public List<String> findItinerary(List<List<String>> tickets) {
    // Graph: departure -> min-heap of arrivals
    Map<String, PriorityQueue<String>> graph = new HashMap<>();

    // Build graph with clear, readable code
    for (List<String> t : tickets) {
      String from = t.get(0);
      String to   = t.get(1);

      if (!graph.containsKey(from)) {
        graph.put(from, new PriorityQueue<>());
      }
      graph.get(from).offer(to);
    }

    LinkedList<String> route = new LinkedList<>();
    Deque<String> stack = new ArrayDeque<>();
    stack.push("JFK");

    // Iterative Hierholzer
    while (!stack.isEmpty()) {
      String top = stack.peek();
      PriorityQueue<String> pq = graph.get(top);
      if (pq != null && !pq.isEmpty()) {
        stack.push(pq.poll()); // consume next smallest edge
      } else {
        route.addFirst(stack.pop()); // dead-end, fix order
      }
    }

    return route;
  }

  public List<String> myAttempt(List<List<String>> tickets) {
    // Build an adjacency list using a PriorityQueue to keep destinations in lexicographical order
    Map<String, PriorityQueue<String>> edgesToWalk = new HashMap<>();

    // Populate the graph: each 'from' maps to a min-heap of possible 'to' airports
    for (List<String> edge : tickets) {
      String from = edge.get(0);
      String to = edge.get(1);

      // If 'from' airport not in map, initialize a new priority queue
      edgesToWalk.putIfAbsent(from, new PriorityQueue<>());
      edgesToWalk.get(from).offer(to);
    }

    // This will hold our final itinerary in reverse order (we’ll add airports to the front)
    LinkedList<String> finalRoute = new LinkedList<>();

    // Stack to simulate the DFS traversal (we always start from JFK)
    ArrayDeque<String> exploreStack = new ArrayDeque<>();
    exploreStack.push("JFK");

    // Hierholzer’s Algorithm (used to find Eulerian path)
    while (!exploreStack.isEmpty()) {
      String top = exploreStack.peek();  // Look at the current airport (don’t remove yet)
      PriorityQueue<String> pqOfRoutes = edgesToWalk.get(top);

      if (pqOfRoutes != null && !pqOfRoutes.isEmpty()) {
        // There are still destinations we can travel to from this airport
        // Pick the lexicographically smallest next destination and continue DFS
        exploreStack.push(pqOfRoutes.poll());
      } else {
        // No more outgoing flights — we’ve reached a “dead end”
        // Pop the airport and add it to the front of the final route
        // (This ensures we build the path in correct order when backtracking)
        finalRoute.addFirst(exploreStack.pop());
      }
    }

    return finalRoute;
  }


}

