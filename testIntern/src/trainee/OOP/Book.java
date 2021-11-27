package trainee.OOP;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Book {
    private List<ICategoriesObserver> categoriesObserver = new ArrayList<>();
    public void create(ICategoriesObserver observer) {
        categoriesObserver.add(observer);
    }
    public void remove(ICategoriesObserver observer) {
        categoriesObserver.remove(observer);
    }
    public void notifyChange(String message) {
        for(ICategoriesObserver observer : categoriesObserver) {
            observer.update(message);
        }
    }

}
