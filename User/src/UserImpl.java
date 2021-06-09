import java.util.ArrayList;

public class UserImpl implements IUser{
    static ArrayList<User> users = new ArrayList<>();
    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public void displayUser() {
        for (User value : users){
            System.out.println(value.toString());
        }
    }

    @Override
    public void deleteUser(int deleteById) {
        users.remove(deleteById-1);
    }

    @Override
    public void updateUser() {

    }
}
