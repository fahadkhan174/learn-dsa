package common;

public class Node {

  public int value;
  public Node next;
  public Node prev;

  public Node(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Node{" +
        "value=" + value +
        ", next=" + next +
        ", prev=" + prev +
        '}';
  }
}
