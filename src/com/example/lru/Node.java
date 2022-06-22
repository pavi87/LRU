package com.example.lru;

public class Node
{
  int key;
  int value;
  Node next;
  Node previous;

  Node(int key,int value){
    this.key=key;
    this.value =value;
  }

  public String toString(){
    return String.valueOf(value);
  }
}
