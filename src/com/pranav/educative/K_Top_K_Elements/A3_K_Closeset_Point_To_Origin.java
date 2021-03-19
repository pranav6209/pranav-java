
/**
 * 
 */
package com.pranav.educative.K_Top_K_Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author pranavpatel
 *
 */

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int distFromOrigin() {
    // ignoring sqrt
    return (x * x) + (y * y);
  }
}

public class A3_K_Closeset_Point_To_Origin {
  public static List<Point> findClosestPoints(Point[] points, int k) {

    PriorityQueue<Point> maxHeap = new PriorityQueue<Point>((n1, n2) -> n2.distFromOrigin() - n1.distFromOrigin());

    for (int i = 0; i < k; i++) {
      maxHeap.add(points[i]);
    }

    for (int i = k; i < points.length; i++) {
      if (points[i].distFromOrigin() < maxHeap.peek().distFromOrigin()) {
        maxHeap.poll();
        maxHeap.add(points[i]);
      }

    }

    return new ArrayList<>(maxHeap);
  }

  public static void main(String[] args) {
    Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
    List<Point> result = A3_K_Closeset_Point_To_Origin.findClosestPoints(points, 2);
    System.out.print("Here are the k points closest the origin: ");
    for (Point p : result)
      System.out.print("[" + p.x + " , " + p.y + "] ");
  }

}
