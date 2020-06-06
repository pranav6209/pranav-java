/**
 * 
 */
package com.pranav.lc.linkedList.Double;

import java.util.HashMap;

import com.pranav.lc.stackQueueHeap.Heap.A_Last_Stone_Weight;

/**
 * @author pranavpatel
 * 
 * 
 *         https://www.youtube.com/watch?v=NDpwj0VWz1U
 *         https://leetcode.com/problems/lru-cache/discuss/45922/JAVA-Easy-Version-To-Understand!!!!
 *         
 *         bottom discussion one from above^^
 *
 */

class Node {

  int key;
  int value;
  Node next;
  Node prev;

  public Node(int key, int value) {

    this.key = key;
    this.value = value;
  }

}

public class A_LRU_Cache {

  Node head = new Node(0, 0);
  Node tail = new Node(0, 0);
  
  // map of key and node( node is key,value,next and prev pointer) 
  HashMap<Integer, Node> map;
  int capacity;

  public A_LRU_Cache(int capacity) {

    this.capacity = capacity;
    map = new HashMap<>(capacity);
    head.next = tail;
    tail.prev = head;

  }

  public int get(int key) {

    int res = -1;
    if (map.containsKey(key)) {

      // once node is found in map
      // remove from the node and add it to the front.
      Node n = map.get(key);
      remove(n);
      insertToHead(n);
      res = n.value;

    }
    return res;
  }

  public void put(int key, int value) {

    if (map.containsKey(key)) {

      // if key exists in map remove it and
      // add it to the front
      Node n = map.get(key);
      remove(n);
      // assign new value to node
      n.value=value;
      insertToHead(n);

    } else {

      if (map.size() == capacity) {
        // first remove it from the map
        map.remove(tail.prev.key);
        // remove it from the LinkedList
        remove(tail.prev);
      }

      Node n = new Node(key, value);
      // insert to map and then add it to map
      insertToHead(n);
      map.put(key, n);

    }

  }

  private void insertToHead(Node n) {

    Node headNext = head.next;
    head.next = n;
    n.next = headNext;
    headNext.prev = n;
    n.prev = head;

  }

  private void remove(Node n) {

    n.prev.next = n.next;
    n.next.prev = n.prev;

  }

  public static void main(String[] args) {
    
   A_LRU_Cache  cache = new A_LRU_Cache(2);
   cache.put(1, 1);
   cache.put(2, 2);
   cache.get(1);
   cache.put(3, 3);   
   cache.get(2);
  }
}
