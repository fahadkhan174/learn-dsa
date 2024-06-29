package linkedlist;

import common.Node;

public class LinkedList {

  private Node head;
  private Node tail;
  private int length;

  public LinkedList() {
  }

  public LinkedList(int value) {
    Node node = new Node(value);
    head = node;
    tail = node;
    length = 1;
  }

  public void getHead() {
    System.out.println("Head : " + head.getValue());
  }

  public void setHead(Node head) {
    this.head = head;
  }

  public void getTail() {
    System.out.println("Tail : " + tail.getValue());
  }

  public void setTail(Node tail) {
    this.tail = tail;
  }

  public void getLength() {
    System.out.println("Length : " + length);
  }

  public void setLength(int length) {
    this.length = length;
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (length == 0) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
    length++;
  }

  public Node removeLast() {
    Node temp = head;
    Node pre = head;
    if (length == 0) {
      return null;
    }

    while (temp.next != null) {
      pre = temp;
      temp = temp.next;
    }
    tail = pre;
    tail.next = null;
    length--;
    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);

    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;

    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) {
      return null;
    }

    Node temp = head;
    head = head.next;
    temp.next = null;
    length--;
    if (length == 0) {
      tail = null;
    }

    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }

    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node temp = get(index);
    if (temp != null) {
      temp.value = value;
      return true;
    }
    return false;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }
    if (index == 0) {
      prepend(value);
      return true;
    }
    if (index == length) {
      append(value);
      return true;
    }

    Node newNode = new Node(value);
    Node temp = get(index - 1);
    newNode.next = temp.next;
    temp.next = newNode;
    length++;
    return true;
  }

  public Node remove(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == length - 1) {
      return removeLast();
    }

    Node previous = get(index - 1);
    Node temp = previous.next;
    previous.next = temp.next;
    temp.next = null;
    length--;
    return temp;
  }

  public void reverse() {
    Node temp = head;
    head = tail;
    tail = temp;

    Node after;
    Node before = null;
    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  public void print() {
    Node temp = this.head;
    StringBuilder stringBuilder = new StringBuilder();
    while (temp != null) {
      stringBuilder.append(temp.getValue()).append(" ");
      temp = temp.next;
    }
    System.out.println("LinkedList -> " + stringBuilder);
    System.out.println();
  }
}

