/**
 * 
 */
package com.pranav.ik.A4Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author pranavpatel
 *  Time  : O(M*N)
 *  Space : O(n+m)
 *  
 *  implicit representation of edges. look at the live class notes 
 *  connected component 
 */
public class A1_Numbers_Of_Island {

  public static int count_islands(List<List<Integer>> matrix) {
 
    // part -3 outer loop
    int count = 0;
    int m = matrix.size();
    int n = matrix.get(0).size();
    
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int value = matrix.get(i).get(j);
        if (value == 1) {
          bfs(i, j, matrix);
          count++;
        }
      }
    }
    return count;
  }

  // part -2 bfs
  private static void bfs(int i, int j, List<List<Integer>> matrix) {
    Queue<Point> q = new LinkedList<Point>();
    q.add(new Point(i, j));
    while (!q.isEmpty()) {
      Point current = q.poll();
      //When a node is visited, change its value from 1 to 0.
      matrix.get(current.x).set(current.y, 0);
      
      for (Point p : current.getNeighbors(matrix.size(),matrix.get(0).size())) {
        if (matrix.get(p.x).get(p.y) == 3) {
          q.add(p);
          //When a node is visited, change its value from 1 to 0.
          matrix.get(p.x).set(p.y, 3);
        }
      }
    }
  }

  private static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public List<Point> getNeighbors(int maxX, int maxY) {
      List<Point> points = new ArrayList<>();
      if (x - 1 >= 0) {
        points.add(new Point(x - 1, y));
      }
      if (y - 1 >= 0) {
        points.add(new Point(x, y - 1));
      }
      if (x + 1 < maxX) {
        points.add(new Point(x + 1, y));
      }
      if (y + 1 < maxY) {
        points.add(new Point(x, y + 1));
      }
      if (x - 1 >= 0 && y - 1 >= 0) {
        points.add(new Point(x - 1, y - 1));
      }
      if (x - 1 >= 0 && y + 1 < maxY) {
        points.add(new Point(x - 1, y + 1));
      }
      if (x + 1 < maxX && y - 1 >= 0) {
        points.add(new Point(x + 1, y - 1));
      }
      if (x + 1 < maxX && y + 1 < maxY) {
        points.add(new Point(x + 1, y + 1));
      }
      return points;
    }
  }



  public static void main(String[] args) {
    List<List<Integer>> ip = new ArrayList<>();

    List<Integer> l1 = new ArrayList<>();
    l1.add(1);
    l1.add(1);
    l1.add(0);
    l1.add(0);
    l1.add(0);
    ip.add(l1);

    List<Integer> l2 = new ArrayList<>();
    l2.add(0);
    l2.add(1);
    l2.add(0);
    l2.add(0);
    l2.add(1);
    ip.add(l2);

    List<Integer> l3 = new ArrayList<>();
    l3.add(1);
    l3.add(0);
    l3.add(0);
    l3.add(1);
    l3.add(1);
    ip.add(l3);

    List<Integer> l4 = new ArrayList<>();
    l4.add(0);
    l4.add(0);
    l4.add(0);
    l4.add(0);
    l4.add(0);
    ip.add(l4);

    List<Integer> l5 = new ArrayList<>();
    l5.add(1);
    l5.add(0);
    l5.add(1);
    l5.add(0);
    l5.add(1);
    ip.add(l5);

    System.out.println(count_islands(ip));

  }
}
