package common;

public class Node {

  public int value;
  public Node next;

  public Node(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Node{" + "value=" + value + ", next=" + next + '}';
  }
}
