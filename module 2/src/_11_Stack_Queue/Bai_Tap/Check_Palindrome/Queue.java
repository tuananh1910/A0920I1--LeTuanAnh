package _11_Stack_Queue.Bai_Tap.Check_Palindrome;

import _11_Stack_Queue.Thuc_Hanh.Queue.Node;

public class Queue {
    public class Node{
        public String key;
        public Node next;

        public Node(String key) {
            this.key = key;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }
    public void enqueue(String key) {
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }
    public Queue.Node dequeue() {
        if (this.head == null)
            return null;
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null)
            this.tail = null;
        return temp;
    }
}
