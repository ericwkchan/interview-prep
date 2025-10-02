package com.ericchan.interview.algo.hard;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReconstructItinTest {

  @Test
  public void testBasicExample() {
    ReconstructItin sol = new ReconstructItin();

    List<List<String>> tickets = Arrays.asList(
      Arrays.asList("MUC", "LHR"),
      Arrays.asList("JFK", "MUC"),
      Arrays.asList("SFO", "SJC"),
      Arrays.asList("LHR", "SFO")
    );

    List<String> expected = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
    assertEquals(expected, sol.findItinerary(tickets));
  }

  @Test
  public void testLexOrderMatters() {
    ReconstructItin sol = new ReconstructItin();

    List<List<String>> tickets = Arrays.asList(
      Arrays.asList("JFK", "SFO"),
      Arrays.asList("JFK", "ATL"),
      Arrays.asList("SFO", "ATL"),
      Arrays.asList("ATL", "JFK"),
      Arrays.asList("ATL", "SFO")
    );

    // The lexicographically smallest valid itinerary
    List<String> expected = Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
    assertEquals(expected, sol.findItinerary(tickets));
  }

  @Test
  public void testMultipleParallelEdges() {
    ReconstructItin sol = new ReconstructItin();

    List<List<String>> tickets = Arrays.asList(
      Arrays.asList("JFK", "ATL"),
      Arrays.asList("JFK", "ATL"),
      Arrays.asList("ATL", "JFK")
    );

    // Two identical JFK->ATL tickets
    List<String> expected = Arrays.asList("JFK", "ATL", "JFK", "ATL");
    assertEquals(expected, sol.findItinerary(tickets));
  }

  @Test
  public void testSingleTicket() {
    ReconstructItin sol = new ReconstructItin();

    List<List<String>> tickets = Arrays.asList(
      Arrays.asList("JFK", "LAX")
    );

    List<String> expected = Arrays.asList("JFK", "LAX");
    assertEquals(expected, sol.findItinerary(tickets));
  }
}
