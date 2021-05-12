package dao;

import model.Manager_prodcut;

import java.util.List;

public interface IManager_productDao {
    void insertProduct( Manager_prodcut manager_prodcut);
    IManager_productDao getProduct(int id);
    List<Manager_prodcut> getAllProduct();
    boolean updateProduct(IManager_productDao IManager_productDao);
    boolean deleteProdcut(int id);
}
