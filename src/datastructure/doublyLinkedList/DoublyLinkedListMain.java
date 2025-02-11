package datastructure.doublyLinkedList;

public class DoublyLinkedListMain {
    public static void main(String[] args) {

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);
        doublyLinkedList.append(2);
        doublyLinkedList.prepend(0);
        doublyLinkedList.printList();
        System.out.println("=====================================");
        doublyLinkedList.insert(2,3);
        System.out.println("=====================================");
        doublyLinkedList.printList();
    }
}
