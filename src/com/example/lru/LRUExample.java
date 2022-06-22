package com.example.lru;

public class LRUExample
{
  public static void main(String[] args){
    //Scanner sc = new Scanner(System.in);
    int capacity = 2;//sc.nextInt();

    LRUCache cache = new LRUCache(capacity);
    cache.get(3);
    cache.put(1,2);
    cache.put(2,4);
    System.out.println(cache.get(1));
    cache.put(4,6);
    System.out.println(cache.get(2));

  }
}
