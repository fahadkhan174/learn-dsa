package linkedlist;

public class Main {

  public static void main(String[] args) {

    LinkedList linkedList = new LinkedList();

    System.out.println("--Append--");
    linkedList.append(1);
    linkedList.append(2);
    linkedList.getHead();
    linkedList.getTail();
    linkedList.getLength();
    linkedList.print();

    System.out.println("--Remove last--");
    System.out.println(linkedList.removeLast());
    System.out.println(linkedList.removeLast());
    System.out.println(linkedList.removeLast());
    linkedList.print();

    System.out.println("--Prepend--");
    linkedList.prepend(3);
    linkedList.prepend(2);
    linkedList.getHead();
    linkedList.getTail();
    linkedList.getLength();
    linkedList.print();

    System.out.println("--Remove first--");
    System.out.println(linkedList.removeFirst());
    System.out.println(linkedList.removeFirst());
    linkedList.print();

    System.out.println("--Get--");
    linkedList.append(1);
    linkedList.append(2);
    System.out.println(linkedList.get(3));
    System.out.println(linkedList.get(1));
    linkedList.print();

    System.out.println("--Set--");
    System.out.println(linkedList.set(10, 55));
    System.out.println(linkedList.set(0, 55));
    linkedList.print();

    System.out.println("--Insert--");
    System.out.println(linkedList.insert(99, 1));
    System.out.println(linkedList.insert(1, 1));
    linkedList.print();

    System.out.println("--Remove--");
    System.out.println(linkedList.remove(99));
    System.out.println(linkedList.remove(0));
    linkedList.print();

    System.out.println("--Reverse--");
    linkedList.reverse();
    linkedList.print();
  }
}
