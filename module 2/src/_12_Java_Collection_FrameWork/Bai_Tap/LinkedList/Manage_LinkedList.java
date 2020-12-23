package _12_Java_Collection_FrameWork.Bai_Tap.LinkedList;

import _12_Java_Collection_FrameWork.Bai_Tap.ArrayList.Product;

import java.util.LinkedList;
import java.util.Scanner;

public class Manage_LinkedList {
    LinkedList<Object> linkedList = new LinkedList<>();
    Scanner scanner = new Scanner(System.in);
    public void add(){
        System.out.println("ID :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Name Product: ");
        String nameProduct = scanner.nextLine();
        System.out.println("Price : ");
        double price = scanner.nextDouble();
        linkedList.add(new Product(id, nameProduct, price));
    }
    public void display(){
        for (int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
    }

    public static void main(String[] args) {
        Manage_LinkedList manage_linkedList = new Manage_LinkedList();
        manage_linkedList.add();
        manage_linkedList.display();
    }
}
