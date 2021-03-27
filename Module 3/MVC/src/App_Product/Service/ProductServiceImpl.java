package App_Product.Service;

import App_Product.Model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"Nike",200,"black-white", "Nike"));
        products.put(2,new Product(1,"Converse",300,"black-white", "Converse"));
        products.put(3,new Product(1,"Bitis Hunter",400,"black-white", "Bitis"));
        products.put(4,new Product(1,"Addidas",500,"black-white", "Addidas"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
