package _12_Java_Collection_FrameWork.Bai_Tap.ArrayList;

import java.util.*;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> arrayList = new ArrayList<>();
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
        boolean check_ID_Empty = false;
        boolean check = true;
        int index = 0;
        while (check) {
            System.out.println("Enter ID , you want to edit :");
            id = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < arrayList.size(); i++) {
                if (id == arrayList.get(i).getId()) {
                    check = false;
                    check_ID_Empty =false;
                    break;
                } else {
                    check_ID_Empty=true;
                }
                index++;
            }
            if (check_ID_Empty){
                System.out.println("Isn't find");
                index=0;
            }
        }
        int number;
        boolean out = true;
        while (out) {
            System.out.println("Choose number ,youn want to edit :");
            System.out.println("1.ID \n" + "2.Name Product\n" + "3.Price \n" + "4.Exit");
            number = scanner.nextInt();
            scanner.nextLine();
            switch (number) {
                case 1:
                    int id_Edit;
                    System.out.println("Enter ID edit");
                    id_Edit = scanner.nextInt();
                    arrayList.get(index).setId(id_Edit);
                    arrayList.set(index, arrayList.get(index));
                    show();
                    break;
                case 2:
                    String name_Product;
                    System.out.println("Enter name product edit");
                    name_Product = scanner.nextLine();
                    arrayList.get(index).setNameProduct(name_Product);
                    arrayList.set(index, arrayList.get(index));
                    show();
                    break;
                case 3:
                    double price;
                    System.out.println("Enter price edit");
                    price = scanner.nextDouble();
                    arrayList.get(index).setPrice(price);
                    arrayList.set(index, arrayList.get(index));
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
        boolean check_ID_Empty = false;
        boolean check = true;
        while (check) {
            System.out.println("Enter ID , you want to delete :");
            id = scanner.nextInt();
            for (int i = 0; i < arrayList.size(); i++) {
                if (id == arrayList.get(i).getId()) {
                    check = false;
                    check_ID_Empty = false;
                    break;
                } else {
                    check_ID_Empty=true;
                }
                index++;
            }
            if (check_ID_Empty) {
                System.out.println("Isn't find");
                index=0;
            }
        }
        if (!check_ID_Empty){
            arrayList.remove(index);
            System.out.println("After , Product did deleted");
            show();
        }
    }

    public void show() {
        if (arrayList.isEmpty()){
            System.out.println("Empty");
        }
        else {
            for (int i = 0; i < arrayList.size(); i++) {
                System.out.println(arrayList.get(i));
            }
        }
    }

    public void find() {
        int index = 0;
        boolean check_Name_Product_Empty = false;
        String name_Product = "";
        boolean check = true;
        while (check) {
            System.out.println("Enter name product, you want to find :");
            name_Product = scanner.nextLine();
            for (int i = 0; i < arrayList.size(); i++) {
                if (name_Product.equals(arrayList.get(i).getNameProduct())) {
                    index = i;
                    check = false;
                    check_Name_Product_Empty = false;
                    break;
                } else {
                    check_Name_Product_Empty = true;
                }
            }

            if (check_Name_Product_Empty) {
                System.out.println("Isn't find");
            }
        }

        if (check == false) {
            System.out.println(name_Product + " : ");
            System.out.println(arrayList.get(index));
            index = 0;
            name_Product = "";
        }
    }

    public void sortAscending() {
        Collections.sort(arrayList, comparator);
    }

    public void sortDecrease() {
        sortAscending();
        Collections.reverse(arrayList);
    }

    public Comparator<Product> comparator = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            if (o1.getPrice() < o2.getPrice()) {
                return -1;
            } else if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else return 0;
        }
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        int number;
        do {
            System.out.println("Menu \n" + "1.Add New Product \n" + "2.Edit Product \n"
                    + "3.Delete Product \n" + "4.Display Product \n" + "5.Find Product \n"
                    + "6.Sort Product Ascending \n" + "7.Sort Product Decrease\n" + "8.Exit");
            number = Integer.parseInt(scanner.nextLine());
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
                case 6:
                    productManager.sortAscending();
                    productManager.show();
                    break;
                case 7:
                    productManager.sortDecrease();
                    productManager.show();
                default:
                    break;
            }
        }
        while (number != 8);
    }
}
