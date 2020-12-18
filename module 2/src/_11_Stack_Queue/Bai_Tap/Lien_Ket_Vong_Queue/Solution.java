package _11_Stack_Queue.Bai_Tap.Lien_Ket_Vong_Queue;

public class Solution {

    static class Node{
         int data;
         Node link;
    }
    static class Queue{
        Node  front,  rear;
    }
    static void enqueue(Queue q,int data){
        Node temp = new Node();
        temp.data = data;
        if (q.front==null){
            q.front=temp;
        }
        else {
            q.rear.link =temp;
        }
        q .rear = temp;
        q .rear .link = q .front;
    }
    static int dequeue(Queue q){
        if (q .front ==  null)
        {
            System.out.printf ("Queue is empty");
            return Integer.MIN_VALUE;
        }

        int value;
        if (q .front == q .rear)
        {
            value = q .front .data;
            q .front =  null;
            q .rear =  null;
        }
        else
        {
            Node  temp = q .front;
            value = temp .data;
            q .front = q .front .link;
            q .rear .link= q .front;
        }

        return value ;
    }
    static void displayQueue( Queue  q)
    {
        Node  temp = q .front;
        System.out.printf(" Elements in Circular Queue are: ");
        while (temp .link != q .front)
        {
            System.out.printf("%d ", temp .data);
            temp = temp .link;
        }
        System.out.printf("%d", temp .data);
    }
    public static void main(String args[])
    {
        Queue  q = new Queue();
        q .front = q .rear =  null;

        enqueue(q, 14);
        enqueue(q, 22);
        enqueue(q, 6);

        displayQueue(q);

        System.out.printf(" Deleted value = %d", dequeue(q));
        System.out.printf(" Deleted value = %d", dequeue(q));

        displayQueue(q);

        enqueue(q, 9);
        enqueue(q, 20);
        displayQueue(q);

    }


}
