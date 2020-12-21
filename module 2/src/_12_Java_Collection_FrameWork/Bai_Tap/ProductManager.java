package _12_Java_Collection_FrameWork.Bai_Tap;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager extends Product  {
    Scanner scanner = new Scanner(System.in);
    int lenghtArry;
    ArrayList<Object> arrayList = new ArrayList<>(lenghtArry);

    public ProductManager(int id, String nameProduct, double price) {
        super(id, nameProduct, price);
    }

    public ProductManager() {

    }

    public void add(){

        System.out.println("ID :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Name Product: ");
        String nameProduct = scanner.nextLine();
        System.out.println("Price : ");
        double price = scanner.nextDouble();
        for (int i=0 ;i<=lenghtArry;i++){
            Product product = new Product(id,nameProduct,price);
            arrayList.add(i,product);
        }
        lenghtArry++;

    }
    public void edit(){
        System.out.println("Choose number want to edit: \n" + "1.ID\n"
        +"2.Name Product\n"+"3.Price");
        int number = scanner.nextInt();
        switch (number){
            case 1:
                int id_edit = scanner.nextInt();
                arrayList.set(0,);
                break;
            case 2:
            case 3:
        }
    }
    public void delete(){

    }
    public void show(){
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
    public void find(){

    }
    public void sort(){

    }
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.add();
        productManager.show();
        productManager.add();
        productManager.show();
        productManager.edit();
        productManager.show();
    }
}
