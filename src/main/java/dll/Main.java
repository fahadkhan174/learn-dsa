package dll;

public class Main {

  public static void main(String[] args) {

    DoublyLinkedList doublyLinkedList = new DoublyLinkedList(0);

    doublyLinkedList.getHead();
    doublyLinkedList.getTail();
    doublyLinkedList.getLength();
    doublyLinkedList.print();

    System.out.println();
    System.out.println("-- Append --");
    doublyLinkedList.append(1);
    doublyLinkedList.print();

    System.out.println();
    System.out.println("-- Remove last --");
    System.out.println(doublyLinkedList.removeLast().value);
    System.out.println(doublyLinkedList.removeLast().value);
    System.out.println(doublyLinkedList.removeLast());

    System.out.println();
    doublyLinkedList.append(1);
    doublyLinkedList.print();
    System.out.println("-- Prepend --");
    doublyLinkedList.prepend(0);
    doublyLinkedList.print();

    System.out.println();
    System.out.println("-- Remove first --");
    System.out.println(doublyLinkedList.removeFirst().value);
    System.out.println(doublyLinkedList.removeFirst().value);
    System.out.println(doublyLinkedList.removeFirst());

    System.out.println();
    System.out.println("-- Get --");
    doublyLinkedList.append(0);
    doublyLinkedList.append(1);
    doublyLinkedList.print();
    System.out.println(doublyLinkedList.get(0).value);
    System.out.println(doublyLinkedList.get(1).value);
    System.out.println(doublyLinkedList.get(4));

    System.out.println();
    System.out.println("-- Set --");
    doublyLinkedList.print();
    System.out.println(doublyLinkedList.set(1, 5));
    doublyLinkedList.print();

    System.out.println();
    System.out.println("-- Insert --");
    doublyLinkedList.insert(1, 1);
    doublyLinkedList.insert(2, 2);
    doublyLinkedList.print();

    System.out.println();
    System.out.println("-- Remove --");
    doublyLinkedList.remove(2);
    doublyLinkedList.print();

    System.out.println();
    System.out.println("-- Swap first last --");
    doublyLinkedList.swapFirstLast();
    doublyLinkedList.print();

    System.out.println();
    System.out.println("-- Reverse --");
    doublyLinkedList.reverse();
    doublyLinkedList.print();

    System.out.println();
    System.out.println("-- Palindrome --");
    doublyLinkedList.append(1);
    doublyLinkedList.append(0);
    doublyLinkedList.print();
    System.out.println(doublyLinkedList.isPalindrome());

    System.out.println();
    System.out.println("-- SwapPairs --");
    doublyLinkedList.swapPairs();
    doublyLinkedList.print();

  }

}
