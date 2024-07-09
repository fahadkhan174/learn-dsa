package ll;

import java.util.HashSet;
import java.util.Set;

import common.Node;

public class LinkedList {

  private Node head;
  private Node tail;
  private int length;

  public LinkedList() {
  }

  public void getHead() {
    System.out.println("Head : " + head.getValue());
  }

  public void getTail() {
    System.out.println("Tail : " + tail.getValue());
  }

  public void getLength() {
    System.out.println("Length : " + length);
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
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

  public Node findMiddleNode() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  public boolean hasLoop() {
    Node slow = head;
    Node fast = head;
    if (length == 0 || length == 1) {
      return false;
    }
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public Node findKthFromEnd(int k) {
    if (head == null || k == 0) {
      return null;
    }
    Node first = head;
    Node second = head;
    int i = 1;
    while (second != null && i < k) {
      second = second.next;
      i++;
    }
    if (second == null) {
      return null;
    }
    while (second.next != null) {
      first = first.next;
      second = second.next;
    }
    return first;
  }

  public void partitionList(int x) {
    if (head == null) {
      return;
    }

    Node dummy1 = new Node(0);
    Node dummy2 = new Node(0);
    Node prev1 = dummy1;
    Node prev2 = dummy2;
    Node current = head;

    while (current != null) {
      if (current.value < x) {
        prev1.next = current;
        prev1 = current;
      } else {
        prev2.next = current;
        prev2 = current;
      }
      current = current.next;
    }

    prev2.next = null;
    prev1.next = dummy2.next;

    head = dummy1.next;
  }

  public void removeDuplicates() {
    Set<Integer> values = new HashSet<>();

    Node previous = null;
    Node current = head;
    while (current != null) {
      if (values.contains(current.value)) {
        previous.next = current.next;
        length--;
      } else {
        values.add(current.value);
        previous = current;
      }
      current = current.next;
    }
  }

  public int binaryToDecimal() {
    int sum = 0;

    Node current = head;
    while (current != null) {
      sum = sum * 2 + current.value;
      current = current.next;
    }

    return sum;
  }

  public void reverseBetween(int startIndex, int endIndex) {
    if (head == null) {
      return;
    }

    Node dummyNode = new Node(0);
    dummyNode.next = head;
    Node previousNode = dummyNode;

    for (int i = 0; i < startIndex; i++) {
      previousNode = previousNode.next;
    }

    Node currentNode = previousNode.next;
    for (int i = 0; i < endIndex - startIndex; i++) {
      Node nodeToMove = currentNode.next;
      currentNode.next = nodeToMove.next;
      nodeToMove.next = previousNode.next;
      previousNode.next = nodeToMove;
    }

    head = dummyNode.next;
  }
}

