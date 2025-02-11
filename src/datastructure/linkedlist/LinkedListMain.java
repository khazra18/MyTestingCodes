package datastructure.linkedlist;

public class LinkedListMain {

    public static void main(String[] args) {

        LinkedList list = new LinkedList(1);
        list.append(2);
        list.prepend(0);
        list.printList();
        System.out.println("==================================");
        list.reverse();
        System.out.println("==================================");
        list.printList();
    }
}
