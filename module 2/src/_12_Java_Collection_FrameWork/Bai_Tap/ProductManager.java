package _12_Java_Collection_FrameWork.Bai_Tap;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager extends Product {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Product> arrayList = new ArrayList<>();

    public ProductManager(int id, String nameProduct, double price) {
        super(id, nameProduct, price);
    }

    public ProductManager() {

    }

    public void add() {

        System.out.println("ID :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Name Product: ");
        String nameProduct = scanner.nextLine();
        System.out.println("Price : ");
        double price = scanner.nextDouble();
        arrayList.add(new Product(id, nameProduct, price));
    }

    public void edit() {
        int id;
        boolean check = true;
        int index = 0;
        while (check){
            System.out.println("Enter ID , you want to delete :");
            id = scanner.nextInt();
            for (int i=0;i<arrayList.size();i++) {
                if (id == arrayList.get(i).getId()) {
                    check = false;
                    break;
                } else {
                    System.out.println("Can't find ID");
                }
                index++;
            }
        }
        int number;
        boolean out = true;
        while (out){
            System.out.println("Choose number ,youn want to edit :");
            System.out.println("1.ID \n"+"2.Name Product\n"+"3.Price \n"+"4.Exit");
            number = scanner.nextInt();
            switch (number){
                case 1:
                    int id_Edit;
                    System.out.println("Enter ID edit");
                    id_Edit=scanner.nextInt();
                    arrayList.get(index).setId(id_Edit);
                    arrayList.set(index,arrayList.get(index));
                    show();
                    break;
                case 2:
                    String name_Product;
                    System.out.println("Enter name product edit");
                    name_Product = scanner.nextLine();
                    arrayList.get(index).setNameProduct(name_Product);
                    arrayList.set(index,arrayList.get(index));
                    show();
                    break;
                case 3:
                    double price;
                    System.out.println("Enter price edit");
                    price = scanner.nextDouble();
                    arrayList.get(index).setPrice(price);
                    arrayList.set(index,arrayList.get(index));
                    show();
                    break;
                case 4:
                    out = false;
                    break;
            }
        }
    }

    public void delete() {
        int id;
        int index = 0;
        boolean check = true;
        while (check){
           System.out.println("Enter ID , you want to delete :");
           id = scanner.nextInt();
           for (int i=0;i<arrayList.size();i++) {
               if (id == arrayList.get(i).getId()) {
                   check = false;
                   break;
               } else {
                   System.out.println("Can't find ID");
               }
               index++;
           }
       }
        arrayList.remove(index);
        System.out.println("After , Product did deleted");
        show();
    }

    public void show() {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }

    public void find() {
        int index=0;
        String name_Product;
        boolean check =true;
        while (check){
            System.out.println("Enter name product, you want to find :");
            name_Product=  scanner.nextLine();
            for (int i=0;i<arrayList.size();i++) {
                if (name_Product == arrayList.get(i).getNameProduct()) {
                    check = false;
                    break;
                } else {
                    System.out.println("Can't find Product");
                }
                index++;
            }
        }
        System.out.println(arrayList.get(index));
    }

    public void sortAscending() {

    }

    public void sortDecrease() {

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        int number;
        do {
            System.out.println("Menu \n" + "1.Add New Product \n" + "2.Edit Product \n"
                    + "3.Delete Product \n" + "4.Display Product \n" + "5.Find Product \n"
                    + "6.Sort Product Ascending \n" + "7.Sort Product Decrease\n" + "8.Exit");
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    productManager.add();
                    break;
                case 2:
                    productManager.edit();
                    break;
                case 3:
                    productManager.delete();
                    break;
                case 4:
                    productManager.show();
                    break;
                case 5:
                    productManager.find();
                    break;
            }
        }
        while (number != 8);

    }
}
