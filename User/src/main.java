import java.util.Scanner;

public class main {
    static UserImpl userImpl = new UserImpl();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        int number;
        do {
            System.out.println("Menu : 1. Create User 2.Delete 3. Edit 4.Display User 5. exit ");
            number = scanner.nextInt();
            switch (number){
                case 1:
                    //goi ham create user;
                    int id;
                    System.out.println("ID :");
                    id=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("--------");
                    System.out.println("Name: ");
                    String name= scanner.nextLine();

                    User user = new User(id,name);

                    userImpl.createUser(user);
                    break;
                case 2:
                    // goi han delete
                    userImpl.displayUser();
                    System.out.println("Chon ID muon xoa :");
                    int deleteId;
                    deleteId = scanner.nextInt();
                    userImpl.deleteUser(deleteId);
                    break;
                case 3:
                    // edit
                    break;
                case 4:
                    // display
                    userImpl.displayUser();
                    break;
                case 5:
                    exit =false;
                    break;
                default:break;

            }
        }while (exit);
    }
}
