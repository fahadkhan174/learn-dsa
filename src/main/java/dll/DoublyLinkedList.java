package dll;

import common.Node;

public class DoublyLinkedList {

  private Node head;
  private Node tail;
  private int length;

  public DoublyLinkedList(int value) {
    Node newNode = new Node(value);
    head = newNode;
    tail = newNode;
    length = 1;
  }

  public void print() {
    Node temp = head;
    StringBuilder stringBuilder = new StringBuilder();
    while (temp != null) {
      stringBuilder.append(temp.getValue()).append(" ");
      temp = temp.next;
    }
    System.out.println("DoublyLinkedList -> " + stringBuilder);
  }

  public void getHead() {
    System.out.println("Head: " + head.value);
  }

  public void getTail() {
    System.out.println("Tail: " + tail.value);
  }

  public void getLength() {
    System.out.println("Length: " + length);
  }

  public void append(int value) {
    Node newNode = new Node(value);

    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      newNode.prev = tail;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if (length == 0) {
      return null;
    }
    Node temp = tail;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      tail = tail.prev;
      tail.next = null;
      temp.prev = null;
    }
    length--;
    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);

    if (length == 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) {
      return null;
    }
    Node temp = head;
    if (length == 1) {
      head = null;
      tail = null;
    } else {
      head = head.next;
      head.prev = null;
      temp.next = null;
    }
    length--;
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
    Node before = get(index - 1);
    Node after = before.next;

    before.next = newNode;
    newNode.prev = before;
    newNode.next = after;
    after.prev = newNode;
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
    Node temp = get(index);

    System.out.println("Temp: " + temp.value);
    Node before = temp.prev;
    Node after = temp.next;
    before.next = after;
    after.prev = before;
    //    without before and after nodes
    //    temp.next.prev = temp.prev;
    //    temp.prev.next = temp.next;

    temp.prev = null;
    temp.next = null;
    length--;
    return temp;
  }

  public void swapFirstLast() {
    if (length >= 2) {
      int temp = head.value;
      head.value = tail.value;
      tail.value = temp;
    }
  }

  public void reverse() {
    if (length >= 2) {
      Node currentNode = head;
      Node tempNode = null;

      while (currentNode != null) {
        tempNode = currentNode.prev;
        currentNode.prev = currentNode.next;
        currentNode.next = tempNode;

        currentNode = currentNode.prev;
      }

      tempNode = head;
      head = tail;
      tail = tempNode;
    }
  }

  public boolean isPalindrome() {
    Node start = head;
    Node end = tail;
    for (int i = 0; i < length / 2; i++) {
      if (start.value != end.value) {
        return false;
      }
      start = start.next;
      end = end.prev;
    }

    return true;
  }

  public void swapPairs() {
    if (length >= 2) {

      Node dummy = new Node(0);
      dummy.next = head;
      Node previous = dummy;

      while (head != null && head.next != null) {
        Node first = head;
        Node second = head.next;

        previous.next = second;
        first.next = second.next;
        second.next = first;

        second.prev = previous;
        first.prev = second;

        if(first.next!=null) {
          first.next.prev = first;
        }

        head = first.next;
        previous = first;
      }

      head = dummy.next;

      if (head != null) head.prev = null;
    }
  }

}
