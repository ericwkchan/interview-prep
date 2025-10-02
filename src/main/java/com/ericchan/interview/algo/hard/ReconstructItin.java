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
    Map<String, PriorityQueue<String>> edgesToWalk = new HashMap<>();

    for (List<String> edge : tickets) {
      String from = edge.get(0);
      String to = edge.get(1);

      if (!edgesToWalk.containsKey(from)) {
        edgesToWalk.put(from, new PriorityQueue<>());
      }

      edgesToWalk.get(from).offer(to);
    }

    LinkedList<String> finalRoute = new LinkedList<>();
    ArrayDeque<String> exploreStack = new ArrayDeque<>();

    exploreStack.add("JFK");

    while(!exploreStack.isEmpty()) {
      String top = exploreStack.peek();
      PriorityQueue<String> pqOfRoutes = edgesToWalk.get(top);

      if (pqOfRoutes != null && !pqOfRoutes.isEmpty()) {
        // consume next smallest edge
        exploreStack.push(pqOfRoutes.poll());
      } else {
        // we reached a dead end -> finalize this position in result and remove from stack
        finalRoute.addFirst(exploreStack.pop());
      }
    }

    return finalRoute;
  }

}

