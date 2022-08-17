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
 *         maintain 2 data structure
 *
 *         1. map will give O(1) - read access to key . map will hold key and a reference to node.
 *         Map<Integer,Node> --- we do not have to explicity maintain/update Node() in a map.
 *         I think since it is refrecend to node in a linkedList it will be updated automatically.
 *
 *         2. to maintain Least recently used logic , Doubly linkedList, head.next will be mosty recently used
 *         and tail.prev is least recently used. Here we are maintaining head and tail with key, val -->> 0,0
 *         and then new keys will be added in between
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

    //  if key is found return it with updating doubly linkedList else return -1
    int res = -1;
    if (map.containsKey(key)) {

      // once node is found in map
      // remove  doubly linkedList from its current position and add it to the front.
      Node n = map.get(key);
      remove(n);
      insertToHead(n);
      res = n.value;

    }
    return res;
  }

  public void put(int key, int value) {

    if (map.containsKey(key)) {

      // if key exists in map remove it from doubly linkedList current position and
      // add it to the front, update the value. No operation needed for map as it is already there
      Node n = map.get(key);
      remove(n);
      // assign new value to node
      n.value=value;
      insertToHead(n);
      // here in a map node attached to that key will be updated automatically with new value,next,prev as in map
      // node is referred to a node in a  linkedList
    } else {

      if (map.size() == capacity) {
        // first remove tail.prev.key from map
        map.remove(tail.prev.key);
        // remove it from the LinkedList
        remove(tail.prev);
      }

      Node n = new Node(key, value);
      // insert to doubly linkedlist at front and then add it to map
      insertToHead(n);
      map.put(key, n);

    }

  }

  // head and tail both are has key,val 0
  private void insertToHead(Node n) {

    Node headNext = head.next;
    head.next = n;
    n.next = headNext;
    headNext.prev = n;
    n.prev = head;

  }

  // head and tail both are has key,val 0
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
