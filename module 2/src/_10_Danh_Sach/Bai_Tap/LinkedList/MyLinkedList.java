package _10_Danh_Sach.Bai_Tap.LinkedList;


import org.w3c.dom.Node;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private  int numNodes;
    public MyLinkedList(Object data) {
        head = new Node(data);
        tail=head;
    }
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for (int i=0; i<index-1 && temp.next != null;i++){
            temp= temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data){
        tail.next = new Node(data);
        tail = tail.next;
        numNodes++;
    }

    public void remove(int index){
        Node temp = head;
        if (head==null){
            return;
        }
        if (index==0){
            head=temp.next;
            return;
        }
        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null){
            return;
        }
        Node next = temp.next.next;
        temp.next = next;
        numNodes--;
    }

    public void removeO(Object o){
        Node holder = head;
        Node temp= head;
        Node check_index = head;
        int check_val =0;
        int count=1;
        if (head==null){
            return;
        }
        for (int i=0;i<numNodes;i++){
            check_index = check_index.next;
            if (check_index.data==o){
                check_val++;
            }
        }
        if (check_val<1){
            System.out.println("Object does not exist");
            return;
        }
        for (int i=0;i<numNodes;i++) {
            holder = holder.next;
            count++;
            if (o==holder.data){
                break;
            }
        }
        for (int i=0;i<count;i++){
            temp = temp.next;
        }
        Node next = temp.next.next ;
        temp.next = next;
        numNodes--;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int size() {
        return numNodes;
    }
    public int indexOf(Object o){
        Node holder= head;
        int count=0;
        for (int i=0;i<numNodes;i++) {
            holder = holder.next;
            count++;
            if (o==holder.data){
                break;
            }
        }
        return count;
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
