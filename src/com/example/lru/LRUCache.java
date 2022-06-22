package com.example.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
  private int capacity;
  private Map<Integer,Node> cache;
  private  Node head;
  private Node tail;

  LRUCache(int capacity){
    this.capacity= capacity;
    cache = new HashMap<>(capacity);
  }

  public int get(int key){
    if(cache.containsKey(key)){
      Node node = cache.get(key);
      moveToFront(node);
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value){
    if(cache.containsKey(key)){
      Node node = cache.get(key);
      node.value =value;
      moveToFront(node);
      return;
    }

    if(cache.size()==capacity){
      cache.remove(tail.key);
      removeNode(tail);
    }

    Node node = new Node(key,value);
    cache.put(key, node);
    addFirst(node);
  }

  private void addFirst(Node node)
  {
    node.next=head;
    node.previous=null;

    if(head !=null){
      head.previous =node;
    }
    head =node;
    if(tail == null){
      tail=node;
    }
  }

  private void removeNode(Node node)
  {
    Node prevNode = node.previous;
    Node nextNode = node.next;

    if(prevNode !=null){
      prevNode.next = nextNode;
    }else{
      head = nextNode;
    }

    if(nextNode !=null){
      nextNode.previous = prevNode;
    }else{
      tail = prevNode;
    }
  }

  private void moveToFront(Node node)
  {
    removeNode(node);
    addFirst(node);
  }
}
