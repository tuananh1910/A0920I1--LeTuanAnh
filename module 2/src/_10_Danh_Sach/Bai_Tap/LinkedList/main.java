package _10_Danh_Sach.Bai_Tap.LinkedList;

public class main {
    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList(0);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);
        ll.remove(2);
        ll.printList();
        System.out.println("------------");
        ll.removeO(154);
        ll.removeO(6);
        ll.printList();
        ll.size();
        System.out.println("index = "+ll.indexOf(7));
    }
}
