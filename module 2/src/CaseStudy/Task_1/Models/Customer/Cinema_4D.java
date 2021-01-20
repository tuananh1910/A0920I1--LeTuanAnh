package CaseStudy.Task_1.Models.Customer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Cinema_4D {
    public static void main(String[] args) {
        Queue<String> list_tickets = new LinkedList<>();
        list_tickets.add("Khach hang A");
        list_tickets.add("Khach hang B");
        list_tickets.add("Khach hang C");
        list_tickets.add("Khach hang D");
        System.out.println("size = " + list_tickets.size());
        System.out.println("List customer bought ticket");
        int size = list_tickets.size();
        list_Customer_Bought_Ticket(size,list_tickets);
    }
    public static void list_Customer_Bought_Ticket(int size, Queue list_tickets){
        while (size>0){
            System.out.println(list_tickets.poll());
            size--;
        }
    }
}
